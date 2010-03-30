package edu.itee.antipodes.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * A persistence class that stores tour dates from the TourDate table in DB.
 *
 */
public class TourDate implements Serializable{
	private int dateID;
	private Date startDate;
	private Date finishDate;
	private int tourID;
	
	public int getDateID(){
		return dateID;
	}
	private void setDateID(int dateID){
		this.dateID=dateID;
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
	public void setTourID(){
		this.tourID=tourID;
	}
	
	@Override
	public String toString() {
		return "TourDate [dateID=" + dateID + ", finishDate=" + finishDate + ", startDate="
				+ startDate + ", tourID=" + tourID + "]";
	}
}