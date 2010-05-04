package edu.itee.antipodes.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;
import edu.itee.antipodes.domain.db.ListedTour;

public interface CustomerManager extends Serializable {
	
	public ListedTour getListedTour(int id);
	
	public List<ListedTour> getListedTours();
	
	public List<ListedTour> getListedToursByOpID(int id);

	public List<Object> searchListedTours(String activityName, String locationName, String startDate, String finishDate) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException;
}
