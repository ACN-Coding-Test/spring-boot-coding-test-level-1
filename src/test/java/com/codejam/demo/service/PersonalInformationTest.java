package com.codejam.demo.service;

import com.codejam.demo.DemoApplication;
import com.codejam.demo.model.PersonalInformationEntity;
import com.codejam.demo.repository.PersonalInformationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = DemoApplication.class)
public class PersonalInformationTest {


    @Autowired
    private PersonalInformationRepository repository;

    @Test
    public void randomPersonalInfoTest(){

        Optional<PersonalInformationEntity> optional = repository.findById(1);
        PersonalInformationEntity entity = null;

        if (optional.isPresent()){
            entity = optional.get();
        }

        Assertions.assertEquals("remy", entity.getIdolName());
    }

    @Test
    public void IdolStatusTest(){

        Optional<PersonalInformationEntity> optional = repository.findById(1);
        PersonalInformationEntity entity = null;

        if (optional.isPresent()){
            entity = optional.get();
        }

        Assertions.assertEquals("ACTIVE", entity.getIdolStatus());
    }

}
