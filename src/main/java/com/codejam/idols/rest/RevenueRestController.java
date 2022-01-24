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

import com.codejam.idols.entity.Revenue;
import com.codejam.idols.entity.Schedule;
import com.codejam.idols.exceptions.RevenueNotFoundException;
import com.codejam.idols.exceptions.ScheduleNotFoundException;
import com.codejam.idols.service.RevenueService;

@RestController
@RequestMapping("/rest/api/re")
public class RevenueRestController {

	private static final Logger LOG = LoggerFactory.getLogger(RevenueRestController.class);

	@Autowired
	private RevenueService revenueService;

	@PostMapping("/save")
	public ResponseEntity<String> saveRevenue(@RequestBody Revenue revenue) {
		LOG.info("ENTER INTO SAVE REVENUE METHOD");
		ResponseEntity<String> response = null;
		try {
			Integer id = revenueService.saveRevenue(revenue);
			response = new ResponseEntity<>("REVENUE SAVES WITH ID " + id, HttpStatus.CREATED);
			LOG.debug("REVENEUE DATA IS SAVE WITH ID {}", id);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM SAVE OPERATION OF REVENUE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE SAVE REVENUE METHOD");
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserRevenueById(@PathVariable Integer id) {
		LOG.info("ENTER INTO GET USER REVENUE METHOD");
		ResponseEntity<?> response = null;
		try {
			Revenue revenue = revenueService.getUserRevenueById(id);
			response = new ResponseEntity<>(revenue, HttpStatus.OK);
			LOG.debug("USER REVENUE {}", revenue);
		} catch (RevenueNotFoundException rne) {
			throw rne;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM GET OPERATION OF REVENUE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GET REVENUE METHOD");
		return response;
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllUsersRevenues() {
		LOG.info("ENTER INTO GET ALL USER REVENUES METHOD");
		ResponseEntity<?> response = null;
		try {
			List<Revenue> revenueList = revenueService.getAllUsersRevenue();
			response = new ResponseEntity<List<Revenue>>(revenueList, HttpStatus.OK);
			LOG.debug("ALL USERS REVENUE  {}", revenueList);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM GET ALL REVENUE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GET ALL USER REVENUE METHOD");
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeUserRevenueById(@PathVariable Integer id) {
		LOG.info("ENTER INTO REMOVE USER REVENUE METHOD");
		ResponseEntity<String> response = null;
		try {
			revenueService.removeUserRevenueById(id);
			response = new ResponseEntity<String>("USER REVENUE WITH ID " + id + " DELETED!", HttpStatus.OK);
			LOG.debug("DELETED USER REVENUE WITH ID {}", id);
		} catch (RevenueNotFoundException rne) {
			throw rne;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM DELETE OPERATION OF USER REVENUE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE DELETE USER REVENUES METHOD");
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUserRevenue(@RequestBody Revenue revenue) {
		LOG.info("ENTER INTO UPDATE USER REVENUE METHOD");
		ResponseEntity<String> response = null;
		try {
			revenueService.updateUserRevenue(revenue);
			response = new ResponseEntity<String>("USER REVENUE DATA " + revenue + " IS UPDATED!", HttpStatus.OK);
			LOG.debug("UPDATED USER REVENUE DATA {}", revenue);
		} catch (RevenueNotFoundException rne) {
			throw rne;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM UPDATE OPERATION OF USER REVENUE DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE UPDATE USER REVENUE METHOD");
		return response;
	}
}
