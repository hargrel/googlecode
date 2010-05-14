package edu.itee.antipodes.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.service.AccountManager;

@Controller
@RequestMapping("/admin/editAccount.html")
public final class editAccountController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String userID = request.getParameter("userID");
		if (userID == null)
			return new RedirectView("editAccountList.html");
		
		AccountUser accountUser = accountManager.getAccountByID(Integer.parseInt(userID));
		if (accountUser == null)
			return new RedirectView("editAccountList.html");
		
		model.addAttribute("accountUser", accountUser);
		return "editAccount";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@RequestParam("membershipExpiry") String membershipExpiry, @ModelAttribute("accountUser") AccountUser accountUser,
			BindingResult result, ModelMap model) throws Exception {
		return "search";
		/*
		validator.validate(accountUser, result);
		if (!accountUser.getUserName().equalsIgnoreCase(accountManager.getAccountByID(accountUser.getUserID()).getUserName()) && result.hasErrors()) { 
			return "editAccount"; 
			}
		//TourOperatorDao tod = DaoManager.getTourOperatorDao();
		//TourOperator operator = tod.getTourOperatorByID(accountUser.getUserID());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date membershipExpiryDate = df.parse(membershipExpiry);
		
		accountManager.updateAccount(accountUser);
		
		if(accountUser.getUserType().equalsIgnoreCase("operator")){
			//operator.setOperatorID(accountUser.getUserID());
			//operator.setMembershipExpired(membershipExpiryDate);
			//tod.saveTourOperator(operator);
		}
		return new RedirectView("accountList.html");
		*/
	}
	@Autowired
	AccountManager accountManager;

}
