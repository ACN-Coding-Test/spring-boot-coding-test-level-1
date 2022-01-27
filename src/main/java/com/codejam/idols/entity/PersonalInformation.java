package com.codejam.idols.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "real_name", length = 50)
	private String realName;
	@Column(name = "idol_name", length = 60)
	private String idolName;
	@Column(name = "address")
	private String address;
	@Column(name = "idol_status", length = 25)
	private String idolStatus;

}
