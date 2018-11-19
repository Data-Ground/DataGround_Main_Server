package com.ktds.common.interceptor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ip = request.getRemoteAddr();
		
		List<String> ipList = new ArrayList<>();
		
		ipList.add("0:0:0:0:0:0:0:1");
		ipList.add("192.168.123");
		
		for (String avalableIp : ipList) {
			if ( ip.startsWith(avalableIp) ) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/main");
		return false;
	}

}
