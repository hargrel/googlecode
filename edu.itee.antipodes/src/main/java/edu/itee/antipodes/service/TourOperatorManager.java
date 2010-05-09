package edu.itee.antipodes.service;

import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

public interface TourOperatorManager {
	public void UploadFile(ApplicationContext applicationContext,
			MultipartFile multipartFile, int tourID);
}
