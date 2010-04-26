package edu.itee.antipodes.test.repository;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.ImageDaoHibernate;
import edu.itee.antipodes.repository.TourDaoHibernate;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImageDaoHibernateTest extends TestCase {
	private ApplicationContext ctx = null;
	private ImageDaoHibernate imageDao = null;
	private TourDaoHibernate tourDao = null;
	private int imageID;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
        ctx = new ClassPathXmlApplicationContext(paths);
        imageDao = (ImageDaoHibernate)ctx.getBean("imageDao");
        tourDao = (TourDaoHibernate)ctx.getBean("tourDao");
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
        imageDao = null;		
        tourDao = null;
	}	

	/**
	 * Example test for Image basic CRUD. Sample data auto generated during test. 
	 */	
	@Test
	public void testImageCRUD() throws Exception {
		
		Tour tour = new Tour();
		Image image = new Image();
		
		// Create
		tour.setTourName("new image tour name");
		tour.setTourDesc("new image tour desc");
		tour.setPrice(335.50);
		tour.setTotalDays(7);
		tour.setOnDemand(1);
		
		image.setTour(tour);
		image.setUrl("new image url");
		imageDao.addImage(image);
		imageID = image.getImageID();
		
		// Retrieve
		assertNotNull(imageDao.getImageList());
		assertEquals("new image url", imageDao.getImageByID(imageID).getUrl());
		
		image = imageDao.getImageByID(imageID);
		assertEquals("new image tour name", image.getTour().getTourName());
		assertEquals("new image tour name", 
				imageDao.getImageByID(imageID).getTour().getTourName());
		
		// Update
		image.setUrl("image url updated");
		imageDao.saveImage(image);
		assertEquals("image url updated", 
				imageDao.getImageByID(imageID).getUrl());
		
		// Delete
		imageDao.dropImage(imageDao.getImageByID(imageID));
		assertNull(imageDao.getImageByID(imageID));
		// deleting child image will not delete parent tour
		imageDao.dropImage(imageDao.getImageByID(3));
		assertNotNull(tourDao.getTourByID(3));
	}	
}
