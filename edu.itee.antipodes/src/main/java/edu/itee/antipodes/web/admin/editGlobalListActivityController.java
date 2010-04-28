package edu.itee.antipodes.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.Activity;

@Controller
@RequestMapping("/editGlobalListActivity.html")
public final class editGlobalListActivityController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Activity activity = new Activity();
		model.addAttribute("activity", activity);
		return "editGlobalListActivity";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("activity") Activity act,
			BindingResult result) {
		
		validator.validate(act, result);
		if (result.hasErrors()) { return "editGlobalListActivity"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
