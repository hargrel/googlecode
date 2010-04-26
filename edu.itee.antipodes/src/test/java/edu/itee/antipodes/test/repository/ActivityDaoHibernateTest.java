package edu.itee.antipodes.test.repository;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.ActivityDaoHibernate;
import edu.itee.antipodes.repository.TourDaoHibernate;

public class ActivityDaoHibernateTest extends TestCase {
	
	private ApplicationContext ctx = null;
	private Activity activity=null;
	private ActivityDaoHibernate dao =null;
	private TourDaoHibernate dao1 = null;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        dao = (ActivityDaoHibernate) ctx.getBean("activityDao");	
        dao1 = (TourDaoHibernate) ctx.getBean("tourDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        dao = null;	
	}

	@Test
	public void testGetActivityByID() {
		assertEquals("Jump", dao.getActivityByID(0001).getActivityName());
		//testGetActivityList()
		assertNotNull(dao.getActivityList());
		//testSaveActivity()
		activity = new Activity();
		activity.setActivityName("Smile");
		dao.saveActivity(activity);
		assertEquals("Smile", dao.getActivityByID(5).getActivityName());
		//testDropActivity()
		activity = dao.getActivityByID(4);
		dao.dropActivity(activity);
		assertNull(dao.getActivityByID(4));
		//testGetToursByActivityID()
		assertEquals(1,dao.getToursByActivityID(1).size());
	}
	
	@Test
	public void testAddActivity() {
		Set<Tour> tours = new HashSet<Tour>();
		tours.add(dao1.getTourByID(1));
		tours.add(dao1.getTourByID(2));
		activity = new Activity("new activity", tours);		
		dao.saveActivity(activity);
		assertNotNull(activity.getTours());
	}
}

