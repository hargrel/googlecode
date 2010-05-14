package edu.itee.antipodes.web.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.pages.ContactOperator;
import edu.itee.antipodes.service.CustomerManager;

@Controller
@RequestMapping("/contactTourOperator.html")
public final class contactTourOperatorController {

	@Autowired
	private Validator validator;
	@Autowired
	private CustomerManager customerManager;

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(HttpServletRequest request, ModelMap model) {
		
		String operatorID = request.getParameter("operatorID");
		ContactOperator contactOperator = customerManager.getContactOperator(operatorID);

		if (contactOperator == null)
			return new RedirectView("search.html");
		
		try{
			model.addAttribute("contactOperator", contactOperator);
			return "contactTourOperator";
		} catch (NumberFormatException ex) {
			return new RedirectView("search.html");
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(
			@ModelAttribute("contactOperator") ContactOperator contactOpt,
			BindingResult result) {

		validator.validate(contactOpt, result);
		if (result.hasErrors()) {
			return "contactTourOperator";
		}

		customerManager.contactOperator(contactOpt);

		return "search";
	}
}
