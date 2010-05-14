package edu.itee.antipodes.domain.pages;


import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;
import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

public final class BillingTourOperators {
	
	@NotNull
	private String exportFormat;
	
	private Date fromDate;
	
	private Date toDate;
	
	private int operatorID;
	
	private int criteriaNum;
	
	@NotBlank
	private String criteria;

	public String getExportFormat() {
		return exportFormat;
	}

	public void setExportFormat(String exportFormat) {
		this.exportFormat = exportFormat;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}

	public int getCriteriaNum() {
		return criteriaNum;
	}

	public void setCriteriaNum(int criteriaNum) {
		this.criteriaNum = criteriaNum;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "fromDate")
    private boolean compareDate() {	
		if (fromDate == null || toDate == null)
		{
			return false;
		}
		return fromDate.before(toDate);
    }
	
	@Override
	public String toString() {
		return "BillingTourOperators [criteria=" + criteria + ", criteriaNum="
				+ criteriaNum + ", exportFormat=" + exportFormat
				+ ", fromDate=" + fromDate + ", operatorID=" + operatorID
				+ ", toDate=" + toDate + "]";
	}

	
}
