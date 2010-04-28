package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.pages.CompanyInfo;

@Controller
@RequestMapping("/updateCompanyInfo.html")
public final class updateCompanyInfoController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		CompanyInfo companyInfo = new CompanyInfo();
		model.addAttribute("updateCompanyInfo", companyInfo);
		return "updateCompanyInfo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("updateCompanyInfo") CompanyInfo compInfo,
			BindingResult result) {
		
		validator.validate(compInfo, result);
		if (result.hasErrors()) { return "updateCompanyInfo"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
