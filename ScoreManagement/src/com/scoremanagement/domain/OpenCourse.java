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
	private String subject_list;			// ���� �����
	private int open_subject_count;			// ���� ���� ��� ����
	private String student_id;				// ������ ���̵�
	private String student_name;			// ������ �̸�
	private int student_count;				// ������ ��� �ο�
	private int count_;						// ���� ���� ����
	private String completion_status;		// ���� ����
	private Date dropout_date;				// ����orŻ�� ��¥


	// Constructor
	public OpenCourse() {

	}

	// ���� ������ �л� �Բ� �˻��� ���
	// �л� ���̵� �̸��� �ʿ�
	public OpenCourse(String open_course_id, String course_name, String student_id, String student_name) {
		this.open_course_id = open_course_id;
		this.course_name = course_name;
		this.student_id = student_id;
		this.student_name = student_name;
	}

	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ����
	public OpenCourse(String open_course_id, String course_name, Date open_course_start_date,
			Date open_course_end_date, String class_room_name, int count_) {
		this.open_course_id = open_course_id;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
		this.count_ = count_;
	}

	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� �����
	public OpenCourse(String open_course_id, String course_name, Date open_course_start_date,
			Date open_course_end_date, String class_room_name, String subject_list) {
		this.open_course_id = open_course_id;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
		this.subject_list = subject_list;
	}

	// ���� ���� �߰��� �� ���
	// ���� ���� ������ �� ���
	// ���� ���� �˻��� �� ���
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ�
	public OpenCourse(String open_course_id, String course_id, String course_name, Date open_course_start_date,
			Date open_course_end_date, String class_room_id, String class_room_name) {
		this.open_course_id = open_course_id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_id = class_room_id;
		this.class_room_name = class_room_name;
	}
	
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�
	public OpenCourse(String open_course_id, String course_name, Date open_course_start_date,
			Date open_course_end_date, String class_room_name, int open_subject_count, int student_count) {
		this.open_course_id = open_course_id;
		this.course_name = course_name;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
		this.open_subject_count = open_subject_count;
		this.student_count = student_count;
	}

	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���Ῡ�� / ��¥
	public OpenCourse(String open_course_id, String course_name, Date open_course_start_date,
			Date open_course_end_date, String class_room_name, String completion_status, Date dropout_date) {
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

	public String getStudent_id() {
		return student_id;
	}

	public String getStudent_name() {
		return student_name;
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

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	public void setDropout_date(Date dropout_date) {
		this.dropout_date = dropout_date;
	}
	
	// print method
	public String print1() {
		String result = "";
		result = String.format("%s / %s / %s ~ %s / %s", 
				this.getOpen_course_id(), this.getCourse_name(), 
				this.getOpen_course_start_date(), this.getOpen_course_end_date(), this.getClass_room_name());
		return result;
	}

	public String print2() {
		String result = "";
		result = String.format("%s / %s / %s ~ %s / %s / %d�� / %d��", 
				this.getOpen_course_id(), this.getCourse_name(),
				this.getOpen_course_start_date(), this.getOpen_course_end_date(), this.getClass_room_name(),
				this.getOpen_subject_count(), this.getStudent_count());
		return result;
	}
	
	public String print3() {
		String result = String.format("%s / %s / %s / %s ~ %s / %s\n", 
				this.getOpen_course_id(), this.getClass_room_name(), this.getCourse_name(), 
				this.getOpen_course_start_date(), this.getOpen_course_end_date(),
				(this.getCount_() > 0 ? 'X' : 'O'));
		return result;
	}
	
	public String print4() {
		String result = String.format("%s / %s / %s ~ %s / %s / %s",
				this.getOpen_course_id(), this.getCourse_name(),
				this.getOpen_course_start_date(), this.getOpen_course_end_date(),
				this.getClass_room_name(), this.getSubject_list());
		return result;
	}
	
	public String print7() {
		String result = "";
		result = String.format("%s / %s / %s ~ %s", 
				this.getOpen_course_id(), this.getCourse_name(), this.getOpen_course_start_date(), this.getOpen_course_end_date());
		return result;
	}
}
