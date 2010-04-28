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

import edu.itee.antipodes.domain.pages.BillingTourOperators;
import edu.itee.antipodes.service.ReportingManager;
import edu.itee.antipodes.service.SimpleReportingManager;

@Controller
@RequestMapping("/detectAbuse.html")
public class detectAbuseController {
	@Autowired
	private Validator validator;

	ReportingManager rp = new SimpleReportingManager();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(Model model) {
		model.addAttribute("detectAbuse", new BillingTourOperators());
		return "detectAbuse";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("detectAbuse") BillingTourOperators bto,
			BindingResult result) {

		validator.validate(bto, result);
		if (result.hasErrors()) {
			return new ModelAndView("detectAbuse");
		}

		try {
			String format = "pdf";

			Map<String, Object> model = rp.getDetectingAbuse(123);
			model.put("format", format);

			return new ModelAndView("reportDetectingAbuse", model);
		} catch (Exception e) {
			return new ModelAndView("detectAbuse");
		}
	}
}
