package edu.itee.antipodes.repository;

//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.TourDate;

public class TourDateDaoHibernate extends HibernateDaoSupport implements TourDateDao {
	
	public void addTourDate(TourDate tourDate) throws HibernateException{
		getHibernateTemplate().save(tourDate);
	}

	@SuppressWarnings("unchecked")
	public List<TourDate> getTourDateList() throws HibernateException{
		return getHibernateTemplate().find("from TourDate");
	}
	
	public TourDate getTourDateByID(int id){
		return (TourDate)getHibernateTemplate().get(TourDate.class, id);
	}

	public void saveTourDate(TourDate tourDate) throws HibernateException{
		getHibernateTemplate().saveOrUpdate(tourDate);	
	}						
	
	public void dropTourDate(TourDate tourDate) throws HibernateException{
		Object record = getHibernateTemplate().load(TourDate.class, tourDate.getDateID());
        getHibernateTemplate().delete(record);
    }
}
