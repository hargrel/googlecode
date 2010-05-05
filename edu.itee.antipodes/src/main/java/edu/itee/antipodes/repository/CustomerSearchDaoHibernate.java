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
	String pattern = "MM/dd/yyyy";
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
	public List<Object> SearchListedTours(String activityName, String locationName, String startDate, String finishDate) 
	throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException{

		// dummy values to be changed
		String activityNameTemp = "dummy";
		String locationNameTemp = "dummy";
		String startDateTemp = "22/11/2000";
		String finishDateTemp = "22/11/3000";
		
		if (activityName != null) {activityNameTemp = activityName;}
		if (locationName != null) {locationNameTemp = locationName;}
		if (startDate != null) {startDateTemp = startDate;}
		if (finishDate != null) {finishDateTemp = finishDate;}
		
		String sqlActivityAndLocationAndStartDateAndFinishDate=select+"from ListedTour as l join l.tour as t " +
		"join t.locations as c join t.activities as a join t.tourDates as d " +
		"where (c.locationName = :locationName1 or a.activityName = :activityName1) " +
		"and (d.startDate >= :startDate and d.finishDate <= :finishDate)";
		
		Query query= getSession().createQuery(sqlActivityAndLocationAndStartDateAndFinishDate).
			setParameter("startDate", um.stringToDate(startDateTemp, pattern)).
			setParameter("finishDate", um.stringToDate(finishDateTemp, pattern)).
			setParameter("activityName1", activityNameTemp).			
			setParameter("locationName1", locationNameTemp);
		return query.list();
	}

	// V2 handles multiple locations and activities
	@SuppressWarnings("unchecked")
	public List<Object> SearchListedToursV2(String activityName, String locationName, String startDate, String finishDate) 
	throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ParseException{

		// dummy values to be changed
		String activityNameTemp = "dummy";
		String locationNameTemp = "dummy";
		String startDateTemp = "22/11/2000";
		String finishDateTemp = "22/11/3000";
		
//		Set<String> activityNameSet = new HashSet<String>();
//		Set<String> locationNameSet = new HashSet<String>();
//		activityNameSet.add("'Hide'");
//		activityNameSet.add("'Jump')");
//		locationNameSet.add("'Brisbane'");
//		locationNameSet.add("'NewYork')");
		
		if (activityName != null) {activityNameTemp = activityName;}
		if (locationName != null) {locationNameTemp = locationName;}
		if (startDate != null) {startDateTemp = startDate;}
		if (finishDate != null) {finishDateTemp = finishDate;}
		
		String sqlCustomerSearchQuery = select+"from ListedTour as l join l.tour as t " +
		"join t.locations as c join t.activities as a join t.tourDates as d " +
		"where (c.locationName = :locationName1 or a.activityName = :activityName1) " +
		"and (d.startDate >= :startDate and d.finishDate <= :finishDate)";
		
		Query query= getSession().createQuery(sqlCustomerSearchQuery).
			setParameter("startDate", um.stringToDate(startDateTemp, pattern)).
			setParameter("finishDate", um.stringToDate(finishDateTemp, pattern)).
			setParameter("activityName1", activityNameTemp).
			setParameter("locationName1", locationNameTemp);			

//		Query query= getSession().createQuery(sqlCustomerSearchQuery).
//		setParameter("startDate", um.stringToDate(startDateTemp, pattern)).
//		setParameter("finishDate", um.stringToDate(finishDateTemp, pattern)).
//		setParameterList("activityName1", activityNameSet).
//		setParameterList("locationName1", locationNameSet);			
		
		return query.list();
	}
	
	@Override
	public Iterator<Object> iterator() {
		return this.iterator();
	}
}
