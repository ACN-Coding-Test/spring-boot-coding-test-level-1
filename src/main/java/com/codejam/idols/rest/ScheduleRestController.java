package com.codejam.idols.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codejam.idols.entity.Schedule;
import com.codejam.idols.exceptions.ScheduleNotFoundException;
import com.codejam.idols.service.ScheduleService;

@RestController
@RequestMapping("/rest/api/sc")
public class ScheduleRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ScheduleRestController.class);

	@Autowired
	private ScheduleService scheduleService;

	@PostMapping("/save")
	public ResponseEntity<String> saveSchedule(@RequestBody Schedule schedule) {
		LOG.info("ENTER INTO SAVE REVENUE METHOD");
		ResponseEntity<String> response = null;
		try {
			Integer id = scheduleService.saveSchedule(schedule);
			response = new ResponseEntity<>("SCHEDULE SAVES WITH ID " + id, HttpStatus.CREATED);
			LOG.debug("SCHEDULE DATA IS SAVE WITH ID {}", id);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM SAVE OPERATION OF SCHEDULE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE SAVE REVENUE METHOD");
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserSchedulesById(@PathVariable Integer id) {
		LOG.info("ENTER INTO GET USER SCHEDULE METHOD");
		ResponseEntity<?> response = null;
		try {
			Schedule schedule = scheduleService.getUserSchedulesById(id);
			response = new ResponseEntity<>(schedule, HttpStatus.OK);
			LOG.debug("PERSONAL INFORMATION  {}", schedule);
		} catch (ScheduleNotFoundException sne) {
			throw sne;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM GET OPERATION OF SCHEDULE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GET PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllUsersSchedule() {
		LOG.info("ENTER INTO GET ALL USER SCHEDULE METHOD");
		ResponseEntity<?> response = null;
		try {
			List<Schedule> scheduleList = scheduleService.getAllUsersSchedule();
			response = new ResponseEntity<List<Schedule>>(scheduleList, HttpStatus.OK);
			LOG.debug("ALL USERS SCHEDULES  {}", scheduleList);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM GET ALL SCHEDULES INFORMATION {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GET ALL USER SCHEDULES METHOD");
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeUserScheduleById(@PathVariable Integer id) {
		LOG.info("ENTER INTO REMOVE USER SCHEDULES METHOD");
		ResponseEntity<String> response = null;
		try {
			scheduleService.removeUserScheduleById(id);
			response = new ResponseEntity<String>("USER SCHEDULES WITH ID " + id + " DELETED!", HttpStatus.OK);
			LOG.debug("DELETED USER SCHEDULES WITH ID {}", id);
		} catch (ScheduleNotFoundException sne) {
			throw sne;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM DELETE OPERATION OF USER SCHEDULES DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE DELETE USER SCHEDULES METHOD");
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUserPersonalInformation(@RequestBody Schedule schedule) {
		LOG.info("ENTER INTO UPDATE USER SCHEDULES METHOD");
		ResponseEntity<String> response = null;
		try {
			scheduleService.updateUserSchedule(schedule);
			response = new ResponseEntity<String>("USER SCHEDULE DATA " + schedule + " UPDATED!", HttpStatus.OK);
			LOG.debug("UPDATED USER SCHEDULE DATA {}", schedule);
		} catch (ScheduleNotFoundException sne) {
			throw sne;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM UPDATE OPERATION OF USER SCHEDULES DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE UPDATE USER SCHEDULE METHOD");
		return response;
	}
}
