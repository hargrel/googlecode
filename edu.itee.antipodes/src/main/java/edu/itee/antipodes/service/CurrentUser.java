package edu.itee.antipodes.service;

import org.springframework.security.context.SecurityContextHolder;

public class CurrentUser {

	//AccountManager aud = new SimpleAccountManager();

	
	public String getCurrentUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public int getCurrentUserID() {
		AccountManager accountManager = UserDetailsServiceImpl.getAccountManager();
		return accountManager.getAccountByUsername(getCurrentUsername()).getUserID();
	}

	public String getCurrentUserType() {
		AccountManager accountManager = UserDetailsServiceImpl.getAccountManager();
		System.out.println("+++ 89 "+accountManager);
		return accountManager.getAccountByUsername(getCurrentUsername()).getUserType();
	}

}
