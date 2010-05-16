package edu.itee.antipodes.web.admin;

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
import edu.itee.antipodes.service.IAccountManager;

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

		validator.validate(accountUser, result);
		if (result.hasErrors()) { return "addAccount"; }
		
		List<AccountUser> newAccounts = accountManager.getAccounts();
		model.addAttribute("accounts", newAccounts);
		return "accountList";
	}

	@Autowired
	IAccountManager accountManager;
}
