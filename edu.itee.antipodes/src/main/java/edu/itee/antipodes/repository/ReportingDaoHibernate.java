package edu.itee.antipodes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReportingDaoHibernate extends HibernateDaoSupport implements Iterable{
	Object[] tuple=null;


/*
 * @param minNum the specified minimum number of listed tour associated with criteria activity
 * @request minNum != null
 * @return returns a list of tuples(i.e. Object[]), 
 * in which Object[0]=activityID, Object[1]=activityName, Object[2]= number of
 * listed tours associated with the criteria
 * @author 41931527 
 */
	public List<Object[]> getNumToursAsscWithActivityByMinNum(int minNum){
		List<Object[]> list = new ArrayList<Object[]>();
				
		String select="select a.activityID, a.activityName, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.activities as a ";
		if ((Integer)minNum != null){
			String sql= select+ from+"group by a.activityID, a.activityName "+"having COUNT(l.listID) >= :minNum";
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
	 * @param minNum the specified minimum number of listed tour associated with criteria loction
	 * @request minNum != null
	 * @return returns a list of tuples(i.e. Object[]), 
	 * in which Object[0]=locationID, Object[1]=locationName, Object[2]= number of
	 * listed tours associated with the criteria
	 * @author 41931527 
	 */
	public List<Object[]> getNumToursAsscWithLocationByMinNum(int minNum){
		List<Object[]> list = new ArrayList<Object[]>();				
		String select="select c.locationID, c.locationName, COUNT(l.listID) ";
		String from="from ListedTour as l join l.tour as t join t.locations as c ";
		if ((Integer)minNum != null){
			String sql= select+ from+ "group by c.locationID, c.locationName "+"having COUNT(l.listID) >=:minNum";
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
