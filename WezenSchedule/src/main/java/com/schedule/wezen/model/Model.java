package com.schedule.wezen.model;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Model {
	
	ArrayList<Schedule> schedules;
	
	public Model() {
		
	}
	
	public boolean deleteSchedule(int id) {
		for(Schedule s: schedules) {
			if(s.getId() == id) {
				schedules.remove(s);
				return true;
			}
		}
		return false;
	}
	
	public int createSecretCode() {
		Random r = new Random();
		int code = r.nextInt();
		for(Schedule s: schedules) {
			if(s.secretCode == code) {
				return createSecretCode();
			}
		}
		return code;
	}
	
	public boolean createSchedule(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, LocalTime slotDuration, int id) {
		for(Schedule s: schedules) {
			if(s.id == id) {
				return false;
			}
		}
		schedules.add(new Schedule(startDate, endDate, startTime, endTime, slotDuration, id, createSecretCode()));
		return true;
	}
	
	public ArrayList<Schedule> getSchedules() {return schedules;}
	
	public void setSchedules(ArrayList<Schedule> schedules) {this.schedules = schedules;}
}
