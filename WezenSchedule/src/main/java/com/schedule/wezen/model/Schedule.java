package com.schedule.wezen.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Schedule {
	
	Date startDate, endDate;
	Time startTime, endTime, slotDuration;
	int id, secretCode;
	ArrayList<TimeSlot> timeSlots;
	ArrayList<Meeting> meetings;
	
	public Schedule(Date startDate, Date endDate, Time startTime, Time endTime, Time slotDuration, int id, int secretCode) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.slotDuration = slotDuration;
		this.id = id;
		this.secretCode = secretCode;
	}
	
	public int createSecretCode() {
		Random r = new Random();
		int code = r.nextInt();
		for(Meeting m: meetings) {
			if(m.secretCode == code) {
				return createSecretCode();
			}
		}
		return code;
	}
	
	public boolean createMeeting(TimeSlot t, String title) {
		if(t.isOccupied()) {
			return false;
		}
		else {
			t.slotMeeting = new Meeting(title, createSecretCode());
			return true;
		}
	}
	
	public boolean changeDuration(Date sd, Date ed) {
		this.startDate = sd;
		this.endDate = ed;
		return true;
	}
	// TODO add searchForTime
}
