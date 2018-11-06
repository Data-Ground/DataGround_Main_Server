package com.ktds.example.mongo.service;

import java.util.List;

import com.ktds.example.mongo.vo.MongoExampleVO;

public interface MongoExampleService {

	public boolean createMongoExampleVO(MongoExampleVO mongoExampleVO);
	
	public boolean modifyMongoExampleVO(MongoExampleVO mongoExampleVO);
	
	public boolean removeMongoExampleVO(String id);
	
	public List<MongoExampleVO> readMongoExampleVOList();
	
}
