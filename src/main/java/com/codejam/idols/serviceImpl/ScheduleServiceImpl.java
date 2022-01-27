package com.codejam.idols.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejam.idols.entity.Schedule;
import com.codejam.idols.exceptions.ScheduleNotFoundException;
import com.codejam.idols.repositpry.ScheduleRepository;
import com.codejam.idols.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Integer saveSchedule(Schedule schedule) {
		schedule = scheduleRepository.save(schedule);
		return schedule.getId();

	}

	@Override
	public List<Schedule> getAllUsersSchedule() {
		List<Schedule> scheduleList = scheduleRepository.findAll();
		return scheduleList;
	}

	@Override
	public Schedule getUserSchedulesById(Integer id) {
		return scheduleRepository.findById(id)
				.orElseThrow(() -> new ScheduleNotFoundException("USER SCHEDULE " + id + " NOT EXIST TO DISPLAY"));
	}

	@Override
	public void removeUserScheduleById(Integer id) {
		if (id == null || !scheduleRepository.existsById(id)) {
			throw new ScheduleNotFoundException("USER SCHEDULE " + id + " NOT EXIST TO REMOVE");
		} else {
			scheduleRepository.delete(getUserSchedulesById(id));
		}

	}

	@Override
	public void updateUserSchedule(Schedule schedule) {
		if (schedule == null || !scheduleRepository.existsById(schedule.getId())) {
			throw new ScheduleNotFoundException("USER SCHEDULE " + schedule.getId() + " NOT EXIST TO UPDATE");
		} else {
			scheduleRepository.save(schedule);
		}
	}

}
