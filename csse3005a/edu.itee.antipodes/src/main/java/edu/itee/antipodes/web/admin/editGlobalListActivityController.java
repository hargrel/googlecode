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
import edu.itee.antipodes.service.ISystemAdminManager;

@Controller
@RequestMapping("/admin/editGlobalListActivity.html")
public final class editGlobalListActivityController {

	String successMessage;
	@Autowired
	private Validator validator;
	@Autowired
	private ISystemAdminManager systemAdminManager;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String activityID = request.getParameter("activityID");
		if (activityID == null)
			return new RedirectView("globalListActivity.html");

		Activity ac = systemAdminManager.getActivityByID(activityID);
		if (ac == null)
			return new RedirectView("globalListActivity.html");

		successMessage = "";
		model.addAttribute("successMessage", successMessage);
		model.addAttribute("act", ac);
		return "editGlobalListActivity";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(ModelMap model, @ModelAttribute("act") Activity ac, BindingResult result) {

		validator.validate(ac, result);
		if (result.hasErrors()) {
			return "editGlobalListActivity";
		}

		systemAdminManager.saveActivity(ac);
		successMessage = "Update successful!";
		model.addAttribute("successMessage", successMessage);
		model.addAttribute("act", ac);
		return "editGlobalListActivity";
	}
}
