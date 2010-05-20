package edu.itee.antipodes.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.CurrentUser;

@Controller
public class loginFailController {

	@RequestMapping("/loginFail.html")
	public Object redirect()
	{
		try
		{
			CurrentUser currentUser = new CurrentUser();
			if(currentUser.getCurrentUserType().equalsIgnoreCase("admin"))
				return new RedirectView("admin/SAhome.html");
			else if(currentUser.getCurrentUserType().equalsIgnoreCase("operator"))
				return new RedirectView("operator/TOhome.html");
		}
		catch(NullPointerException npe)
		{
			return "loginFail";
		}
		return "loginFail";
	}
}
