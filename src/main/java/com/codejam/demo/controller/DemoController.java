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
}
