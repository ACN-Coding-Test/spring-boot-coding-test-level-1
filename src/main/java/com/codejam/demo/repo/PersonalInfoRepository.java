package com.codejam.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codejam.demo.pojo.PersonalInformation;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInformation, Integer> {

	
	@Query("SELECT u FROM PersonalInformation u WHERE u.idol_name = :name")
    Optional<PersonalInformation> findIdolPersonalInfoByIdolName(@Param("name") String name);
	

    @Query(value = "select * from PERSONAL_INFORMATION order by rand() limit 1", nativeQuery = true)
    Optional<PersonalInformation> getRandomPersonalInfo();
}
