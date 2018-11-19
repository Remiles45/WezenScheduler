package com.schedule.wezen.demo;

public class DateRequest {
	int day;
	
	public DateRequest (int d) {
		this.day = d;
	}
	
	public String toString() {
		return "Date(" + day + ")";
	}
}