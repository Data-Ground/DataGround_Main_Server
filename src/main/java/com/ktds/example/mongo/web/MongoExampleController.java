package com.ktds.example.mongo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.example.mongo.service.MongoExampleService;
import com.ktds.example.mongo.vo.MongoExampleVO;

@Controller
public class MongoExampleController {

	@Autowired
	private MongoExampleService MongoExampleService;
	
	@GetMapping("example/mongo/form")
	public String viewFormPage() {
		return "example/mongo/form";
	};
	
	@GetMapping("example/mongo/list")
	public ModelAndView viewListPage() {
		ModelAndView view = new ModelAndView("example/mongo/list");
		
		return view;
	}
	
	@PostMapping("example/mongo/insert")
	public String doInsertAction(MongoExampleVO mongoExampleVO) {
		
		return "redirect:example/mongo/list";
	}
	
	@PostMapping("example/mongo/update")
	public String doUpdateAction(MongoExampleVO mongoExampleVO) {
		
		return "redirect:example/mongo/list";
	}
	
	@PostMapping("example/mongo/delete")
	public String doDeleteAction(MongoExampleVO mongoExampleVO) {
		
		return "redirect:example/mongo/list";
	}
}
