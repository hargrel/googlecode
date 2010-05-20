package edu.itee.antipodes.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.itee.antipodes.domain.db.AccountUser;
import edu.itee.antipodes.domain.db.Image;
import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.repository.AccountUserDaoHibernate;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.repository.ListedTourDao;
import edu.itee.antipodes.repository.TourDao;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.utils.SpringApplicationContext;

@SuppressWarnings("serial")
public class SimpleAccountManager implements IAccountManager {

	private SimpleAccountManager() {
	}

	PasswordHash pHash = new PasswordHash();

	@Autowired
	private AccountUserDaoHibernate accountDao;
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private TourDao tourDao;
	@Autowired
	private ListedTourDao listedTourDao;
	@Autowired
	private TourOperatorDao tourOperatorDao;

	public void addAccount(AccountUser account) throws Exception {
		account.setPassword(pHash.Hash(account.getPassword()));
		accountDao.addAccountUser(account);
	}

	public void dropAccountByID(int id) {
		if (getAccountByID(id).getUserType().equalsIgnoreCase("operator")) {
			List<ListedTour> listedTours = listedTourDao
					.getListedToursByOpID(id);
			List<Tour> tourList = tourDao.getTourListByOperatorID(id);
			
			Object[] ltit = null;
			if (listedTours != null) {
				ltit = listedTours.toArray();
			}

			Object[] tourIt = null;
			if (tourList != null) {
				tourIt = tourList.toArray();
			}
			
			if (ltit != null) {
				for (Object obj : ltit) {
					ListedTour listedTour = (ListedTour) obj;
					listedTourDao.dropListedTour(listedTour);
				}
			}

			if (tourIt != null) {
				for (Object obj : tourIt) {
					Tour tour = (Tour) obj;

					List<Image> imgList = imageDao.getImageByTourID(tour
							.getTourID());

					for (Object objImage : imgList) {
						Image img = (Image) objImage;
						imageDao.dropImage(img);
					}

					tourDao.dropTour(tour);
				}
			}
			
			tourOperatorDao.dropTourOperatorByID(id);
		}
		accountDao.dropAccountUserByID(id);
	}

	public AccountUser getAccountByID(int id) {
		return accountDao.getAccountUserByID(id);
	}

	public List<AccountUser> getAccounts() {
		return accountDao.getAccountUserList();
	}

	public void updateAccount(AccountUser account) throws Exception {
		account.setPassword(pHash.Hash(account.getPassword()));
		accountDao.saveAccountUser(account);
	}

	public void setAccountDao(AccountUserDaoHibernate accountDao) {
		this.accountDao = accountDao;
	}

	public AccountUser getAccountByUsername(String userName) {
		return accountDao.getAccountUserByUsername(userName);
	}

	@Override
	public AccountUser getAccountByEmail(String email) {
		return accountDao.getAccountUserByEmail(email);
	}
}
