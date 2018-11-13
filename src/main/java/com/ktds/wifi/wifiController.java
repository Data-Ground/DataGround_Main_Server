package com.ktds.wifi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class wifiController {

	@RequestMapping("/wifi")
	public String viewWifiMapPage() {
		return "wifi/wifi";
	}
	
}
