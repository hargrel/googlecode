package edu.itee.antipodes.domain.pages;

import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;
import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

public class AlignTour {
	private int tourID;
	
	private String tourName;
	
	private Date startDate;
	
	private Date finishDate;
	
	private int locationID;
	
	private int activityID;
	


	private int totalDays;
	
	@Length(max = 30)
	@RegExp(value = "[a-zA-Z ]*")
	private String locationName;
	
	@Length(max = 30)
	@RegExp(value = "[a-zA-Z ]*")
	private String activityName;

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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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
		return "AlignTour [activityName=" + activityName + ", finishDate="
				+ finishDate + ", locationName=" + locationName
				+ ", startDate=" + startDate + ", totalDays=" + totalDays
				+ ", tourID=" + tourID + ", tourName=" + tourName + "]";
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
