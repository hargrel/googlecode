package edu.itee.antipodes.test.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import edu.itee.antipodes.domain.Tour;
import edu.itee.antipodes.repository.TourDao;
import edu.itee.antipodes.service.ExampleTourManager;
import edu.itee.antipodes.service.TourManager;
import edu.itee.antipodes.test.repository.InMemoryTourDao;

public class ExampleTourManagerTests extends TestCase {
	
	private ExampleTourManager tourManager;
	private List<Tour> tours;
	
	protected void setUp() throws Exception {
		
		tourManager = new ExampleTourManager();
		tours = new ArrayList<Tour>();

		// stub up a list of fake tours
		Tour tour = new Tour();
        tour.setTourName("Testy Tour1");
        tour.setTourDesc("Testy Tour1 description");
        tour.setPrice(new Double(12.95));
        tour.setTotalDays(1);
        tours.add(tour);
        
		tour = new Tour();
        tour.setTourName("Testy Tour2");
        tour.setTourDesc("Testy Tour2 description");
        tour.setPrice(new Double(13.95));
        tour.setTotalDays(2);
        tours.add(tour);

        TourDao tourDao = new InMemoryTourDao(tours);
        tourManager.setTourDao(tourDao);
        //tourManager.setTours(tours);

	}
	
	public void testGetToursWithNoTours() {
		System.out.println("Hello from the service test!");
		tourManager = new ExampleTourManager();
		tourManager.setTourDao(new InMemoryTourDao(null));
		assertNull(tourManager.getTours());
	}
	
	public void testGetTours() {
		List<Tour> tours = tourManager.getTours();
		assertNotNull(tours);        
		assertEquals(2, tourManager.getTours().size());

		Tour tour = tours.get(0);
		assertEquals("Testy Tour1 description", tour.getTourDesc());

		tour = tours.get(1);
		assertEquals("Testy Tour2 description", tour.getTourDesc());   
	}

}