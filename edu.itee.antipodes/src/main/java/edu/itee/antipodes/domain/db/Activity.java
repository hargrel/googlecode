package edu.itee.antipodes.domain.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

/**
 * A persistence class that stores info from Activity table
 */

@SuppressWarnings("serial")
public class Activity implements Serializable{

	private int activityID;
	
	@NotBlank
	@Length(max = 20)
	@RegExp(value = "[a-zA-Z ,]*")
	private String activityName;
	
	private Set<Tour> tours = new HashSet<Tour>(0);
	

	public Activity(){}
	public Activity(String activityName, Set<Tour> tours) {
		this.activityName = activityName;
		this.tours = tours;
	}
	
	

	public int getActivityID() {
		return activityID;
	}

	@SuppressWarnings("unused")
	private void setActivityID(int activityID){
		this.activityID=activityID;

	
	public void setActivityID(int activityID){
		this.activityID=activityID;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Set<Tour> getTours() {
		return tours;
	}
	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}
@Override
	public String toString() {
		return "Activity [activityID=" + activityID + ", activityName="
				+ activityName + "]";
	}

}
