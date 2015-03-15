package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.Currency;
import edu.itee.antipodes.service.ITourOperatorManager;

@Controller
@RequestMapping("/operator/addTour.html")
public final class addTourController {

	@Autowired
	private ITourOperatorManager tourOperatorManager;
	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		// Populate the model with data
		model.addAttribute("addTour", new Tour());
		model.addAttribute("currencyList", Currency.getCurrencyList());
		return "addTour";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object addTour(ModelMap model, @ModelAttribute("addTour") Tour tour,
			BindingResult result) {
		// Check data for errors, and don't proceed if there are any
		validator.validate(tour, result);
		if (result.hasErrors()) {
			model.addAttribute("currencyList", Currency.getCurrencyList());
			return "addTour";
		}

		tourOperatorManager.addTour(tour);

		// Redirect to upload page with a state add, to indicate new tour
		return new RedirectView("uploadImages.html?tourID=" + tour.getTourID()
				+ "&state=add");
	}
}
