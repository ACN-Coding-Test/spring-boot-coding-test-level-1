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
@Table(name = "REVENUE")
public class Revenue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "monthly_rate", length = 50)
	private String monthlyRate;

	@Column(name = "event_name", length = 60)
	private String eventName;

	@Column(name = "date_time", length = 50)
	private String dateTime;

}
