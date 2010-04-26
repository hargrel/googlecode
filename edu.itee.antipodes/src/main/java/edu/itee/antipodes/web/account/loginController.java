package edu.itee.antipodes.web.account;

import org.springframework.stereotype.Controller;

@Controller
public class loginController {

	//@RequestMapping("/loginFail.html")
	public String redirect()
	{
		return "loginFail";
	}
}
