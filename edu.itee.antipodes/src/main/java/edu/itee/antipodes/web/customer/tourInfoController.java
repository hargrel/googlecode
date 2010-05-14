package edu.itee.antipodes.web.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.service.CustomerManager;
import edu.itee.antipodes.service.SimpleCustomerManager;

@Controller
@RequestMapping("/tourInfo.html")
public class tourInfoController {

	private CustomerManager cm = new SimpleCustomerManager();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model) {
		return "tourInfo";
	}	

	@RequestMapping(method = RequestMethod.POST)
	public String showInventory(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int listID = Integer.parseInt(request.getParameter("listID"));
		ListedTour listedTour = cm.getListedTour(listID);	
		model.addAttribute("listedTour", listedTour);
		return "tourInfo";
	}		
}


