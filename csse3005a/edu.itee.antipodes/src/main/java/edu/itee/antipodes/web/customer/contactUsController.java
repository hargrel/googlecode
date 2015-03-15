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
import edu.itee.antipodes.service.ICustomerManager;

@Controller
@RequestMapping("/contactUs.html")
public final class contactUsController {

	@Autowired
	private Validator validator;
	@Autowired
	private ICustomerManager customerManager;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		ContactOperator contactUs = new ContactOperator();
		model.addAttribute("contactUs", contactUs);
		return "contactUs";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(ModelMap model,
			@ModelAttribute("contactUs") ContactOperator contact,
			BindingResult result) {

		validator.validate(contact, result);
		if (result.hasErrors()) {
			return "contactUs";
		}

		if(!customerManager.contactUs(contact)){
			model.addAttribute("errorheader", "Oopps");
			model.addAttribute("errormessage", "Our email server is currently unavailable. Please try again later.");
			return "error";
		}

		model.addAttribute("headermessage", "Thank you.");
		model.addAttribute("message",
				"Your message has been sent. Thank you for your time");
		return "success";

	}

}
