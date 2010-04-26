package edu.itee.antipodes.repository;

import java.util.List;

import edu.itee.antipodes.domain.MonthlyFee;

public interface MonthlyFeeDao {

	public List<MonthlyFee> getMonthlyFeeList();
	
	public MonthlyFee getMonthlyFeeByID(int id);
	
	public void saveMonthlyFee(MonthlyFee monthlyFee);
	
	public void dropMonthlyFee(MonthlyFee monthlyFee);		
}

