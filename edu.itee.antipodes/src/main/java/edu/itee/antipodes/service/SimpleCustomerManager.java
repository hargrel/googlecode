package edu.itee.antipodes.service;

import java.text.ParseException;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import edu.itee.antipodes.domain.db.ListedTour;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.domain.pages.ContactOperator;
import edu.itee.antipodes.repository.CustomerSearchDaoHibernate;
import edu.itee.antipodes.repository.ListedTourDao;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.utils.SpringApplicationContext;

@SuppressWarnings("serial")
public class SimpleCustomerManager implements ICustomerManager {

	@Autowired
	private ListedTourDao listedTourDao;// = DaoManager.getListedTourDao();
	@Autowired
	private TourOperatorDao tourOperatorDao;

	public void setListedTourDao(ListedTourDao listedTourDao) {
		this.listedTourDao = listedTourDao;
	}

	@Autowired
	private CustomerSearchDaoHibernate tourSearchDao;

	public ListedTour getListedTour(int id) {
		return listedTourDao.getListedTourByID(id);
	}

	public List<ListedTour> getListedTours() {
		return listedTourDao.getListedTourList();
	}

	public List<ListedTour> getListedToursByOpID(int id) {
		return listedTourDao.getListedToursByOpID(id);
	}
	
	public List<Object> searchListedTours(String activityNames,
			String locationNames, String startDate, String finishDate, String currency)
			throws DataAccessResourceFailureException, HibernateException,
			IllegalStateException, ParseException {
		
		SpringApplicationContext.getSessionHolder().setCurrency(currency);
		
		return tourSearchDao.findListedTours( activityNames, locationNames,
				startDate, finishDate);
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
	public void contactOperator(ContactOperator contactOperator) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		TourOperator operator = tourOperatorDao
				.getTourOperatorByID(contactOperator.getOperatorID());

		msg.setTo(operator.getEmail());
		msg.setReplyTo(contactOperator.getEmail());
		msg.setSubject("Antipodes - Message - " + contactOperator.getSubject());
		msg.setText("Dear " + operator.getAccountUser().getUserName() + ",\n\n"
				+ "You have been contacted by a customer, "
				+ contactOperator.getName() + ".\n\nMessage: \n"
				+ contactOperator.getText() + "\n\nPlease reply him at " 
				+ contactOperator.getEmail() + "\n\nAntipodes\nOnline Eco-adventure Tours Directory");

		try {
			this.mailSender.send(msg);
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public ContactOperator getContactOperator(String operatorID) {
		if (operatorID == null)
			return null;

		try {
			int id = Integer.parseInt(operatorID);
			ContactOperator contactOperator = new ContactOperator();
			contactOperator.setOperatorID(id);

			return contactOperator;
		} catch (NumberFormatException ex) {
			return null;
		}

	}

}
