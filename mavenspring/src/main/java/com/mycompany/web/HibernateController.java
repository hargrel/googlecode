package com.mycompany.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HibernateController {
	
	@RequestMapping("/hibernate.htm")
    public String exampleHandler() {
		return "hibernate";
    }
	
}
