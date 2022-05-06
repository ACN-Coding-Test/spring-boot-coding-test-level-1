package com.codejam.demo.controller;

import com.codejam.demo.model.PersonalInformation;
import com.codejam.demo.repository.PersonalInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @GetMapping("/information/all")
    public List<PersonalInformation> getAllInformation() {
        return personalInformationRepository.findAll();
    }

    @GetMapping("/information/{id}")
    public Optional<PersonalInformation> getInformation(@PathVariable("id") Integer id) {
        return personalInformationRepository.findById(id);
    }

    @PostMapping("/information/save")
    public PersonalInformation savePersonalInformation(@RequestBody PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    @PostMapping("/information/update")
    public PersonalInformation updatePersonalInformation(@RequestBody PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    @GetMapping("/information/{id}/delete")
    public String deletePersonalInformation(@PathVariable("id") Integer id) {
        try {
            personalInformationRepository.deleteById(id);
        } catch (Exception e) {
            return "Failed";
        }
        return "Successful";
    }
}
