package com.ktds.publicdata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicDataController {

	
	@GetMapping("/publicData")
	public String publicDataPage() {
		return "publicData/publicData";
	}
}
