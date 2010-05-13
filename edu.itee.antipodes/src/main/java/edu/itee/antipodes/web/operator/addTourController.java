package edu.itee.antipodes.web.operator;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.SimpleTourOperatorManager;
import edu.itee.antipodes.service.TourManager;
import edu.itee.antipodes.service.TourOperatorManager;


@Controller
@RequestMapping("/operator/addTour.html")
public final class addTourController {
	
	
	@Autowired
	private Validator validator;
	
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@Autowired
	TourManager tourManager;

	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Tour tourInfo = new Tour();
		model.addAttribute("addTour", tourInfo);
		return "addTour";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("addTour") Tour info,
			BindingResult result) {
		
		TourOperatorDaoHibernate todh = DaoManager.getTourOperatorDao();
		CurrentUser currentUser = new CurrentUser();
		
		validator.validate(info, result);
		if (result.hasErrors()) { return "addTour"; }

		
		
		info.setOperator(todh.getTourOperatorByID(currentUser.getCurrentUserID()));
		tourManager.addTour(info);
		
		// Use the redirect-after-post pattern to reduce double-submits.
		return new RedirectView("uploadImages.html?tourID=" + tourManager.getTourByID(tourManager.getTours().size()).getTourID());
		
	}

}
