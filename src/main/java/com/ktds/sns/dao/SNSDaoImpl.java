package com.ktds.sns.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SNSDaoImpl implements SNSDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;

}
