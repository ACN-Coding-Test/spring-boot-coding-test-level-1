package com.codejam.idols.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codejam.idols.entity.PersonalInformation;
import com.codejam.idols.exceptions.PersonalInformationNotFoundException;
import com.codejam.idols.service.PersonalInfoService;

@Controller
@RequestMapping("/pi")
public class PersonalInformationController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonalInformationController.class);

	@Autowired
	private PersonalInfoService personalInfoService;

	@GetMapping("/register")
	public String showRegister() {
		LOG.info("DISPLAY THE PERSONAL INFORMATION REGISTRATION PAGE...!");
		return "PersonalInformationPage";
	}

	@PostMapping("/save")
	public String savePersonalInfo(@ModelAttribute PersonalInformation personalInformation, Model model) {
		LOG.info("ENTER INTO SAVE PERSONAL INFORMATION METHOD");
		try {
			Integer id = personalInfoService.savePersonalInfo(personalInformation);
			String message = "PERSONAL INFROMATION SAVES WITH ID " + id;
			model.addAttribute("message", message);
			LOG.debug("PERSONAL INFORMATION DATA IS SAVE WITH ID {}", id);
		} catch (Exception e) {
			model.addAttribute("message",
					"COULD NOT EXECUTE THE DUPLICATE FORM DATA OR  PAGE RELOAD DATA OR EMPTY FIELD FORM...!");
			LOG.error("UNABLE TO PERFORM SAVE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		LOG.info("ABOUT TO LEAVE SAVE PERSONAL INFORMATION METHOD");
		return "PersonalInformationPage";
	}
}
