package com.codejam.demo.service;

import com.codejam.demo.pojo.PersonalInformation;

public interface PersonalInfoService {

	PersonalInformation findById(Integer id) throws Exception;

	PersonalInformation savePersonalInfo(PersonalInformation personalInformation);

	PersonalInformation getRandomPersonalInfo();

	void deletePersonalInfo(Integer id);

	PersonalInformation updatePersonalInfo(PersonalInformation personalInformation);

}
