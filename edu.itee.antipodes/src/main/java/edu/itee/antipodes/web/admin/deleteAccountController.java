package edu.itee.antipodes.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.service.AccountManager;

@Controller
@RequestMapping("/admin/deleteAccount.html")
public class deleteAccountController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		List<AccountUser> accounts = accountManager.getAccounts();
		model.addAttribute("accounts", accounts);
		return "deleteAccount";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@RequestParam("userID") int userID) {

		accountManager.dropAccountByID(userID);
		return "thanks"; //}
		
	}

	@Autowired
	AccountManager accountManager;
}
