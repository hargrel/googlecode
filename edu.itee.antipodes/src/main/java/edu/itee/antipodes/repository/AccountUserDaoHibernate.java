package edu.itee.antipodes.repository;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.AccountUser;

import java.util.List;

import org.hibernate.Query;
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
	public AccountUser getAccountUserByUsername(String userName) {
		 Query query = getSession().createQuery("select u from AccountUser as u where u.userName=:userName");
		 query.setParameter("userName", userName);
		 return (AccountUser)query.uniqueResult();
		}
	//It is assumed that user name is unique. So, often the above method for querying by username should suffice.
	//However, if it is not sure if the result would be only one tuple, the method below can be used, which returns a list.
	@SuppressWarnings("unchecked")
	public List<Object> getAccountUserByUsername2(String userName) {
		 Query query = getSession().createQuery("select u from AccountUser as u where u.userName=:userName");
		 query.setParameter("userName", userName);
		 return query.list();
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
