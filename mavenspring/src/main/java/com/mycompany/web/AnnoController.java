package com.mycompany.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnoController {

	@RequestMapping("/anno.htm")
    public String exampleHandler() {
		return "anno";
    }

}