package com.ktds.common.exception.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ktds.common.exception.PolicyViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandlerFoundExceptionHandler() {
		return "error/404";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeExceptionHandler(RuntimeException e) throws UnsupportedEncodingException {
		e.printStackTrace();
/*		if ( e instanceof PolicyViolationException ) {
			PolicyViolationException pve = (PolicyViolationException)e;
			return "redirect:" 
					+ pve.getRedirectUri() 
					+ "?message=" 
					+ URLEncoder.encode(pve.getMessage(), "UTF-8");
		}*/
		return "error/500";
	}
}