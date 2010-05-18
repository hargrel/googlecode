package edu.itee.antipodes.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.itee.antipodes.domain.db.MonthlyFee;

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
	public void dropMonthlyFeeByID(int monthlyFeeID) {
		Object record = getHibernateTemplate().load(MonthlyFee.class, monthlyFeeID);
        getHibernateTemplate().delete(record);
    }
	
	/*
	 * @return a list of tuples as Object[], where
	 * Object[0]=listID
	 * Object[1]=tourID
	 * Object[2]=operatorID
	 * Object[3]=listedFrom
	 * Object[4]=listedTo
	 * Object[5]= total monthly fee for the listed tour
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getTotalMonthlyFeeForAllListedTours() {

		List<Object[]> list = new ArrayList<Object[]>();
		
		String select="select  l.listID, l.tourID, l.operator.operatorID, l.listedFrom, l.listedTo, SUM(m.fee) ";
		String from="from ListedTour as l, MonthlyFee as m ";
		
		// l.listedFrom-30 since we want to include the previous month, ex. for 12/05/2010, we want to charge 05/2010's fee as well
		String where="where m.monthYearStart between (l.listedFrom-30) and l.listedTo   ";		
		String sql = select+ from+ where+"group by  l.listID, l.tourID, l.operator.operatorID, l.listedFrom, l.listedTo "+"order by l.listID ASC";
		
		// --------------------- START: original version ------------------------------------------------------------
		Query query = getSession().createQuery(sql);		
		int i=0;
		for (Iterator it = query.iterate(); it.hasNext(); i++ ) {
			list.add((Object[]) it.next());
		}
		return list;
		// --------------------- END: original version ------------------------------------------------------------
		
//		list = (List<Object[]>)getHibernateTemplate().find(sql);
//		return list;
	}
	
	/*
	 * @return a list of tuples as Object[], where
	 * Object[0]=listID
	 * Object[1]=monthYearStart, i.e. the date that represents a month-year
	 * Object[2]=monthly fee for the month
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getMonthlyFeeForListedTour(int id) {
		
		List<Object[]> list = new ArrayList<Object[]>();
		
		String select="select l.listID, m.monthYearStart, m.fee, m.feeID ";
		String from="from ListedTour as l, MonthlyFee as m ";
		
		// l.listedFrom-30 since we want to include the previous month, ex. for 12/05/2010, we want to charge 05/2010's fee as well
		String where="where l.listID=:listID and m.monthYearStart between (l.listedFrom-30) and l.listedTo   ";		
		String sql= select+ from+ where;
		
		// --------------------- START: original version ------------------------------------------------------------
		if ((Integer)id != null){
			Query query= getSession().createQuery(sql);		
			query.setParameter("listID", id);
			int i=0;
			for (Iterator it = query.iterate(); it.hasNext(); i++ ) {
				list.add((Object[]) it.next());
			}
		}
		return list;
		// --------------------- END: original version ------------------------------------------------------------

//		if (id == 0) return null;
//		list = (List<Object[]>)getHibernateTemplate().findByNamedParam(sql, "listID", id);
//		return list;
	}
}

