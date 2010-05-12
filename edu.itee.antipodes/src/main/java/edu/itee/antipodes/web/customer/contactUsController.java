package edu.itee.antipodes.web.customer;

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
@RequestMapping("/contactUs.html")
public final class contactUsController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		ContactOperator contactUs = new ContactOperator();
		model.addAttribute("contactUs", contactUs);
		return "contactUs";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("contactOperator") ContactOperator contact,
			BindingResult result) {
		
		validator.validate(contact, result);
		if (result.hasErrors()) { return "contactUs"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "search";
		
	}

}
