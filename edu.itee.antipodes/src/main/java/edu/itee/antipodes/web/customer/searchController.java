package edu.itee.antipodes.web.customer;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import edu.itee.antipodes.service.Currency;
import edu.itee.antipodes.service.ICustomerManager;

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
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Search search = new Search();
		setData(model, search);
		return "search";
	}

	private void setData(ModelMap model, Search search) {
		model.addAttribute("search", search);
		List<Activity> act = ad.getActivityList();
		model.addAttribute("activities", act);
		model.addAttribute("currencyList", Currency.getCurrencyTest());
	}

	@RequestMapping(method = RequestMethod.POST)
    public String post(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
    		@ModelAttribute("search") Search sch, BindingResult result, Model model, 
			@RequestParam("locationName") String locationName,
			@RequestParam(value="activityName",required=false) String activityName,
			@RequestParam("startDate") String startDate,
			@RequestParam("finishDate") String finishDate,
			@RequestParam("currency") String currency
    	) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException {

		validator.validate(sch, result);
		if (result.hasErrors()) { setData(modelMap, sch); return "search"; }
		
		try{
			activityName.isEmpty();
		}catch(NullPointerException npe){
			activityName = "";
		}
		
		Set<ListedTour> ListedTours = new HashSet<ListedTour>();
		List<Object> ls = customerManager.searchListedTours(activityName,
				locationName, startDate, finishDate, currency);
		if (ls != null) {
			Iterator<Object> it = ls.iterator();
			while (it.hasNext()) {
				Object[] tour = (Object[]) it.next();
				ListedTours.add((ListedTour) tour[0]); // tour[0] is the listedTour
			}
		}
		
		model.addAttribute("listedTours", ListedTours);
		return "searchResult";
    }
}
