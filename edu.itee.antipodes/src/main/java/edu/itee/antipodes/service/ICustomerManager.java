package edu.itee.antipodes.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;

import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.pages.ContactOperator;

public interface ICustomerManager extends Serializable {
	
	public ListedTour getListedTour(int id);
	
	public List<ListedTour> getListedTours();
	
	public List<ListedTour> getListedToursByOpID(int id);

	public List<Object> searchListedTours(String activityNames, String locationNames, String startDate, String finishDate, String currency) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException;
	
	public void contactOperator(ContactOperator contactOperator);
	
	public ContactOperator getContactOperator(String operatorID);

	public void contactUs(ContactOperator contact);
}
