package edu.itee.antipodes.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.SystemAdminManager;
import edu.itee.antipodes.service.XMLGenerator;

@Controller
@RequestMapping("/admin/editGlobalListLocation.html")
public final class editGlobalListLocationController {

	@Autowired
	private Validator validator;

	SystemAdminManager sam = new SimpleSystemAdminManager();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String locationID = request.getParameter("locationID");
		if (locationID == null)
			return new RedirectView("globalListLocation.html");

		Location loc = sam.getLocationByID(locationID);
		if (loc == null)
			return new RedirectView("globalListLocation.html");

		model.addAttribute("loc", loc);
		return "editGlobalListLocation";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("loc") Location loc, BindingResult result) {

		validator.validate(loc, result);
		if (result.hasErrors()) {
			return "editGlobalListLocation";
		}

		sam.saveLocation(loc);
		XMLGenerator xml = new XMLGenerator();
		String x[]={"A"};
		try {
			xml.main(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView("globalListLocation.html");
	}
}
