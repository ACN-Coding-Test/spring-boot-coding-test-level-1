package com.codejam.idols.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codejam.idols.entity.PersonalInformation;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInformation, Integer> {

	@Query("SELECT p.id, p.idolName FROM PersonalInformation AS p ORDER BY RAND()")
	String fetchRandomIdolPersonalInformation();

}
