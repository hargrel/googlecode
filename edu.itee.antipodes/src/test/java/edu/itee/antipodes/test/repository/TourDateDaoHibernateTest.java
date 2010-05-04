package edu.itee.antipodes.test.repository;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.domain.db.TourDate;
import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.repository.TourDateDaoHibernate;
import edu.itee.antipodes.service.UtilityManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TourDateDaoHibernateTest extends TestCase {

	private ApplicationContext ctx = null;
	private TourDateDaoHibernate tourDateDao = null;
	private TourDaoHibernate tourDao = null;
	private int tourID;
	private int tourDateID;
	
	UtilityManager um = new UtilityManager();
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        tourDateDao = (TourDateDaoHibernate) ctx.getBean("tourDateDao");
        tourDao = (TourDaoHibernate) ctx.getBean("tourDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        tourDateDao = null;
        tourDao = null;
	}

	public void testTourDateCRUD() throws Exception {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = df.parse("11/05/2010");
		Date finishDate = df.parse("11/12/2010");
		
		// Create
		Tour tour = new Tour();
		tour.setTourName("new tour");
		tour.setTourDesc("new description");
		tour.setPrice(10.95);
		tour.setTotalDays(4);
		tour.setOnDemand(1);
		
		TourDate tourDate = new TourDate();
		tourDate.setStartDate(startDate);
		tourDate.setFinishDate(finishDate);
		tourDate.setTourID(tourID);
		tourDate.setTour(tour);
		tourDateDao.saveTourDate(tourDate);
		// addition of tourDate will cascade to addition of tour
		tourDateID = tourDate.getDateID();
		assertEquals("11/05/2010", um.dateToString((tourDateDao.getTourDateByID(
				tourDateID).getStartDate()), "dd/MM/yyyy"));
		
		// Retrieve
		assertNotNull(tourDateDao.getTourDateList());
		assertEquals("11/12/2010", um.dateToString(
				tourDateDao.getTourDateByID(tourDateID).getFinishDate(), "dd/MM/yyyy"));
	
		// Update
		finishDate = df.parse("22/12/2010");
		tourDate = tourDateDao.getTourDateByID(tourDateID);
		tourDate.setFinishDate(finishDate);
		tourDateDao.saveTourDate(tourDate);
		assertEquals("22/12/2010", um.dateToString(
				tourDateDao.getTourDateByID(tourDateID).getFinishDate(), "dd/MM/yyyy"));
		
		// Delete
		tourDateDao.dropTourDate(tourDate);
		assertNull(tourDateDao.getTourDateByID(tourDateID));
		// delete child tourDate will not delete parent tour
		tourDateDao.dropTourDate(tourDateDao.getTourDateByID(3));
		assertNotNull(tourDao.getTourByID(3));		
	}
}
