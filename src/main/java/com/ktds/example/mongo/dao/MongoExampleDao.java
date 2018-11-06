package com.ktds.example.mongo.dao;

import java.util.List;

import com.ktds.example.mongo.vo.MongoExampleVO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public interface MongoExampleDao {

	public MongoExampleVO insertMongoExampleVO(MongoExampleVO mongoExampleVO);
	
	public UpdateResult updateMongoExampleVO(MongoExampleVO mongoExampleVO);
	
	public DeleteResult deleteMongoExampleVO(String id);
	
	public List<MongoExampleVO> selectMongoExampleVOList();
	
}
