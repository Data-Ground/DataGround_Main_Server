package com.ktds.wifi.parkinglot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktds.wifi.parkinglot.vo.ParkinglotVO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ParkinglotDaoImpl implements ParkinglotDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public ParkinglotVO insertParkinglotVO(ParkinglotVO parkinglotVO) {
		return null;
	}

	@Override
	public UpdateResult updateParkinglotVO(ParkinglotVO parkinglotVO) {
		return null;
	}

	@Override
	public DeleteResult deleteParkinglotVO(String location) {
		return null;
	}

	@Override
	public List<ParkinglotVO> selectParkinglotVOList() {
		return null;
	}

}
