package com.ktds.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String viewAdminPage() {
		return "admin/main";
	}
	
	@RequestMapping("/admin/test")
	public String viewTestPage() {
		
		Integer.parseInt("문자");
		
		return "admin/test";
	}
	
}
