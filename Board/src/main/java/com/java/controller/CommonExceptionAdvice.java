package com.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	private static Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView coomon(Exception ex) {
		
		logger.info("exception....");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/error_common");
		mav.addObject("exception", ex);
		
		return mav;
	}
}
