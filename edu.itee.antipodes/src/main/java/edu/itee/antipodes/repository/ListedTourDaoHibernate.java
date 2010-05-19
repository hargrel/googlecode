package edu.itee.antipodes.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.ListedTour;

public class ListedTourDaoHibernate extends HibernateDaoSupport implements ListedTourDao {
	public void addListedTour(ListedTour listedTour) {
		getHibernateTemplate().save(listedTour);
	}
	@SuppressWarnings("unchecked")
	public List<ListedTour> getListedTourList() {
		return getHibernateTemplate().find("from ListedTour");
	}
	@SuppressWarnings("unchecked")
	public List<ListedTour> getListedToursByOpID(int id) {
		return getHibernateTemplate().find("from ListedTour as LT where LT.operator.operatorID="+id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ListedTour> getListedToursByTourID(int id) {
		return getHibernateTemplate().find("from ListedTour as LT join LT.tour as T where T.tourID="+id);
	}
	
	public ListedTour getListedTourByID(int id){
		return (ListedTour)getHibernateTemplate().get(ListedTour.class, id);
	}
	public void saveListedTour(ListedTour listedTour) {
		getHibernateTemplate().saveOrUpdate(listedTour);	
	}			
	public void dropListedTour(ListedTour listedTour) {
		Object record = getHibernateTemplate().load(ListedTour.class, listedTour.getListID());
        getHibernateTemplate().delete(record);
    }
	public void dropListedTourByID(int listedTourID) {
		Object record = getHibernateTemplate().load(ListedTour.class, listedTourID);
        getHibernateTemplate().delete(record);
    }
	/*
	 * For Google map function
	 * @return a list of tuples in which
	 * Object[0]= location object
	 * Object[1]=latitude
	 * Object[2]=longitude
	 * Object[3]=points
	 * Object[4]=levels
	 */
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getLocationDetailsByListedTourID(int id){
		
//		List<Object[]> list = new ArrayList<Object[]>();		
//		String select="select c, c.latitude,c.longitude, c.points, c.levels ";
//		String from="from ListedTour as l join l.tour as t join t.locations as c ";	
//		String where="where l.listID=:listID ";
//		String sql=select+from+where;
//		Query query = getSession().createQuery(sql);
//		list= query.setParameter("listID", id).list();
//		return list;

		if (id == 0) return null;
		List<Object[]> list = new ArrayList<Object[]>();		
		String sql = "select c, c.latitude, c.longitude "+
			"from ListedTour as l join l.tour as t join t.locations as c "+
			"where l.listID = :listID ";
		list = (List<Object[]>)getHibernateTemplate().findByNamedParam(sql, "listID", id);
		if (list.size() == 0) return null;
		return list;
	}
	
	/*
	 * For Google map function
	 * @return a list of tuples in which
	 * Object[0]= image object
	 * Object[1]= url
	 * */
	@SuppressWarnings("unchecked")
	public List<Object[]> getImageDetailsByListedTourID(int id){

//		List<Object[]> list = new ArrayList<Object[]>();		
//		String select="select i, i.url ";
//		String from="from ListedTour as l join l.tour as t join t.images as i ";	
//		String where="where l.listID=:listID ";
//		String sql=select+from+where;
//		Query query = getSession().createQuery(sql);
//		list = query.setParameter("listID", id).list();
//		return list;
		
		if (id == 0) return null;
		List<Object[]> list = new ArrayList<Object[]>();		
		String sql = "select i, i.url "+"from ListedTour as l join l.tour as t join t.images as i "+"where l.listID = :listID";
		list = (List<Object[]>)getHibernateTemplate().findByNamedParam(sql, "listID", id);
		if (list.size() == 0) return null;
		return list;
	}
}
