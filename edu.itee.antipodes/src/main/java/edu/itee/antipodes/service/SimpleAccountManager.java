package edu.itee.antipodes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.repository.AccountUserDaoHibernate;

@SuppressWarnings("serial")
public class SimpleAccountManager implements AccountManager {
	
	private SimpleAccountManager(){	}

	PasswordHash pHash = new PasswordHash();
	
	@Autowired
	private AccountUserDaoHibernate accountDao;

	public void addAccount(AccountUser account) throws Exception {
		account.setPassword(pHash.Hash(account.getPassword()));
		accountDao.addAccountUser(account);
	}
	public void dropAccountByID(int id) {
		accountDao.dropAccountUserByID(id);
	}
	public AccountUser getAccountByID(int id) {
		return accountDao.getAccountUserByID(id);
	}
	public List<AccountUser> getAccounts() {
		return accountDao.getAccountUserList();
	}
	public void updateAccount(AccountUser account) throws Exception {
		account.setPassword(pHash.Hash(account.getPassword()));
		accountDao.saveAccountUser(account);
	}
	public void setAccountDao(AccountUserDaoHibernate accountDao) {
		this.accountDao = accountDao;
	}
	
	public AccountUser getAccountByUsername(String userName) {
		return accountDao.getAccountUserByUsername(userName);
	}
}
