package edu.itee.antipodes.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.itee.antipodes.domain.db.MonthlyFee;
import edu.itee.antipodes.repository.MonthlyFeeDaoHibernate;
import edu.itee.antipodes.utils.SpringApplicationContext;

@Controller
@RequestMapping("/admin/feeList.html")
public class feeListController {
	MonthlyFeeDaoHibernate mfdh = SpringApplicationContext.getMonthlyFeeDao();
	String successMessage;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		String listID = request.getParameter("listID");

		List<Object[]> listedTourFees = mfdh.getMonthlyFeeForListedTour(Integer
				.parseInt(listID));
		successMessage = "";
		model.addAttribute("listedTourFees", listedTourFees);
		model.addAttribute("successMessage", successMessage);
		return "feeList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(@RequestParam("fee") String feeString,
			@RequestParam("listID") int listID,
			@RequestParam("feeID") int feeID, Model model) {

		
		MonthlyFee monthlyFee = mfdh.getMonthlyFeeByID(feeID);
		String errorMessage;

		try {
			float fee = Float.valueOf(feeString.trim()).floatValue();
			monthlyFee.setFee(fee);
			mfdh.saveMonthlyFee(monthlyFee);
		} catch (NumberFormatException nfe) {
			errorMessage = "Please enter a correct value.";
			model.addAttribute("errorMessage", errorMessage);
		}

		successMessage = "Update successful!";
		List<Object[]> listedTourFees = mfdh.getMonthlyFeeForListedTour(listID);
		model.addAttribute("listedTourFees", listedTourFees);
		model.addAttribute("successMessage", successMessage);
		return "feeList";
		
	}

}
