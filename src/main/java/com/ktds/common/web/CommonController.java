package com.ktds.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/main")
	public String viewMainPage() {
		return "main";
	}
	
}
