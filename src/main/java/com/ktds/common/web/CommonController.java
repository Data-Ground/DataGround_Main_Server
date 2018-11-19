package com.ktds.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ktds.common.AES128Util;

@Controller
public class CommonController {
	
	@RequestMapping("/main")
	public String viewMainPage() throws Exception {
		return "main";
	}
	
}
