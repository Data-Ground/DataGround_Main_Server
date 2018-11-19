package com.ktds.common.exception.handler;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	public void sendLog(Exception e, HttpServletRequest request) {
		String msg = "Ħ" + e.getClass().getName() + "Ħ" + e.getMessage() + "Ħ" + request.getRequestURI() + "Ħ" + request.getRemoteAddr();
		System.out.println(msg);
		logger.error(msg);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandlerFoundExceptionHandler(NoHandlerFoundException e, HttpServletRequest request) {
		this.sendLog(e, request);
		return "error/404";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeExceptionHandler(RuntimeException e, HttpServletRequest request) throws UnsupportedEncodingException {
		e.printStackTrace();
		this.sendLog(e, request);
		return "error/500";
	}
}
