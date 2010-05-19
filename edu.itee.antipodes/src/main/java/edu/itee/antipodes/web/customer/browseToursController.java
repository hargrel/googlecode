package edu.itee.antipodes.web.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.service.ICustomerManager;

@Controller
public class browseToursController {
	
	@Autowired
	private ICustomerManager customerManager;
	
	
	@RequestMapping("/browseTours.html")
	public String showTour(Model model) {
		List<ListedTour> ListedTours = customerManager.getListedTours();
		model.addAttribute("listedTours", ListedTours);
		return "browseTours";
	}
	
}
