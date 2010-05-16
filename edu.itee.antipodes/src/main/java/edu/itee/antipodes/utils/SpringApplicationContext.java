package edu.itee.antipodes.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import edu.itee.antipodes.repository.AccountUserDaoHibernate;
import edu.itee.antipodes.repository.ActivityDao;
import edu.itee.antipodes.repository.ActivityDaoHibernate;
import edu.itee.antipodes.repository.CustomerSearchDaoHibernate;
import edu.itee.antipodes.repository.ImageDao;
import edu.itee.antipodes.repository.ImageDaoHibernate;
import edu.itee.antipodes.repository.ListedTourDaoHibernate;
import edu.itee.antipodes.repository.LocationDao;
import edu.itee.antipodes.repository.LocationDaoHibernate;
import edu.itee.antipodes.repository.MonthlyFeeDaoHibernate;
import edu.itee.antipodes.repository.ReportingDaoHibernate;
import edu.itee.antipodes.repository.TourDaoHibernate;
import edu.itee.antipodes.repository.TourOperatorDaoHibernate;
import edu.itee.antipodes.service.IAccountManager;

/**
 * Wrapper to always return a reference to the Spring Application Context from
 * within non-Spring enabled beans. Unlike Spring MVC's
 * WebApplicationContextUtils we do not need a reference to the Servlet context
 * for this. All we need is for this bean to be initialized during application
 * startup.
 */
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext CONTEXT;

	/**
	 * This method is called from within the ApplicationContext once it is done
	 * starting up, it will stick a reference to itself into this bean.
	 * 
	 * @param context
	 *            a reference to the ApplicationContext.
	 */
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		CONTEXT = context;
	}

	/**
	 * This is about the same as context.getBean("beanName"), except it has its
	 * own static handle to the Spring context, so calling this method
	 * statically will give access to the beans by name in the Spring
	 * application context. As in the context.getBean("beanName") call, the
	 * caller must cast to the appropriate target class. If the bean does not
	 * exist, then a Runtime error will be thrown.
	 * 
	 * @param beanName
	 *            the name of the bean to get.
	 * @return an Object reference to the named bean.
	 */
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);
	}

	public static ApplicationContext getApplicationContext() {
		return CONTEXT;
	}
	
	
	
	
	public static IAccountManager getAccountManager() {
		return (IAccountManager) SpringApplicationContext
				.getBean("accountUserManager");
	}
	
	
	
	
	/*
	 * Manual loading of Dao beans, you shouldn't be using them, use autowired
	 * instead
	 */

	public static TourOperatorDaoHibernate getTourOperatorDao() {
		return (TourOperatorDaoHibernate) CONTEXT.getBean("tourOperatorDao");
	}

	public static ListedTourDaoHibernate getListedTourDao() {
		return (ListedTourDaoHibernate) CONTEXT.getBean("listedTourDao");
	}

	public static TourDaoHibernate getTourDao() {
		return (TourDaoHibernate) CONTEXT.getBean("tourDao");
	}

	public static CustomerSearchDaoHibernate getTourSearchDao() {
		return (CustomerSearchDaoHibernate) CONTEXT
				.getBean("customerSearchDao");
	}

	public static LocationDao getLocationDao() {
		return (LocationDaoHibernate) CONTEXT.getBean("locationDao");
	}

	public static ActivityDaoHibernate getActivityDao() {
		return (ActivityDaoHibernate) CONTEXT.getBean("activityDao");
	}

	public static ReportingDaoHibernate getReporingDao() {
		return (ReportingDaoHibernate) CONTEXT.getBean("reportDao");
	}

	public static AccountUserDaoHibernate getAccountUserDao() {
		return (AccountUserDaoHibernate) CONTEXT.getBean("accountUserDao");
	}

	public static ImageDaoHibernate getImageDao() {
		return (ImageDaoHibernate) CONTEXT.getBean("imageDao");
	}

	public static MonthlyFeeDaoHibernate getMonthlyFeeDao() {
		return (MonthlyFeeDaoHibernate) CONTEXT.getBean("monthlyFeeDao");
	}

}
