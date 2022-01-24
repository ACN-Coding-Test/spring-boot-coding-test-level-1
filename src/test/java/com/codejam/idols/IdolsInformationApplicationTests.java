package com.codejam.idols;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
		assertThat(save).isNotNull();

	}

}
