package edu.itee.antipodes.service;

import java.io.Serializable;
import java.util.List;

import edu.itee.antipodes.domain.db.AccountUser;

public interface IAccountManager extends Serializable {
	
	public List<AccountUser> getAccounts();
	
	public void dropAccountByID(int id);

	public AccountUser getAccountByID(int id);

	public AccountUser getAccountByUsername(String userName);
	
	public void updateAccount(AccountUser account) throws Exception;
	
	public void addAccount(AccountUser account) throws Exception;

}
