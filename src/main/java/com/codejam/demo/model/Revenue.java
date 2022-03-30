
package com.codejam.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "revenue")
public class Revenue {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "monthly_rate", length = 50)
	private String monthlyRate;
	@Column(name = "event_name", length = 60)
	private String eventName;
	@Column(name = "date_time", length = 50)
	private String dateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(String monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}