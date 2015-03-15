package com.mycompany.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	private int id;
	private String author;
	private String title;
	
	public Book() {
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	@Column
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	@Column
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}
