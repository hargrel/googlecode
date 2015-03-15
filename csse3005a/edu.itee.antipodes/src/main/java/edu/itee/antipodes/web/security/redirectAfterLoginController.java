package edu.itee.antipodes.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.CurrentUser;


@Controller

public class redirectAfterLoginController {
	@RequestMapping("/redirect.html")
	public Object redirect()
	{
		CurrentUser currentUser = new CurrentUser();
		if(currentUser.getCurrentUserType().equalsIgnoreCase("admin"))
			return new RedirectView("admin/SAhome.html");
		else if(currentUser.getCurrentUserType().equalsIgnoreCase("operator"))
			return new RedirectView("operator/TOhome.html");
		else
			return new RedirectView("search");
	}
}
