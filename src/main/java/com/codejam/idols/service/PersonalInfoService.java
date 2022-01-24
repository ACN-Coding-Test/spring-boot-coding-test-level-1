package com.codejam.idols.service;

import java.util.List;

import com.codejam.idols.entity.PersonalInformation;

public interface PersonalInfoService {

	public Integer savePersonalInfo(PersonalInformation personalInformation);

	public List<PersonalInformation> getAllUsersPersonalInformations();

	public PersonalInformation getUserPersonalInformationById(Integer id);

	public void removePersonalInformationById(Integer id);

	public void updateUserPersonalInformation(PersonalInformation personalInformation);
	
	public String fetchRandomIdolPersonalInformation();

}
