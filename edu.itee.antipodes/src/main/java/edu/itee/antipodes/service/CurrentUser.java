package edu.itee.antipodes.service;

import org.springframework.security.context.SecurityContextHolder;

public class CurrentUser {
	
	AccountManager aud = new SimpleAccountManager();
	
	public String getCurrentUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public int getCurrentUserID () {
		return aud.getAccountByUsername(getCurrentUsername()).getUserID();
	}
	
	public String getCurrentUserType() {
		return aud.getAccountByUsername(getCurrentUsername()).getUserType();
	}
	
}
