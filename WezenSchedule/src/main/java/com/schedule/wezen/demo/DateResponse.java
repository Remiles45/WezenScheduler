package com.schedule.wezen.demo;

public class DateResponse {
	String name;
	int httpCode;
	
	public DateResponse (String n, int code) {
		this.name = n; // May change as implementation does
		this.httpCode = code;
	}
	
	// 200 means success
	public DateResponse (String n) {
		this.name = n;
		this.httpCode = 200;
	}
	
	public String toString() {
		return "Name(" + name + ")";
	}
}