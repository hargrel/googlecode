package edu.itee.antipodes.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import edu.itee.antipodes.domain.*;
import edu.itee.antipodes.domain.db.TourOperator;

public interface IReportingManager {

	public Map<String, Object> getBillingTourOperators(int tourOperatorID, Date startDate, Date endDate );
	public Map<String, Object> getMonitoringSystemUtilisation(Date startDate, Date endDate );
	public Map<String, Object> getMonitoringSearchCriteriaUtilisation(String criteria );
	public Map<String, Object> getDetectingAbuse(int numberOfCriterias);
	
	public List<UniversalBean> getCriterias();
	public List<TourOperator> getTourOperators();
}
