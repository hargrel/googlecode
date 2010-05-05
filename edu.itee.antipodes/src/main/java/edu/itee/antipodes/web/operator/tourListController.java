package edu.itee.antipodes.web.operator;

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
@RequestMapping("/operator/tourList.html")
public class tourListController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showTour(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "tourList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String deleteTour(@RequestParam("tourID") int tourID, Model model) {
		tourManager.dropTourByID(tourID);
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "tourList";
	}
	
	@Autowired
	TourManager tourManager;
}

