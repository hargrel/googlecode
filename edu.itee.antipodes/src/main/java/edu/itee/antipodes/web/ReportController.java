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

package edu.itee.antipodes.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ReportController extends MultiActionController {
	
	public ModelAndView handleBillingTourOperators(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);

		Map model = new HashMap();
		model.put("format", format);
		model.put("ReportTitle", "Billing tour operators report");
		model.put("CustomerName", "Hilsbrat hotel company association inc.(R)");
		model.put("ReportPeriod", "July 2009 - August 2009");
		
		List list = new ArrayList();
		ReportUniBean bean;

		bean = new ReportUniBean();
		bean.setS1("July 2009");
		bean.setS2("Tour 1");
		bean.setI1(1);
		bean.setI2(20);
		list.add(bean);
		
		bean = new ReportUniBean();
		bean.setS1("July 2009");
		bean.setS2("Tour 2");
		bean.setI1(2);
		bean.setI2(30);
		list.add(bean);
		
		bean = new ReportUniBean();
		bean.setS1("August 2009");
		bean.setS2("Tour 3");
		bean.setI1(3);
		bean.setI2(20);
		list.add(bean);
		
		model.put("dataSource", list);
		return new ModelAndView("reportBillingTourOperators", model);
	}
	
	public ModelAndView handleMonitoringSystemUtilisation(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);

		Map model = new HashMap();
		model.put("format", format);

		return new ModelAndView("reportMonitoringSystemUtilisation", model);
	}
	
	public ModelAndView handleMonitoringSearchCriteriaUtilisation(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);

		Map model = new HashMap();
		model.put("format", format);
		model.put("ReportTitle", "Monitoring search criteria utilisation report");

		List list = new ArrayList();
		ReportUniBean bean;
		
		bean = new ReportUniBean();
		bean.setI1(243);
		bean.setS1("Extreme");
		bean.setI2(13);
		list.add(bean);
		
		bean = new ReportUniBean();
		bean.setI1(788);
		bean.setS1("Snow");
		bean.setI2(44);
		list.add(bean);
		
		bean = new ReportUniBean();
		bean.setI1(141);
		bean.setS1("Beach");
		bean.setI2(7);
		list.add(bean);
		
		bean = new ReportUniBean();
		bean.setI1(651);
		bean.setS1("Famous");
		bean.setI2(58);
		list.add(bean);
		
		model.put("dataSource", list);
		
		return new ModelAndView("reportMonitoringSearchCriteriaUtilisation", model);
	}
	
	public ModelAndView handleDetectingAbuse(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);

		Map model = new HashMap();
		model.put("ReportTitle", "Detecting abuse report");
		model.put("format", format);
		
		List list = new ArrayList();
		for (int i = 0; i < 10; i++){
			ReportUniBean bean = new ReportUniBean();
			bean.setI1(i);
			bean.setS1("Tour " +  (int)(Math.random() * 100));
			bean.setI2((int)(20*Math.random()));
			list.add(bean);
		}
		
		model.put("dataSource", list);

		return new ModelAndView("reportDetectingAbuse", model);
	}
	
	
	
	public class ReportUniBean {

		private int i1;
		private int i2;
		private int i3;
		private int i4;
		private int i5;
		
		private String s1;
		private String s2;
		private String s3;
		private String s4;
		private String s5;
		
		public int getI1() {
			return i1;
		}
		public void setI1(int i1) {
			this.i1 = i1;
		}
		public int getI2() {
			return i2;
		}
		public void setI2(int i2) {
			this.i2 = i2;
		}
		public int getI3() {
			return i3;
		}
		public void setI3(int i3) {
			this.i3 = i3;
		}
		public int getI4() {
			return i4;
		}
		public void setI4(int i4) {
			this.i4 = i4;
		}
		public int getI5() {
			return i5;
		}
		public void setI5(int i5) {
			this.i5 = i5;
		}
		public String getS1() {
			return s1;
		}
		public void setS1(String s1) {
			this.s1 = s1;
		}
		public String getS2() {
			return s2;
		}
		public void setS2(String s2) {
			this.s2 = s2;
		}
		public String getS3() {
			return s3;
		}
		public void setS3(String s3) {
			this.s3 = s3;
		}
		public String getS4() {
			return s4;
		}
		public void setS4(String s4) {
			this.s4 = s4;
		}
		public String getS5() {
			return s5;
		}
		public void setS5(String s5) {
			this.s5 = s5;
		}
		
		
		
	}
	
	
	
}