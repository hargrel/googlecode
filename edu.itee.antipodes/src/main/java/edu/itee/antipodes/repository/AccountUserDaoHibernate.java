package edu.itee.antipodes.repository;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.AccountUser;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AccountUserDaoHibernate extends HibernateDaoSupport implements AccountUserDao {

	public void addAccountUser(AccountUser accUser){
		getHibernateTemplate().save(accUser);
	}

	@SuppressWarnings("unchecked")
	public List<AccountUser> getAccountUserList() {
		return getHibernateTemplate().find("from AccountUser");
	}
	
	public AccountUser getAccountUserByID(int id){
		return (AccountUser)getHibernateTemplate().get(AccountUser.class, id);
	}
	
	public void dropAccountUser(AccountUser accUser) {
		Object record = getHibernateTemplate().load(AccountUser.class, accUser.getUserID());
        getHibernateTemplate().delete(record);
    }
	public void dropAccountUserByID(int accUserID) {
		Object record = getHibernateTemplate().load(AccountUser.class, accUserID);
        getHibernateTemplate().delete(record);
    }

	public void saveAccountUser(AccountUser accUser) {
		getHibernateTemplate().saveOrUpdate(accUser);
	}
}
