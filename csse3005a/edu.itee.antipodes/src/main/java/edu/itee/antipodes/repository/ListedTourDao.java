package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.ListedTour;


public interface ListedTourDao {

	public void addListedTour(ListedTour listedTour);
	
	public List<ListedTour> getListedTourList();

	public List<ListedTour> getListedToursByOpID(int id);
	
	public ListedTour getListedTourByID(int id);
	
	/**
	 * Save a listed tour to database
	 * @param listedTour Listed tour object
	 */
	public void saveListedTour(ListedTour listedTour);
	
	public void dropListedTour(ListedTour listedTour);

	public List<ListedTour> getListedToursByTourID(int id);

}
