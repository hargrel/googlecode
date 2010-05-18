package edu.itee.antipodes.web.customer;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
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

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.pages.Search;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.service.ICustomerManager;
import edu.itee.antipodes.service.SimpleCustomerManager;

@Controller
@RequestMapping("/search.html")
public class searchController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@Autowired
	private ActivityDao ad;
	
	@Autowired
	private ICustomerManager customerManager;
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Search search = new Search();
		model.addAttribute("search", search);
		List<Activity> act = ad.getActivityList();
		model.addAttribute("activities", act);
		return "search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public String post(@ModelAttribute("search") Search sch, BindingResult result, Model model, 
		@RequestParam("locationName") String locationName,
		@RequestParam(value="activityName",required=false) String activityName,
		@RequestParam("startDate") String startDate,
		@RequestParam("finishDate") String finishDate
    	) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException {

		validator.validate(sch, result);
		if (result.hasErrors()) { return "search"; }

		Set<ListedTour> ListedTours = new HashSet<ListedTour>();
		//ICustomerManager cm = new SimpleCustomerManager();
		// should name activityNames, locationNames
		Iterator<Object> it = customerManager.searchListedTours(activityName,locationName,startDate,finishDate).iterator();
		// tour[0] is the listedTour
		while(it.hasNext()) {Object[] tour = (Object[]) it.next(); ListedTours.add((ListedTour)tour[0]);}
		model.addAttribute("listedTours", ListedTours);
		return "searchResult";
    }

//	public static void main(String[] args) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException {
//		String locationsName = "Peru";
//		String activityName = "Seek";
//		Set<ListedTour> ListedTours = new HashSet<ListedTour>();
//		System.out.println("******");
//		ICustomerManager cm = new SimpleCustomerManager();
//		Iterator<Object> it = cm.searchListedTours(activityName,locationsName,"","").iterator();
//		System.out.println("******");
//		while(it.hasNext()) {Object[] tour = (Object[]) it.next(); ListedTours.add((ListedTour)tour[0]);}
//		for(ListedTour lt: ListedTours) {
//			System.out.println("***   "+lt.getListID());
//		}
//		if (ListedTours.size() == 0) {System.out.println("***   nothing found");}
//	}
	
}


