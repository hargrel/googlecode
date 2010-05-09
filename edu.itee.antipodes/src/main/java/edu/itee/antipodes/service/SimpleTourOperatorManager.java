package edu.itee.antipodes.service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.repository.TourDao;

public class SimpleTourOperatorManager implements TourOperatorManager {

	ImageDao imd = DaoManager.getImageDao();
	TourDao to = DaoManager.getTourDao();
	
	@Override
	public void UploadFile(ApplicationContext applicationContext,
			MultipartFile multipartFile, int tourID) {
		
		try {
			File dir = applicationContext.getResource("/uploads/images/").getFile();
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String originalFileName = multipartFile.getOriginalFilename();
			String contentType = multipartFile.getContentType();
			int dot = originalFileName.lastIndexOf('.');
		    String extension = originalFileName.substring(dot);
			if (!contentType.equals("image/png")
					&& !contentType.equals("image/jpg"))
				throw new InvalidParameterException();
			
			Image img = new Image();
			img.setTourID(tourID);
			img.setUrl(extension);
			img.setTour( to.getTourByID(tourID));
			imd.saveImage(img);
			
			String fileName = img.getImageID() + extension;
			File file = new File(dir, fileName);
			multipartFile.transferTo(file);
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
