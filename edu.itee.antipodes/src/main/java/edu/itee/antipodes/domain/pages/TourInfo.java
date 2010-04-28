package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.RegExp;

public class TourInfo {
	
	private int tourID;
	
	@NotBlank
	@Length(max = 40)
	@RegExp(value = "[a-zA-Z0-9 '?!]*")
	private String tourName;
	
	@NotBlank
	@Length(max = 80)
	private String tourDesc;
	
	@NotBlank
	@Length(max = 8)
	@RegExp(value = "[0-9.]*")
	private String price;
	
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
		

}
