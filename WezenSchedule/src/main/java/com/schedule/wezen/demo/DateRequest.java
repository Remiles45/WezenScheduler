package com.schedule.wezen.demo;

public class DateRequest {
	String name;
	
	public DateRequest (String n) {
		this.name = "Wezen";
		//this.name = n;
	}
	
	public String toString() {
		return "Date(" + name + ")";
	}
}