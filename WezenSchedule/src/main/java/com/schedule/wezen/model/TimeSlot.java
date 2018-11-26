package com.schedule.wezen.model;

import java.sql.Time;
import java.util.Date;

public class TimeSlot {
	
	int id;
	Time startTime, duration;
	Meeting slotMeeting;
	Date slotDate;
	
	public TimeSlot(Time startTime, Time duration, Date date, int id) {
		this.startTime = startTime;
		this.duration = duration;
		this.slotDate = date;
		this.id = id;
	}
	
	public boolean isOccupied() {
		return (slotMeeting != null);
	}
	
	public boolean deleteMeeting() {
		if(slotMeeting == null) {
			return false;
		}
		else {
			slotMeeting = null;
			return true;
		}
	}
	
	public int getId() {return id;}
	public Time getStartTime() {return startTime;}
	public Time getDuration() {return duration;}
	public Meeting getMeeting() {return slotMeeting;}
	public Date getDate() {return slotDate;}
	
	public void setMeeting(Meeting m) {this.slotMeeting = m;}
}
