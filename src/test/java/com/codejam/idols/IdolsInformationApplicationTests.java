package com.codejam.idols;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.codejam.idols.entity.PersonalInformation;
import com.codejam.idols.repositpry.PersonalInfoRepository;
import com.codejam.idols.service.PersonalInfoService;
import com.codejam.idols.serviceImpl.PersonalInfoServiceImpl;

@SpringBootTest
public class IdolsInformationApplicationTests {

	@Mock
	private PersonalInfoRepository personalInfoRepository;

	@InjectMocks
	private PersonalInfoService personalInfoService = new PersonalInfoServiceImpl();

	@Test
	public void test_savePersonalInfo() {
		PersonalInformation personalInformation = new PersonalInformation();
		personalInformation.setIdolName("kul");
		personalInformation.setIdolStatus("active");
		personalInformation.setAddress("hyd");
		personalInformation.setRealName("malisiya");
		when(personalInfoRepository.save(personalInformation)).thenReturn(personalInformation);
		Integer save = personalInfoService.savePersonalInfo(personalInformation);
		assertThat(personalInformation.getIdolStatus().equalsIgnoreCase("ACTIVE"));
		assertThat(save).isNotNull();

	}

	@Test
	public void test_getAllUsersPersonalInformations() {
		List<PersonalInformation> personalInformationList = new ArrayList<>();
		PersonalInformation personalInformation = new PersonalInformation();
		personalInformation.setIdolName("kul");
		personalInformation.setIdolStatus("active");
		personalInformation.setAddress("hyd");
		personalInformation.setRealName("malisiya");
		personalInformationList.add(personalInformation);
		when(personalInfoRepository.findAll()).thenReturn(personalInformationList);
		List<PersonalInformation> list = personalInfoService.getAllUsersPersonalInformations();
		assertThat(list).isNotEmpty();

	}

	@Test
	public void test_fetchRandomIdolPersonalInformation() {
		PersonalInformation personalInformation = new PersonalInformation();
		personalInformation.setIdolName("remy");
		personalInformation.setIdolStatus("ACTIVE");
		personalInformation.setAddress("Malaysia");
		personalInformation.setRealName("rahimi");
		when(personalInfoRepository.fetchRandomIdolPersonalInformation()).thenReturn(personalInformation.toString());
		String info = personalInfoService.fetchRandomIdolPersonalInformation();
		assertThat(info).isNotNull();

	}

}
