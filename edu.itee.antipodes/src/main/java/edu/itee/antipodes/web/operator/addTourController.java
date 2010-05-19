package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.Currency;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.ITourOperatorManager;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/operator/addTour.html")
public final class addTourController {

	@Autowired
	private ITourOperatorManager tourOperatorManager;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		Tour tourInfo = new Tour();
		model.addAttribute("addTour", tourInfo);
		model.addAttribute("currencyList", Currency.getCurrencyTest());
		return "addTour";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("addTour") Tour info,
			BindingResult result) {

		TourOperatorDaoHibernate todh = SpringApplicationContext
				.getTourOperatorDao();
		CurrentUser currentUser = new CurrentUser();

		validator.validate(info, result);
		if (result.hasErrors()) {
			return "addTour";
		}

		info.setOperator(todh.getTourOperatorByID(currentUser
				.getCurrentUserID()));
		tourOperatorManager.addTour(info);

		// Use the redirect-after-post pattern to reduce double-submits.
		return new RedirectView("uploadImages.html?tourID="
				+ tourOperatorManager.getTourByID(
						tourOperatorManager.getTours().size()).getTourID()
						+ "&state=add");

	}

}
