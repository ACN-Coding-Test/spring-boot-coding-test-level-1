package com.codejam.idols.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codejam.idols.entity.PersonalInformation;
import com.codejam.idols.service.PersonalInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/idol/users")
public class PersonalInformationController {

	@Autowired
	private PersonalInfoService personalInfoService;

	@GetMapping("/register")
	public String showRegister() {
		log.info("DISPLAY THE PERSONAL INFORMATION REGISTRATION PAGE...!");
		return "PersonalInformationPage";
	}

	@PostMapping("/saveuser")
	public String savePersonalInfo(@ModelAttribute PersonalInformation personalInformation, Model model) {
		log.info("ENTER INTO SAVE PERSONAL INFORMATION METHOD");
		try {
			Integer id = personalInfoService.savePersonalInfo(personalInformation);
			String message = "PERSONAL INFROMATION SAVES WITH ID " + id;
			model.addAttribute("message", message);
			log.debug("PERSONAL INFORMATION DATA IS SAVE WITH ID {}", id);
		} catch (Exception e) {
			model.addAttribute("message",
					"COULD NOT EXECUTE THE DUPLICATE FORM DATA OR  PAGE RELOAD DATA OR EMPTY FIELD FORM...!");
			log.error("UNABLE TO PERFORM SAVE OPERATION OF PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE SAVE PERSONAL INFORMATION METHOD");
		return "PersonalInformationPage";
	}

	@GetMapping("/allusers")
	public String getAllPersonalInfos(Model model) {
		log.info("ENTER INTO SAVE PERSONAL INFORMATION METHOD");
		try {
			List<PersonalInformation> info = personalInfoService.getAllUsersPersonalInformations();
			model.addAttribute("info", info);
			log.debug("PERSONAL INFORMATION DATA IS SAVE WITH ID {}", info);
		} catch (Exception e) {
			model.addAttribute("message",
					"COULD NOT EXECUTE THE DUPLICATE FORM DATA OR  PAGE RELOAD DATA OR EMPTY FIELD FORM...!");
			log.error("UNABLE TO PERFORM OPERATION OF GET ALL PERSONAL INFORMATION DATA {}", e.getMessage());
		}
		log.info("ABOUT TO LEAVE GETALL PERSONAL INFORMATION METHOD");
		return "PersonalInformationData";
	}
}
