package com.codejam.demo.pojo;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer idol_personal_info_id;
	@Column
	private String venue;
	@Column
	private String event_name;
	@Column
	private String date_time;

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(Integer id, Integer idol_personal_info_id, String venue, String event_name, String date_time) {
		super();
		this.id = id;
		this.idol_personal_info_id = idol_personal_info_id;
		this.venue = venue;
		this.event_name = event_name;
		this.date_time = date_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdol_personal_info_id() {
		return idol_personal_info_id;
	}

	public void setIdol_personal_info_id(Integer idol_personal_info_id) {
		this.idol_personal_info_id = idol_personal_info_id;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

}
