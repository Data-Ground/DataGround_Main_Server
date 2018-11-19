package com.ktds.dataground.shopping.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
}
