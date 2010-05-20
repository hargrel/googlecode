package edu.itee.antipodes.web.operator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.pages.AlignTour;
import edu.itee.antipodes.domain.pages.AlignTourDate;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.ITourOperatorManager;

@Controller
// @RequestMapping("/operator/alignTour.html")
public class alignTourController {

	CurrentUser currentUser = new CurrentUser();
	String successMessage;
	
	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	private ITourOperatorManager tourOperatorManager;

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	private void setData(ModelMap model, String tourID) {
		model.addAttribute("locations", tourOperatorManager.getLocationList());
		model.addAttribute("activities", tourOperatorManager.getActivityList());
		model.addAttribute("tour", tourOperatorManager.getTourByID(tourID));
	}

	@RequestMapping(value = "/operator/alignTour.html", method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String tourID = request.getParameter("tourID");

		if(tourOperatorManager.getTourByID(tourID).getOperator().getOperatorID() != currentUser.getCurrentUserID()) {
			return new RedirectView("/antipodes/accessDenied.html");
		}
		model.addAttribute("errordate", request.getParameter("errordate"));
		model.addAttribute("successMessage", request.getParameter("successMessage"));

		setData(model, tourID);
		model.addAttribute("alignTourDate", tourOperatorManager
				.getAlignTourDateByID(tourID));
		model.addAttribute("alignTour", tourOperatorManager
				.getAlignTourByID(tourID));

		return "alignTour";
	}

	@RequestMapping(value = "/operator/alignTour.html", method = RequestMethod.POST)
	public Object post(ModelMap model,
			@ModelAttribute("alignTour") AlignTour alignTour,
			@ModelAttribute("alignTourDate") AlignTourDate alignTourDate,
			BindingResult result) throws Exception {

		setData(model, String.valueOf(alignTour.getTourID()));

		validator.validate(alignTour, result);
		if (result.hasErrors()) {
			return "alignTour";
		}

		successMessage = "Update successful!";
		tourOperatorManager.alignTour(alignTour);

		return new RedirectView("alignTour.html?tourID="
				+ alignTourDate.getTourID() + "&successMessage=" + successMessage);
	}

	@RequestMapping(value = "/operator/alignTourDate.html", method = RequestMethod.POST)
	public Object addDate(ModelMap model, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("alignTourDate") AlignTourDate alignTourDate,
			BindingResult result) throws Exception {

		setData(model, String.valueOf(alignTourDate.getTourID()));

		model.addAttribute("alignTour", tourOperatorManager
				.getAlignTourByID(String.valueOf(alignTourDate.getTourID())));

		validator.validate(alignTourDate, result);
		if (result.hasErrors()) {
			return new RedirectView("alignTour.html?tourID="
					+ alignTourDate.getTourID()
					+ "&errordate=Please enter correct dates");
		}

		tourOperatorManager.alignTourDate(alignTourDate);

		return new RedirectView("alignTour.html?tourID="
				+ alignTourDate.getTourID());
	}

	@RequestMapping(value = "/operator/deleteTourDate.html", method = RequestMethod.POST)
	public Object deleteDate(ModelMap model,@RequestParam("tourID") String tourID,
			@RequestParam("dateID") String dateID) throws Exception {

		tourOperatorManager.deleteTourDate(dateID);

		return new RedirectView("alignTour.html?tourID=" + tourID);
	}
}
