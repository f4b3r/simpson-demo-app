package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.domain.DataOperationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(DataOperationException.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="IOException occured")
	public String handleDatabaseException(HttpServletRequest request, Exception ex){
		logger.error("SQLException Occured:: URL="+request.getRequestURL());
		return "/error";
	}
}
