package com.mycompany.domain;

import junit.framework.TestCase;

public class BookTest extends TestCase {

	public void testBook() throws Exception {
		Book book = new Book();
		book.setAuthor("Luke!");
		assertEquals("Luke!", book.getAuthor());	
	}
}