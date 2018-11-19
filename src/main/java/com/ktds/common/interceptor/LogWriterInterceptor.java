package com.ktds.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.common.AES128Util;

public class LogWriterInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AES128Util aes128Util;
	
	private Logger logger = LoggerFactory.getLogger(LogWriterInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String ip = request.getRemoteAddr();
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		String msg = "Ħ" + ip + "Ħ" + uri + "Ħ" + method;
		String encMsg = this.aes128Util.encrypt(msg);
	
		logger.info(encMsg);
		
		return true;
	}
	
}
