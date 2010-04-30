package edu.itee.antipodes.repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoManager {
	private static String[] paths = {"edu/itee/antipodes/repository/hibernate-cfg.xml"};
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);

	public static TourOperatorDao getTourOperatorDao() {
        return (TourOperatorDaoHibernate) ctx.getBean("tourOperatorDao");
	}
	
	public static LocationDao getLocationDao() {
		return (LocationDaoHibernate) ctx.getBean("locationDao");
	}
	
	public static ActivityDao getActivityDao() {
		return (ActivityDaoHibernate) ctx.getBean("activityDao");
	}
}
