package edu.itee.antipodes.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.SimpleSystemAdminManager;
import edu.itee.antipodes.service.SystemAdminManager;

@Controller
@RequestMapping("/globalListActivity.html")
public class globalListActivityController {
	
	SystemAdminManager sam = new SimpleSystemAdminManager();
	
	@RequestMapping(method = RequestMethod.GET)
	public String redirect(ModelMap model) {
		
		model.addAttribute("activities", sam.getActivityList());
		return "globalListActivity";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object delete(HttpServletRequest request,
			HttpServletResponse response) {

		sam.removeActivityByID(request.getParameter("activityID"));

		// Use the redirect-after-post pattern to reduce double-submits.
		return new RedirectView("globalListActivity.html");

	}
}
