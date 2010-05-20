package edu.itee.antipodes.service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.domain.db.TourDate;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.domain.pages.AlignTour;
import edu.itee.antipodes.domain.pages.AlignTourDate;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.repository.ListedTourDao;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.TourDao;
import edu.itee.antipodes.repository.TourDateDao;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;

@SuppressWarnings("serial")
public class SimpleTourOperatorManager implements ITourOperatorManager {

	private SimpleTourOperatorManager() {
	}

	@Autowired
	private ImageDao imd;
	@Autowired
	TourDao tourDao;
	@Autowired
	private TourOperatorDaoHibernate operatorDao;
	@Autowired
	LocationDao locationDao;
	@Autowired
	ActivityDao activityDao;
	@Autowired
	private ListedTourDao listedTourDao;
	@Autowired
	private TourOperatorDao tourOperatorDao;
	@Autowired
	private TourDateDao tourDateDao;

	public TourOperator getTourOperatorByID(int id) {
		return operatorDao.getTourOperatorByID(id);
	}

	public void updateTourOperator(TourOperator operator) {
		operatorDao.saveTourOperator(operator);
	}

	public void addTourOperator(TourOperator operator) {
		operatorDao.addTourOperator(operator);
	}

	public void dropTourOperator(int id) {
		operatorDao.dropTourOperatorByID(id);
	}

	public List<TourOperator> getOperators() {
		return operatorDao.getTourOperatorList();
	}

