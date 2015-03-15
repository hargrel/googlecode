package edu.itee.antipodes.web.reporting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.pages.BillingTourOperators;
import edu.itee.antipodes.domain.pages.Search;
import edu.itee.antipodes.service.Currency;
import edu.itee.antipodes.service.IReportingManager;

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
	private IReportingManager reportingManager;

	@RequestMapping(method = RequestMethod.GET)
	public Object redirect(ModelMap model) {
		BillingTourOperators bto = new BillingTourOperators();
		setData(model, bto);
		model.addAttribute("billOperator", new BillingTourOperators());
		return "billTourOperator";
	}
	
	private void setData(ModelMap model, BillingTourOperators bto) {

		model.addAttribute("touroperators", reportingManager.getTourOperators());
		

	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(
			@ModelAttribute("billOperator") BillingTourOperators bto,
			BindingResult result, ModelMap map) {

		validator.validate(bto, result);
		if (result.hasErrors()) {
			setData(map, bto);
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
