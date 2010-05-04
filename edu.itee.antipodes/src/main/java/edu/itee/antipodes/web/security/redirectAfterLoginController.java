package edu.itee.antipodes.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.AccountManager;
import edu.itee.antipodes.service.SimpleAccountManager;


@Controller

public class redirectAfterLoginController {
	@RequestMapping("/redirect.html")
	public Object redirect(HttpServletRequest request,
			HttpServletResponse response)
	{
		String username = request.getParameter("username");
		if(username == null)
			return "redirect";
		AccountManager accountManager = new SimpleAccountManager();
		if(accountManager.getAccountByUsername(username).getUserType().equalsIgnoreCase("admin"))
			return new RedirectView("SAhome.html");
		else if(accountManager.getAccountByUsername(username).getUserType().equalsIgnoreCase("operator"))
			return new RedirectView("TOhome.html");
		return "search";
	}
}
