package com.codejam.idols.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejam.idols.entity.PersonalInformation;
import com.codejam.idols.exceptions.PersonalInformationNotFoundException;
import com.codejam.idols.repositpry.PersonalInfoRepository;
import com.codejam.idols.service.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

	@Autowired
	private PersonalInfoRepository personalInfoRepository;

	@Override
	public Integer savePersonalInfo(PersonalInformation personalInformation) {
		personalInformation = personalInfoRepository.save(personalInformation);
		return personalInformation.getId();
	}

	@Override
	public PersonalInformation getUserPersonalInformationById(Integer id) {
		return personalInfoRepository.findById(id).orElseThrow(
				() -> new PersonalInformationNotFoundException("USER PERSONAL_INFORMATION " + id + " NOT EXIST"));
	}

	@Override
	public List<PersonalInformation> getAllUsersPersonalInformations() {
		List<PersonalInformation> personalInformationList = personalInfoRepository.findAll();
		return personalInformationList;
	}

	@Override
	public void removePersonalInformationById(Integer id) {
		if (id == null || !personalInfoRepository.existsById(id)) {
			throw new PersonalInformationNotFoundException("USER PERSONAL_INFORMATION " + id + " NOT EXIST TO REMOVE");
		} else {
			personalInfoRepository.delete(getUserPersonalInformationById(id));
		}
	}

	@Override
	public void updateUserPersonalInformation(PersonalInformation personalInformation) {
		if (personalInformation == null || !personalInfoRepository.existsById(personalInformation.getId())) {
			throw new PersonalInformationNotFoundException(
					"USER PERSONAL_INFORMATION " + personalInformation.getId() + " NOT EXIST TO UPDATE");
		} else {
			personalInfoRepository.save(personalInformation);
		}
	}

	@Override
	public String fetchRandomIdolPersonalInformation() {
		String personalInformation = personalInfoRepository.fetchRandomIdolPersonalInformation();
		return personalInformation;
	}
}
