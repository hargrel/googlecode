package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.AccountUserDaoHibernate;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.SimpleTourOperatorManager;
import edu.itee.antipodes.service.TourOperatorManager;

@Controller
@RequestMapping("/operator/editCompanyInfo.html")
public final class editCompanyInfoController {

	CurrentUser currentUser = new CurrentUser();
	TourOperatorDaoHibernate tod = DaoManager.getTourOperatorDao();
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model) {
		TourOperator operator = tod.getTourOperatorByID(currentUser.getCurrentUserID());
		model.addAttribute("editCompanyInfo", operator);
		return "editCompanyInfo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("editCompanyInfo") TourOperator operator,
			BindingResult result, ModelMap model) {
		
		validator.validate(operator, result);
		if (result.hasErrors()) { return "editCompanyInfo"; }
		operator.setOperatorID(currentUser.getCurrentUserID());
		tod.saveTourOperator(operator);
		model.addAttribute("editCompanyInfo", tod.getTourOperatorByID(currentUser.getCurrentUserID()));
		return "editCompanyInfo";
		
	}
}
