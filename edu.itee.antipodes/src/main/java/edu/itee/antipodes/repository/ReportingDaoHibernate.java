package edu.itee.antipodes.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.db.Tour;


@SuppressWarnings("unchecked")
public class ReportingDaoHibernate extends HibernateDaoSupport implements Iterable{
	Object[] tuple=null;
	List list=null;
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
		String select="select a.activityID, a.activityName, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.activities as a ";	
		String where="where a.activityID=:activityID ";

		if (id == 0) return null;
		String sql= select+ from+where+"group by a.activityID, a.activityName ";
		list = getHibernateTemplate().findByNamedParam(sql, "activityID", id);
		if (list.size()==0) return null;
		return list;
//		return (list.size() != 0)? list:null;
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
		String select="select a.activityID, a.activityName, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.activities as a ";			
		String sql= select+ from+"group by a.activityID, a.activityName ";
		list = getHibernateTemplate().find(sql);
//		Query query= getSession().createQuery(sql);
//		int i=0;
//		 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
//	            list.add((Object[]) it.next());
//		 }
		if (list.size()==0) return null;
		return list;
//		return (list.size() != 0)? list:null;
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
		String select="select c.locationID, c.locationName, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.locations as c ";
		String where="where c.locationID=:locationID ";
		
		if (id == 0) return null;
		String sql= select+ from+where+ "group by c.locationID, c.locationName ";

//			Query query= getSession().createQuery(sql);
//			query.setParameter("locationID", id);
//			int i=0;
//			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
//		            list.add((Object[]) it.next());
//			 }

		list = getHibernateTemplate().findByNamedParam(sql, "locationID", id);
		
		if (list.size()==0) return null;
		return list;
//		return (list.size() != 0)? list:null;
	}
	
	/*
	 * For Monitoring search criteria utilisation report--all locations	 
	 * @return list of tuples(actually one) in the form of Object[], in which 
	 * Object[0]=location object,  Object[1]= number of listed 
	 * tours that are aligned with the given location .
	 * @author 41931527
	 */
	public List<Object[]> getNumToursAsscWithLocation(){
				
		String select="select c.locationID, c.locationName, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.locations as c ";
		
		String sql= select+ from+"group by c.locationID, c.locationName ";
//			Query query= getSession().createQuery(sql);
//			int i=0;
//			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
//		            list.add((Object[]) it.next());
//		     }
//			 return list;	
		
		list = getHibernateTemplate().find(sql);
		if (list.size()==0) return null;
		return list;
//		return (list.size() != 0)? list:null;
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

		
		String select = "select t.tourID,  t.tourName, COUNT(DISTINCT a.activityID) + COUNT(DISTINCT c.locationID) ";
		String from = "from ListedTour as l join l.tour as t join t.activities as a join t.locations as c ";
		String sql = select+from+"group by t.tourID, t.tourName "+
			"having COUNT(DISTINCT a.activityID)+COUNT(DISTINCT c.locationID) >= :minNum "+"order by t.tourID";
		
		list = getHibernateTemplate().findByNamedParam(sql, "minNum", (long)minNum);
		

		
		if (list.size()==0) return null;
		return list;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//(list.size() != 0)? list:null;
//			Query query= getSession().createQuery(sql);
//			query.setParameter("minNum", Long.valueOf(minNum));
//			int i=0;
//			 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
//		            list.add((Object[]) it.next());
//			 }
//		}
//
//		return list;
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
	public List<Object[]> getNumOfToursAndTotalPricePerMonthForAllTourOperator(Date fromD, Date toD) {

		//o-> id, name
		List<Object[]> list = new ArrayList<Object[]>();
		String select="select  m.monthYearStart,o.operatorID,o.operatorName, m.fee, COUNT(t.tourID), COUNT(t.tourID)*m.fee ";
		String from="from TourOperator as o join o.listedTour as l join l.tour as t, MonthlyFee as m ";
		
		// l.listedFrom-30 since we want to include the previous month, ex. for 12/05/2010, we want to charge 05/2010's fee as well
		String where="where m.monthYearStart between :from and :to and m.monthYearStart between (l.listedFrom-30) and l.listedTo and (l.listedTo-l.listedFrom)>=1  ";
		String sql= select+ from+ where+"group by  m.monthYearStart,o.operatorID,o.operatorName, m.fee "+"order by m.monthYearStart desc";
		
		String[] params = new String[2];
		params[0] = "from";
		params[1] = "to";
		
		Object[] vals = new Object[2];
		vals[0] = fromD;
		vals[1] = toD;
		
		list = (List<Object[]>)getHibernateTemplate().findByNamedParam(sql, params, vals);
		
		if (list.size()==0) return null;
		return list;

		//		return (list.size() != 0)? list:null;
//		Query query= getSession().createQuery(sql);
//		query.setParameter("from", fromD).setParameter("to", toD);
//		int i=0;
//		 for (Iterator it= query.iterate(); it.hasNext(); i++ ) {
//	            list.add((Object[]) it.next());
//		 }
//		
//		return list;
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
	public List<Object[]> getListedToursPerMonthByOperatorID(int operatorID, Date fromD, Date toD){
		//t->id, name
		List<Object[]> list = new ArrayList<Object[]>();
		String select="select m.monthYearStart, t.tourID, t.tourName, m.fee ";
		String from="from TourOperator as o join o.listedTour as l join l.tour as t, MonthlyFee as m ";
		String where="where o.operatorID=:operatorID and m.monthYearStart between :from and :to and m.monthYearStart between (l.listedFrom-30) and l.listedTo and (l.listedTo-l.listedFrom)>=1 ";
		String sql= select+ from+ where+"order by m.monthYearStart desc";
		
		String[] params = new String[3];
		params[0]="operatorID";
		params[1]="from";
		params[2]="to";
		
		Object[] vals = new Object[3];
		vals[0]=operatorID;
		vals[1]=fromD;
		vals[2]=toD;
		
		list = (List<Object[]>)getHibernateTemplate().findByNamedParam(sql, params, vals);
		
		if (list.size()==0) return null;
		return list;
		
		
		
//		Date currentDate = new Date();
//		
//		//t->id, name
//		List<Object[]> list = new ArrayList<Object[]>();
//		String select="select m.monthYearStart, t.tourID, t.tourName, m.fee ";
//		String from="from TourOperator as o join o.listedTour as l join l.tour as t, MonthlyFee as m ";
//		String where="where o.operatorID=:operatorID and m.monthYearStart between :from and :to and " +
//				"((l.listedTo is null and m.monthYearStart between (l.listedFrom-30) and :currentDate " +
//				"and (:currentDate-l.listedFrom)>=1)) or (l.listedTo is not null and m.monthYearStart " +
//				"between (l.listedFrom-30) and l.listedTo and (l.listedTo-l.listedFrom)>=1))  ";
//		String sql= select+ from+ where+"order by m.monthYearStart desc";
//		
//		String[] params = new String[4];
//		params[0]="operatorID";
//		params[1]="from";
//		params[2]="to";
//		params[3]="currentDate";
//		
//		Object[] vals = new Object[4];
//		vals[0]=operatorID;
//		vals[1]=fromD;
//		vals[2]=toD;
//		vals[3]=currentDate;
//		
//		
//		list = (List<Object[]>)getHibernateTemplate().findByNamedParam(sql, params, vals);
//		
//		if (list.size()==0) return null;
//		return list;

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
