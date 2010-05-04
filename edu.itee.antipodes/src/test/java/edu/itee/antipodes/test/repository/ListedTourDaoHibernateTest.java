package edu.itee.antipodes.test.repository;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.itee.antipodes.service.UtilityManager;
import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.ListedTourDaoHibernate;
import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListedTourDaoHibernateTest extends TestCase {
	private ApplicationContext ctx = null;
	private ListedTourDaoHibernate dao = null;
	private TourOperatorDaoHibernate dao1 = null;
	private TourDaoHibernate dao2 = null;
	private ListedTour listedTour = null;
	private TourOperator op = null;
	private Tour tour = null;
	
	UtilityManager um = new UtilityManager();
	
	@Before
	public void setUp() throws Exception {
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        dao = (ListedTourDaoHibernate)ctx.getBean("listedTourDao");
        dao1 = (TourOperatorDaoHibernate)ctx.getBean("tourOperatorDao");
        dao2 = (TourDaoHibernate)ctx.getBean("tourDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        dao = null;	
        dao1 = null;
        dao2 = null;
	}

	@Test
	public void testAddListedTour() throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFrom = df.parse("11/05/2010");
		Date dateTo = df.parse("11/12/2010");
		
		op = dao1.getTourOperatorByID(3);
		tour = dao2.getTourByID(1);
		listedTour = new ListedTour(dateFrom, dateTo, op, tour);
		listedTour.setListID(5);
		
		dao.addListedTour(listedTour);
		assertNotNull(dao.getListedTourByID(5));
		assertEquals(4, dao.getListedTourByID(5).getOperator().getOperatorID());
		assertEquals(4, dao.getListedTourByID(5).getTour().getTourID());
	
		assertNotNull(dao.getListedTourList());
		assertNotNull(dao.getListedTourByID(1));
	
		dateTo = df.parse("21/12/2010");
		listedTour = dao.getListedTourByID(5);
		listedTour.setListedTo(dateTo);
		dao.saveListedTour(listedTour);
		assertEquals("21/12/2010", um.dateToString(dao.getListedTourByID(5).getListedTo(), "dd/MM/yyyy"));

		listedTour = dao.getListedTourByID(3);
		dao.dropListedTour(listedTour);
		assertNull(dao.getListedTourByID(3));		

		// extra
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		assertEquals(3, dao.getListedToursByOpID(3).size());
	}
}


