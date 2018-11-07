package com.ktds.example.mongo.web;

import java.util.List;

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
	private MongoExampleService mongoExampleService;
	
	@GetMapping("example/mongo/form")
	public String viewFormPage() {
		return "example/mongo/form";
	};
	
	@GetMapping("example/mongo/list")
	public ModelAndView viewListPage() {
		ModelAndView view = new ModelAndView("example/mongo/list");
		
		List<MongoExampleVO> mongoExampleVOList = this.mongoExampleService.readMongoExampleVOList();
		view.addObject("mongoExampleVOList", mongoExampleVOList);
		return view;
	}
	
	@PostMapping("example/mongo/insert")
	public String doInsertAction(MongoExampleVO mongoExampleVO) {
		this.mongoExampleService.createMongoExampleVO(mongoExampleVO);
		return "redirect:/example/mongo/list";
	}
	
	@PostMapping("example/mongo/update")
	public String doUpdateAction(MongoExampleVO mongoExampleVO) {
		this.mongoExampleService.modifyMongoExampleVO(mongoExampleVO);
		return "redirect:/example/mongo/list";
	}
	
	@PostMapping("example/mongo/delete")
	public String doDeleteAction(MongoExampleVO mongoExampleVO) {
		this.mongoExampleService.removeMongoExampleVO(mongoExampleVO.getId());
		return "redirect:example/mongo/list";
	}
}
