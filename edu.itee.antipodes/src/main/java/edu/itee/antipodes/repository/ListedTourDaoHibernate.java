package edu.itee.antipodes.repository;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.*;

public class ListedTourDaoHibernate extends HibernateDaoSupport implements ListedTourDao {
	public void addListedTour(ListedTour listedTour) {
		getHibernateTemplate().save(listedTour);
	}
	@SuppressWarnings("unchecked")
	public List<ListedTour> getListedTourList() {
		return getHibernateTemplate().find("from ListedTour");
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
}
