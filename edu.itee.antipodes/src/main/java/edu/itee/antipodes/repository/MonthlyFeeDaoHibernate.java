package edu.itee.antipodes.repository;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.itee.antipodes.domain.MonthlyFee;

public class MonthlyFeeDaoHibernate extends HibernateDaoSupport implements MonthlyFeeDao {

	@SuppressWarnings("unchecked")
	public List<MonthlyFee> getMonthlyFeeList() {
		return getHibernateTemplate().find("from MonthlyFee");
	}
	
	public MonthlyFee getMonthlyFeeByID(int id){
		return (MonthlyFee)getHibernateTemplate().get(MonthlyFee.class, id);
	}
	
	public void saveMonthlyFee(MonthlyFee monthlyFee) {
		getHibernateTemplate().saveOrUpdate(monthlyFee);	
	}					

	public void dropMonthlyFee(MonthlyFee monthlyFee) {
		Object record = getHibernateTemplate().load(MonthlyFee.class, monthlyFee.getFeeID());
        getHibernateTemplate().delete(record);
    }

}

