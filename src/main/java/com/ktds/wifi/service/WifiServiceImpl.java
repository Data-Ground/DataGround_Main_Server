package com.ktds.wifi.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.wifi.dao.WifiDao;
import com.ktds.wifi.readfile.ReadWifiFile;
import com.ktds.wifi.vo.WifiVO;

@Service
public class WifiServiceImpl implements WifiService {
	
	@Autowired
	private ReadWifiFile readWifiFile;
	
	@Autowired
	private WifiDao wifiDao;
	
	@Override
	public boolean createWifiVO(WifiVO wifiVO) {
		
		wifiVO.setWriteDate(new DateTime().now());
		return this.wifiDao.insertWifiVO(wifiVO) != null;
	}

	@Override
	public boolean modifyWifiVO() {
		
		List<WifiVO> wifiVOList = readWifiFile.getWifiList();
		
		boolean isUpdateSuccess = false;
		
		for (WifiVO wifiVO : wifiVOList) {
			wifiVO.setModifyDate(new DateTime().now());
			isUpdateSuccess = this.wifiDao.updateWifiVO(wifiVO).wasAcknowledged();
		}
		
		return isUpdateSuccess;
	}

	@Override
	public boolean removeWifiVO(String district) {
		return this.wifiDao.deleteWifiVO(district).getDeletedCount() > 0;
	}

	@Override
	public List<WifiVO> readWifiVOList() {
		return this.wifiDao.selectWifiVOList();
	}

}
