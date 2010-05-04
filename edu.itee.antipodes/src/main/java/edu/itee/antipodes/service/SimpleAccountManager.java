package edu.itee.antipodes.service;

import java.util.List;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.repository.AccountUserDaoHibernate;
import edu.itee.antipodes.repository.DaoManager;

public class SimpleAccountManager implements AccountManager {
	
	private AccountUserDaoHibernate accountDao = DaoManager.getAccountUserDao();

	public void addAccount(AccountUser account) {
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
	public void updateAccount(AccountUser account) {
		accountDao.saveAccountUser(account);
	}
	public void setAccountDao(AccountUserDaoHibernate accountDao) {
		this.accountDao = accountDao;
	}
	@Override
	public AccountUser getAccountByUsername(String userName) {
		return accountDao.getAccountUserByUsername(userName);
	}
}
