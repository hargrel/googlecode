package edu.itee.antipodes.domain.pages;

import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

public class AlignTourDate {

	private Date startDate;
	private Date finishDate;

	private int tourID;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	@ValidationMethod(forProperty = "startDate")
	private boolean compareDate() {
		if (startDate == null || finishDate == null) {
			return false;
		}
		return startDate.before(finishDate) || startDate.equals(finishDate);
	}
}
