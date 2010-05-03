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

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.service.AccountManager;

@Controller
@RequestMapping("/addAccount.html")
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
	public String post(@ModelAttribute("accountUser") AccountUser accountUser,
			BindingResult result, ModelMap model) {

		
		validator.validate(accountUser, result);
		if (result.hasErrors()) { return "addAccount"; }
		
		List<AccountUser> accounts = accountManager.getAccounts();
		
		for(AccountUser accUser : accounts){
			if(accUser.getUserName().equalsIgnoreCase(accountUser.getUserName()))
				return "addAccount";
		}
		accountManager.addAccount(accountUser);
		// Use the redirect-after-post pattern to reduce double-submits.
		List<AccountUser> newAccounts = accountManager.getAccounts();
		model.addAttribute("accounts", newAccounts);
		return "accountList";
		
	}

	@Autowired
	AccountManager accountManager;
}
