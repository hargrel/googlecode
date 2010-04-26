package edu.itee.antipodes.service;

import java.util.List;

import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.TourDaoHibernate;

public class ExampleTourManager implements TourManager {
	
	private TourDaoHibernate tourDao;
	
	public List<Tour> getTours() {
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
	public void setTourDao(TourDaoHibernate tourDao) {
		this.tourDao = tourDao;
	}
}
