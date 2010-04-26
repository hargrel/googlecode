package edu.itee.antipodes.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class searchResultController {

	@RequestMapping("/searchResult.html")
	public String redirect()
	{
		return "searchResult";
	}
}
