package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.TourManager;


@Controller
@RequestMapping("/operator/addTour.html")
public final class addTourController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@Autowired
	TourManager tourManager;

	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Tour tourInfo = new Tour();
		model.addAttribute("addTour", tourInfo);
		return "addTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("addTour") Tour info,
			BindingResult result) {
		
		validator.validate(info, result);
		if (result.hasErrors()) { return "addTour"; }
		
		tourManager.addTour(info);

		// Use the redirect-after-post pattern to reduce double-submits.
		return "tourList";
		
	}

}
