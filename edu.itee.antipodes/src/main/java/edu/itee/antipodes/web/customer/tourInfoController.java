package edu.itee.antipodes.web.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.TourManager;

@Controller
@RequestMapping("/tourInfo.html")
public class tourInfoController {
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String showInventory(Model model) {
//		List<Tour> tours = customerManager.getTours();
//		model.addAttribute("tours", tours);
//		return "tourInfo";
//	}

	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourManager.getTours();
		//model.addAttribute("tours", tours);
		Tour tour = tours.get(0);
		model.addAttribute("tour", tour);
		return "tourInfo";
	}	
	
	@Autowired
	TourManager tourManager;
}
