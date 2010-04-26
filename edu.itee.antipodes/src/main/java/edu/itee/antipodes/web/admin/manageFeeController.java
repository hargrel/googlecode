package edu.itee.antipodes.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class manageFeeController {

	@RequestMapping("/manageFee.html")
	public String redirect()
	{
		return "manageFee";
	}
}
