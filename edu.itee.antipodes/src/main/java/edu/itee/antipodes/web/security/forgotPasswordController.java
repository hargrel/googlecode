package edu.itee.antipodes.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.ISystemAdminManager;


@Controller
@RequestMapping("/forgotPassword.html")
public class forgotPasswordController {

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm()
	{
		return "forgotPassword";
	}
	@RequestMapping(method = RequestMethod.POST)
	public Object getMessage(@RequestParam("email") String email) throws Exception
	{
		systemAdminManager.regeneratePassword(email);
		return new RedirectView("search.html");
	}
	@Autowired
	private ISystemAdminManager systemAdminManager;
}
