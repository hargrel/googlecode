package edu.itee.antipodes.domain.db;

import java.io.Serializable;
/**
 * A persistence class that stores info from Image table in DB.
 *
 */
@SuppressWarnings("serial")
public class Image implements Serializable{
	private int imageID;
	private String url;
	private int tourID;
	private Tour tour;
	
	public int getImageID() {
		return imageID;
	}
	@SuppressWarnings("unused")
	private void setImageID(int imageID){
		this.imageID=imageID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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

	@Override
	public String toString() {
		return "Image [imageID=" + imageID + ", tourID=" + tourID + ", url=" + url + "]";
	}
	
	
}