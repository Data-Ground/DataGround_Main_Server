package com.ktds.wifi.service;

import java.util.List;

import com.ktds.wifi.vo.WifiVO;

public interface WifiService {

	public boolean createWifiVO(WifiVO wifiVO);
	
	public boolean modifyWifiVO();
	
	public boolean removeWifiVO(String district);
	
	public List<WifiVO> readWifiVOList();
	
}
