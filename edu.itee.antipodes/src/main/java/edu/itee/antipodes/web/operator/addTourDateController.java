package edu.itee.antipodes.web.operator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


import edu.itee.antipodes.domain.db.TourDate;


@Controller
@RequestMapping("/operator/addTourDate.html")
public final class addTourDateController {

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		TourDate td = new TourDate();
		model.addAttribute("addTourDate", td);
		return "addTourDate";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("addTourDate") TourDate td, BindingResult result) {

		validator.validate(td, result);
		if (result.hasErrors()) {
			return "addTourDate";
		}

		return new RedirectView("addTourDate.html");
	}
}
