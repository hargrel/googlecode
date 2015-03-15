package edu.itee.antipodes.domain.db;

import java.io.Serializable;
import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

import edu.itee.antipodes.service.UtilityManager;

/**
 * A persistence class that stores tour dates from the TourDate table in DB.
 *
 */
@SuppressWarnings("serial")
public class TourDate implements Serializable{
	private int dateID;
	private Date startDate;
	private Date finishDate;
	private int tourID;
	private Tour tour;
	private String startDateString;
	private String finishDateString;
	private String pattern = "dd/MM/yyyy";
	
	UtilityManager um = new UtilityManager();
	
	public int getDateID(){
		return dateID;
	}
	
	public void setDateID(int dateID){
		this.dateID = dateID;
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
	public int getTourID() {
		return tourID;
	}
	public void setTourID(int tourID){
		this.tourID = tourID;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public String getStartDateString() {
		startDateString = um.dateToString(startDate, pattern);
		return startDateString;
	}
	public String getFinishDateString() {
		finishDateString = um.dateToString(finishDate, pattern);
		return finishDateString;
	}

	@Override
	public String toString() {
		return "TourDate [dateID=" + dateID + ", finishDate=" + finishDate + ", startDate="
				+ startDate + ", tourID=" + tourID + "]";
	}
	
	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "startDate")
    private boolean compareDate() {	
		if (startDate == null || finishDate == null)
		{
			return false;
		}
		return startDate.before(finishDate) || startDate.equals(finishDate);
    }
}