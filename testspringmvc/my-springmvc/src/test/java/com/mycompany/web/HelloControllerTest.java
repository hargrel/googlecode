package com.mycompany.web;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTest extends TestCase {

	public void testHandleRequestView() throws Exception {
		HelloController controller = new HelloController();
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
	}
}
