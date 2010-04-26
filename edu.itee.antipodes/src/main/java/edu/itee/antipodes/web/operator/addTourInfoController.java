package edu.itee.antipodes.web.operator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.TourManager;

@Controller
@RequestMapping("/addTourInfo.html")
@SessionAttributes("userMessage")
public class addTourInfoController {

	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "addTourInfo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateTour(@RequestParam("tourID") int tourID, @RequestParam("tourName") String tourName, 
			@RequestParam("tourDesc") String tourDesc, @RequestParam("price") double price, 
			@RequestParam("totalDays") int totalDays, Model model) {
		Tour tour = new Tour();
		tour.setTourID(tourID);
		tour.setTourName(tourName);
		tour.setTourDesc(tourDesc);
		tour.setPrice(price);
		tour.setTotalDays(totalDays);
		
		tourManager.addTour(tour);
		
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tours", tours);
		return "addTourInfo";
	}
	
	@Autowired
	TourManager tourManager;
}