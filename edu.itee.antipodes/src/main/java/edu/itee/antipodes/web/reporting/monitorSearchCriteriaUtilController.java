package edu.itee.antipodes.web.reporting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.service.SimpleReportingManager;

@Controller
@RequestMapping("/monitorSearchCriteriaUtil.html")
public class monitorSearchCriteriaUtilController 
{
	@RequestMapping(method = RequestMethod.GET)
	public String redirect(Model model)
	{
		SimpleReportingManager srm = new SimpleReportingManager();
		
		model.addAttribute("criterias", srm.getCriterias());
		return "monitorSearchCriteriaUtil";	
	}
}
