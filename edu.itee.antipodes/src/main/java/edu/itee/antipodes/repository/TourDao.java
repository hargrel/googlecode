package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.Tour;

public interface TourDao {
	
	public List<Tour> getTourList();
	
	public Tour getTourByID(int id);
	
	public void saveTour(Tour tour);
	
	public void dropTour(Tour tour);
	
	public void addTour(Tour tour);

}
