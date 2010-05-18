package edu.itee.antipodes.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.db.AccountUser;

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
	
	@Autowired
	SessionFactory mySessionFactory;

	@SuppressWarnings("unchecked")
	public AccountUser getAccountUserByUsername(String userName) {

//		Query query = getSession().createQuery("select u from AccountUser as u where u.userName=:userName");
//		query.setParameter("userName", userName);
//		return (AccountUser)query.uniqueResult();
		
		if (userName == null || userName.equalsIgnoreCase("roleAnonymous")) return null;
		List<AccountUser> list = (List<AccountUser>)getHibernateTemplate().findByNamedParam("select u from AccountUser as u where u.userName=:userName", "userName", userName); 
		if (list.size() == 0) return null;
		return (AccountUser)list.get(0);
	}
	@SuppressWarnings("unchecked")
	public AccountUser getAccountUserByEmail(String email) {

//		Query query = getSession().createQuery("select u from AccountUser as u where u.userName=:userName");
//		query.setParameter("userName", userName);
//		return (AccountUser)query.uniqueResult();	
		
		String sql = "select u "+
			"from AccountUser as u join u.operator as o "+
			"where o.email=:email ";
		List<AccountUser> list = (List<AccountUser>)getHibernateTemplate().findByNamedParam(sql, "email", email);
		
		
		
		if (list.size() == 0) return null;
		return (AccountUser)list.get(0);
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
