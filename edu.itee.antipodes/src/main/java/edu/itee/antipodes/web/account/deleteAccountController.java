package edu.itee.antipodes.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class deleteAccountController {

	@RequestMapping("/deleteAccount.html")
	public String redirect()
	{
		return "deleteAccount";
	}
}
