package edu.itee.antipodes.web.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class companyInfoController {

	@RequestMapping("/companyInfo.html")
	public String redirect()
	{
		return "companyInfo";
	}
}
