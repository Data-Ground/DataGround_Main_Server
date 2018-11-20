package com.ktds.wifi.vo;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class WifiVO {
	
	@Override
	public String toString() {
		return "WifiVO [id=" + id + ", location=" + location + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", writeDate=" + writeDate + ", modifyDate=" + modifyDate + "]";
	}
	@Id
	private String id;
	
	private String location;
	private String address;
	private String latitude ;
	private String longitude;
	private DateTime writeDate;
	private DateTime modifyDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
