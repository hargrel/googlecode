package edu.itee.antipodes.web.operator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.ITourOperatorManager;

@Controller
@RequestMapping("/operator/deleteTour.html")
public class deleteTourController {
	@Autowired
	private ITourOperatorManager tourOperatorManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showInventory(Model model) {
		List<Tour> tours = tourOperatorManager.getTours();
		model.addAttribute("tours", tours);
		return "deleteTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String deleteTour(@RequestParam("tourID") int tourID, Model model) {
		tourOperatorManager.dropTourByID(tourID);
		List<Tour> tours = tourOperatorManager.getTours();
		model.addAttribute("tours", tours);
		return "deleteTour";
	}
	
}
