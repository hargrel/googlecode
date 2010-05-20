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
import edu.itee.antipodes.domain.pages.AlignTourDate;

/**
 * A tour operator interface contains all the necessary functionality required
 * by tour operator. It links directly to Tour Operator use case group in the
 * software requirements specification.
 * 
 */
public interface ITourOperatorManager extends Serializable {

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

	/**
	 * Add a new tour to the database with the linked listed tour
	 * 
	 * @param tour
	 *            tour Object
	 */
	public void addTour(Tour tour);

	public void alignTour(AlignTour alignTour) throws ParseException;

	public List<Location> getLocationList();

	public List<Activity> getActivityList();

	public AlignTour getAlignTourByID(String tourID);

	public Tour getTourByID(String id);

	public void alignTourDate(AlignTourDate alignTourDate);

	public AlignTourDate getAlignTourDateByID(String tourID);

	public void deleteTourDate(String dateID);
}
