package com.codejam.demo.pojo;


import javax.persistence.*;


@Entity
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "real_name")
    private String real_name;
    
    @Column(name = "idol_name")
    private String idol_name;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "idol_status")
    private String idol_status;

	public PersonalInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalInformation(Integer id, String real_name, String idol_name, String address, String idol_status) {
		super();
		this.id = id;
		this.real_name = real_name;
		this.idol_name = idol_name;
		this.address = address;
		this.idol_status = idol_status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getIdol_name() {
		return idol_name;
	}

	public void setIdol_name(String idol_name) {
		this.idol_name = idol_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdol_status() {
		return idol_status;
	}

	public void setIdol_status(String idol_status) {
		this.idol_status = idol_status;
	}
    
    
    
}
