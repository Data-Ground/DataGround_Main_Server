package com.ktds.traffic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrafficController {

	@GetMapping("/traffic")
	public String viewTrafficPage() {
		return "/traffic/traffic";
	}
}
