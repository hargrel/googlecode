package edu.itee.antipodes.web.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/operator/editCompanyInfo.html")
public final class editCompanyInfoController {

	CurrentUser currentUser = new CurrentUser();
	TourOperatorDaoHibernate tod = SpringApplicationContext.getTourOperatorDao();
	String successMessage;
	
	@Autowired
	private Validator validator;
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model) {
		TourOperator operator = tod.getTourOperatorByID(currentUser.getCurrentUserID());
		successMessage = "";
		model.addAttribute("editCompanyInfo", operator);
		model.addAttribute("successMessage", successMessage);
		return "editCompanyInfo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@ModelAttribute("editCompanyInfo") TourOperator operator,
			BindingResult result, Model model) {
		
		validator.validate(operator, result);
		if (result.hasErrors()) { return "editCompanyInfo"; }
		operator.setOperatorID(currentUser.getCurrentUserID());
		tod.saveTourOperator(operator);
		successMessage = "Update successful!";
		model.addAttribute("successMessage", successMessage);
		return "editCompanyInfo";
		
	}
}
