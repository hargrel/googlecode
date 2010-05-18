package edu.itee.antipodes.web.operator;

import java.util.List;

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

import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.Currency;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.ITourOperatorManager;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/operator/editTour.html")
public final class editTourController {
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	private ITourOperatorManager tourOperatorManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		int tourID = Integer.parseInt(request.getParameter("tourID"));
		Tour updateTourInfo = tourOperatorManager.getTourByID(tourID);
		ImageDao idh = SpringApplicationContext.getImageDao();
		List<Image> images = idh.getImageByTourID(tourID);
		model.addAttribute("editTour", updateTourInfo);
		model.addAttribute("images", images);
		model.addAttribute("numberOfImages", images.size());
		model.addAttribute("currencyList", Currency.getCurrencyTest());
		return "editTour";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("editTour") Tour info,
			BindingResult result) {
		
		validator.validate(info, result);
		if (result.hasErrors()) { return "editTour"; }
		
		TourOperatorDaoHibernate todh = SpringApplicationContext.getTourOperatorDao();
		CurrentUser currentUser = new CurrentUser();
		
		info.setOperator(todh.getTourOperatorByID(currentUser.getCurrentUserID()));
		tourOperatorManager.updateTour(info);
		return new RedirectView("tourList.html");
		
	}

}
