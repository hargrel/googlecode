package edu.itee.antipodes.test.repository;

//import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.itee.antipodes.domain.Location;
import edu.itee.antipodes.repository.LocationDaoHibernate;
//import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.domain.Tour;;

public class LocationDaoHibernateTest extends TestCase{
	private ApplicationContext ctx = null;
	private Location location=null;
	private LocationDaoHibernate dao = null;
	//private TourDaoHibernate dao1 = null;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        dao = (LocationDaoHibernate) ctx.getBean("locationDao");		
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        dao = null;
	}

	@Test
	public void testGetLocation() throws HibernateException{
		assertEquals("NewYork", dao.getLocation(3).getLocationName());
		//testDropLocation() 
		location=dao.getLocation(1);
		dao.dropLocation(location);
		assertNull(dao.getLocation(1));
		//testGetLocationList() 
		assertNotNull(dao.getLocationList());
		//testSaveLocation() 
		location= new Location();
		location.setLatitude(23.0000);
		location.setLongitude(124.0903);
		location.setLocationName("HAHA");
		dao.saveLocation(location);
		assertEquals("HAHA", dao.getLocation(5).getLocationName());
		//testGetToursByLocationId() 
		assertEquals(1, dao.getLocation(2).getTours().size());
		//testAddLocation()
		Set<Tour> tours = new HashSet<Tour>();
		location = new Location("new location name", 5f, 5f, tours);	
		dao.saveLocation(location);
		assertEquals("new location name",dao.getLocation(6).getLocationName() );
	}
}

