package edu.itee.antipodes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.UserMessage;

@Controller
@RequestMapping("/form.html")
public final class formController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		UserMessage userMessage = new UserMessage();
		model.addAttribute("userMessage", userMessage);
		return "form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("userMessage") UserMessage userMsg,
			BindingResult result) {
		
		validator.validate(userMsg, result);
		if (result.hasErrors()) { return "form"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
