package edu.itee.antipodes.domain.pages;

import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;
import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

public class Search {
	
	
	@Length(max = 30)
	@RegExp(value = "[a-zA-Z ,]*")
	private String locationName;
	
	@Length(max = 30)
	@RegExp(value = "[a-zA-Z ,]*")
	private String activityName;
	
	private Date startDate;
	
	private Date finishDate;
	
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
	
	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "startDate")
    private boolean compareDate() {	
		if (startDate == null || finishDate == null){
		return true;}
		else return startDate.before(finishDate) || startDate.equals(finishDate);
    }

}
