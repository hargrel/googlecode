package edu.itee.antipodes.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.service.AccountManager;





@Controller
@RequestMapping("/editAccountList.html")
public class editAccountListController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model) {
		List<AccountUser> accounts = accountManager.getAccounts();
		model.addAttribute("accounts", accounts);
		return "editAccountList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(Model model) {
		return showUserForm(model);
	}

	@Autowired
	AccountManager accountManager;
}
