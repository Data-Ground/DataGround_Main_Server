package com.ktds.wifi.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.wifi.service.WifiService;
import com.ktds.wifi.vo.WifiVO;

@Controller
public class wifiController {
	
	@Autowired
	private WifiService wifiService;

	@GetMapping("/wifi")
	public String viewWifiMapPage() {
		return "wifi/wifi";
	}
	
	@PostMapping("/wifi")
	@ResponseBody
	public Map<String, Object> doSendMapPositionAction() {
				
		List<WifiVO> wifiVOList = wifiService.readWifiVOList();
		
		List<Map<String, Object>> lagLngList = new ArrayList<Map<String, Object>>();
		
		for (WifiVO wifiVO : wifiVOList) {
						
			Map<String, Object> lagLng = new HashMap<String, Object>();
			
			lagLng.put("lat", wifiVO.getLatitude());
			lagLng.put("lng", wifiVO.getLongitude());
			lagLng.put("location", wifiVO.getLocation());
			lagLng.put("address", wifiVO.getAddress());
			
			lagLngList.add(lagLng);
		}
		
		Map<String, Object> positions = new HashMap<String, Object>();
		
		positions.put("positions", lagLngList);
		
		
		return positions;
	}
	
	@RequestMapping("/wifi/update")
	public String doUpdateWifiMapAction() {
		wifiService.modifyWifiVO();
		
		return "redirect:/wifi";
	}
}
