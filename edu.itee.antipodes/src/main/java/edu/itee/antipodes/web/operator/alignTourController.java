package edu.itee.antipodes.web.operator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.pages.AlignTour;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.service.TourManager;

@Controller
@RequestMapping("/operator/alignTour.html")
public class alignTourController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@Autowired
	TourManager tourManager;
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("dd-MMM-yy"), true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		AlignTour alignTour = new AlignTour();
		LocationDao ld = DaoManager.getLocationDao();
		List<Location> loc = ld.getLocationList();
		ActivityDao ad = DaoManager.getActivityDao();
		List<Activity> act = ad.getActivityList();
		
		model.addAttribute("activities", act);
		model.addAttribute("locations", loc);
		model.addAttribute("alignTour", alignTour);
		return "alignTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("alignTour") AlignTour align,
			BindingResult result) {
		
		validator.validate(align, result);
		if (result.hasErrors()) { return "alignTour"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
