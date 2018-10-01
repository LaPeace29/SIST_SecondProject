package com.scoremanagement.domain;

import java.sql.Date;

public class StudentHistory {

	// Field
	private String student_id;			// ������ ���̵�
	private String open_course_id;		// ���� ���� ���̵�
	private Date dropout_date;			// �ߵ� Ż����
	
	// Constructor
	public StudentHistory() {
		
	}

	// ������ �����丮 �߰��� ���
	public StudentHistory(String student_id, String open_course_id) {
		this.student_id = student_id;
		this.open_course_id = open_course_id;
	}

	// ������ �ߵ�Ż�� �߰��� ���
	public StudentHistory(String student_id, String open_course_id, Date dropout_date) {
		this.student_id = student_id;
		this.open_course_id = open_course_id;
		this.dropout_date = dropout_date;
	}

	// Getter
	public String getStudent_id() {
		return student_id;
	}

	public String getOpen_course_id() {
		return open_course_id;
	}

	public Date getDropout_date() {
		return dropout_date;
	}

	// Setter
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
	}

	public void setDropout_date(Date dropout_date) {
		this.dropout_date = dropout_date;
	}
	
	
}
