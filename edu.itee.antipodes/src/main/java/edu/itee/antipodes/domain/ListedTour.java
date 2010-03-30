package edu.itee.antipodes.domain;
import java.io.Serializable;
import java.util.Date;
/**
 * A persistence class that stores the tours listed from ListedTours table in DB.
 *
 */
public class ListedTour implements Serializable{
	private int listID;
	private int tourID;
	private int operatorID;
	private Date listedFrom;
	private Date listedTo;
	
	public int getListID() {
		return listID;
	}
	public void setListID(int listID){
		this.listID=listID;
	}
	public int getTourID() {
		return tourID;
	}
	public void setTourID(int tourID){
		this.tourID=tourID;
	}

	
	public int getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String username) {
		this.operatorID = operatorID;
	}
	public Date getListedFrom() {
		return listedFrom;
	}
	public void setListedFrom(Date listedFrom) {
		this.listedFrom = listedFrom;
	}
	public Date getListedTo() {
		return listedTo;
	}
	public void setListedTo(Date listedTo) {
		this.listedTo = listedTo;
	}
	@Override
	public String toString() {
		return "ListedTours [listID=" + listID + ", listedFrom=" + listedFrom + ", listedTo="
				+ listedTo + ", tourID=" + tourID + ", operatorID=" + operatorID
				+ "]";
	}
	
	
}