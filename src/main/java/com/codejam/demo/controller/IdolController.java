package com.codejam.demo.controller;

import com.codejam.demo.dto.PersonalInformationDto;
import com.codejam.demo.dto.ResponseDto;
import com.codejam.demo.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/idol")
public class IdolController {

    private final PersonalInformationService personalInformationService;

    @Autowired
    public IdolController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody PersonalInformationDto dto) {

        return personalInformationService.save(dto);

    }

    @GetMapping(path = "users/{id}")
    public ResponseEntity<PersonalInformationDto> get(
            @PathVariable(value = "id") Integer id
    ) {
        return personalInformationService.get(id);
    }

    @PutMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> updateById(@Valid @RequestBody PersonalInformationDto dto) {

        return personalInformationService.update(dto);

    }

    @DeleteMapping(path = "users/{id}")
    public ResponseEntity<ResponseDto> deleteById(
            @PathVariable(value = "id") Integer id
    ) {
        return personalInformationService.delete(id);
    }

}
