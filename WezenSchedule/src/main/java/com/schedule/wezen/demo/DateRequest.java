package com.schedule.wezen.demo;

public class DateRequest {
	String name;
	
	public DateRequest (String n) {
		this.name = "Wezen"; // This is for current implementation, eventually this will change
		//this.name = n;
	}
	
	public String toString() {
		return "Date(" + name + ")";
	}
}