package edu.itee.antipodes.domain.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Tour implements Serializable {
	
	private int tourID; 
	private String tourName;
	private String tourDesc;
	private double price;
	private int totalDays;
	private int onDemand;
	private Set<Activity> activities = new HashSet<Activity>(0);
	private Set<Location> locations = new HashSet<Location>(0);
	private Set<TourDate> tourDates = new HashSet<TourDate>(0);
	private Set<Image> images = new HashSet<Image>(0);
	
	//default constructor, instances are initiated by Constructor.newInstance()
	public Tour(){}
	
	public Tour(String tourName, String tourDesc, float price, int totalDays){
		this.tourName = tourName;
		this.tourDesc = tourDesc;
		this.price = price;
		this.totalDays = totalDays;
	}		
	
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
	
	public int getOnDemand() {
		return onDemand;
	}

	public void setOnDemand(int onDemand) {
		this.onDemand = onDemand;
	}
	
	public Set<Activity> getActivities() {
		return activities;
	}
	
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	public Set<Location> getLocations() {
		return locations;
	}
	
	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
	
	public Set<TourDate> getTourDates() {
		return tourDates;
	}

	public void setTourDates(Set<TourDate> tourDates) {
		this.tourDates = tourDates;
	}
	
	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Tour [price=" + price + ", totalDays=" + totalDays
				+ ", tourDesc=" + tourDesc + ", tourID=" + tourID
				+ ", tourName=" + tourName + "]";
	}
	
}
