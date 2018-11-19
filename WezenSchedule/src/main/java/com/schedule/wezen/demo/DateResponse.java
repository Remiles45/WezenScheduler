package com.schedule.wezen.demo;

public class DateResponse {
	String response;
	int day;
	int httpCode;
	
	public DateResponse (int d, int code) {
		this.day = d;
		this.httpCode = code;
		this.response = "Date: " + day + "2018";
	}
	
	// 200 means success
	public DateResponse (int d) {
		this.day = d;
		this.httpCode = 200;
		this.response = "Date: " + day + "2018";
	}
}