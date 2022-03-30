package com.codejam.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codejam.demo.model.PersonalInfo;
import com.codejam.demo.repository.PersonalInfoRepository;
import com.codejam.demo.model.Revenue;
import com.codejam.demo.model.Schedule;
import com.codejam.demo.repository.RevenueRepository;
import com.codejam.demo.repository.ScheduleRepository;

@Service
public class DemoService {

	@Autowired
	PersonalInfoRepository personalInfoRepository;
	
	@Autowired
	RevenueRepository revenueRepository;
	
	@Autowired
	ScheduleRepository scheduleRepository;

	public List<PersonalInfo> getAllPersonalInfo() {
		List<PersonalInfo> personalInfos = new ArrayList<PersonalInfo>();
		personalInfoRepository.findAll().forEach(personalInfo -> personalInfos.add(personalInfo));
		return personalInfos;
	}

	public PersonalInfo getPersonalInfoById(int id) {
		return personalInfoRepository.findById(id).get();
	}

	public void saveOrUpdate(PersonalInfo personalInfo) {
		personalInfoRepository.save(personalInfo);
	}

	public void delete(int id) {
		personalInfoRepository.deleteById(id);
	}
	
	


	public List<Schedule> getSchedule() {
		List<Schedule> schedules = new ArrayList<Schedule>();
		scheduleRepository.findAll().forEach(schedule ->schedules.add(schedule));
		return schedules;
	}

	public void saveOrUpdate(Schedule schedule) {
		scheduleRepository.save(schedule);
	}
	
	public Schedule getScheduleById(int id) {
		return scheduleRepository.findById(id).get();
	}	
	
	public void deleteSchedule(int id) {
		scheduleRepository.deleteById(id);
	}
	


	public List<Revenue> getRevenue() {
		List<Revenue> revenues = new ArrayList<Revenue>();
		revenueRepository.findAll().forEach(revenue ->revenues.add(revenue));
		return revenues;
	}

	public void saveOrUpdate(Revenue revenue) {
		revenueRepository.save(revenue);
	}
	
	public Revenue getRevenueById(int id) {
		return revenueRepository.findById(id).get();
	}
	
	public void deleteRevenue(int id) {
		revenueRepository.deleteById(id);
	}
}