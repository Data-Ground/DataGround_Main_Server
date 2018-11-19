package com.ktds.wifi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ktds.wifi.vo.WifiVO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class WifiDaoImpl implements WifiDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public WifiVO insertWifiVO(WifiVO wifiVO) {
		return this.mongoTemplate.insert(wifiVO, "seoulWifi");
	}

	@Override
	public UpdateResult updateWifiVO(WifiVO wifiVO) {
		Query query = new Query(new Criteria("location").is(wifiVO.getLocation()));
		
		Update update = new Update();
				
		update.set("address", wifiVO.getAddress());
		update.set("latitude", wifiVO.getLatitude());
		update.set("longitude", wifiVO.getLongitude());
		update.set("modifyDate", wifiVO.getModifyDate());
		
		return this.mongoTemplate.upsert(query, update, WifiVO.class, "seoulWifi");
	}

	@Override
	public DeleteResult deleteWifiVO(String district) {
		Query query = new Query(new Criteria("address").in(district));
		return this.mongoTemplate.remove(query, WifiVO.class, "seoulWifi");
	}

	@Override
	public List<WifiVO> selectWifiVOList() {
		return this.mongoTemplate.findAll(WifiVO.class, "seoulWifi");
	}

}
