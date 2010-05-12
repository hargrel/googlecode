package edu.itee.antipodes.service;

import java.text.ParseException;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;
import edu.itee.antipodes.domain.db.*;
import edu.itee.antipodes.repository.*;

@SuppressWarnings("serial")
public class SimpleCustomerManager implements CustomerManager {
	
	private ListedTourDaoHibernate listedTourDao = DaoManager.getListedTourDao();
	private CustomerSearchDaoHibernate tourSearchDao = DaoManager.getTourSearchDao();

	public ListedTour getListedTour(int id) {
		return listedTourDao.getListedTourByID(id);
	}	
	public List<ListedTour> getListedTours() {
		return listedTourDao.getListedTourList();
	}
	public List<ListedTour> getListedToursByOpID(int id) {
		return listedTourDao.getListedToursByOpID(id);
	}
	public List<Object> searchListedTours(String activityNames, String locationNames,  
			String startDate, String finishDate) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException {
		return tourSearchDao.findListedTours(activityNames, locationNames, startDate, finishDate);
	}

}
