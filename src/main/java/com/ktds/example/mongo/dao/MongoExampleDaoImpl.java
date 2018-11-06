package com.ktds.example.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.ktds.example.mongo.vo.MongoExampleVO;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class MongoExampleDaoImpl implements MongoExampleDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public MongoExampleVO insertMongoExampleVO(MongoExampleVO mongoExampleVO) {
		return this.mongoTemplate.insert(mongoExampleVO, "example");
	}

	@Override
	public UpdateResult updateMongoExampleVO(MongoExampleVO mongoExampleVO) {
		Query query = new Query(new Criteria("_id").is(mongoExampleVO.getId()));
		
		Update update = new Update();
		for( String menu : mongoExampleVO.getMenu() ) {
			update.addToSet("menu", menu);
		}
		
		return this.mongoTemplate.upsert(query, update, MongoExampleVO.class, "example");
	}

	@Override
	public DeleteResult deleteMongoExampleVO(String id) {
		Query query = new Query(new Criteria("_id").is(id));
		return this.mongoTemplate.remove(query, MongoExampleVO.class, "example");
	}

	@Override
	public List<MongoExampleVO> selectMongoExampleVOList() {
		return this.mongoTemplate.findAll(MongoExampleVO.class, "example");
	}

}
