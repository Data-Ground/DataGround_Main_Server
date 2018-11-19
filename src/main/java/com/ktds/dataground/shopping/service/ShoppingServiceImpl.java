package com.ktds.dataground.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.dataground.shopping.dao.ShoppingDao;

@Service
public class ShoppingServiceImpl {
	@Autowired
	private ShoppingDao shoppingDao;
}
