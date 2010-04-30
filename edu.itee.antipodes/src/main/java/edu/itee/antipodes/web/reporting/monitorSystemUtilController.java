package edu.itee.antipodes.web.reporting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import edu.itee.antipodes.domain.pages.MonitorSystemUtil;
import edu.itee.antipodes.service.ReportingManager;
import edu.itee.antipodes.service.SimpleReportingManager;

@Controller
@RequestMapping("/monitorSystemUtil.html")
public class monitorSystemUtilController {
	@Autowired
	private Validator validator;

	ReportingManager rm = new SimpleReportingManager();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(Model model) {
		model.addAttribute("monitorSystem", new MonitorSystemUtil());
		return "monitorSystemUtil";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("monitorSystem") MonitorSystemUtil bto,
			BindingResult result) {

		validator.validate(bto, result);
		if (result.hasErrors()) {
			return new ModelAndView("monitorSystemUtil");
		}

		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate = df.parse(bto.getFromDate());
			Date toDate = df.parse(bto.getToDate());
			String format = bto.getExportFormat();

			Map<String, Object> model = rm.getMonitoringSystemUtilisation(
					fromDate, toDate);
			model.put("format", format);

			return new ModelAndView("reportMonitoringSystemUtilisation", model);
		} catch (Exception e) {
			return new ModelAndView("monitorSystemUtil");
		}
	}
}