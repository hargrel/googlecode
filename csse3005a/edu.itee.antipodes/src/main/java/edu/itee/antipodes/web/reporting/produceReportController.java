package edu.itee.antipodes.web.reporting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class produceReportController {

	@RequestMapping("/admin/produceReport.html")
	public String redirect()
	{
		return "produceReport";
	}
}
