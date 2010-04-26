package edu.itee.antipodes.repository;

import java.util.List;
import java.util.Set;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//import edu.itee.antipodes.domain.Activity;
import edu.itee.antipodes.domain.Location;
import edu.itee.antipodes.domain.Tour;

public class LocationDaoHibernate extends HibernateDaoSupport implements LocationDao {

	public Location getLocation(int id){
		return (Location)getHibernateTemplate().get(Location.class, id);
	}
	public void addLocation(Location location) {
		getHibernateTemplate().save(location);
	}
	public void dropLocation(Location location) {
		Object record = getHibernateTemplate().load(Location.class, location.getLocationID());
        getHibernateTemplate().delete(record);
    }

	@SuppressWarnings("unchecked")
	public List<Location> getLocationList() {
		return getHibernateTemplate().find("from Location");
	}

	public void saveLocation(Location location) {
		getHibernateTemplate().saveOrUpdate(location);	
	}		
	public Set<Tour> getToursByLocationId(int locationID){
		return ((Location)getHibernateTemplate().get(Location.class, locationID)).getTours();
		
	}
}

