package edu.itee.antipodes.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/searchResult.html")	
public class searchResultController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		return "searchResult";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String showResult(Model model){
		return "searchResult";
	}
}
