package edu.itee.antipodes.domain.pages;

import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

public class AlignTour {
	private int tourID;
	
	private String tourName;
	
	private Date startDate;
	
	private Date finishDate;
	
	private int locationID;
	
	private int activityID;

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

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public int getActivityID() {
		return activityID;
	}

	public void setActivityID(int activityID) {
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
	
	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "totalDays")
    private boolean checkInt() {	
		if (totalDays == 0){
		return false;}
		else return true;
    }
	
}
