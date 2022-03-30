package com.codejam.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codejam.demo.model.PersonalInfo;
import com.codejam.demo.repository.PersonalInfoRepository;

@Service
public class DemoService {

	@Autowired
	PersonalInfoRepository personalInfoRepository;

	public List<PersonalInfo> getAllPersonalInfo() {
		List<PersonalInfo> personalInfos = new ArrayList<PersonalInfo>();
		personalInfoRepository.findAll().forEach(personalInfo -> personalInfos.add(personalInfo));
		return personalInfos;
	}

	public PersonalInfo getPersonalInfoById(int id) {
		return personalInfoRepository.findById(id).get();
	}

	public void saveOrUpdate(PersonalInfo personalInfo) {
		personalInfoRepository.save(personalInfo);
	}

	public void delete(int id) {
		personalInfoRepository.deleteById(id);
	}
}