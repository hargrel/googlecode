package com.mycompany.dao;

import com.mycompany.domain.Book;

public interface BookDao {

	public void create(Book book);
	public Book retrieve(int id);

}
