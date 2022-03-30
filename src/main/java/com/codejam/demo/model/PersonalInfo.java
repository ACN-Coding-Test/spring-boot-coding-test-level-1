
package com.codejam.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_information")
public class PersonalInfo {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "real_name", length = 50)
	private String realName;
	@Column(name = "idol_name", length = 60)
	private String idolName;
	@Column(name = "address", length = 255)
	private String idolAddress;
	@Column(name = "idol_status", length = 25)
	private String idolStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdolName() {
		return idolName;
	}

	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}

	public String getIdolAddress() {
		return idolAddress;
	}

	public void setIdolAddress(String idolAddress) {
		this.idolAddress = idolAddress;
	}

	public String getIdolStatus() {
		return idolStatus;
	}

	public void setIdoltaStus(String idolStatus) {
		this.idolStatus = idolStatus;
	}

}