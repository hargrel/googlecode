package edu.itee.antipodes.web.operator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.ITourOperatorManager;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/operator/tourList.html")
public class tourListController {
	
	@Autowired
	private ITourOperatorManager tourOperatorManager;
	
	CurrentUser currentUser = new CurrentUser();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showTour(Model model) {
		List<Tour> tours = tourOperatorManager.getToursByOperatorID(currentUser.getCurrentUserID());
		model.addAttribute("tours", tours);
		return "tourList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object deleteTour(@RequestParam("tourID") int tourID, Model model) {
		tourOperatorManager.dropTourByID(tourID);

		return new RedirectView("tourList.html");
	}

}

