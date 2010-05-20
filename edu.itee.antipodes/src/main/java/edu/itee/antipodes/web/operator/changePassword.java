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

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.pages.ChangeNewPassword;
import edu.itee.antipodes.service.CurrentUser;
import edu.itee.antipodes.service.IAccountManager;

@Controller
@RequestMapping("/operator/changePassword.html")
public class changePassword {
	String successMessage;

	@Autowired
	private Validator validator;
	
	@Autowired
	IAccountManager accountManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		ChangeNewPassword changeNewPassword = new ChangeNewPassword();
		successMessage = "";
		model.addAttribute("successMessage", successMessage);
		model.addAttribute("changeNewPassword", changeNewPassword);
		return "changePassword";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object changePwd(@ModelAttribute("changeNewPassword") ChangeNewPassword changeNewPassword,
			BindingResult result,
			ModelMap model) throws Exception {
		
		validator.validate(changeNewPassword, result);
        if (result.hasErrors()) { return "changePassword"; }

		CurrentUser currentUser = new CurrentUser();
		AccountUser accUser = accountManager.getAccountByID(currentUser.getCurrentUserID());
		
		accUser.setPassword(changeNewPassword.getNewPassword());
		
		accountManager.updateAccount(accUser);
		successMessage = "Update successful!";
		model.addAttribute("successMessage", successMessage);
		

		return "changePassword";
	}
}
