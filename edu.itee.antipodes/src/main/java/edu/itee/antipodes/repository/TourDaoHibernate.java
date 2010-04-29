package edu.itee.antipodes.repository;

import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.*;
import edu.itee.antipodes.domain.db.*;


public class TourDaoHibernate extends HibernateDaoSupport implements TourDao {

	public void addTour(Tour tour) throws HibernateException{
		getHibernateTemplate().save(tour);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tour> getTourList() throws HibernateException{
		//return (List<Tour>)getHibernateTemplate().find("from Tour");
		return (List<Tour>)getHibernateTemplate().find("from Tour where totalDays < 5");
	}
	
	public Tour getTourByID(int id){
		return (Tour)getHibernateTemplate().get(Tour.class, id);
	}
	
	public void saveTour(Tour tour) throws HibernateException{
		getHibernateTemplate().saveOrUpdate(tour);
	}
	
	public void dropTour(Tour tour) throws HibernateException{
		Object record = getHibernateTemplate().load(Tour.class, tour.getTourID());
        getHibernateTemplate().delete(record);
    }
	
//	public Set<TourDate> getTourDatesByTourID(int tourID){
//		return ((Tour)getHibernateTemplate().get(Tour.class, tourID)).getTourDates();
//	}
//
//	public Set<Image> getImagesByTourID(int tourID){
//		return ((Tour)getHibernateTemplate().get(Tour.class, tourID)).getTourImages();
//	}

}
