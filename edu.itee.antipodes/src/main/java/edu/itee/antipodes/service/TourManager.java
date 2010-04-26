package edu.itee.antipodes.service;

import java.io.Serializable;
import java.util.List;

import edu.itee.antipodes.domain.db.Tour;

public interface TourManager extends Serializable {
	
	public List<Tour> getTours();
	
	public void dropTourByID(int id);
	
	public Tour getTourByID(int id);
	
	public void updateTour(Tour tour);
	
	public void addTour(Tour tour);

}
