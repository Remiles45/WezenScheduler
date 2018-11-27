package com.schedule.wezen.model;

public class Meeting {
	
	String name;
	int secretCode, id;
	
	public Meeting(String title, int secretCode, int id) {
		this.name = title;
		this.secretCode = secretCode;
		this.id = id;
	}
	
	public boolean isCorrectCode(int sc) {
		return (sc == secretCode);
	}
	
	public String getName() {return name;}
	public int getSecretCode() {return secretCode;}
	
	public void setName(String n) {this.name = n;}
}
