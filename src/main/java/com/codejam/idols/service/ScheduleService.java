package com.codejam.idols.service;

import java.util.List;

import com.codejam.idols.entity.Revenue;
import com.codejam.idols.entity.Schedule;

public interface ScheduleService {

	public Integer saveSchedule(Schedule schedule);

	public List<Schedule> getAllUsersSchedule();

	public Schedule getUserSchedulesById(Integer id);

	public void removeUserScheduleById(Integer id);

	public void updateUserSchedule(Schedule schedule);

}
