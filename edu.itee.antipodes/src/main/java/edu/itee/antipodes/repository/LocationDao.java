package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.Location;

public interface LocationDao {

	public List<Location> getLocationList();
	
	public void saveLocation(Location location);
	
	public void dropLocation(Location location);	
}


