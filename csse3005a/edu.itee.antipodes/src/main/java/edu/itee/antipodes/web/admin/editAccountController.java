package edu.itee.antipodes.web.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.service.IAccountManager;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/admin/editAccount.html")
public final class editAccountController {

	String successMessage;
	@Autowired
	private Validator validator;

	TourOperatorDao tod = SpringApplicationContext.getTourOperatorDao();

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String userID = request.getParameter("userID");
		if (userID == null)
			return new RedirectView("editAccountList.html");

		AccountUser accountUser = accountManager.getAccountByID(Integer
				.parseInt(userID));
		if (accountUser == null)
			return new RedirectView("editAccountList.html");

		TourOperator operator = tod
				.getTourOperatorByID(accountUser.getUserID());
		model.addAttribute("accountUser", accountUser);
		if (accountUser.getUserType().equalsIgnoreCase("admin")) {
			model.addAttribute("hide", "none");
		} else {
			model.addAttribute("hide", "");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			model.addAttribute("membershipExpiry", df.format(operator
					.getMembershipExpired()));
		}
		successMessage = "";
		model.addAttribute("successMessage", successMessage);
		return "editAccount";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object post(HttpServletRequest request,
			@ModelAttribute("accountUser") AccountUser accountUser,
			BindingResult result, ModelMap model) throws Exception {

		// @RequestParam("membershipExpiry") String membershipExpiry
		validator.validate(accountUser, result);

		if (result.hasErrors()) {
			if (accountUser.getUserType().equalsIgnoreCase("admin")) {
				model.addAttribute("hide", "none");
			} else {
				model.addAttribute("hide", "");
				model.addAttribute("membershipExpiry", request
						.getParameter("membershipExpiry"));
			}
			model.addAttribute("successMessage", "");
			return "editAccount";
		}

		TourOperator operator = new TourOperator();
		accountManager.updateAccount(accountUser);
		String membershipExpiry = request.getParameter("membershipExpiry");
		Date membershipExpiryDate = null;
		
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			membershipExpiryDate = df.parse(membershipExpiry);
			
			if (accountUser.getUserType().equalsIgnoreCase("operator")
					&& !membershipExpiry.isEmpty()) {
				operator = tod.getTourOperatorByID(accountUser.getUserID());
				operator.setOperatorID(accountUser.getUserID());

				operator.setMembershipExpired(membershipExpiryDate);
				tod.saveTourOperator(operator);
			}
			if (accountUser.getUserType().equalsIgnoreCase("admin")) {
				model.addAttribute("hide", "none");
			} else {
				model.addAttribute("hide", "");
				model.addAttribute("membershipExpiry", df.format(operator
						.getMembershipExpired()));
			}
			successMessage = "Update successful!";
		} catch (Exception ex) {
			successMessage = "Incorrect expiry date";
		}

		
		model.addAttribute("accountUser", accountUser);
		model.addAttribute("successMessage", successMessage);
		return "editAccount";

	}

	@Autowired
	IAccountManager accountManager;

}
