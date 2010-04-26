package edu.itee.antipodes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class thanksController {

	@RequestMapping("/thanks.html")
	public String redirect()
	{
		return "thanks";
	}
}
