package com.ktds.example.mongo.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.example.mongo.dao.MongoExampleDao;
import com.ktds.example.mongo.vo.MongoExampleVO;

@Service
public class MongoExampleServiceImpl implements MongoExampleService {

	@Autowired
	private MongoExampleDao mongoExampleDao;
	
	@Override
	public boolean createMongoExampleVO(MongoExampleVO mongoExampleVO) {
		mongoExampleVO.setWriteDate(new DateTime().now());
		return this.mongoExampleDao.insertMongoExampleVO(mongoExampleVO) != null;
	}

	@Override
	public boolean modifyMongoExampleVO(MongoExampleVO mongoExampleVO) {
		mongoExampleVO.setModifyDate(new DateTime().now());
		return this.mongoExampleDao.updateMongoExampleVO(mongoExampleVO).wasAcknowledged();
	}

	@Override
	public boolean removeMongoExampleVO(String id) {
		return this.mongoExampleDao.deleteMongoExampleVO(id).getDeletedCount() > 0;
	}

	@Override
	public List<MongoExampleVO> readMongoExampleVOList() {
		return this.mongoExampleDao.selectMongoExampleVOList();
	}

}
