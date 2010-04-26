package edu.itee.antipodes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnnotationExampleController {
	
	@RequestMapping("/annotationexample.html")
	public void exampleHandler() {
	}
	
}