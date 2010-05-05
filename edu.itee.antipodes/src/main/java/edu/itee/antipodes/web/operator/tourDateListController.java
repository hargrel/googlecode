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
@RequestMapping("/operator/tourDateList.html")
public class tourDateListController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showTourDate(Model model) {
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tourDate", tours);
		return "tourDateList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String deleteTourDate(@RequestParam("dateID") int dateID, Model model) {
		tourManager.dropTourByID(dateID);
		List<Tour> tours = tourManager.getTours();
		model.addAttribute("tourDate", tours);
		return "tourDateList";
	}
	
	@Autowired
	TourManager tourManager;
}

