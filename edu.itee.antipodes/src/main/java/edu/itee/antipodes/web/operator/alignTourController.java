package edu.itee.antipodes.web.operator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class alignTourController {

	@RequestMapping("/alignTour.html")
	public String redirect()
	{
		return "alignTour";
	}
}
