package edu.itee.antipodes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.pages.ContactOperator;

@Controller
@RequestMapping("/contactTourOperator.html")
public final class contactTourOperatorController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		ContactOperator contactOperator = new ContactOperator();
		model.addAttribute("contactOperator", contactOperator);
		return "contactTourOperator";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("contactOperator") ContactOperator contactOpt,
			BindingResult result) {
		
		validator.validate(contactOpt, result);
		if (result.hasErrors()) { return "contactTourOperator"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
