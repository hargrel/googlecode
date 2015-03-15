package edu.itee.antipodes.web.operator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userManualController {

	@RequestMapping("/operator/userManual.html")
	public String redirect()
	{
		return "userManual";
	}
}
