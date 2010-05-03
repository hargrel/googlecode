package edu.itee.antipodes.test.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessResourceFailureException;

import edu.itee.antipodes.domain.db.*;
import edu.itee.antipodes.repository.ReportingDaoHibernate;

public class ReportingDaoHibernateTest extends TestCase {
	private ApplicationContext ctx = null;
	private ReportingDaoHibernate dao = null;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = { "edu/itee/antipodes/repository/hibernate-cfg.xml" };
		ctx = new ClassPathXmlApplicationContext(paths);
		dao = (ReportingDaoHibernate) ctx.getBean("reportDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Test
	public void testSearch() throws DataAccessResourceFailureException,
			HibernateException, IllegalStateException, ParseException {
//		//test getNumToursAsscWithActivityByActivityID(int id)
//		assertEquals("1",dao.getNumToursAsscWithActivityByActivityID(1).get(0)[1].toString());
//		assertEquals("3",dao.getNumToursAsscWithActivityByActivityID(4).get(0)[1].toString());
//		
//		//test getNumToursAsscWithLocationByLocationID(int id)
//		assertEquals("1",dao.getNumToursAsscWithLocationByLocationID(1).get(0)[1].toString());
//		assertEquals("3",dao.getNumToursAsscWithLocationByLocationID(4).get(0)[1].toString());
//
//		//test getSumOfActivitiesForToursByMinNum(int minNum)
//		assertEquals("Tour [price=1899.95, totalDays=2, tourDesc=The most " +
//				"electrifying rock in world entertainment., tourID=4, " +
//				"tourName=The Rock]",
//				dao.getSumOfActivitiesAndLocationsForToursByMinNum(3).
//				get(1)[0].toString());
//		assertEquals("3",dao.getSumOfActivitiesAndLocationsForToursByMinNum(3).
//				get(1)[1].toString());
		
		//test getNumOfToursAndTotalPricePerMonthByTourOperator(int operatorID)
		assertEquals(7,dao.getNumOfToursAndTotalPricePerMonthByTourOperator(3).size());
		assertEquals("245.0",dao.getNumOfToursAndTotalPricePerMonthByTourOperator(3).get(0)[3].toString());
		

	}

}
