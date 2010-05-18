package edu.itee.antipodes.repository;

import edu.itee.antipodes.domain.db.AccountUser;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class AccountUserDaoHibernate /*extends HibernateDaoSupport*/ implements AccountUserDao {
	private SessionFactory sessionFactory = null;
	private Session session=null;
	Query query=null;
	
	public void addAccountUser(AccountUser accUser){
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(accUser);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<AccountUser> getAccountUserList() {
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		query = session.createQuery("select u from AccountUser as u");
		List<AccountUser> list = query.list();
		session.getTransaction().commit();

		return list;
		
		
//		return getHibernateTemplate().find("from AccountUser");
	}
	
	public AccountUser getAccountUserByID(int id){
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		AccountUser user= (AccountUser) session.get(AccountUser.class, id);
		session.getTransaction().commit();

		return user;
		
//		return (AccountUser)getHibernateTemplate().get(AccountUser.class, id);
	}
	public AccountUser getAccountUserByUsername(String userName) {
		session=sessionFactory.openSession();
		session.getTransaction().begin(); 
		Query query = session.createQuery("select u from AccountUser as u where u.userName=:userName");
		query.setParameter("userName", userName);
		session.getTransaction().commit();

		 return (AccountUser)query.uniqueResult();
		}
	
	public void dropAccountUser(AccountUser accUser) {
		session=sessionFactory.openSession();
		session.getTransaction().begin(); 
		Object record = session.load(AccountUser.class, accUser.getUserID());
        session.delete(record);
        session.getTransaction().commit();

    }
	public void dropAccountUserByID(int accUserID) {
		session=sessionFactory.openSession();
		session.getTransaction().begin(); 
		Object record = session.load(AccountUser.class, accUserID);
        session.delete(record);
        session.getTransaction().commit();

    }

	public void saveAccountUser(AccountUser accUser) {
		session=sessionFactory.openSession();
		session.getTransaction().begin(); 
		session.saveOrUpdate(accUser);
		session.getTransaction().commit();

	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
		}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
