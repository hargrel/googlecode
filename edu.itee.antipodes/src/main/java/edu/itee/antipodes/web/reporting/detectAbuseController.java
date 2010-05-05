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

import edu.itee.antipodes.domain.pages.DetectAbuse;
import edu.itee.antipodes.service.ReportingManager;
import edu.itee.antipodes.service.SimpleReportingManager;

@Controller
@RequestMapping("/admin/detectAbuse.html")
public class detectAbuseController {
	@Autowired
	private Validator validator;

	ReportingManager rp = new SimpleReportingManager();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(Model model) {
		model.addAttribute("detectAbuse", new DetectAbuse());
		return "detectAbuse";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView post(@ModelAttribute("detectAbuse") DetectAbuse bto,
			BindingResult result) {

		validator.validate(bto, result);
		if (result.hasErrors()) {
			return new ModelAndView("detectAbuse");
		}

		try {
			String format = bto.getExportFormat();
			int minNo = bto.getCriteriaNum();

			Map<String, Object> model = rp.getDetectingAbuse(minNo);
			model.put("format", format);

			return new ModelAndView("reportDetectingAbuse", model);
		} catch (Exception e) {
			return new ModelAndView("detectAbuse");
		}
	}
}
