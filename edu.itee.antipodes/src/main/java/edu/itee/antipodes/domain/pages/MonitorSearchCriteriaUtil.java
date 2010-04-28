package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public final class MonitorSearchCriteriaUtil {
	@NotBlank
	private String exportFormat;
	
	private String searchCriteria;

	
	
	
	
	
	public String getExportFormat() {
		return exportFormat;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setExportFormat(String exportFormat) {
		this.exportFormat = exportFormat;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
}
