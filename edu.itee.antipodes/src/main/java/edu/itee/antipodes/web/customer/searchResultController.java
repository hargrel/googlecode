package edu.itee.antipodes.web.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.TourManager;

@Controller
// added
@RequestMapping("/searchResult.html")	
public class searchResultController {

//	@RequestMapping("/searchResult.html")
//	public String redirect()
//	{
//		return "searchResult";
//	}

	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "searchResult";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showResult(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "searchResult";
	}
	
  	@Autowired
	TourManager tourManager;	
}
