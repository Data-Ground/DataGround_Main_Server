package com.ktds.example.mongo.vo;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class MongoExampleVO {

	@Id
	private String id; // 몽고 insert시 자동생성

	private String name;
	private String type;
	private String tel;
	private List<String> menu;
	private DateTime writeDate;
	private DateTime modifyDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<String> getMenu() {
		return menu;
	}

	public void setMenu(List<String> menu) {
		this.menu = menu;
	}

	public DateTime getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(DateTime writeDate) {
		this.writeDate = writeDate;
	}

	public DateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(DateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

}
