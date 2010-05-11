package edu.itee.antipodes.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import edu.itee.antipodes.domain.db.TourOperator;

public interface TourOperatorManager extends Serializable{
	
	public List<TourOperator> getOperators();
	
	public void dropTourOperator(int id);
	
	public TourOperator getTourOperatorByID(int id);
	
	public void updateTourOperator(TourOperator operator);

	public void addTourOperator(TourOperator operator);
	
	public void UploadFile(ApplicationContext applicationContext,
			MultipartFile multipartFile, int tourID);
}
