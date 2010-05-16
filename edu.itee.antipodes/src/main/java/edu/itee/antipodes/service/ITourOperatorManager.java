package edu.itee.antipodes.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.domain.pages.AlignTour;

public interface ITourOperatorManager extends Serializable{
	
	public List<TourOperator> getOperators();
	
	public void dropTourOperator(int id);
	
	public TourOperator getTourOperatorByID(int id);
	
	public void updateTourOperator(TourOperator operator);

	public void addTourOperator(TourOperator operator);
	
	public void UploadFile(ApplicationContext applicationContext,
			MultipartFile multipartFile, int tourID);
	
	
	public List<Tour> getTours();
	
	public List<Tour> getToursByOperatorID(int id);
	
	public void dropTourByID(int id);
	
	public Tour getTourByID(int id);
	
	public void updateTour(Tour tour);
	
	public void addTour(Tour tour);

	public void alignTour(String startDateString, String finishDateString,
			AlignTour alignTour) throws ParseException;

	public List<Location> getLocationList();

	public List<Activity> getActivityList();

	public AlignTour getAlignTourByID(String tourID);

	public Tour getTourByID(String id);
}
