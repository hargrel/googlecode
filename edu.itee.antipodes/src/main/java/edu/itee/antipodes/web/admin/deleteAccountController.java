package edu.itee.antipodes.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.SystemAdminManager;

@Controller
@RequestMapping("/deleteAccount.html")
public class deleteAccountController {

	SystemAdminManager sam = new SimpleSystemAdminManager();

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(ModelMap model)
	{
		model.addAttribute("accounts", sam.getAccountList());
		return "deleteAccount";
	}
}
