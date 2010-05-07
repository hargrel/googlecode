package edu.itee.antipodes.test.repository;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.repository.AccountUserDaoHibernate;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountUserDaoHibernateTest extends TestCase {
	private ApplicationContext ctx = null;
	private AccountUserDaoHibernate dao =null;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        dao = (AccountUserDaoHibernate) ctx.getBean("accountUserDao");			
	}
	@After
	public void tearDown() throws Exception {
		super.tearDown();
        dao = null;	
	}
	@Test
	public void testAccountUser() {
		//test List<Object> getAccountUserByUsername(String userName)
		assertEquals("AccountUser [userID=2, password=4034611159, userType=admin, userName=user2]",dao.getAccountUserByUsername("user2").toString());
	
		
		
		int userID;
		AccountUser accUser1 = new AccountUser("user5", "hashed5", "admin");
		dao.addAccountUser(accUser1);
		userID = dao.getAccountUserList().size();
		
		assertEquals("admin", dao.getAccountUserByID(userID).getUserType());
		assertEquals("user5", dao.getAccountUserByID(userID).getUserName());
		
		assertNotNull(dao.getAccountUserList());
		
		assertEquals("user1", dao.getAccountUserByID(1).getUserName());
		assertEquals("admin", dao.getAccountUserByID(1).getUserType());
		
		accUser1 = dao.getAccountUserByID(userID);
		accUser1.setUserName("new user name");
		dao.saveAccountUser(accUser1);
		assertEquals("new user name", dao.getAccountUserByID(userID).getUserName());		
		
		// delete of new account user not being referenced is possible
		dao.dropAccountUser(dao.getAccountUserByID(userID));
		assertNull(dao.getAccountUserByID(userID));		
		// delete of existing account user being referenced is not possible
		//dao.dropAccountUser(dao.getAccountUserByID(3));
		//assertNull(dao.getAccountUserByID(3));
	}
}


