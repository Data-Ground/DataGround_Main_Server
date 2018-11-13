package com.ktds.sns.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ktds.sns.service.SNSService;

@Controller
public class SNSController {
	
	@Autowired
	private SNSService snsService;
	

}
