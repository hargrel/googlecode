package edu.itee.antipodes.web.operator;
/*
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.HttpServletBean;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.pages.AlignTour;

@Controller
@RequestMapping("/alignTour.html")
public class alignTourController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	/*
	protected void initBinder(HttpServletBean request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	  }*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		AlignTour alignTour = new AlignTour();
		model.addAttribute("alignTour", alignTour);
		return "alignTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@ModelAttribute("alignTour") AlignTour align,
			BindingResult result) {
		
		validator.validate(align, result);
		if (result.hasErrors()) { return "alignTour"; }
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return "redirect:thanks.html";
		
	}

}
