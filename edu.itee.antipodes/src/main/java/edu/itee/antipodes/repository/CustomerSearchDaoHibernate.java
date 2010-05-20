package edu.itee.antipodes.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.itee.antipodes.service.UtilityManager;

public class CustomerSearchDaoHibernate extends HibernateDaoSupport implements Iterable<Object>{
	
	Object[] tuple = null;
	String pattern = "dd/MM/yyyy";
	
	UtilityManager um = new UtilityManager();
	
	@SuppressWarnings("unchecked")
	public List<Object> findListedTours(String activityNames, String locationNames, String startDate, String finishDate) 
	throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException{
		
		// default values for search criteria which will not search anything
		String activityNamesTemp = "xxx"; 		 
		String locationNamesTemp = "xxx";		
		String startDateTemp = "22/11/2000";	 
		String finishDateTemp = "22/11/9000";
		String sqlCustomerSearchQuery = "";
		String superFlag = "super";
		List<Object> list = new ArrayList<Object>(); 
		
		// search all listed tours if NONE of the criteria provided
		if (activityNames.isEmpty()){
			if (locationNames.isEmpty()){
				if (startDate.isEmpty()){
					if (finishDate.isEmpty()){
						
						superFlag = "not super";
						sqlCustomerSearchQuery = "from ListedTour as l join l.tour as t join t.locations as "+
							"c join t.activities as a join t.tourDates as d";
						list = (List<Object>)getHibernateTemplate().find(sqlCustomerSearchQuery);
					}
				}
			}
		}
		// search listed tours based on any search criteria provided
		if (superFlag == "super") { 
			
			// update default search criteria
			if (activityNames != "") {activityNamesTemp = activityNames;}
			if (locationNames != "") {locationNamesTemp = locationNames;}
			if (startDate != "") {startDateTemp = startDate;}
			if (finishDate != "") {finishDateTemp = finishDate;}

			String[] params = new String[4];
			params[0] = "activityName1"; 
			params[1] = "locationName1"; 
			params[2] = "startDate"; 
			params[3] = "finishDate";
			
			Object[] vals = new Object[4];
			
			// Trim variables
			String[] locations = locationNamesTemp.toUpperCase().split(",");
			for (int i = 0; i < locations.length; i++) {
				locations[i] = locations[i].trim();
			}
			
			// Trim variables
			String[] activities = activityNamesTemp.toUpperCase().split(",");
			for (int i = 0; i < activities.length; i++) {
				activities[i] = activities[i].trim();
			}
			
			vals[0] = activities;
			vals[1] = locations;
			vals[2] = um.stringToDate(startDateTemp, pattern);
			vals[3] = um.stringToDate(finishDateTemp, pattern);

			// query listed tours on any locs OR acts, AND with dates
			sqlCustomerSearchQuery = "from ListedTour as l join l.tour as t " +
				"join t.locations as c join t.activities as a join t.tourDates as d " +
				"where (c.locationName IN (:locationName1) or a.activityName IN (:activityName1)) " +
				"and (d.startDate >= :startDate and d.finishDate <= :finishDate)";
			
			list = (List<Object>)getHibernateTemplate().findByNamedParam(sqlCustomerSearchQuery, params, vals);
		}
		
		if (list.size() == 0) return null;
		return list;	
	}
	
	@Override
	public Iterator<Object> iterator() {
		return this.iterator();
	}
}
