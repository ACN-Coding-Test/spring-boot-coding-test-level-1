package com.codejam.demo.service;

import com.codejam.demo.dto.PersonalInformationDto;
import com.codejam.demo.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface PersonalInformationService {

    ResponseEntity<ResponseDto> save(PersonalInformationDto dto);

    ResponseEntity<PersonalInformationDto> get(Integer id);

    ResponseEntity<ResponseDto> update(PersonalInformationDto dto);

    ResponseEntity<ResponseDto> delete(Integer id);

}
