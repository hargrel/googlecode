package org.example.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login.html")
public class LoginController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String loginGet(HttpServletRequest request, ModelMap model) {
		model.addAttribute("samlstring", request.getQueryString());
		
		return "login";
	}
 
}