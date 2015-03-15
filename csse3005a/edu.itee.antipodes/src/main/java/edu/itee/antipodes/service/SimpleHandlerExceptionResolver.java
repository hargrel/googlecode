package edu.itee.antipodes.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class SimpleHandlerExceptionResolver extends SimpleMappingExceptionResolver  {

	private Log log = LogFactory.getLog(SimpleHandlerExceptionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		log.warn("An Exception has occured in the application", ex);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("errorheader", "Warning");
		model.put("errormessage", "The system is currently not available, please try again later");
		//model.put("errordetails", ex.toString());
				
		return new ModelAndView("error",model);
	}



}
