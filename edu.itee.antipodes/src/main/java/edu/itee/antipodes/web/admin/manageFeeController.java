package edu.itee.antipodes.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.MonthlyFee;

@Controller
@RequestMapping("/admin/manageFee.html")
public final class manageFeeController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		MonthlyFee monthlyFee = new MonthlyFee();
		model.addAttribute("monthlyFee", monthlyFee);
		return "manageFee";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("monthlyFee") MonthlyFee fee,
			BindingResult result) {
		
		validator.validate(fee, result);
		if (result.hasErrors()) { return "manageFee"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
