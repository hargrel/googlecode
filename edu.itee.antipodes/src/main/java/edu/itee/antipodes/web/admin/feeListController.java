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
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.MonthlyFeeDaoHibernate;

@Controller
@RequestMapping("/admin/feeList.html")
public class feeListController {
	MonthlyFeeDaoHibernate mfdh = DaoManager.getMonthlyFeeDao();
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String listID = request.getParameter("listID");
		
		
		List<Object[]> listedTourFees = mfdh.getMonthlyFeeForListedTour(Integer.parseInt(listID));
		model.addAttribute("listedTourFees", listedTourFees);
		return "feeList";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(@RequestParam("fee") float fee, @RequestParam("listID") int listID, @RequestParam("feeID") int feeID, Model model) {
		
		MonthlyFee monthlyFee = mfdh.getMonthlyFeeByID(feeID);
		monthlyFee.setFee(fee);
		mfdh.saveMonthlyFee(monthlyFee);
		//MonthlyFee monthlyFee = new MonthlyFee();
		//monthlyFee.setFee(fee);
		//monthlyFee.setFeeID(feeID);
		
		//mfdh.saveMonthlyFee(monthlyFee);
		
		List<Object[]> listedTourFees = mfdh.getMonthlyFeeForListedTour(listID);
		model.addAttribute("listedTourFees", listedTourFees);
		return "feeList";
	}

}
