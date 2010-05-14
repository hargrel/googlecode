package edu.itee.antipodes.web.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.itee.antipodes.domain.pages.BillingTourOperators;
import edu.itee.antipodes.service.ReportingManager;

@Controller
@RequestMapping("/admin/billTourOperator.html")
public class billTourOperatorController {
	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	@Autowired
	private ReportingManager reportingManager;

	@RequestMapping(method = RequestMethod.GET)
	public Object redirect(Model model) {
		BillingTourOperators bto = new BillingTourOperators();
		model.addAttribute("touroperators", reportingManager.getTourOperators());
		model.addAttribute("billOperator", new BillingTourOperators());

		return "billTourOperator";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(
			@ModelAttribute("billOperator") BillingTourOperators bto,
			BindingResult result) {

		validator.validate(bto, result);
		if (result.hasErrors()) {
			return "billTourOperator";
		}

		try {
			String format = bto.getExportFormat();
			Date toDate = bto.getToDate();
			Date fromDate = bto.getFromDate();
			int operatorID = bto.getOperatorID();

			Map<String, Object> model = reportingManager.getBillingTourOperators(operatorID,
					fromDate, toDate);
			model.put("format", format);

			return new ModelAndView("reportBillingTourOperators", model);
		} catch (Exception e) {
			return new ModelAndView("billTourOperator");
		}
	}
}
