package edu.itee.antipodes.service;

import java.util.List;

import edu.itee.antipodes.domain.Tour;
import edu.itee.antipodes.repository.TourDao;

public class ExampleTourManager implements TourManager {
	
	//private List<Tour> tours;
	private TourDao tourDao;

	public List<Tour> getTours() {
		//return tours;
		return tourDao.getTourList();
	}
	
	public void dropTourByID(int id) {
		tourDao.dropTour(tourDao.getTourByID(id));
	}
	
	public Tour getTourByID(int id) {
		return tourDao.getTourByID(id);
	}

	public void updateTour(Tour tour) {
		tourDao.saveTour(tour);
	}
	
	public void addTour(Tour tour) {
		tourDao.addTour(tour);
	}
	
//	public void setTours(List<Tour> tours) {
//		this.tours = tours;
//	}
	
	public void setTourDao(TourDao tourDao) {
		this.tourDao = tourDao;
	}

}
