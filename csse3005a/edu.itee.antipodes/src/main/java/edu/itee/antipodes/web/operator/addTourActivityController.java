package edu.itee.antipodes.web.operator;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.ITourOperatorManager;
import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.ISystemAdminManager;

@Controller
@RequestMapping("/operator/addTourActivity.html")
public final class addTourActivityController {

	CurrentUser currentUser = new CurrentUser();
	@Autowired
	private ITourOperatorManager tourOperatorManager;
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
		Activity act = new Activity();
		int tourID = Integer.parseInt(request.getParameter("tourID"));
		if(tourOperatorManager.getTourByID(tourID).getOperator().getOperatorID() != currentUser.getCurrentUserID()) {
			return new RedirectView("/antipodes/accessDenied.html");
		}
		model.addAttribute("tourID", tourID);
		model.addAttribute("activity", act);
		return "addTourActivity";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("activity") Activity act, 
			BindingResult result, 
			HttpServletRequest request,
			HttpServletResponse response) {

		int tourID = Integer.parseInt(request.getParameter("tourID"));
		validator.validate(act, result);
		if (result.hasErrors()) {
			return "addTourActivity";
		}

		systemAdminManager.saveActivity(act);
		return new RedirectView("alignTour.html?tourID=" + tourID);
	}
}
