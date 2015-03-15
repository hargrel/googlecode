package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.Location;

public interface LocationDao {

	public List<Location> getLocationList();
	
	public void saveLocation(Location location);
	
	public void dropLocation(Location location);	
	
	public Location getLocationByID(int id);
	
	public void dropLocationByID(int locationID);
}


