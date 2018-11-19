package com.ktds.wifi.parkinglot.dao;

import java.util.List;

import com.ktds.wifi.parkinglot.vo.ParkinglotVO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface ParkinglotDao {

	public ParkinglotVO insertParkinglotVO(ParkinglotVO parkinglotVO);
	
	public UpdateResult updateParkinglotVO(ParkinglotVO parkinglotVO);
	
	public DeleteResult deleteParkinglotVO(String location);
	
	public List<ParkinglotVO> selectParkinglotVOList();
}
