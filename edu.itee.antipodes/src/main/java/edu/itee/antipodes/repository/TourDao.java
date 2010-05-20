package edu.itee.antipodes.repository;

import java.util.List;

import org.hibernate.HibernateException;

import edu.itee.antipodes.domain.db.Tour;

public interface TourDao {
	
	public List<Tour> getTourList();
	
	public Tour getTourByID(int id);
	
	public void saveTour(Tour tour);
	
	public void dropTour(Tour tour);
	
	public void addTour(Tour tour);

	public  List<Tour> getTourListByOperatorID(int id);

	public void dropTourByID(int tourID) throws HibernateException;
	
}
