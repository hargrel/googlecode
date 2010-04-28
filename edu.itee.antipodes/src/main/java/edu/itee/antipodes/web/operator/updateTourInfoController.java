package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.pages.TourInfo;

@Controller
@RequestMapping("/updateTourInfo.html")
public final class updateTourInfoController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		TourInfo updateTourInfo = new TourInfo();
		model.addAttribute("updateTourInfo", updateTourInfo);
		return "updateTourInfo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("updateTourInfo") TourInfo info,
			BindingResult result) {
		
		validator.validate(info, result);
		if (result.hasErrors()) { return "updateTourInfo"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
