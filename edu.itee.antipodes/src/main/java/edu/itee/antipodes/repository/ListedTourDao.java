package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.ListedTour;

public interface ListedTourDao {

	public void addListedTour(ListedTour listedTour);
	
	public List<ListedTour> getListedTourList();

	public List<ListedTour> getListedToursByOpID(int id);
	
	public ListedTour getListedTourByID(int id);
	
	public void saveListedTour(ListedTour listedTour);
	
	public void dropListedTour(ListedTour listedTour);

}
