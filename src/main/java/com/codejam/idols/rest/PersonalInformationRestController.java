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

import com.codejam.idols.entity.PersonalInformation;
import com.codejam.idols.exceptions.PersonalInformationNotFoundException;
import com.codejam.idols.service.PersonalInfoService;

@RestController
@RequestMapping("/rest/api/pi")
public class PersonalInformationRestController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonalInformationRestController.class);

	@Autowired
	private PersonalInfoService personalInfoService;

	@PostMapping("/save")
	public ResponseEntity<String> savePersonalInfo(@RequestBody PersonalInformation personalInformation) {
		LOG.info("ENTER INTO SAVE PERSONAL INFORMATION METHOD");
		ResponseEntity<String> response = null;
		try {
			Integer id = personalInfoService.savePersonalInfo(personalInformation);
			response = new ResponseEntity<>("PERSONAL INFROMATION SAVES WITH ID " + id, HttpStatus.CREATED);
			LOG.debug("PERSONAL INFORMATION DATA IS SAVE WITH ID {}", id);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM SAVE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE SAVE PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserPersonalInformationById(@PathVariable Integer id) {
		LOG.info("ENTER INTO GET USER PERSONAL INFORMATION METHOD");
		ResponseEntity<?> response = null;
		try {
			PersonalInformation personalInformation = personalInfoService.getUserPersonalInformationById(id);
			response = new ResponseEntity<>(personalInformation, HttpStatus.OK);
			LOG.debug("PERSONAL INFORMATION  {}", personalInformation);
		} catch (PersonalInformationNotFoundException pie) {
			throw pie;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM GET OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GET PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllUsersPersonalInformations() {
		LOG.info("ENTER INTO GET ALL USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<?> response = null;
		try {
			List<PersonalInformation> personalInformation = personalInfoService.getAllUsersPersonalInformations();
			response = new ResponseEntity<List<PersonalInformation>>(personalInformation, HttpStatus.OK);
			LOG.debug("ALL USER PERSONAL INFORMATION  {}", personalInformation);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM GET OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GET PERSONAL INFORMATION METHOD");
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removePersonalInformationById(@PathVariable Integer id) {
		LOG.info("ENTER INTO REMOVE USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<String> response = null;
		try {
			personalInfoService.removePersonalInformationById(id);
			response = new ResponseEntity<String>("USER PERSONAL INFORMATION WITH ID " + id + " DELETED!",
					HttpStatus.OK);
			LOG.debug("DELETED USER PERSONAL INFORMATION WITH ID {}", id);
		} catch (PersonalInformationNotFoundException pie) {
			throw pie;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM DELETE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE DELETE PERSONAL INFORMATION METHOD");
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUserPersonalInformation(@RequestBody PersonalInformation personalInformation) {
		LOG.info("ENTER INTO UPDATE USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<String> response = null;
		try {
			personalInfoService.updateUserPersonalInformation(personalInformation);
			response = new ResponseEntity<String>(
					"USER PERSONAL INFORMATION WITH ID " + personalInformation + " UPDATED!", HttpStatus.OK);
			LOG.debug("UPDATED USER PERSONAL INFORMATION WITH ID {}", personalInformation);
		} catch (PersonalInformationNotFoundException pie) {
			throw pie;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM UPDATE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE UPDATE PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/random")
	public ResponseEntity<String> fetchRandomIdolPersonalInformation() {
		LOG.info("ENTER INTO FETCH RENADOM USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<String> response = null;
		try {
			String personalInformation = personalInfoService.fetchRandomIdolPersonalInformation();
			response = new ResponseEntity<String>(personalInformation, HttpStatus.OK);
			LOG.debug("RANDOM USER PERSONAL INFORMATION WITH ID {}", personalInformation);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFORM FETCH RANDOM OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE FETCH RANDOM PERSONAL INFORMATION METHOD");
		return response;
	}

}
