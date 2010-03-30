package edu.itee.antipodes.domain;

import java.io.Serializable;
/**
 * A persistence class that stores info from Activity table
 *
 */

public class Activity implements Serializable{

	private int activityID;
	private String activityName;
	
	public int getActivityID() {
		return activityID;
	}

	private void setActivityID(int activityID){
		this.activityID=activityID;
	}
	
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
@Override
	public String toString() {
		return "Activity [activityID=" + activityID + ", activityName="
				+ activityName + "]";
	}

}
