package edu.itee.antipodes.domain.db;
import java.io.Serializable;
import java.util.Date;

/**
 * A persistence class that stores the tours listed from ListedTours table in DB.
 *
 */
@SuppressWarnings("serial")
public class ListedTour implements Serializable{
	private int listID;
	private Date listedFrom;
	private Date listedTo;
	private TourOperator operator;
	private Tour tour;
	private int tourID;
	
	public ListedTour(){}
	
	public ListedTour(TourOperator operator, Tour tour) {
		this.operator = operator;
		this.tour = tour;
	}
	
	public int getListID() {
		return listID;
	}
	public void setListID(int listID){
		this.listID=listID;
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
	public TourOperator getOperator() {
		return operator;
	}
	public void setOperator(TourOperator operator) {
		this.operator = operator;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	
	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	@Override
	public String toString() {
		return "ListedTour [listID=" + listID + ", listedFrom=" + listedFrom
				+ ", listedTo=" + listedTo + ", operatorID=" + operator.getOperatorID()
				+ ", tourID=" + tour.getTourID() + "]";
	}
	
}