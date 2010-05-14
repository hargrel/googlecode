package edu.itee.antipodes.web.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.AccountManager;

@Controller
@RequestMapping("/admin/addAccount.html")
public final class addAccountController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		AccountUser accountUser = new AccountUser();
		model.addAttribute("accountUser", accountUser);
		return "addAccount";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@RequestParam("membershipExpiry") String membershipExpiry, @ModelAttribute("accountUser") AccountUser accountUser,
			BindingResult result, ModelMap model) throws Exception {

		TourOperator operator = new TourOperator();
		TourOperatorDao tod = DaoManager.getTourOperatorDao();
		
		validator.validate(accountUser, result);
		if (result.hasErrors()) { return "addAccount"; }
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date membershipExpiryDate = df.parse(membershipExpiry);

		accountManager.addAccount(accountUser);
		if(accountUser.getUserType().equalsIgnoreCase("operator")){
			//operator.setOperatorID(accountUser.getUserID());
			operator.setAccountUser(accountUser);
			operator.setMembershipExpired(membershipExpiryDate);
			tod.addTourOperator(operator);
		}
		// Use the redirect-after-post pattern to reduce double-submits.
		List<AccountUser> newAccounts = accountManager.getAccounts();
		model.addAttribute("accounts", newAccounts);
		return "accountList";
		
	}

	@Autowired
	AccountManager accountManager;
}
