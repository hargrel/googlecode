package com.mycompany.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnoController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping("/anno.htm")
    public void exampleHandler() {
		logger.info("Returning view using AnnoController.");
    }

}