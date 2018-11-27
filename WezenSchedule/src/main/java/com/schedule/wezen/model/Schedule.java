package com.schedule.wezen.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalTime;

public class Schedule {
	
	LocalDate startDate, endDate;
	LocalTime startTime, endTime, slotDuration;
	int id, secretCode;
	ArrayList<TimeSlot> timeSlots;
	ArrayList<Meeting> meetings;
	
	public Schedule(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, LocalTime slotDuration, int id, int secretCode) {
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
	
	public boolean createMeeting(TimeSlot t, String title, int id) {
		if(t.isOccupied()) {
			return false;
		}
		else {
			t.slotMeeting = new Meeting(title, createSecretCode(), id);
			return true;
		}
	}
	
	public boolean changeDuration(LocalDate sd, LocalDate ed) {
		if(this.startDate.isBefore(sd) || this.endDate.isAfter(ed)) {
			return false;
		}
		else {
			this.startDate = sd;
			this.endDate = ed;
			return true;
		}
	}
	
	public ArrayList<TimeSlot> searchForTime(int month, int year, int dayWeek, int dayMonth, LocalTime time) {
		ArrayList<TimeSlot> available = timeSlots;
		for(TimeSlot ts: available) {
			if(month != 0 && ts.getDate().getMonthValue() != month) {
				available.remove(ts);
			}
			else if(year != 0 && ts.getDate().getYear() != year) {
				available.remove(ts);
			}
			else if(dayWeek != 0 && ts.getDate().getDayOfWeek().getValue() != dayWeek) {
				available.remove(ts);
			}
			else if(dayMonth != 0 && ts.getDate().getDayOfMonth() != dayMonth) {
				available.remove(ts);
			}
			else if(time.getSecond() != 1 && (ts.getStartTime().getHour() != time.getHour() || ts.getStartTime().getMinute() != time.getMinute())) {
				available.remove(ts);
			}
		}
		return available;
	}
	
	public boolean isCorrectCode(int sc) {
		return (sc == secretCode);
	}
	
	public LocalDate getStartDate() {return startDate;}
	public LocalDate getEndDate() {return endDate;}
	public LocalTime getStartTime() {return startTime;}
	public LocalTime getEndTime() {return endTime;}
	public LocalTime getSlotDuration() {return slotDuration;}
	public int getId() {return id;}
	public int getSecretCode() {return secretCode;}
	public ArrayList<TimeSlot> getTimeSlots() {return timeSlots;}
	public ArrayList<Meeting> meetings() {return meetings;}
	
	public void setStartDate(LocalDate sd) {this.startDate = sd;}
	public void setEndDate(LocalDate ed) {this.endDate = ed;}
	public void setStartTime(LocalTime st) {this.startTime = st;}
	public void setEndTime(LocalTime et) {this.endTime = et;}
}
