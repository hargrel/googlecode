package edu.itee.antipodes.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.TourOperatorDao;

public class SimpleSystemAdminManager implements ISystemAdminManager {

	private SimpleSystemAdminManager(){}
	
	@Autowired
	private LocationDao ld;
	@Autowired
	private ActivityDao ad;
	@Autowired
	private IAccountManager accountUserManager;
	@Autowired
	private TourOperatorDao tourOperatorDao;
	
	@Override
	public void removeLocationByID(String locationID) {
		int id = Integer.parseInt(locationID);
		//LocationDao ld = DaoManager.getLocationDao();
		ld.dropLocationByID(id);
	}

	@Override
	public Location getLocationByID(String locationID) {
		int id = Integer.parseInt(locationID);
		//LocationDao ld = DaoManager.getLocationDao();
		return ld.getLocationByID(id);
	}

	@Override
	public void saveLocation(Location location) {
		//LocationDao ld = DaoManager.getLocationDao();
		ld.saveLocation(location);
	}

	@Override
	public List<Location> getLocationList() {
		//LocationDao ld = DaoManager.getLocationDao();
		return ld.getLocationList();
	}

	@Override
	public List<Activity> getActivityList() {
		//ActivityDao ad = DaoManager.getActivityDao();
		return ad.getActivityList();
	}

	@Override
	public Activity getActivityByID(String activityID) {
		int id = Integer.parseInt(activityID);
		//ActivityDao ad = DaoManager.getActivityDao();
		return ad.getActivityByID(id);
	}

	@Override
	public void saveActivity(Activity activity) {
		//ActivityDao ad = DaoManager.getActivityDao();
		ad.saveActivity(activity);
	}

	@Override
	public void removeActivityByID(String activityID) {
		int id = Integer.parseInt(activityID);
		//ActivityDao ad = DaoManager.getActivityDao();
		ad.dropActivityByID(id);
	}

	@Override
	public void addAccount(AccountUser accountUser, String membershipExpiry) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Date membershipExpiryDate = df.parse(membershipExpiry);

		accountUserManager.addAccount(accountUser);
		if(accountUser.getUserType().equalsIgnoreCase("operator")){
			TourOperator operator = new TourOperator();
			operator.setOperatorID(accountUser.getUserID());
			operator.setAccountUser(accountUser);
			operator.setMembershipExpired(membershipExpiryDate);
			tourOperatorDao.addTourOperator(operator);
		}
		
	}

}
