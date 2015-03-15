package edu.itee.antipodes.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import edu.itee.antipodes.service.ISystemAdminManager;


@Controller
@RequestMapping("/forgotPassword.html")
public class forgotPasswordController {

	@RequestMapping(method = RequestMethod.GET)
	public Object showUserForm()
	{
		return "forgotPassword";
	}
	@RequestMapping(method = RequestMethod.POST)
	public Object getMessage(Model model,@RequestParam("email") String email) throws Exception
	{
		try{
			if(!systemAdminManager.regeneratePassword(email)){
				model.addAttribute("errorheader", "Oopps");
				model.addAttribute("errormessage", "Our email server is currently unavailable. Please try again later.");
				return "error";
			}
		}catch(NullPointerException npe){
			model.addAttribute("errorMessage", "The email you entered was invalid or does not exist.");
			return "forgotPassword";
		}
		
		model.addAttribute("headermessage", "Thank you");
		model.addAttribute("message", "New password have been sent to " + email);
		return "success";
	}
	@Autowired
	private ISystemAdminManager systemAdminManager;
}
