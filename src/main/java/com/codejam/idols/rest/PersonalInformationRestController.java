package com.codejam.idols.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.client.RestTemplate;

import com.codejam.idols.entity.PersonalInformation;
import com.codejam.idols.exceptions.PersonalInformationNotFoundException;
import com.codejam.idols.service.PersonalInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/idol/users")
public class PersonalInformationRestController {

	@Autowired
	private PersonalInfoService personalInfoService;

	@Value("${external.url.todo}")
	private String url;

	@PostMapping("/save")
	public ResponseEntity<String> savePersonalInfo(@RequestBody PersonalInformation personalInformation) {
		log.info("ENTER INTO SAVE PERSONAL INFORMATION METHOD");
		ResponseEntity<String> response = null;
		try {
			Integer id = personalInfoService.savePersonalInfo(personalInformation);
			response = new ResponseEntity<>("PERSONAL INFROMATION SAVES WITH ID " + id, HttpStatus.CREATED);
			log.debug("PERSONAL INFORMATION DATA IS SAVE WITH ID {}", id);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFORM SAVE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE SAVE PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserPersonalInformationById(@PathVariable Integer id) {
		log.info("ENTER INTO GET USER PERSONAL INFORMATION METHOD");
		ResponseEntity<?> response = null;
		try {
			PersonalInformation personalInformation = personalInfoService.getUserPersonalInformationById(id);
			response = new ResponseEntity<>(personalInformation, HttpStatus.OK);
			log.debug("PERSONAL INFORMATION  {}", personalInformation);
		} catch (PersonalInformationNotFoundException pie) {
			throw pie;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFORM GET OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE GET PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsersPersonalInformations() {
		log.info("ENTER INTO GET ALL USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<?> response = null;
		try {
			List<PersonalInformation> personalInformation = personalInfoService.getAllUsersPersonalInformations();
			response = new ResponseEntity<List<PersonalInformation>>(personalInformation, HttpStatus.OK);
			log.debug("ALL USER PERSONAL INFORMATION  {}", personalInformation);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFORM GET OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE GET PERSONAL INFORMATION METHOD");
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removePersonalInformationById(@PathVariable Integer id) {
		log.info("ENTER INTO REMOVE USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<String> response = null;
		try {
			personalInfoService.removePersonalInformationById(id);
			response = new ResponseEntity<String>("USER PERSONAL INFORMATION WITH ID " + id + " DELETED!",
					HttpStatus.OK);
			log.debug("DELETED USER PERSONAL INFORMATION WITH ID {}", id);
		} catch (PersonalInformationNotFoundException pie) {
			throw pie;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFORM DELETE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE DELETE PERSONAL INFORMATION METHOD");
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUserPersonalInformation(@RequestBody PersonalInformation personalInformation) {
		log.info("ENTER INTO UPDATE USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<String> response = null;
		try {
			personalInfoService.updateUserPersonalInformation(personalInformation);
			response = new ResponseEntity<String>(
					"USER PERSONAL INFORMATION WITH ID " + personalInformation + " UPDATED!", HttpStatus.OK);
			log.debug("UPDATED USER PERSONAL INFORMATION WITH ID {}", personalInformation);
		} catch (PersonalInformationNotFoundException pie) {
			throw pie;
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFORM UPDATE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE UPDATE PERSONAL INFORMATION METHOD");
		return response;
	}

	@GetMapping("/random")
	public ResponseEntity<String> fetchRandomIdolPersonalInformation() {
		log.info("ENTER INTO FETCH RENADOM USER PERSONAL INFORMATIONS METHOD");
		ResponseEntity<String> response = null;
		try {
			String personalInformation = personalInfoService.fetchRandomIdolPersonalInformation();
			response = new ResponseEntity<String>(personalInformation, HttpStatus.OK);
			log.debug("RANDOM USER PERSONAL INFORMATION WITH ID {}", personalInformation);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFORM FETCH RANDOM OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE FETCH RANDOM PERSONAL INFORMATION METHOD");
		return response;
	}

	@PostMapping("/todo/{id}")
	public ResponseEntity<?> getTodoData(@PathVariable Integer id) {
		log.info("ENTER INTO TODO METHOD");
		ResponseEntity<?> response = null;
		try {
			RestTemplate rest = new RestTemplate();
			Todo toDo = rest.getForObject(url.concat("/".concat(id.toString())), Todo.class);
			response = new ResponseEntity<Todo>(toDo, HttpStatus.OK);
			log.debug("JSON DATA FEATECHED FROM EXTERNAL URL {}", toDo);
		} catch (Exception e) {
			response = new ResponseEntity<>("UNABLE TO PERFORM FETCH JSON DATA FORM EXTERNAL URL",
					HttpStatus.INTERNAL_SERVER_ERROR);
			log.error("UNABLE TO PERFROM JSON FETCHING FROM EXTERNAL URL {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE TODO METHOD");
		return response;
	}

}
