package edu.itee.antipodes.service;

import org.springframework.security.context.SecurityContextHolder;

import edu.itee.antipodes.domain.SessionHolder;
import edu.itee.antipodes.utils.SpringApplicationContext;

public class CurrentUser {

	//IAccountManager aud = new SimpleAccountManager();

	
	public String getCurrentUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public int getCurrentUserID() {
		IAccountManager accountManager = SpringApplicationContext.getAccountManager();
		return accountManager.getAccountByUsername(getCurrentUsername()).getUserID();
	}

	public String getCurrentUserType() {
		IAccountManager accountManager = SpringApplicationContext.getAccountManager();
		System.out.println("+++ 89 "+accountManager);
		return accountManager.getAccountByUsername(getCurrentUsername()).getUserType();
	}

}
