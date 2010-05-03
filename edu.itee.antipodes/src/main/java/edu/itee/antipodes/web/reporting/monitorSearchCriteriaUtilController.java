package edu.itee.antipodes.web.reporting;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.itee.antipodes.domain.pages.MonitorSearchCriteriaUtil;
import edu.itee.antipodes.service.ReportingManager;
import edu.itee.antipodes.service.SimpleReportingManager;

@Controller
@RequestMapping("/monitorSearchCriteriaUtil.html")
public class monitorSearchCriteriaUtilController {
	@Autowired
	private Validator validator;

	ReportingManager rm = new SimpleReportingManager();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(Model model) {
		model.addAttribute("criterias", rm.getCriterias());
		model.addAttribute("monitorCriteria", new MonitorSearchCriteriaUtil());
		return "monitorSearchCriteriaUtil";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("monitorCriteria") MonitorSearchCriteriaUtil bto,
			BindingResult result) {

		validator.validate(bto, result);
		if (result.hasErrors()) {
			return new ModelAndView("monitorSearchCriteriaUtil");
		}

		try {
			String format = bto.getExportFormat();
			String criteria = bto.getCriteria();

			// TODO: UI Mapping

			Map<String, Object> model = rm
					.getMonitoringSearchCriteriaUtilisation(criteria);
			model.put("format", format);

			return new ModelAndView(
					"reportMonitoringSearchCriteriaUtilisation", model);
		} catch (Exception e) {
			return new ModelAndView("monitorSearchCriteriaUtil");
		}
	}
}