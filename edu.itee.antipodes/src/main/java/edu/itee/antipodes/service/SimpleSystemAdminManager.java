package edu.itee.antipodes.service;

import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.LocationDao;

public class SimpleSystemAdminManager implements SystemAdminManager {

	@Override
	public void removeLocationByID(String locationID) {
		// TODO Auto-generated method stub
		LocationDao ld = DaoManager.getLocationDao();
		ld.removeLocationByID(locationID);
	}

}