	@Override
	public void UploadFile(ApplicationContext applicationContext,
			MultipartFile multipartFile, int tourID) {

		try {
			File dir = applicationContext.getResource("/uploads/images/")
					.getFile();
			if (!dir.exists()) {
				dir.mkdirs();
			}

			String originalFileName = multipartFile.getOriginalFilename();
			String contentType = multipartFile.getContentType();
			int dot = originalFileName.lastIndexOf('.');
			String extension = originalFileName.substring(dot);
			if (!contentType.equals("image/png")
					&& !contentType.equals("image/jpeg"))
				throw new InvalidParameterException();

			Image img = new Image();
			img.setTourID(tourID);
			img.setUrl(extension);
			img.setTour(tourDao.getTourByID(tourID));
			imd.saveImage(img);

			String fileName = img.getImageID() + extension;
			img.setUrl(img.getImageID() + extension);
			imd.saveImage(img);
			File file = new File(dir, fileName);
			multipartFile.transferTo(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public List<Tour> getTours() {
		return tourDao.getTourList();
	}

	public void dropTourByID(int id) {
		
		List<ListedTour> listedTours = listedTourDao.getListedToursByTourID(id);
		
		if (listedTours.size()>0){
			ListedTour listedTour = listedTours.get(0);
			Date listedTo = new Date();
			listedTour.setListedTo(listedTo);
			listedTourDao.saveListedTour(listedTour);
		}
		
		Tour tour = tourDao.getTourByID(id);
		tourDao.dropTour(tour);
	}

	public Tour getTourByID(int id) {
		return tourDao.getTourByID(id);
	}

	public void updateTour(Tour tour) {
		Tour dbTour = tourDao.getTourByID(tour.getTourID());
		
		tour.setActivities(dbTour.getActivities());
		tour.setLocations(dbTour.getLocations());
		
		tourDao.saveTour(tour);
	}

	@SuppressWarnings("deprecation")
	public void addTour(Tour tour) {
		tourDao.addTour(tour);
		
		ListedTour listedTour = new ListedTour();
		listedTour.setListedFrom(new Date());
		listedTour.setTour(tour);
		listedTour.setTourID(tour.getTourID());
		listedTour.setOperator(tour.getOperator());
		
		//THIS SHOULD BE NULL IDEALLY
		listedTour.setListedTo(new Date(2030, 1, 1, 1, 1, 1));
		//listedTour.setListedTo(null);
		listedTourDao.saveListedTour(listedTour);
	}

	public List<Tour> getToursByOperatorID(int operatorID) {
		return tourDao.getTourListByOperatorID(operatorID);
	}

	public List<Location> getLocationList() {
		return locationDao.getLocationList();
	}

	public List<Activity> getActivityList() {
		return activityDao.getActivityList();
	}

	public AlignTour getAlignTourByID(String tourID) {
		int id = Integer.parseInt(tourID);
		Tour tour = tourDao.getTourByID(id);

		CurrentUser currentUser = new CurrentUser();
		TourOperator tourOperator = tourOperatorDao
				.getTourOperatorByID(currentUser.getCurrentUserID());

		if (tour.getOperator().equals(tourOperator))
			return null;

		AlignTour alignTour = new AlignTour();
		alignTour.setTourID(id);
		alignTour.setTotalDays(tour.getTotalDays());

		List<Integer> locs = new ArrayList<Integer>();
		for (Location location : tour.getLocations()) {
			locs.add(location.getLocationID());
		}
		alignTour.setLocationID(locs);

		List<Integer> activities = new ArrayList<Integer>();
		for (Activity activity : tour.getActivities()) {
			activities.add(activity.getActivityID());
		}
		alignTour.setActivityID(activities);

		return alignTour;
	}

	public Tour getTourByID(String id) {
		return tourDao.getTourByID(Integer.parseInt(id));
	}

	public void alignTour(AlignTour alignTour) throws ParseException {

		CurrentUser currentUser = new CurrentUser();

		Tour tour = tourDao.getTourByID(alignTour.getTourID());

		TourOperator tourOperator = tourOperatorDao
				.getTourOperatorByID(currentUser.getCurrentUserID());

		if (tour.getOperator().getOperatorID() != tourOperator.getOperatorID())
			return;

		if (alignTour.getLocationID() != null) {
			// LOCATIONS
			List<Integer> locationIds = alignTour.getLocationID();
			// Remove locations, that not selected
			Object[] tourLocations = tour.getLocations().toArray();
			List<Integer> tourLocationIds = new ArrayList<Integer>();
			for (Object obj : tourLocations) {
				Location location = (Location) obj;
				Integer locationId = location.getLocationID();
				tourLocationIds.add(locationId);
				if (!locationIds.contains(locationId)) {
					tour.getLocations().remove(location);
				}
			}
			// Add new locations
			for (Integer locationId : locationIds) {
				if (!tourLocationIds.contains(locationId)) {
					// Tour doesn't have location, add one
					Location newLocation = locationDao
							.getLocationByID(locationId);
					tour.getLocations().add(newLocation);
				}
			}
		}

		if (alignTour.getActivityID() != null) {
			// ACTIVITIES
			List<Integer> activityIds = alignTour.getActivityID();
			// Remove activities, that not selected
			Object[] tourActivities = tour.getActivities().toArray();
			List<Integer> tourActivityIds = new ArrayList<Integer>();
			for (Object obj : tourActivities) {
				Activity activity = (Activity) obj;
				Integer activityId = activity.getActivityID();
				tourActivityIds.add(activityId);
				if (!activityIds.contains(activityId)) {
					tour.getActivities().remove(activity);
				}
			}
			// Add new activities
			for (Integer activityId : activityIds) {
				if (!tourActivityIds.contains(activityId)) {
					// Tour doesn't have activity, add one
					Activity newActivity = activityDao
							.getActivityByID(activityId);
					tour.getActivities().add(newActivity);
				}
			}
		}

		tourDao.saveTour(tour);
	}

	@Override
	public void alignTourDate(AlignTourDate alignTourDate) {
		Tour tour = tourDao.getTourByID(alignTourDate.getTourID());

		TourDate tourDate = new TourDate();
		tourDate.setTour(tour);
		tourDate.setStartDate(alignTourDate.getStartDate());
		tourDate.setFinishDate(alignTourDate.getFinishDate());
		tourDate.setTourID(tour.getTourID());

		tourDateDao.saveTourDate(tourDate);
	}

	@Override
	public AlignTourDate getAlignTourDateByID(String tourID) {
		int id = Integer.parseInt(tourID);

		AlignTourDate atd = new AlignTourDate();
		atd.setTourID(id);
		return atd;
	}

	@Override
	public void deleteTourDate(String dateID) {
		int id = Integer.parseInt(dateID);
		
		TourDate tourDate = tourDateDao.getTourDateByID(id);
		tourDateDao.dropTourDate(tourDate);
	}

}
