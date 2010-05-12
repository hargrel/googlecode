package edu.itee.antipodes.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class aboutUsController {

	@RequestMapping("/aboutUs.html")
	public String redirect()
	{
		return "aboutUs";
	}
}
