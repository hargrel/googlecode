package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.db.MonthlyFee;

public interface MonthlyFeeDao {

	public List<MonthlyFee> getMonthlyFeeList();
	
	public MonthlyFee getMonthlyFeeByID(int id);
	
	public void saveMonthlyFee(MonthlyFee monthlyFee);
	
	public void dropMonthlyFee(MonthlyFee monthlyFee);		
	
	public List<Object[]> getTotalMonthlyFeeForAllListedTours();
	
	public List<Object[]> getMonthlyFeeForListedTour(int id);
}

