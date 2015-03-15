package edu.itee.antipodes.web.operator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.ISystemAdminManager;

@Controller
@RequestMapping("/operator/tourLocationList.html")
public class tourLocationListController {
	@Autowired
	private ISystemAdminManager systemAdminManager;

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(ModelMap model) {

		model.addAttribute("locations", systemAdminManager.getLocationList());
		return "tourLocationList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object deleteLocation(HttpServletRequest request,
			HttpServletResponse response) {

		systemAdminManager.removeLocationByID(request.getParameter("locationID"));

		// Use the redirect-after-post pattern to reduce double-submits.
		return new RedirectView("tourLocationList.html");

	}
}
