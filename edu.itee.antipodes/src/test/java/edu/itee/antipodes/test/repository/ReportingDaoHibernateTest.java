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
		dao = (ReportingDaoHibernate) ctx.getBean("reportSearchDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Test
	public void testSearch() throws DataAccessResourceFailureException,
			HibernateException, IllegalStateException, ParseException {

		
		//test getNumToursAsscWithLocationByMinNum(int minNum)
//		assertNotNull(dao.getNumToursAsscWithActivityByMinNum(1));
//		assertEquals(4,dao.getNumToursAsscWithActivityByMinNum(1).size());
		assertEquals("3",dao.getNumToursAsscWithActivityByMinNum(2).get(0)[2].toString());

		
		//test getNumToursAsscWithLocationByMinNum(int minNum)
//		assertEquals(4,dao.getNumToursAsscWithLocationByMinNum(1).size());
//		assertEquals(2,dao.getNumToursAsscWithLocationByMinNum(2).size());
		assertEquals("3",dao.getNumToursAsscWithLocationByMinNum(2).get(0)[2].toString());
		
	}

}
