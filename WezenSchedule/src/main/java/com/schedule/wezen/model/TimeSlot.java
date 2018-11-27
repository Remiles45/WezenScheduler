package com.schedule.wezen.model;

import java.time.LocalTime;
import java.time.LocalDate;

public class TimeSlot {
	
	int id;
	LocalTime startTime, duration;
	Meeting slotMeeting;
	LocalDate slotDate;
	
	public TimeSlot(LocalTime startTime, LocalTime duration, LocalDate date, int id) {
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
	public LocalTime getStartTime() {return startTime;}
	public LocalTime getDuration() {return duration;}
	public Meeting getMeeting() {return slotMeeting;}
	public LocalDate getDate() {return slotDate;}
	
	public void setMeeting(Meeting m) {this.slotMeeting = m;}
}
