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
import edu.itee.antipodes.utils.SpringApplicationContext;

@SuppressWarnings("serial")
public class SimpleAccountManager implements IAccountManager {
	
	private SimpleAccountManager(){	}

	PasswordHash pHash = new PasswordHash();
	
	@Autowired
	private AccountUserDaoHibernate accountDao;

	public void addAccount(AccountUser account) throws Exception {
		account.setPassword(pHash.Hash(account.getPassword()));
		accountDao.addAccountUser(account);
	}
	public void dropAccountByID(int id) {
		
		if(getAccountByID(id).getUserType().equalsIgnoreCase("operator")){

			ListedTourDao ltd = SpringApplicationContext.getListedTourDao();
			Iterator<ListedTour> ltit = ltd.getListedToursByOpID(id).iterator();

			TourDao td = SpringApplicationContext.getTourDao();
			Iterator<Tour> tourIt = td.getTourListByOperatorID(id).iterator();

			ImageDao imagedao = SpringApplicationContext.getImageDao();
			
			while(ltit.hasNext()){
				ltd.dropListedTour(ltit.next());
				System.out.println("+++ 01");
			}
			while(tourIt.hasNext()){
				System.out.println("+++ 02");
				Tour tour = tourIt.next();
				List<Image> imgList = imagedao.getImageByTourID(tour.getTourID());
				Iterator<Image> imgIt = imgList.iterator();
				while(imgIt.hasNext()){
					System.out.println("+++ 03");
					imagedao.dropImage(imgIt.next());
				}
				
				td.dropTour(tour);
			}
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
