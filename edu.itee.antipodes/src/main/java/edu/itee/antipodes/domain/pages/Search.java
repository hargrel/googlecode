package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

public class Search {
	
	@NotBlank
	@Length(max = 30)
	@RegExp(value = "[a-zA-Z ,]*")
	private String locationName;
	
	@NotBlank
	@Length(max = 30)
	@RegExp(value = "[a-zA-Z ,]*")
	private String activityName;
	
	@RegExp(value = "[0-9{2}/0-9{2}/0-9{4}]*")
	private String startDate;
	
	@RegExp(value = "[0-9{2}/0-9{2}/0-9{4}]*")
	private String finishDate;
	
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
	
}
