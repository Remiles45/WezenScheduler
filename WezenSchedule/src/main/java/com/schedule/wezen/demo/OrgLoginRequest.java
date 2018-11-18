package com.schedule.wezen.demo;

public class OrgLoginRequest {
	String user;
	String pass;
	
	public OrgLoginRequest (String a1, String a2) {
		this.user = a1;
		this.pass = a2;
	}
	public String toString() {
		return "Org(" + user + "," + pass + ")";
	}
}
