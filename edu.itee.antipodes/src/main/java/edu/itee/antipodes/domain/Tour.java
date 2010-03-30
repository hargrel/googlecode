package edu.itee.antipodes.domain;

import java.io.Serializable;

public class Tour implements Serializable {
	
	private int tourID; 
	private String tourName;
	private String tourDesc;
	private double price;
	private int totalDays;
	
	//default constructor, instances are initiated by Constructor.newInstance()
	public Tour(){	}
	
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
	
	public String getTourDesc() {
		return tourDesc;
	}
	
	public void setTourDesc(String tourDesc) {
		this.tourDesc = tourDesc;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getTotalDays() {
		return totalDays;
	}
	
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	

	@Override
	public String toString() {
		return "Tour [price=" + price + ", totalDays=" + totalDays
				+ ", tourDesc=" + tourDesc + ", tourID=" + tourID
				+ ", tourName=" + tourName + "]";
	}
	
}
