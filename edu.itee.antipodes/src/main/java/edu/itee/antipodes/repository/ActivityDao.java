package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.Activity;

public interface ActivityDao {

	public List<Activity> getActivityList();
	
	public void saveActivity(Activity activity);
	
	public void dropActivity(Activity activity);

	public Activity getActivityByID(int activityID);
}

