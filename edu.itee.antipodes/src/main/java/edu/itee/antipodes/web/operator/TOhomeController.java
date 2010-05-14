package edu.itee.antipodes.web.operator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TOhomeController {

	@RequestMapping("/operator/TOhome.html")
	public Object redirect()
	{
		
		return "TOhome";
	}
}
