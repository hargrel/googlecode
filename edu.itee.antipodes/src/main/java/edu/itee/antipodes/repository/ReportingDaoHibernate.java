package edu.itee.antipodes.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.db.MonthlyFee;

public class ReportingDaoHibernate extends HibernateDaoSupport implements Iterable{
	Object[] tuple=null;
	/*
	 * For Monitoring search criteria utilisation report--activity
	 * @param id the activityID
	 * @request id != null
	 * @return list of tuples(actually one) in the form of Object[], in which 
	 * Object[0]=activityID,  Object[1]=activityName,Object[12]= number of listed 
	 * tours that are aligned with the given activity .
	 * @author 41931527
	 */
	
	public List<Object[]> getNumToursAsscWithActivityByActivityID(int id){
		List<Object[]> list = new ArrayList<Object[]>();		
		String select="select a, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.activities as a ";	
		String where="where a.activityID=:activityID ";
		if ((Integer)id != null){
			String sql= select+ from+where+"group by a.activityID, a.activityName ";
			Query query= getSession().createQuery(sql);
			query.setParameter("activityID", id);
			int i=0;
			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
		            list.add((Object[]) it.next());
			 }
		}

		return list;
	}
	/* 
	 * For Monitoring search criteria utilisation report--all activities
	 * @return list of tuples(actually one) in the form of Object[], in which 
	 * Object[0]=activityID,  Object[1]=activityName,Object[12]= number of listed 
	 * tours that are aligned with the given activity .
	 * @author 41931527
	 */
	public List<Object[]> getNumToursAsscWithActivity(){
		List<Object[]> list = new ArrayList<Object[]>();		
		String select="select a, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.activities as a ";	
		
		
		String sql= select+ from+"group by a.activityID, a.activityName ";
		Query query= getSession().createQuery(sql);
		
		int i=0;
		 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
	            list.add((Object[]) it.next());
		 }
		return list;
	}
	
	/*
	 * For Monitoring search criteria utilisation report
	 * @param id the locationID
	 * @request id != null
	 * @return list of tuples(actually one) in the form of Object[], in which 
	 * Object[0]=location object,  Object[1]= number of listed 
	 * tours that are aligned with the given location .
	 * @author 41931527
	 */
	
	public List<Object[]> getNumToursAsscWithLocationByLocationID(int id){
		List<Object[]> list = new ArrayList<Object[]>();				
		String select="select c, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.locations as c ";
		String where="where c.locationID=:locationID ";
		if ((Integer)id != null){
			String sql= select+ from+where+ "group by c.locationID, c.locationName ";
			Query query= getSession().createQuery(sql);
			query.setParameter("locationID", id);
			int i=0;
			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
		            list.add((Object[]) it.next());
			 }
		}

		return list;
	}
	
	/*
	 * For Monitoring search criteria utilisation report--all locations	 
	 * @return list of tuples(actually one) in the form of Object[], in which 
	 * Object[0]=location object,  Object[1]= number of listed 
	 * tours that are aligned with the given location .
	 * @author 41931527
	 */
	public List<Object[]> getNumToursAsscWithLocation(){
		List<Object[]> list = new ArrayList<Object[]>();				
		String select="select c, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.locations as c ";
		
			String sql= select+ from+"group by c.locationID, c.locationName ";
			Query query= getSession().createQuery(sql);
			int i=0;
			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
		            list.add((Object[]) it.next());
		     }
			 return list;	
	}
	
	

	/*
	 *Detecting abuse report
	 * @param minNum the specified minimum number of listed tour associated with criteria activity
	 * @request minNum != null
	 * @return returns a list of tuples(i.e. Object[]), 
	 * in which Object[0]=tour object, Object[1]=number of
	 * listed tours associated with the criteria where the number >= minNum
	 * @author 41931527 
	 */
	public List<Object[]> getSumOfActivitiesAndLocationsForToursByMinNum(int minNum){
		List<Object[]> list = new ArrayList<Object[]>();
				
		String select="select t, COUNT(DISTINCT a.activityID)+COUNT(DISTINCT c.locationID)  ";
		String from="from ListedTour as l join l.tour as t join t.activities as a join t.locations as c ";
		if ((Integer)minNum != null){
			String sql= select+ from+"group by t "+"having COUNT(DISTINCT a.activityID)+COUNT(DISTINCT c.locationID) >= :minNum";
			Query query= getSession().createQuery(sql);
			query.setParameter("minNum", Long.valueOf(minNum));
			int i=0;
			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
		            list.add((Object[]) it.next());
			 }
		}

		return list;
	}
	/*
	 * Monitoring system utilisation
	 * @param operatorID the specified operatorID
	 * @param fromDate
	 * @param toDate
	 * @request operatorID != null
	 * @return returns a list of tuples(i.e. Object[]), in which 
	 * Object[0]=monthYearStart (the starting date of a month-year)
	 * Object[1]= operator object, 
	 * Object[2]= fee of the month
	 * Object[3]= number of tours listed in that month-year
	 * Object[4]= total price of the month = (tour# listed in the month)*(monthly fee) 
	 */
	public List<Object[]> getNumOfToursAndTotalPricePerMonthForAllTourOperator(String fromDate, String toDate) throws ParseException{
		List<Object[]> list = new ArrayList<Object[]>();
		Date fromD = StringToDate(fromDate);
		Date toD = StringToDate(toDate);
		String select="select  m.monthYearStart,o, m.fee, COUNT(t.tourID), COUNT(t.tourID)*m.fee ";
		String from="from TourOperator as o join o.listedTour as l join l.tour as t, MonthlyFee as m ";
		// l.listedFrom-30 since we want to include the previous month, ex. for 12/05/2010, we want to charge 05/2010's fee as well
		String where="where m.monthYearStart between :from and :to and m.monthYearStart between (l.listedFrom-30) and l.listedTo and (l.listedTo-l.listedFrom)>=1  ";
		
		String sql= select+ from+ where+"group by  m.monthYearStart,o, m.fee "+"order by m.monthYearStart desc";
		Query query= getSession().createQuery(sql);
		query.setParameter("from", fromD).setParameter("to", toD);
		int i=0;
		 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
	            list.add((Object[]) it.next());
		 }
		
		return list;
	}
	/*
	 * Billing Tour Operators
	 * @param fromDate
	 * @param toDate
	 * @return returns a list of tuples(i.e. Object[]), in which 
	 * Object[0]= monthYearStart (the starting date of a month-year)
	 * Object[1]= tour object, i.e. the tour listed
	 * Object[2]= fee of the month
	 */
	public List<Object[]> getListedToursPerMonthByOperatorID(int operatorID, String fromDate, String toDate) throws ParseException{
		List<Object[]> list = new ArrayList<Object[]>();
		Date fromD = StringToDate(fromDate);
		Date toD = StringToDate(toDate);
		String select="select m.monthYearStart, t, m.fee ";
		String from="from TourOperator as o join o.listedTour as l join l.tour as t, MonthlyFee as m ";
		String where="where o.operatorID=:operatorID and m.monthYearStart between :from and :to and m.monthYearStart between (l.listedFrom-30) and l.listedTo and (l.listedTo-l.listedFrom)>=1 ";
		String sql= select+ from+ where+"order by m.monthYearStart desc";
		Query query= getSession().createQuery(sql);
		query.setParameter("operatorID",operatorID).setParameter("from", fromD).setParameter("to", toD);
		int i=0;
		 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
	            list.add((Object[]) it.next());
		 }
		
		return list;
	}
	
	
	// Convert from string to date
	public Date StringToDate(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date myDate = simpleDateFormat.parse(date);
		return myDate;
	} 
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */

	@Override
	public Iterator iterator() {
		return this.iterator();
	}
}
