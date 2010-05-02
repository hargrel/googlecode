package edu.itee.antipodes.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class accessDeniedController {

	@RequestMapping("/accessDenied.html")
	public String redirect()
	{
		return "accessDenied";
	}
}
