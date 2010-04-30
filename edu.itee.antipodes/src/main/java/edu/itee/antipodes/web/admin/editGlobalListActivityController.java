package edu.itee.antipodes.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import edu.itee.antipodes.service.SystemAdminManager;

@Controller
@RequestMapping("/editGlobalListActivity.html")
public final class editGlobalListActivityController {

	@Autowired
	private Validator validator;

	SystemAdminManager sam = new SimpleSystemAdminManager();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		Activity ac = sam.getActivityByID(request.getParameter("activityID"));
		//Location ac = sam.getLocationByID(request.getParameter("activityID"));

		if (ac == null)
			return new RedirectView("globalListActivity.html");

		model.addAttribute("act", ac);
		return "editGlobalListActivity";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("act") Activity ac,
			BindingResult result) {

		validator.validate(ac, result);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "editGlobalListActivity";
		}

		sam.saveActivity(ac);
		return new RedirectView("globalListActivity.html");
	}
}
