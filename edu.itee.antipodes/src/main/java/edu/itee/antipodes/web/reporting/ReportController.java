/*
 * Copyright 2002-2004 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.itee.antipodes.web.reporting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import edu.itee.antipodes.service.ReportingManager;
import edu.itee.antipodes.service.SimpleReportingManager;

public class ReportController extends MultiActionController {
	ReportingManager rp = new SimpleReportingManager();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public ModelAndView handleBillingTourOperators(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Date fromDate = df.parse(request.getParameter("fromDate")); 
		Date toDate	= df.parse(request.getParameter("toDate")); 
		int tourOperator = Integer.parseInt(request.getParameter("tourOperator")) ; 

		Map<String, Object> model = rp.getBillingTourOperators(tourOperator, fromDate, toDate);
		model.put("format", request.getParameter("fileType"));
		
		model.put("ReportTitle", " " + tourOperator + " " + fromDate.toString());
		
		return new ModelAndView("reportBillingTourOperators", model);
	}
	
	public ModelAndView handleMonitoringSystemUtilisation(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Date fromDate = df.parse(request.getParameter("fromDate")); 
		Date toDate	= df.parse(request.getParameter("toDate")); 
		
		Map<String, Object> model = rp.getMonitoringSystemUtilisation(fromDate, toDate);
		model.put("format", request.getParameter("fileType"));

		return new ModelAndView("reportMonitoringSystemUtilisation", model);
	}
	
	public ModelAndView handleMonitoringSearchCriteriaUtilisation(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> model = rp.getMonitoringSearchCriteriaUtilisation(request.getParameter("criteria"));
		model.put("format", request.getParameter("fileType"));
		
		return new ModelAndView("reportMonitoringSearchCriteriaUtilisation", model);
	}
	
	public ModelAndView handleDetectingAbuse(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> model = rp.getDetectingAbuse(123);
		setFormat(model, request);
		
		return new ModelAndView("reportDetectingAbuse", model);
	}
	
	private void setFormat(Map<String, Object> model, HttpServletRequest request){
		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);
		model.put("format", format);
	}
	
	
}