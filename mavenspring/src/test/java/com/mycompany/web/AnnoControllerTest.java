package com.mycompany.web;

import junit.framework.TestCase;

public class AnnoControllerTest extends TestCase {

	public void testExampleHandlerView() throws Exception {
		AnnoController controller = new AnnoController();
		String viewName = controller.exampleHandler();
		assertEquals("anno", viewName);
	}
}