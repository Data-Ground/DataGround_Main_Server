package com.ktds.wifi.parkinglot.vo;

import org.springframework.data.annotation.Id;

public class ParkinglotVO {
	
	@Id
	private String id;
	
	private String name;
	private String location;
	private String kinds;
	private String classification;
	private String isNotFree;
	private String weekdayStartTime;
	private String weekdayEndTime;
	private String weekendStartTime;
	private String weekendEndTime;
	private String holidayStartTime;
	private String holidayEndTime;
	private String saturdayNotFree;
	private String holidayNotFree;
	private String parkingMonthlyCommuterPassFee;
	private String basicParkingFee;
	private String basicParkingTime;
	private String additionalTimeCharges;
	private String additionalTime;
	private String latitude;
	private String longitude;
	
	
	public ParkinglotVO(String[] parkinglot) {
		this.name = parkinglot[0];
		this.location = parkinglot[1];
		this.kinds = parkinglot[2];
		this.classification = parkinglot[3];
		this.isNotFree = parkinglot[4];
		this.weekdayStartTime = parkinglot[5];
		this.weekdayEndTime = parkinglot[6];
		this.weekendStartTime = parkinglot[7];
		this.weekendEndTime = parkinglot[8];
		this.holidayStartTime = parkinglot[9];
		this.holidayEndTime = parkinglot[10];
		this.saturdayNotFree = parkinglot[11];
		this.holidayNotFree = parkinglot[12];
		this.parkingMonthlyCommuterPassFee = parkinglot[13];
		this.basicParkingFee = parkinglot[14];
		this.basicParkingTime = parkinglot[15];
		this.additionalTimeCharges = parkinglot[16];
		this.additionalTime = parkinglot[17];
		this.latitude = parkinglot[18];
		this.longitude = parkinglot[19];
	}
	
	
	public synchronized String getId() {
		return id;
	}
	public synchronized void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getIsNotFree() {
		return isNotFree;
	}
	public void setIsNotFree(String isNotFree) {
		this.isNotFree = isNotFree;
	}
	public String getWeekdayStartTime() {
		return weekdayStartTime;
	}
	public void setWeekdayStartTime(String weekdayStartTime) {
		this.weekdayStartTime = weekdayStartTime;
	}
	public String getWeekdayEndTime() {
		return weekdayEndTime;
	}
	public void setWeekdayEndTime(String weekdayEndTime) {
		this.weekdayEndTime = weekdayEndTime;
	}
	public String getWeekendStartTime() {
		return weekendStartTime;
	}
	public void setWeekendStartTime(String weekendStartTime) {
		this.weekendStartTime = weekendStartTime;
	}
	public String getWeekendEndTime() {
		return weekendEndTime;
	}
	public void setWeekendEndTime(String weekendEndTime) {
		this.weekendEndTime = weekendEndTime;
	}
	public String getHolidayStartTime() {
		return holidayStartTime;
	}
	public void setHolidayStartTime(String holidayStartTime) {
		this.holidayStartTime = holidayStartTime;
	}
	public String getHolidayEndTime() {
		return holidayEndTime;
	}
	public void setHolidayEndTime(String holidayEndTime) {
		this.holidayEndTime = holidayEndTime;
	}
	public String getSaturdayNotFree() {
		return saturdayNotFree;
	}
	public void setSaturdayNotFree(String saturdayNotFree) {
		this.saturdayNotFree = saturdayNotFree;
	}
	public String getHolidayNotFree() {
		return holidayNotFree;
	}
	public void setHolidayNotFree(String holidayNotFree) {
		this.holidayNotFree = holidayNotFree;
	}
	public String getParkingMonthlyCommuterPassFee() {
		return parkingMonthlyCommuterPassFee;
	}
	public void setParkingMonthlyCommuterPassFee(String parkingMonthlyCommuterPassFee) {
		this.parkingMonthlyCommuterPassFee = parkingMonthlyCommuterPassFee;
	}
	public String getBasicParkingFee() {
		return basicParkingFee;
	}
	public void setBasicParkingFee(String basicParkingFee) {
		this.basicParkingFee = basicParkingFee;
	}
	public String getBasicParkingTime() {
		return basicParkingTime;
	}
	public void setBasicParkingTime(String basicParkingTime) {
		this.basicParkingTime = basicParkingTime;
	}
	public String getAdditionalTimeCharges() {
		return additionalTimeCharges;
	}
	public void setAdditionalTimeCharges(String additionalTimeCharges) {
		this.additionalTimeCharges = additionalTimeCharges;
	}
	public String getAdditionalTime() {
		return additionalTime;
	}
	public void setAdditionalTime(String additionalTime) {
		this.additionalTime = additionalTime;
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
	
}
