package com.codejam.demo.model;

import com.codejam.demo.dto.PersonalInformationDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PERSONAL_INFORMATION", schema = "testdb")
public class PersonalInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "idol_name")
    private String idolName;

    @Column(name = "address")
    private String dateTime;

    @Column(name = "idol_status")
    private String idolStatus;

    public PersonalInformationDto toDto() {
        PersonalInformationDto dto = new PersonalInformationDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
}
