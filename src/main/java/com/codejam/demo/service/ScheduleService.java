package com.codejam.demo.service;

import com.codejam.demo.pojo.Schedule;

public interface ScheduleService {
	
    Schedule findById(Integer id);

    Schedule saveSchedule(Schedule schedule);

    Schedule updateSchedule(Schedule schedule);

    void deleteSchedule(Integer id);
}
