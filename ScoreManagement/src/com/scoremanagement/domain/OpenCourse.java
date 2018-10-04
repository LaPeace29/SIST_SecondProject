package com.scoremanagement.domain;

import java.sql.Date;

public class OpenCourse {
	
	private String open_course_id;			// ���� ���� ���̵�
	private String class_room_id;			// ���ǽ� ���̵�
	private String class_room_name;			// ���ǽ� �̸�
	private String course_id;				// ���� ���̵�
	private String course_name;				// ���� �̸�
	private Date open_course_start_date;	// ���� ���� ������
	private Date open_course_end_date;		// ���� ���� ������
	private String subject_list;			// ���� �����(������ 37�� ����)
	private int open_subject_count;			// ���� ���� ��� ����
	private int student_count;				// ������ ��� �ο�
	private int count_;						// ���� ���� ����
	private String completion_status;		// ���� ����
	private Date dropout_date;				// ����orŻ�� ��¥


	// Constructor
	public OpenCourse() {

	}
	
	
	// ���� ���� ������ �� ���
	public OpenCourse(String open_course_id, String course_name) {
		this.open_course_id = open_course_id;
		this.course_name = course_name;
	}

	// ���� ���� �߰��� �� ���
	public OpenCourse(String open_course_id, String class_room_id, String course_id, Date open_course_start_date,
			Date open_course_end_date) {
		this.open_course_id = open_course_id;
		this.class_room_id = class_room_id;
		this.course_id = course_id;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
	}

	// ����������ȣ / ������ / ���������Ⱓ / ���ǽǸ�
	// ������ / ���� ���� �Ⱓ / ���ǽǸ� 
	// ����������ȣ / ������ / ���������Ⱓ
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�
	public OpenCourse(String open_course_id, String class_room_name, String course_name, Date open_course_start_date,
			Date open_course_end_date, int open_subject_count, int student_count) {
		this.open_course_id = open_course_id;
		this.class_room_name = class_room_name;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.open_subject_count = open_subject_count;
		this.student_count = student_count;
	}

	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / �������ɿ���
	public OpenCourse(String open_course_id, String class_room_name, String course_name, Date open_course_start_date,
			Date open_course_end_date, int count_) {
		this.open_course_id = open_course_id;
		this.class_room_name = class_room_name;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.count_ = count_;
	}

	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� �����
	public OpenCourse(String open_course_id, String class_room_name, String course_name, Date open_course_start_date,
			Date open_course_end_date, String subject_list) {
		this.open_course_id = open_course_id;
		this.class_room_name = class_room_name;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.subject_list = subject_list;
	}

	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���Ῡ�� / ��¥
	public OpenCourse(String open_course_id, String class_room_name, String course_name, Date open_course_start_date,
			Date open_course_end_date, String completion_status, Date dropout_date) {
		this.open_course_id = open_course_id;
		this.class_room_name = class_room_name;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.completion_status = completion_status;
		this.dropout_date = dropout_date;
	}
	
	// Getter
	public String getOpen_course_id() {
		return open_course_id;
	}

	public String getClass_room_id() {
		return class_room_id;
	}

	public String getClass_room_name() {
		return class_room_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public Date getOpen_course_start_date() {
		return open_course_start_date;
	}

	public Date getOpen_course_end_date() {
		return open_course_end_date;
	}

	public String getSubject_list() {
		return subject_list;
	}

	public int getOpen_subject_count() {
		return open_subject_count;
	}

	public int getStudent_count() {
		return student_count;
	}

	public int getCount_() {
		return count_;
	}

	public String getCompletion_status() {
		return completion_status;
	}

	public Date getDropout_date() {
		return dropout_date;
	}

	// Setter
	public void setClass_room_id(String class_room_id) {
		this.class_room_id = class_room_id;
	}

	public void setClass_room_name(String class_room_name) {
		this.class_room_name = class_room_name;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public void setOpen_course_start_date(Date open_course_start_date) {
		this.open_course_start_date = open_course_start_date;
	}

	public void setOpen_course_end_date(Date open_course_end_date) {
		this.open_course_end_date = open_course_end_date;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	public void setDropout_date(Date dropout_date) {
		this.dropout_date = dropout_date;
	}
	
	// print method
}
