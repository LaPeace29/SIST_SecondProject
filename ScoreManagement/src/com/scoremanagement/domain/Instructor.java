package com.scoremanagement.domain;

import java.sql.Date;

public class Instructor {
	
	// Field
	private String instructor_id;		// ���� ���̵�
	private String instructor_name;		// ���� �̸�
	private String instructor_phone;	// ���� �޴��� ��ȣ
	private Date instructor_regDate;	// ���� �����
	private String instructor_pw;		// ���� ��й�ȣ
	private String instructor_new_pw;	// ���� �� ��й�ȣ
	private String instructor_possible;	// ���� ���� ���� ����
	private int count_;					// ���� ���� ����
	
	// Constructor
	public Instructor() {

	}

	// ���� ��й�ȣ �ʱ�ȭ�� ���
	public Instructor(String instructor_id, String instructor_pw) {
		this.instructor_id = instructor_id;
		this.instructor_pw = instructor_pw;
	}

	// ���� �α��ν� ���
	// ���� ��й�ȣ ������ ���
	public Instructor(String instructor_name, String instructor_pw, String instructor_new_pw) {
		this.instructor_name = instructor_name;
		this.instructor_pw = instructor_pw;
		this.instructor_new_pw = instructor_new_pw;
	}

	public Instructor(String instructor_id, String instructor_name, String instructor_phone, Date instructor_regDate) {
		this.instructor_id = instructor_id;
		this.instructor_name = instructor_name;
		this.instructor_phone = instructor_phone;
		this.instructor_regDate = instructor_regDate;
	}

	// ���� �߰��� ���
	public Instructor(String instructor_name, String instructor_phone, Date instructor_regDate, String instructor_pw) {
		this.instructor_name = instructor_name;
		this.instructor_phone = instructor_phone;
		this.instructor_regDate = instructor_regDate;
		this.instructor_pw = instructor_pw;
	}
	
	public Instructor(String instructor_id, String instructor_name, String instructor_phone, Date instructor_regDate,
			String instructor_possible) {
		this.instructor_id = instructor_id;
		this.instructor_name = instructor_name;
		this.instructor_phone = instructor_phone;
		this.instructor_regDate = instructor_regDate;
		this.instructor_possible = instructor_possible;
	}

	public Instructor(String instructor_id, String instructor_name, String instructor_phone, Date instructor_regDate,
			String instructor_possible, int count_) {
		this.instructor_id = instructor_id;
		this.instructor_name = instructor_name;
		this.instructor_phone = instructor_phone;
		this.instructor_regDate = instructor_regDate;
		this.instructor_possible = instructor_possible;
		this.count_ = count_;
	}

	// Getter
	public String getInstructor_id() {
		return instructor_id;
	}

	public String getInstructor_name() {
		return instructor_name;
	}

	public String getInstructor_phone() {
		return instructor_phone;
	}

	public Date getInstructor_regDate() {
		return instructor_regDate;
	}

	public String getInstructor_pw() {
		return instructor_pw;
	}
	
	public String getInstructor_new_pw() {
		return instructor_new_pw;
	}
	
	public String getInstructor_possible() {
		return instructor_possible;
	}

	public int getCount_() {
		return count_;
	}

	// Setter
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public void setInstructor_phone(String instructor_phone) {
		this.instructor_phone = instructor_phone;
	}

	public void setInstructor_regDate(Date instructor_regDate) {
		this.instructor_regDate = instructor_regDate;
	}

	public void setInstructor_pw(String instructor_pw) {
		this.instructor_pw = instructor_pw;
	}	
	
	public void setInstructor_new_pw(String instructor_new_pw) {
		this.instructor_new_pw = instructor_new_pw;
	}	
	// print method
}
