package edu.itee.antipodes.domain.pages;

import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public final class DetectAbuse {
	
	@NotBlank
	private String exportFormat;
	
	public String getExportFormat() {
		return exportFormat;
	}

	public void setExportFormat(String exportFormat) {
		this.exportFormat = exportFormat;
	}
}
