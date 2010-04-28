package edu.itee.antipodes.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.Location;

@Controller
@RequestMapping("/editGlobalListLocation.html")
public final class editGlobalListLocationController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Location location = new Location();
		model.addAttribute("location", location);
		return "editGlobalListLocation";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("location") Location loc,
			BindingResult result) {
		
		validator.validate(loc, result);
		if (result.hasErrors()) { return "editGlobalListLocation"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
