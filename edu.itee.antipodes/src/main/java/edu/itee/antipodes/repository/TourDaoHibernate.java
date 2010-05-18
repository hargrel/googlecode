package edu.itee.antipodes.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.*;
import edu.itee.antipodes.domain.db.*;


public class TourDaoHibernate extends HibernateDaoSupport implements TourDao {

	public void addTour(Tour tour) throws HibernateException{
		getHibernateTemplate().save(tour);
	}	
   
    @SuppressWarnings("unchecked")
    public List<Tour> getTourList() throws HibernateException{
		return (List<Tour>)getHibernateTemplate().find("from Tour");
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

    public void dropTourByID(int tourID) throws HibernateException{
        Object record = getHibernateTemplate().load(Tour.class, tourID);
        getHibernateTemplate().delete(record);
    }
        
	 //For Operator functionality: get all the tours added (not the listed)by an operator
	@SuppressWarnings("unchecked")
	public  List<Tour> getTourListByOperatorID(int id){
		
		// --------------------- START: original version ------------------------------------------------------------
		//Query query = getSession().createQuery("select t from Tour as t join t.operator as o where o.operatorID = :id ");
		//List<Tour> list = query.setParameter("id", id).list();
		//return list;
		// --------------------- END: original version ------------------------------------------------------------
		
		if (id == 0) return null;
		List<Tour> list = new ArrayList<Tour>();
		String sql = "select t from Tour as t join t.operator as o where o.operatorID = :id ";
		list = (List<Tour>)getHibernateTemplate().findByNamedParam(sql, "id", id);
		if (list.size() == 0) return null;
		return list;
	}
	
//	public Set<TourDate> getTourDatesByTourID(int tourID){
//		return ((Tour)getHibernateTemplate().get(Tour.class, tourID)).getTourDates();
//	}
//
//	public Set<Image> getImagesByTourID(int tourID){
//		return ((Tour)getHibernateTemplate().get(Tour.class, tourID)).getTourImages();
//	}
}



