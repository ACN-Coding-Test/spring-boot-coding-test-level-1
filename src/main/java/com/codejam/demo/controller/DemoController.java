package com.codejam.demo.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codejam.demo.model.PersonalInfo;
import com.codejam.demo.model.Revenue;
import com.codejam.demo.service.DemoService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping(path = "/unit-test")
	ResponseEntity<Integer> getUnitTestResult() throws Exception {
		return null;
	}

	@GetMapping("/personalinfo/all")
	private List<PersonalInfo> getAllPersonalInfo() {
		return demoService.getAllPersonalInfo();

	}

	@PostMapping("/personalinfo")
	private int savePersonalInfo(@RequestBody PersonalInfo personalInfo) {
		demoService.saveOrUpdate(personalInfo);
		return personalInfo.getId();
	}

	@GetMapping("/personalinfo/{id}")
	private PersonalInfo getPersonalInfo(@PathVariable("id") int id) {
		return demoService.getPersonalInfoById(id);

	}

	@DeleteMapping("/personalinfo/{id}")
	private void deletePersonalInfo(@PathVariable("id") int id) {
		demoService.delete(id);
	}
	
	
	@PostMapping("/revenue")
	private int saveRevenue(@RequestBody Revenue revenue) {
		demoService.saveOrUpdate(revenue);
		return revenue.getId();
	}

	@GetMapping("/revenue/{id}")
	private Revenue getRevenue(@PathVariable("id") int id) {
		return demoService.getRevenueById(id);

	}

	@DeleteMapping("/revenue/{id}")
	private void deleteRevenue(@PathVariable("id") int id) {
		demoService.deleteRevenue(id);
	}
	
	
	@PostMapping("/schedule")
	private int saveSchedule(@RequestBody Revenue schedule) {
		demoService.saveOrUpdate(schedule);
		return schedule.getId();
	}

	@GetMapping("/schedule/{id}")
	private Revenue getSchedule(@PathVariable("id") int id) {
		return demoService.getRevenueById(id);

	}

	@DeleteMapping("/schedule/{id}")
	private void deleteSchedule(@PathVariable("id") int id) {
		demoService.deleteSchedule(id);
	}
}
