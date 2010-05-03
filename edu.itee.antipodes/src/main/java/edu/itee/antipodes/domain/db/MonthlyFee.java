package edu.itee.antipodes.domain.db;

import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

public class MonthlyFee {
	private int feeID;
	private Date monthYearStart;
	
	@NotNull
	private float fee;

	
	public MonthlyFee() {}
	
	public int getFeeID() {
		return feeID;
	}

	public void setFeeID(int feeID) {
		this.feeID = feeID;
	}

	

	public Date getMonthYearStart() {
		return monthYearStart;
	}

	public void setMonthYearStart(Date monthYearStart) {
		this.monthYearStart = monthYearStart;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}
	



	@Override
	public String toString() {
		return "MonthlyFee [fee=" + fee + ", feeID=" + feeID
				+ ", monthYearStart=" + monthYearStart + "]";
	}

	
	
}
