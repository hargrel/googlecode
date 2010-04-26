package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.Activity;

public interface ActivityDao {

	public List<Activity> getActivityList();
	
	public void saveActivity(Activity activity);
	
	public void dropActivity(Activity activity);

}

