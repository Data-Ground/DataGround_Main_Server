package com.ktds.wifi.dao;

import java.util.List;

import com.ktds.wifi.vo.WifiVO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface WifiDao {

	public WifiVO insertWifiVO(WifiVO wifiVO);
	
	public UpdateResult updateWifiVO(WifiVO wifiVO);
	
	public DeleteResult deleteWifiVO(String district);
	
	public List<WifiVO> selectWifiVOList();
	
}
