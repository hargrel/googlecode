package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

public final class BillingTourOperators {
	
	@NotBlank
	@Length(max = 80)
	@RegExp(value = "[a-zA-Z]*")
	private String name;
	
	@NotBlank
	@Email
	@Length(max = 80)
	private String email;
	
	@NotBlank
	@Length(max = 10)
	@RegExp(value = "[0-9]*")
	private String telephone;
	
	@NotBlank
	@Length(max = 80)
	private String subject;
	
	@NotBlank
	@Length(max = 4000)
	private String text;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
