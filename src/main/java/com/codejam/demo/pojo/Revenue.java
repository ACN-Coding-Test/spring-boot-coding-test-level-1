package com.codejam.demo.pojo;


import javax.persistence.*;

@Entity
@Table(name = "REVENUE")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private Integer idol_personal_info_id;
    @Column
    private String monthly_rate;
    @Column
    private String date_time;
    
    

	public Revenue() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Revenue(Integer id, Integer idol_personal_info_id, String monthly_rate, String date_time) {
		super();
		this.id = id;
		this.idol_personal_info_id = idol_personal_info_id;
		this.monthly_rate = monthly_rate;
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

	public String getMonthly_rate() {
		return monthly_rate;
	}

	public void setMonthly_rate(String monthly_rate) {
		this.monthly_rate = monthly_rate;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
    
    
}
