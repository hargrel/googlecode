package edu.itee.antipodes.web.operator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.pages.AlignTour;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.ListedTourDaoHibernate;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.CurrentUser;
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
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String tourID = request.getParameter("tourID");
		
		
		AlignTour alignTour = new AlignTour();
		
		LocationDao ld = DaoManager.getLocationDao();
		List<Location> loc = ld.getLocationList();
		ActivityDao ad = DaoManager.getActivityDao();
		List<Activity> act = ad.getActivityList();

		alignTour.setTourID(Integer.parseInt(tourID));
		
		model.addAttribute("locations", loc);
		model.addAttribute("activities", act);
		model.addAttribute("alignTour", alignTour);
		model.addAttribute("tour", tourManager.getTourByID(Integer.parseInt(tourID)));
		return "alignTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(
			@RequestParam("startDate") String startDateString,
			@RequestParam("finishDate") String finishDateString, 
			@ModelAttribute("alignTour") AlignTour align,
			BindingResult result) throws Exception {
		
		validator.validate(align, result);
		if (result.hasErrors()) { return "alignTour"; }
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Date startDate = df.parse(startDateString);
		Date finishDate = df.parse(finishDateString);
		
		ListedTourDaoHibernate ltdh = DaoManager.getListedTourDao();
		TourDaoHibernate tdh = DaoManager.getTourDao();
		TourOperatorDaoHibernate todh = DaoManager.getTourOperatorDao();
		
		CurrentUser currentUser = new CurrentUser();
		ListedTour listedTour = new ListedTour();
		
		listedTour.setTour(tdh.getTourByID(align.getTourID()));
		listedTour.setTourID(tdh.getTourByID(align.getTourID()).getTourID());
		listedTour.setOperator(todh.getTourOperatorByID(currentUser.getCurrentUserID()));
		if(startDate.getDate() != 0 || finishDate.getDate() != 0){
			listedTour.setListedFrom(startDate);
			listedTour.setListedTo(finishDate);
		}
		
		ltdh.addListedTour(listedTour);
		// Use the redirect-after-post pattern to reduce double-submits.
		return "alignTourList";
		
	}

}
