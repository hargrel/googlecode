package edu.itee.antipodes.web.customer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HttpServletBean;


import edu.itee.antipodes.domain.pages.Search;

@Controller
@RequestMapping("/search.html")
public class searchController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	/*@InitBinder
	protected void initBinder(HttpServletBean request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
	    dateFormat.setLenient(false);
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, false);
	    binder.registerCustomEditor(Date.class, editor);
	  }*/
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("dd-MMM-yy"), true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Search search = new Search();
		model.addAttribute("search", search);
		return "search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("search") Search sch,
			BindingResult result) {
		
		validator.validate(sch, result);
		if (result.hasErrors()) { return "search"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "searchResult";
		
	}

}
