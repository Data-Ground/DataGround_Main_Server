package com.ktds.sns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.sns.dao.SNSDao;

@Service
public class SNSServiceImpl implements SNSService {

	@Autowired
	private SNSDao snsDao;
}
