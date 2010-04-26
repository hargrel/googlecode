package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.TourOperator;

public interface TourOperatorDao {
	
	public List<TourOperator> getTourOperatorList();
	
	public TourOperator getTourOperatorByID(int id);
	
	public void saveTourOperator(TourOperator tourOperator);
	
	public void dropTourOperator(TourOperator tourOperator);		

}
