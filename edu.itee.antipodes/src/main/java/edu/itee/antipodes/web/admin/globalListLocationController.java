package edu.itee.antipodes.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.SystemAdminManager;

@Controller
@RequestMapping("/globalListLocation.html")
public class globalListLocationController {

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(ModelMap model) {
		LocationDao ld = DaoManager.getLocationDao();

		model.addAttribute("locations", ld.getLocationList());
		return "globalListLocation";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object deleteLocation(HttpServletRequest request, HttpServletResponse response) {
		SystemAdminManager sam = new SimpleSystemAdminManager();
		sam.removeLocationByID(request.getParameter("tourID"));
		System.out.println("++++++++ REMOVE LOCATION ID ");
		// Use the redirect-after-post pattern to reduce double-submits.
		return new RedirectView("globalListLocation.html");

	}
}
