package com.codejam.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.codejam.demo.model.PersonalInfo;

public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, Integer> {
}
