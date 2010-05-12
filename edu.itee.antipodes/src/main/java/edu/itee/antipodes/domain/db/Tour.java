package edu.itee.antipodes.domain.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;
import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

@SuppressWarnings("serial")
public class Tour implements Serializable {
	
	private int tourID; 
	
	@NotBlank
	@Length(max = 40)
	@RegExp(value = "[a-zA-Z0-9 '?!]*")
	private String tourName;
	
	@NotBlank
	@Length(max = 256)
	private String tourDesc;
	
	@NotNull
	@Length(max = 3)
	private String currency;
	
	private double price;
	private int totalDays;
	private int onDemand;
	private Set<Activity> activities = new HashSet<Activity>(0);
	private Set<Location> locations = new HashSet<Location>(0);
	private Set<TourDate> tourDates = new HashSet<TourDate>(0);
	private Set<Image> images = new HashSet<Image>(0);
	private TourOperator operator;
	
	//default constructor, instances are initiated by Constructor.newInstance()
	public Tour(){}
	
	public Tour(String tourName, String tourDesc, float price, int totalDays,String currency){
		this.tourName = tourName;
		this.tourDesc = tourDesc;
		this.price = price;
		this.totalDays = totalDays;
		this.currency=currency;
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
	
	
	
	
	public TourOperator getOperator() {
		return operator;
	}

	public void setOperator(TourOperator operator) {
		this.operator = operator;
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
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	
	
	@Override
	public String toString() {
		return "Tour [currency=" + currency + ", locations=" + locations
				+ ", onDemand=" + onDemand + ", operator=" + operator
				+ ", price=" + price + ", tourDesc=" + tourDesc + ", tourID="
				+ tourID + ", tourName=" + tourName + "]";
	}

	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "price")
    private boolean checkDouble() {	
		return (price != 0.0);
    }
	
}
