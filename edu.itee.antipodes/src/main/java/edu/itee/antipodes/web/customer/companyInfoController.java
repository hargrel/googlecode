package edu.itee.antipodes.web.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.db.*;
import edu.itee.antipodes.service.*;

@Controller
@RequestMapping("/companyInfo.html")
public class companyInfoController {

	@Autowired
  	private CustomerManager customerManager;// = new SimpleCustomerManager();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model) {
		return "companyInfo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showInventory(Model model,
			@RequestParam("operatorID") int operatorID) {
		List<ListedTour> listedTours = customerManager.getListedToursByOpID(operatorID);
		model.addAttribute("listedTours", listedTours);
		return "companyInfo";
	}
}


