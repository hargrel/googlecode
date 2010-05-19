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

import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.ISystemAdminManager;

@Controller
@RequestMapping("/operator/addTourLocation.html")
public final class addTourLocationController {

	@Autowired
	private Validator validator;
	@Autowired
	private ISystemAdminManager systemAdminManager;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Location loc = new Location();
		model.addAttribute("loc", loc);
		return "addTourLocation";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("location") Location loc, BindingResult result) {

		validator.validate(loc, result);
		if (result.hasErrors()) {
			return "addTourLocation";
		}

		systemAdminManager.saveLocation(loc);
		return new RedirectView("alignTour.html");
	}
}
