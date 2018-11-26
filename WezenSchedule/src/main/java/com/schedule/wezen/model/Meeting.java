package com.schedule.wezen.model;

public class Meeting {
	
	String name;
	int secretCode;
	
	public Meeting(String title, int secretCode) {
		this.name = title;
		this.secretCode = secretCode;
	}
	
	public String getName() {return name;}
	public int getSecretCode() {return secretCode;}
	
	public void setName(String n) {this.name = n;}
}
