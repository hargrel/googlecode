package edu.itee.antipodes.repository;

import java.util.List;
import edu.itee.antipodes.domain.db.TourDate;

public interface TourDateDao {

	public void addTourDate(TourDate tourDate);
	
	public List<TourDate> getTourDateList();
	
	public TourDate getTourDateByID(int id);
	
	public void saveTourDate(TourDate tourDate);
	
	public void dropTourDate(TourDate tourDate);		

}
