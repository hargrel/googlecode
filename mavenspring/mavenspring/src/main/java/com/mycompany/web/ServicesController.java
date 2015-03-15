package com.mycompany.web;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicesController {

	@RequestMapping("/time.htm")
    public ModelAndView timeHandler() {
		
		ModelAndView mav = new ModelAndView("time");
		
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		
		mav.addObject("time", currentTimestamp);
		
		return mav;
		
    }

}