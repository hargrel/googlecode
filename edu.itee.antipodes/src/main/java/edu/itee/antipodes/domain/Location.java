package edu.itee.antipodes.domain;

import java.io.Serializable;
/**
 * A persistence class that stores info from local Location table in DB.
 */
public class Location implements Serializable{
	private int locationID;
	private String locationName;
	private double longitude;
	private double latitude;

	public int getLocationID() {
		return locationID;
	}
	private void setLocationID(){
		this.locationID=locationID;
	}

	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "Location [locationID=" + locationID + ", locationName="
				+ locationName + "]";
	}

	
}
