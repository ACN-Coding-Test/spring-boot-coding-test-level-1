package com.codejam.idols.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/api/json")
public class FetchJsonDataFromUrl {

	private static final Logger LOG = LoggerFactory.getLogger(PersonalInformationRestController.class);

	@GetMapping("/data")
	public ResponseEntity<String> getJsonDataFromUrl() {
		LOG.info("ENTER INTO GETJSONDATAFROMURL METHOD");
		ResponseEntity<String> response = null;
		String uri = "https://jsonplaceholder.typicode.com/todos/1";
		try {
			RestTemplate rest = new RestTemplate();
			String result = rest.getForObject(uri, String.class);
			response = new ResponseEntity<String>(result, HttpStatus.OK);
			LOG.debug("JSON DATA FEATECHED FROM EXTERNAL URL {}", result);
		} catch (Exception e) {
			response = new ResponseEntity<>("UNABLE TO PERFORM FETCH JSON DATA FORM EXTERNAL URL",
					HttpStatus.INTERNAL_SERVER_ERROR);
			LOG.error("UNABLE TO PERFROM JSON FETCHING FROM EXTERNAL URL {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE GETJSONDATAFROMURL METHOD");
		return response;
	}

}
