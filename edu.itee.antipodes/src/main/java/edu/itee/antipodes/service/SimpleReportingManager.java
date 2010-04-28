package edu.itee.antipodes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.itee.antipodes.domain.UniversalBean;
import edu.itee.antipodes.domain.db.TourOperator;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;

public class SimpleReportingManager implements ReportingManager {

	private TourOperatorDaoHibernate toDao = DaoManager.getTourOperatorDao();
	@Override
	public Map<String, Object> getBillingTourOperators(int tourOperatorID,
			Date startDate, Date endDate) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<UniversalBean> list = new ArrayList<UniversalBean>();
		UniversalBean bean;

		bean = new UniversalBean();
		bean.setS1("July 2009");
		bean.setS2("Tour 1");
		bean.setI1(1);
		bean.setI2(20);
		list.add(bean);
		
		bean = new UniversalBean();
		bean.setS1("July 2009");
		bean.setS2("Tour 2");
		bean.setI1(2);
		bean.setI2(30);
		list.add(bean);
		
		bean = new UniversalBean();
		bean.setS1("August 2009");
		bean.setS2("Tour 3");
		bean.setI1(3);
		bean.setI2(20);
		list.add(bean);
		
		
		model.put("ReportTitle", "Billing tour operators report");
		model.put("ReportPeriod", "July 2009 - August 2009");
		model.put("CustomerName", getCustomerNameByID(1));
		model.put("dataSource", list);
		
		return model;
	}

	@Override
	public Map<String, Object> getDetectingAbuse(int numberOfCriterias) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ReportTitle", "Detecting abuse report");
		
		List<UniversalBean> list = new ArrayList<UniversalBean>();
		for (int i = 0; i < 10; i++){
			UniversalBean bean = new UniversalBean();
			bean.setI1(i);
			bean.setS1("Tour " +  (int)(Math.random() * 100));
			bean.setI2((int)(20*Math.random()));
			list.add(bean);
		}
		
		model.put("dataSource", list);
		return model;
	}

	@Override
	public Map<String, Object> getMonitoringSearchCriteriaUtilisation(String criteria) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		String prefix = "";
		String objectID = "";
		if (criteria.equals("all")){
			
		} else {
			prefix = criteria.substring(0, 1);
			objectID = criteria.substring(1);
		}
		
		model.put("ReportTitle", "Monitoring search criteria utilisation report " + prefix + " " + objectID);

		List<UniversalBean> list = new ArrayList<UniversalBean>();
		UniversalBean bean;
		
		bean = new UniversalBean();
		bean.setI1(243);
		bean.setS1("Extreme");
		bean.setI2(13);
		list.add(bean);
		
		bean = new UniversalBean();
		bean.setI1(788);
		bean.setS1("Snow");
		bean.setI2(44);
		list.add(bean);
		
		bean = new UniversalBean();
		bean.setI1(141);
		bean.setS1("Beach");
		bean.setI2(7);
		list.add(bean);
		
		bean = new UniversalBean();
		bean.setI1(651);
		bean.setS1("Famous");
		bean.setI2(58);
		list.add(bean);
		
		model.put("dataSource", list);
		return model;
	}

	@Override
	public Map<String, Object> getMonitoringSystemUtilisation(Date startDate,
			Date endDate) {
		Map<String, Object> model = new HashMap<String, Object>();
		return model;
	}

	private String getCustomerNameByID(int customerID) {
		return "Hilsbrat hotel company association inc.(R)";
	}

	@Override
	public List<UniversalBean> getCriterias() {
		List<UniversalBean> list = new ArrayList<UniversalBean>();
		
		UniversalBean ub;
		ub = new UniversalBean();
		ub.setS1("l1");
		ub.setS2("Location 1");
		list.add(ub);
		
		ub = new UniversalBean();
		ub.setS1("l2");
		ub.setS2("Location 2");
		list.add(ub);
		
		ub = new UniversalBean();
		ub.setS1("a1");
		ub.setS2("Activity 1");
		list.add(ub);
		
		ub = new UniversalBean();
		ub.setS1("a2");
		ub.setS2("Activity 2");
		list.add(ub);
		return list;
	}
	
	@Override
	public List<TourOperator> getTourOperators() {	
		return toDao.getTourOperatorList();
	}

}
