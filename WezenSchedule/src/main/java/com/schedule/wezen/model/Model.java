package com.schedule.wezen.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Model {
	
	ArrayList<Schedule> schedules;
	
	public Model() {
		
	}
	
	public boolean deleteSchedule(Schedule s) {
		// TODO implement
		return true;
	}
	
	public boolean createSchedule(Date startDate, Date endDate, Time startTime, Time endTime, Time slotDuration, int id) {
		// TODO implement
		return true;
	}
	
	public ArrayList<Schedule> getSchedules() {return schedules;}
	
	public void setSchedules(ArrayList<Schedule> schedules) {this.schedules = schedules;}
	
	// TODO getters and setters for all classes
	// TODO implement controllers instead of code
}
