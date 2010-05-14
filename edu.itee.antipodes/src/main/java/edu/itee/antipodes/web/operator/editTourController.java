package edu.itee.antipodes.web.operator;

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

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.service.TourManager;

@Controller
@RequestMapping("/operator/editTour.html")
public final class editTourController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	TourManager tourManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		return "search";
		/*
		int tourID = Integer.parseInt(request.getParameter("tourID"));
		Tour updateTourInfo = tourManager.getTourByID(tourID);
		ImageDao idh = DaoManager.getImageDao();
		List<Image> images = idh.getImageByTourID(tourID);
		model.addAttribute("editTour", updateTourInfo);
		model.addAttribute("images", images);
		model.addAttribute("numberOfImages", images.size());
		return "editTour";
		*/
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("editTour") Tour info,
			BindingResult result) {
		
		return "search";
		/*
		validator.validate(info, result);
		if (result.hasErrors()) { return "editTour"; }
		
		TourOperatorDaoHibernate todh = DaoManager.getTourOperatorDao();
		CurrentUser currentUser = new CurrentUser();
		
		info.setOperator(todh.getTourOperatorByID(currentUser.getCurrentUserID()));
		tourManager.updateTour(info);
		return new RedirectView("tourList.html");
		*/
	}

}
