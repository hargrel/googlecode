package edu.itee.antipodes.repository;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.db.TourOperator;

public class TourOperatorDaoHibernate extends HibernateDaoSupport implements TourOperatorDao {

	@SuppressWarnings("unchecked")
	public List<TourOperator> getTourOperatorList() {
		return getHibernateTemplate().find("from TourOperator");
	}
	public TourOperator getTourOperatorByID(int id){
		return (TourOperator)getHibernateTemplate().get(TourOperator.class, id);
	}
	public void saveTourOperator(TourOperator tourOperator) {
		//getHibernateTemplate().saveOrUpdate(tourOperator);	
		getHibernateTemplate().save(tourOperator);
	}						
	public void dropTourOperator(TourOperator tourOperator) {
		Object record = getHibernateTemplate().load(TourOperator.class, tourOperator.getOperatorID());
        getHibernateTemplate().delete(record);
    }
	public void dropTourOperatorByID(int tourOperatorID) {
		Object record = getHibernateTemplate().load(TourOperator.class, tourOperatorID);
        getHibernateTemplate().delete(record);
    }
}
