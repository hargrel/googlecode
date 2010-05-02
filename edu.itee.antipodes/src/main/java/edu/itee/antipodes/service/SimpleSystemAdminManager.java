package edu.itee.antipodes.service;

import java.util.List;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.repository.AccountUserDao;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.ActivityDaoHibernate;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.web.AccountsDao;

public class SimpleSystemAdminManager implements SystemAdminManager {

	@Override
	public void removeLocationByID(String locationID) {
		int id = Integer.parseInt(locationID);
		LocationDao ld = DaoManager.getLocationDao();
		ld.dropLocationByID(id);
	}

	@Override
	public Location getLocationByID(String locationID) {
		int id = Integer.parseInt(locationID);
		LocationDao ld = DaoManager.getLocationDao();
		return ld.getLocationByID(id);
	}

	@Override
	public void saveLocation(Location location) {
		LocationDao ld = DaoManager.getLocationDao();
		ld.saveLocation(location);
	}

	@Override
	public List<Location> getLocationList() {
		LocationDao ld = DaoManager.getLocationDao();
		return ld.getLocationList();
	}

	@Override
	public List<Activity> getActivityList() {
		ActivityDao ad = DaoManager.getActivityDao();
		return ad.getActivityList();
	}

	@Override
	public Activity getActivityByID(String activityID) {
		int id = Integer.parseInt(activityID);
		ActivityDao ad = DaoManager.getActivityDao();
		return ad.getActivityByID(id);
	}

	@Override
	public void saveActivity(Activity activity) {
		ActivityDao ad = DaoManager.getActivityDao();
		ad.saveActivity(activity);
	}

	@Override
	public void removeActivityByID(String activityID) {
		int id = Integer.parseInt(activityID);
		ActivityDao ad = DaoManager.getActivityDao();
		ad.dropActivityByID(id);
	}

	@Override
	public List<AccountUser> getAccountList() {
		AccountUserDao aud = DaoManager.getAccountUserDao();
		return aud.getAccountUserList();
	}

	@Override
	public AccountUser getAccountUserByID(String userID) {
		int id = Integer.parseInt(userID);
		AccountUserDao aud = DaoManager.getAccountUserDao();
		return aud.getAccountUserByID(id);
	}

	@Override
	public void saveAccountUser(AccountUser account) {
		AccountUserDao aud = DaoManager.getAccountUserDao();
		aud.saveAccountUser(account);
	}

}
