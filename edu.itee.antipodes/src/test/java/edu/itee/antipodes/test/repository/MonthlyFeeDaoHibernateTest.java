package edu.itee.antipodes.test.repository;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.itee.antipodes.domain.MonthlyFee;
import edu.itee.antipodes.repository.MonthlyFeeDaoHibernate;

public class MonthlyFeeDaoHibernateTest extends TestCase {

	private ApplicationContext ctx = null;
	private MonthlyFee fee = null;
	private MonthlyFeeDaoHibernate dao = null;	
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        dao = (MonthlyFeeDaoHibernate) ctx.getBean("monthlyFeeDao");				
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        dao = null;			
	}

	@Test
	public void testMonthlyFee() {
		assertNotNull(dao.getMonthlyFeeList());
		assertNotNull(dao.getMonthlyFeeByID(1));
		fee = dao.getMonthlyFeeByID(12);
		fee.setFee(122.50f);
		dao.saveMonthlyFee(fee);
		assertEquals(122.50f, dao.getMonthlyFeeByID(12).getFee());
		dao.dropMonthlyFee(dao.getMonthlyFeeByID(1));
		assertNull(dao.getMonthlyFeeByID(1));		
	}
}
