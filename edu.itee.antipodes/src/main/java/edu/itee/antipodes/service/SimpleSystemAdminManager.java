package edu.itee.antipodes.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.domain.pages.ContactOperator;
import edu.itee.antipodes.repository.AccountUserDao;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.utils.SpringApplicationContext;

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

	private MailSender mailSender;
	private SimpleMailMessage templateMessage;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	@Override
	public void regeneratePassword(String email) throws Exception {
		SecureRandom random = new SecureRandom();
	    String newPassword = new BigInteger(130, random).toString(16);
	    
	    
	    AccountUser accUser = accountUserManager.getAccountByEmail(email);
	    accUser.setPassword(newPassword);
	    
	    accountUserManager.updateAccount(accUser);
	    
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		TourOperator operator = tourOperatorDao.getTourOperatorByID(accUser.getUserID());

		msg.setTo(email);
		msg.setSubject("Antipodes - Password Regeneration");
		msg.setText("Dear " + operator.getOperatorName() + ",\n"
				+ "Your new password is: "
				+ newPassword);

		try {
			this.mailSender.send(msg);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
		
	}

}
