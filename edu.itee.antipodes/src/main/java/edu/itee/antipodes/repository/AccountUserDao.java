package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.AccountUser;

public interface AccountUserDao {

	public void addAccountUser(AccountUser accUser);	
	
	public List<AccountUser> getAccountUserList();

	public AccountUser getAccountUserByID(int id);
	
	public AccountUser getAccountUserByEmail(String email);
	
	public AccountUser getAccountUserByUsername(String username);
	
	public void saveAccountUser(AccountUser accUser);
	
	public void dropAccountUser(AccountUser accUser);

}
