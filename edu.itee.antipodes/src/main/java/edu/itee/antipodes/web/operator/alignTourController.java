package edu.itee.antipodes.web.operator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.pages.AlignTour;
import edu.itee.antipodes.service.ITourOperatorManager;

@Controller
@RequestMapping("/operator/alignTour.html")
public class alignTourController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@Autowired
	private ITourOperatorManager tourOperatorManager;
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String tourID = request.getParameter("tourID");
		
		model.addAttribute("locations", tourOperatorManager.getLocationList());
		model.addAttribute("activities", tourOperatorManager.getActivityList());
		model.addAttribute("alignTour", tourOperatorManager.getAlignTourByID(tourID));
		model.addAttribute("tour", tourOperatorManager.getTourByID(tourID));
		return "alignTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(
			@RequestParam("startDate") String startDateString,
			@RequestParam("finishDate") String finishDateString, 
			@ModelAttribute("alignTour") AlignTour alignTour,
			BindingResult result) throws Exception {
		
		validator.validate(alignTour, result);
		if (result.hasErrors()) { return "alignTour"; }
		
		
		tourOperatorManager.alignTour(startDateString, finishDateString, alignTour);
		
		return new RedirectView("alignTourList.html");
	}

}
