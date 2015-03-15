package edu.itee.antipodes.web.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.service.ICustomerManager;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/tourInfo.html")
public class tourInfoController {

	@Autowired
	private ICustomerManager customerManager;// = new SimpleCustomerManager();

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model) {
		return "tourInfo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String showInventory(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int listID = Integer.parseInt(request.getParameter("listID"));
		ListedTour listedTour = customerManager.getListedTour(listID);
		model.addAttribute("listedTour", listedTour);

		if (listedTour.getTourID() > 0) {
			ImageDao idh = SpringApplicationContext.getImageDao();
			List<Image> images = idh.getImageByTourID(listedTour.getTourID());
			model.addAttribute("images", images);
		}

		return "tourInfo";
	}
}
