/**
 * 
 */
package edu.itee.antipodes.test.repository;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.TourDaoHibernate;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author s4208528
 *
 */
public class TourDaoHibernateTest extends TestCase{
	
	private ApplicationContext ctx = null;
	private TourDaoHibernate tourDao = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        tourDao = (TourDaoHibernate) ctx.getBean("tourDao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		super.tearDown();
        tourDao = null;
	}
	
	/**
	 * Example test for Tour basic CRUD. Sample data auto generated during test. 
	 */
	@Test
	public void testTourCRUD() {
		
		Tour tour = new Tour();
		int tourID;

		// Create
		tour.setTourName("new tour");
		tour.setTourDesc("new description");
		tour.setPrice(10.95);
		tour.setTotalDays(4);
		tour.setOnDemand(1);
		tourDao.addTour(tour);

		// Retrieve
		assertNotNull(tourDao.getTourList());

		// Retrieve
		assertNotNull(tourDao.getTourByID(tourDao.getTourList().size()));
		assertEquals("new tour", tourDao.getTourByID(tourDao.getTourList().size()).getTourName());
		assertEquals(10.95, tourDao.getTourByID(tourDao.getTourList().size()).getPrice());
		assertEquals(4, tourDao.getTourByID(tourDao.getTourList().size()).getTotalDays());	
		
		// Update
		tour = tourDao.getTourByID(tourDao.getTourList().size());
		tour.setTotalDays(33);
		tourDao.saveTour(tour);
		assertEquals(33, tourDao.getTourByID(tourDao.getTourList().size()).getTotalDays());		

		// Delete
		tourID = tourDao.getTourList().size();
		tour = tourDao.getTourByID(tourID);
		tourDao.dropTour(tour);
		assertNull(tourDao.getTourByID(tourID));		
	}
}

