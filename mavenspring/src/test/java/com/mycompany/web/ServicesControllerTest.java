package com.mycompany.web;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

public class ServicesControllerTest extends TestCase {

	public void testTimeHandlerView() throws Exception {
		
		ServicesController controller = new ServicesController();
		ModelAndView mav = controller.timeHandler();
		assertEquals("time", mav.getViewName());
		System.out.print(mav.getModel().get("time"));
	}
	
}
