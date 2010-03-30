package edu.itee.antipodes.domain;

import java.io.Serializable;
/**
 * A persistence class that stores info from Image table in DB.
 *
 */
public class Image implements Serializable{
	private int imageID;
	private String url;
	private int tourID;
	
	public int getImageID() {
		return imageID;
	}
	
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
	public void setTourID(){
		this.tourID=tourID;
	}
	
	@Override
	public String toString() {
		return "Image [imageID=" + imageID + ", tourID=" + tourID + ", url=" + url + "]";
	}
	
	
}