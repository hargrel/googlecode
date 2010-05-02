package edu.itee.antipodes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReportingDaoHibernate extends HibernateDaoSupport implements Iterable{
	Object[] tuple=null;
/*
 * For Monitoring search criteria utilisation report
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

	@Override
	public Iterator iterator() {
		return this.iterator();
	}
}
