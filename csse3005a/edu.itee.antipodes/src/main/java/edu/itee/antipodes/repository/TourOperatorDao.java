package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.TourOperator;

public interface TourOperatorDao {

	public void addTourOperator(TourOperator tourOperator);

	public List<TourOperator> getTourOperatorList();

	/**
	 * 
	 * @param id
	 *            unique identification number of a tour
	 * @return the tour operator object from database with populated fields
	 */
	public TourOperator getTourOperatorByID(int id);

	public void saveTourOperator(TourOperator tourOperator);

	public void dropTourOperator(TourOperator tourOperator);

	public void dropTourOperatorByID(int id);

}
