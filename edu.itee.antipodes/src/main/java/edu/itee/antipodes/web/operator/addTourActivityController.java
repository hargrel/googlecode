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

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.ISystemAdminManager;

@Controller
@RequestMapping("/operator/addTourActivity.html")
public final class addTourActivityController {

	@Autowired
	private Validator validator;
	@Autowired
	private ISystemAdminManager systemAdminManager;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Activity act = new Activity();
		model.addAttribute("activity", act);
		return "addTourActivity";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("activity") Activity act, BindingResult result) {

		validator.validate(act, result);
		if (result.hasErrors()) {
			return "addTourActivity";
		}

		systemAdminManager.saveActivity(act);
		return new RedirectView("alignTour.html");
	}
}
