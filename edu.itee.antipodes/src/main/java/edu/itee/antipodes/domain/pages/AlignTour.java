package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

public class AlignTour {
	private int tourID;
	
	private String tourName;
	
	@RegExp(value = "[0-9{2}/0-9{2}/0-9{4}]*")
	private String startDate;
	
	@RegExp(value = "[0-9{2}/0-9{2}/0-9{4}]*")
	private String finishDate;
	
	@Length(max = 2)
	@RegExp(value = "[0-9]*")
	private String totalDays;
	
	@NotNull
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(String totalDays) {
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

	@Override
	public String toString() {
		return "AlignTour [activityName=" + activityName + ", finishDate="
				+ finishDate + ", locationName=" + locationName
				+ ", startDate=" + startDate + ", totalDays=" + totalDays
				+ ", tourID=" + tourID + ", tourName=" + tourName + "]";
	}

	
}
