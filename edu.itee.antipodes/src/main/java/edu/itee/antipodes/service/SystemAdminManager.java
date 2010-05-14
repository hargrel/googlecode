package edu.itee.antipodes.service;

import java.util.List;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;

public interface SystemAdminManager {
	public void removeLocationByID(String locationID);
	public Location getLocationByID(String locationID);
	public void saveLocation(Location location);
	public List<Location> getLocationList();

	public List<Activity> getActivityList();
	public Activity getActivityByID(String activityID);
	public void saveActivity(Activity activity);
	public void removeActivityByID(String activityID);
	
	public void addAccount(AccountUser accountUser, String membershipExpiry) throws Exception;
}
