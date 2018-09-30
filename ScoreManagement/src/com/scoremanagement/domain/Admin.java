package com.scoremanagement.domain;

public class Admin {
	// Field
	private String admin_id;
	private String admin_pw;

	// Constructor
	public Admin() {

	}

	public Admin(String admin_id, String admin_pw) {
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
	}

	// Getter
	public String getAdmin_id() {
		return admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	// Setter
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
}
