package edu.itee.antipodes.domain.db;

import java.io.Serializable;

/**
 * A persistence class that stores info from TourActivity table
 *
 */
@SuppressWarnings("serial")
public class TourActivity implements Serializable{
	
	private int activityID;
	private int tourID;

	public TourActivity(){}
	
	public int getActivityID() {
		return activityID;
	}
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
	public int getTourID() {
		return tourID;
	}
	public void setTourID(int tourID) {
		this.tourID = tourID;
	}
	
	public String toString() {
		return "Activity [activityID=" + activityID + ", tourID="
				+ tourID + "]";
	}	
	
}
