package edu.itee.antipodes.service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.ParseException;
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
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.domain.pages.AlignTour;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.repository.ListedTourDao;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.TourDao;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;

@SuppressWarnings("serial")
public class SimpleTourOperatorManager implements ITourOperatorManager {

	private SimpleTourOperatorManager(){}
	
	@Autowired
	private ImageDao imd;// = DaoManager.getImageDao();
	@Autowired TourDao tourDao;// = DaoManager.getTourDao();
	@Autowired
	private TourOperatorDaoHibernate operatorDao;// = DaoManager.getTourOperatorDao();
	@Autowired LocationDao locationDao;
	@Autowired ActivityDao activityDao;
	@Autowired
	private ListedTourDao listedTourDao;
	@Autowired
	private TourOperatorDao tourOperatorDao;

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
			File dir = applicationContext.getResource("/uploads/images/").getFile();
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
		tourDao.dropTour(tourDao.getTourByID(id));
	}

	public Tour getTourByID(int id) {
		return tourDao.getTourByID(id);
	}

	public void updateTour(Tour tour) {
		tourDao.saveTour(tour);
	}

	public void addTour(Tour tour) {
		tourDao.addTour(tour);
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
		AlignTour alignTour = new AlignTour();
		alignTour.setTourID(Integer.parseInt(tourID));
		return alignTour;
	}

	
	public Tour getTourByID(String id) {
		return tourDao.getTourByID(Integer.parseInt(id));
	}

	
	public void alignTour(String startDateString, String finishDateString,
			AlignTour alignTour) throws ParseException {

		Date startDate = UtilityManager.stringToDate(startDateString);
		Date finishDate = UtilityManager.stringToDate(startDateString);

		CurrentUser currentUser = new CurrentUser();
		ListedTour listedTour = new ListedTour();

		listedTour.setTour(tourDao.getTourByID(alignTour.getTourID()));
		listedTour
				.setTourID(tourDao.getTourByID(alignTour.getTourID()).getTourID());
		listedTour.setOperator(tourOperatorDao.getTourOperatorByID(currentUser
				.getCurrentUserID()));
		if (startDate.getYear() == 0 || finishDate.getYear() == 0) {
			tourDao.getTourByID(alignTour.getTourID()).setTotalDays(
					alignTour.getTotalDays());
		}

		listedTour.setListedFrom(startDate);
		listedTour.setListedTo(finishDate);

		listedTourDao.addListedTour(listedTour);
	}

}
