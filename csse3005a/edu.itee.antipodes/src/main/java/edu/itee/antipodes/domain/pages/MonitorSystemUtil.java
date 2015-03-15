package edu.itee.antipodes.domain.pages;

import java.util.Date;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationMethod;

public final class MonitorSystemUtil {
	private String exportFormat;

	private Date fromDate;
	
	private Date toDate;

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

	@SuppressWarnings("unused")
	@ValidationMethod(forProperty = "fromDate")
    private boolean compareDate() {	
		if (fromDate == null || toDate == null)
		{
			return false;
		}
		return fromDate.before(toDate);
    }


	
	
}
