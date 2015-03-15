package edu.itee.antipodes.test.repository;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.AccountUserDaoHibernate;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TourOperatorDaoHibernateTest extends TestCase {
	private ApplicationContext ctx = null;
	private TourOperatorDaoHibernate dao = null;
	private AccountUserDaoHibernate dao2 = null;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        dao = (TourOperatorDaoHibernate) ctx.getBean("tourOperatorDao");
        dao2 = (AccountUserDaoHibernate) ctx.getBean("accountUserDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        dao = null;		
        dao2 = null;
	}

	@Test
	public void testTourOperator() throws Exception {
		int opID;
		int userID;
		
		assertNotNull(dao.getTourOperatorList());
		assertEquals("company3", dao.getTourOperatorByID(3).getCompanyInfo());

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateExpired = df.parse("15/12/2020");
		AccountUser accUser1 = new AccountUser("user5", "hashed5", "admin");
		//dao2.addAccountUser(accUser1);
		
		TourOperator op = new TourOperator("op5", "c5", dateExpired, "o5@5.com",  accUser1);
		dao.saveTourOperator(op);
		opID = op.getOperatorID();
		assertEquals(opID, dao.getTourOperatorByID(opID).getOperatorID());
		assertEquals("user5", dao.getTourOperatorByID(opID).getAccountUser().getUserName());		
		
		dao.dropTourOperator(dao.getTourOperatorByID(opID));
		assertNull(dao.getTourOperatorByID(opID));
		
		// deleting a child tour operator will not delete the parent account user
		userID = dao.getTourOperatorByID(3).getAccountUser().getUserID();
		dao.dropTourOperator(dao.getTourOperatorByID(3));
		assertNull(dao.getTourOperatorByID(3));
		assertNotNull(dao2.getAccountUserByID(userID));
	}
}
