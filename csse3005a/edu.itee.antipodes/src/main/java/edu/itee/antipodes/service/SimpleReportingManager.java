package edu.itee.antipodes.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import edu.itee.antipodes.domain.UniversalBean;
import edu.itee.antipodes.domain.db.Activity;
import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.domain.db.Tour;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.ReportingDaoHibernate;
import edu.itee.antipodes.repository.TourOperatorDao;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;

public class SimpleReportingManager implements IReportingManager {

	private SimpleReportingManager() {
	}

	@Autowired
	private TourOperatorDaoHibernate toDao;
	@Autowired
	private TourOperatorDao to;
	@Autowired
	private LocationDao ld;
	@Autowired
	private ActivityDao ad;
	@Autowired
	private ReportingDaoHibernate rdh;

	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Object> getBillingTourOperators(int tourOperatorID,
			Date fromDate, Date toDate) {
		fromDate.setDate(1);
		Map<String, Object> model = new HashMap<String, Object>();

		List<UniversalBean> list = new ArrayList<UniversalBean>();
		UniversalBean bean;

		// TourOperatorDao to = DaoManager.getTourOperatorDao();
		// ReportingDaoHibernate rdh = DaoManager.getReporingDao();
		DateFormat df = new SimpleDateFormat("MMMMM yyyy");

		List<Object[]> temp = rdh.getListedToursPerMonthByOperatorID(
				tourOperatorID, fromDate, toDate);

		if (temp != null) {
			for (Object[] objects : temp) {
				Date d = (Date) objects[0];
				// Tour t = (Tour) objects[1];
				float f = (Float) objects[3];

				bean = new UniversalBean();
				bean.setS1(df.format(d));
				bean.setS2(objects[2].toString());
				bean.setI1((Integer) objects[1]);
				bean.setF1(f);
				list.add(bean);
			}
		}
		TourOperator operator = to.getTourOperatorByID(tourOperatorID);

		String datesRange = df.format(fromDate) + " - " + df.format(toDate);
		model.put("ReportPeriod", datesRange);
		model.put("CustomerName", operator.getOperatorName());
		model.put("dataSource", list);

		model.put("ReportTitle", "Billing report");

		return model;
	}

	// @Override
	public Map<String, Object> getDetectingAbuse(int numberOfCriterias) {
		UniversalBean ub;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ReportTitle", "Detecting abuse report");

		// ReportingDaoHibernate rdh = DaoManager.getReporingDao();

		//numberOfCriterias++;
		List<UniversalBean> list = new ArrayList<UniversalBean>();
		List<Object[]> tl = rdh
				.getSumOfActivitiesAndLocationsForToursByMinNum(numberOfCriterias);

		if (tl != null) {
			for (Object[] objects : tl) {
				ub = new UniversalBean();

				ub.setS1(objects[0].toString());
				ub.setS2(objects[1].toString());
				ub.setS3(objects[2].toString());
				list.add(ub);
			}
		}
		/*
		 * for (int i = 0; i < 10; i++) { ub = new UniversalBean();
		 * ub.setS1(String.format("{0}", i)); ub.setS2("Tour " + (int)
		 * (Math.random() * 100)); ub.setS3(" " + (int) (20 * Math.random()));
		 * list.add(ub); }
		 */
		model.put("dataSource", list);
		
		
		return model;
	}

	/*
	 * // @Override public Map<String, Object> getDetectingAbuse(int
	 * numberOfCriterias) { UniversalBean ub; Map<String, Object> model = new
	 * HashMap<String, Object>(); model.put("ReportTitle",
	 * "Detecting abuse report");
	 * 
	 * //ReportingDaoHibernate rdh = DaoManager.getReporingDao();
	 * 
	 * numberOfCriterias++; List<UniversalBean> list = new
	 * ArrayList<UniversalBean>(); List<Object[]> tl =
	 * rdh.getSumOfActivitiesAndLocationsForToursByMinNum(numberOfCriterias);
	 * 
	 * for (Object[] objects : tl) { ub = new UniversalBean(); Tour tour =
	 * (Tour) objects[0]; ub.setS1(tour.getTourID() + "");
	 * ub.setS2(tour.getTourName()); ub.setS3(objects[1].toString());
	 * list.add(ub); }
	 * 
	 * model.put("dataSource", list); return model; }
	 */

