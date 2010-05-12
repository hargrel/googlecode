package edu.itee.antipodes.domain.pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.db.TourDate;

public class AlignTour {
	private int tourID;
	
	private String tourName;
	
	private Date startDate;
	
	private Date finishDate;
	

	private List<Integer> activityID = new ArrayList<Integer>(0);
	private List<Integer> locationID = new ArrayList<Integer>(0);
	
	private int totalDays;

	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public List<Integer> getLocationID() {
		return locationID;
	}

	public void setLocationID(List<Integer> locationID) {
		this.locationID = locationID;
	}

	public List<Integer> getActivityID() {
		return activityID;
	}

	public void setActivityID(List<Integer> activityID) {
		this.activityID = activityID;
	}

	@Override
	public String toString() {
		return "AlignTour [activityID=" + activityID + ", finishDate="
				+ finishDate + ", locationID=" + locationID + ", startDate="
				+ startDate + ", totalDays=" + totalDays + ", tourID=" + tourID
				+ ", tourName=" + tourName + "]";
	}

	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "startDate")
    private boolean compareDate() {	
		if (startDate == null || finishDate == null){
		return true;}
		else return startDate.before(finishDate) || startDate.equals(finishDate);
    }
	/*
	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "totalDays")
    private boolean checkInt() {	
		if (totalDays == 0){
		return false;}
		else return true;
    }
	*/
}
