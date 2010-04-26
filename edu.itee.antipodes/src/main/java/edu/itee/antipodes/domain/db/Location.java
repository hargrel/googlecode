package edu.itee.antipodes.domain.db;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * A persistence class that stores info from local Location table in DB.
 */
@SuppressWarnings("serial")
public class Location implements Serializable{
	
	private int locationID;
	private String locationName;
	private double longitude;
	private double latitude;
	private Set<Tour> tours = new HashSet<Tour>(0);

	public Location(){}
	public Location(String locationName, float longitude, float latitude, Set<Tour> tours) {
		this.locationName = locationName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.tours = tours;
	}
	
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID){
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
	public Set<Tour> getTours() {
		return tours;
	}
	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}
	@Override
	public String toString() {
		return "Location [latitude=" + latitude + ", locationID=" + locationID
				+ ", locationName=" + locationName + ", longitude=" + longitude
				+ "]";
	}
}