	// @Override
	public Map<String, Object> getMonitoringSearchCriteriaUtilisation(
			String criteria) {
		Map<String, Object> model = new HashMap<String, Object>();

		// ReportingDaoHibernate rdh = DaoManager.getReporingDao();
		List<Object[]> locationList = new ArrayList<Object[]>();
		List<Object[]> activityList = new ArrayList<Object[]>();
		String prefix = "";
		int objectID;
		if (criteria.equals("all")) {
			activityList = rdh.getNumToursAsscWithActivity();
			locationList = rdh.getNumToursAsscWithLocation();
		} else {
			prefix = criteria.substring(0, 1);
			objectID = Integer.parseInt(criteria.substring(1));

			if (prefix.equalsIgnoreCase("a")) {
				activityList = rdh
						.getNumToursAsscWithActivityByActivityID(objectID);
			} else if (prefix.equalsIgnoreCase("l")) {
				locationList = rdh
						.getNumToursAsscWithLocationByLocationID(objectID);
			}
		}

		model.put("ReportTitle",
				"Monitoring search criteria utilisation report ");

		List<UniversalBean> result = new ArrayList<UniversalBean>();
		UniversalBean bean;

		if (activityList != null) {
			for (Object[] objects : activityList) {
				bean = new UniversalBean();
				bean.setS1(objects[1].toString());
				bean.setS2(objects[2].toString());
				result.add(bean);
			}
		}

		if (locationList != null) {
			for (Object[] objects : locationList) {
				bean = new UniversalBean();
				bean.setS1(objects[1].toString());
				bean.setS2(objects[2].toString());
				result.add(bean);
			}
		}

		model.put("dataSource", result);
		return model;
	}

	// @Override
	@SuppressWarnings("deprecation")
	public Map<String, Object> getMonitoringSystemUtilisation(Date fromDate,
			Date toDate) {
		fromDate.setDate(1);

		Map<String, Object> model = new HashMap<String, Object>();

		List<UniversalBean> list = new ArrayList<UniversalBean>();
		UniversalBean bean;

		// ReportingDaoHibernate rdh = DaoManager.getReporingDao();
		DateFormat df = new SimpleDateFormat("MMMMM yyyy");

		List<Object[]> temp = rdh
				.getNumOfToursAndTotalPricePerMonthForAllTourOperator(fromDate,
						toDate);

		if (temp != null) {
			for (Object[] objects : temp) {
				Date d = (Date) objects[0];
				// TourOperator t = (TourOperator)objects[1];
				float f = (Float) objects[3];
				long countL = (Long) objects[4];
				int count = (int) countL;
				float cost = (Float) objects[5];

				bean = new UniversalBean();
				bean.setS1(df.format(d));
				bean.setS2(objects[2].toString());
				bean.setI1((Integer) objects[1]);
				bean.setI2(count);
				bean.setF1(cost);
				bean.setF2(f);
				list.add(bean);
			}
		}

		String datesRange = df.format(fromDate) + " - " + df.format(toDate);
		model.put("ReportPeriod", datesRange);
		model.put("dataSource", list);

		model.put("ReportTitle", "System Utilisation Report");

		return model;
	}

	// @Override
	public List<UniversalBean> getCriterias() {

		// LocationDao ld = DaoManager.getLocationDao();
		List<Location> ll = ld.getLocationList();

		// ActivityDao ad = DaoManager.getActivityDao();
		List<Activity> al = ad.getActivityList();

		List<UniversalBean> list = new ArrayList<UniversalBean>();
		UniversalBean ub;

		if (ll != null) {
			for (Location location : ll) {
				ub = new UniversalBean();
				ub.setS1("l" + location.getLocationID());
				ub.setS2(location.getLocationName());
				list.add(ub);
			}
		}

		if (al != null) {
			for (Activity activity : al) {
				ub = new UniversalBean();
				ub.setS1("a" + activity.getActivityID());
				ub.setS2(activity.getActivityName());
				list.add(ub);
			}
		}
		return list;
	}

	// @Override
	public List<TourOperator> getTourOperators() {
		return toDao.getTourOperatorList();
	}

}
