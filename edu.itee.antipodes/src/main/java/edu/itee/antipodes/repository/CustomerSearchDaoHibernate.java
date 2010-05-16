package edu.itee.antipodes.repository;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.service.UtilityManager;

public class CustomerSearchDaoHibernate extends HibernateDaoSupport implements Iterable<Object>{
	
	Object[] tuple = null;
	String pattern = "dd/MM/yyyy";
	String select="";
	
	UtilityManager um = new UtilityManager();
	
	@SuppressWarnings("unchecked")
	public void SearchTourDatesFromName(String tourName){
		Query query= getSession().createQuery(select+"from TourDate as d left join d.tour as t where t.tourName=?");
		Iterator it= query.setString(0, tourName).iterate();
		 while ( it.hasNext() ) {
	            tuple= (Object[]) it.next();
	            System.out.println(tuple[0].toString());
		 }
		getSession().close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findListedTours(String activityNames, String locationNames, String startDate, String finishDate) 
	throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException{

		// dummy values to avoid passing null to database
		String activityNamesTemp = "dummy";
		String locationNamesTemp = "dummy";
		String startDateTemp = "22/11/2000";
		String finishDateTemp = "22/11/3000";
		
		// use input parameters if not null, else use dummy values
		if (activityNames != null) {activityNamesTemp = activityNames;}
		if (locationNames != null) {locationNamesTemp = locationNames;}
		if (startDate != "") {startDateTemp = startDate;}
		if (finishDate != "") {finishDateTemp = finishDate;}
		
		// query listed tours on any locs OR acts, AND with dates
		String sqlCustomerSearchQuery = select+"from ListedTour as l join l.tour as t " +
		"join t.locations as c join t.activities as a join t.tourDates as d " +
		"where (c.locationName IN (:locationName1) or a.activityName IN (:activityName1)) " +
		"and (d.startDate >= :startDate and d.finishDate <= :finishDate)";

		// use setParameterList() for multiple values
		Query query = getSession().createQuery(sqlCustomerSearchQuery)
		.setParameter("startDate", um.stringToDate(startDateTemp, pattern))
		.setParameter("finishDate", um.stringToDate(finishDateTemp, pattern))
		.setParameterList("activityName1", activityNamesTemp.split(","))
		.setParameterList("locationName1", locationNamesTemp.split(","));

		return query.list();
	}
	
	@Override
	public Iterator<Object> iterator() {
		return this.iterator();
	}
}
