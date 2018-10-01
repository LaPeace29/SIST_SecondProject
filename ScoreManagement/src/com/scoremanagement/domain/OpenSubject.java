package com.scoremanagement.domain;

import java.sql.Date;

public class OpenSubject {
	
	// Field
	private String open_subject_id;			// ���� ���� ���̵�
	private String subject_id;				// ���� ���̵�
	private String subject_name;			// ���� �̸�
	private String subjectbook_id;			// ���� ���̵�
	private String subjectbook_name;		// ���� �̸�
	private String instructor_id;			// ���� ���̵�
	private String instructor_name;			// ���� �̸�
	private String open_course_id;			// ���� ���� ���̵�
	private String course_name;				// ���� �̸�
	private Date subject_start_date;		// ���� ������
	private Date subject_end_date;			// ���� ������
	private Date open_course_start_date;	// ���� ���� ������
	private Date open_course_end_date;		// ���� ���� ������
	private String class_room_name;			// ���ǽ� �̸�
	private int student_count;				// ������ ��� �ο�
	private String instructor_status;		// ���� ���� ����(����������, ����������, ��������)
	private int count_;						// ���� ���� ����
	
	// Constructor
	public OpenSubject() {

	}
	
	// ���������ȣ / ����� / ����Ⱓ / ���
	public OpenSubject(String open_subject_id, String subject_name, Date subject_start_date, Date subject_end_date,
			String instructor_status) {
		this.open_subject_id = open_subject_id;
		this.subject_name = subject_name;
		this.subject_start_date = subject_start_date;
		this.subject_end_date = subject_end_date;
		this.instructor_status = instructor_status;
	}

	// ���� ���� �߰��Ҷ� ���
	public OpenSubject(String open_subject_id, String subject_id, String subjectbook_id, String instructor_id,
			String open_course_id, Date subject_start_date, Date subject_end_date) {
		this.open_subject_id = open_subject_id;
		this.subject_id = subject_id;
		this.subjectbook_id = subjectbook_id;
		this.instructor_id = instructor_id;
		this.open_course_id = open_course_id;
		this.subject_start_date = subject_start_date;
		this.subject_end_date = subject_end_date;
	}

	// ��������� / ��������Ⱓ
	// ���������ȣ / ��������� / ��������Ⱓ / ����� / �����
	// ��������� / ��������Ⱓ / ����� / �����
	// ���������ȣ / ��������� / ��������Ⱓ / ����� / ����� / ���������� / ���������Ⱓ / ���ǽ�
	// ���������ȣ / ����� / ��������Ⱓ
	public OpenSubject(String open_subject_id, String subject_name, String subjectbook_name, String instructor_name,
			String course_name, Date subject_start_date, Date subject_end_date, Date open_course_start_date,
			Date open_course_end_date, String class_room_name) {
		this.open_subject_id = open_subject_id;
		this.subject_name = subject_name;
		this.subjectbook_name = subjectbook_name;
		this.instructor_name = instructor_name;
		this.course_name = course_name;
		this.subject_start_date = subject_start_date;
		this.subject_end_date = subject_end_date;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
	}
	
	// ���������ȣ / ��������� / ��������Ⱓ / ����� / ����� / ���������� / ���������Ⱓ / ���ǽ� / �������ɿ���
	public OpenSubject(String open_subject_id, String subject_name, String subjectbook_name, String instructor_name,
			String course_name, Date subject_start_date, Date subject_end_date, Date open_course_start_date,
			Date open_course_end_date, String class_room_name, int count_) {
		this.open_subject_id = open_subject_id;
		this.subject_name = subject_name;
		this.subjectbook_name = subjectbook_name;
		this.instructor_name = instructor_name;
		this.course_name = course_name;
		this.subject_start_date = subject_start_date;
		this.subject_end_date = subject_end_date;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
		this.count_ = count_;
	}

	// ���������ȣ / ���������� / ���������Ⱓ / ���ǽ� / ��������� / ��������Ⱓ / ����� / ����������ο�
	public OpenSubject(String open_subject_id, String subject_name, String subjectbook_name, String course_name,
			Date subject_start_date, Date subject_end_date, Date open_course_start_date, Date open_course_end_date,
			String class_room_name, int student_count) {
		this.open_subject_id = open_subject_id;
		this.subject_name = subject_name;
		this.subjectbook_name = subjectbook_name;
		this.course_name = course_name;
		this.subject_start_date = subject_start_date;
		this.subject_end_date = subject_end_date;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
		this.student_count = student_count;
	}

	// ��������� / ��������Ⱓ / ���������� / ���������Ⱓ / ���ǽ� / �������࿩��
	public OpenSubject(String subject_name, String course_name, Date subject_start_date, Date subject_end_date,
			Date open_course_start_date, Date open_course_end_date, String class_room_name, String instructor_status) {
		this.subject_name = subject_name;
		this.course_name = course_name;
		this.subject_start_date = subject_start_date;
		this.subject_end_date = subject_end_date;
		this.open_course_start_date = open_course_start_date;
		this.open_course_end_date = open_course_end_date;
		this.class_room_name = class_room_name;
		this.instructor_status = instructor_status;
	}

	// Getter
	public String getOpen_subject_id() {
		return open_subject_id;
	}

	public String getSubject_id() {
		return subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public String getSubjectbook_id() {
		return subjectbook_id;
	}

	public String getSubjectbook_name() {
		return subjectbook_name;
	}

	public String getInstructor_id() {
		return instructor_id;
	}

	public String getInstructor_name() {
		return instructor_name;
	}

	public String getOpen_course_id() {
		return open_course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public Date getSubject_start_date() {
		return subject_start_date;
	}

	public Date getSubject_end_date() {
		return subject_end_date;
	}

	public Date getOpen_course_start_date() {
		return open_course_start_date;
	}

	public Date getOpen_course_end_date() {
		return open_course_end_date;
	}

	public String getClass_room_name() {
		return class_room_name;
	}

	public int getStudent_count() {
		return student_count;
	}

	public String getInstructor_status() {
		return instructor_status;
	}

	public int getCount_() {
		return count_;
	}

	// Setter
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public void setSubjectbook_id(String subjectbook_id) {
		this.subjectbook_id = subjectbook_id;
	}

	public void setSubjectbook_name(String subjectbook_name) {
		this.subjectbook_name = subjectbook_name;
	}

	public void setInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}

	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public void setOpen_course_id(String open_course_id) {
		this.open_course_id = open_course_id;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public void setSubject_start_date(Date subject_start_date) {
		this.subject_start_date = subject_start_date;
	}

	public void setSubject_end_date(Date subject_end_date) {
		this.subject_end_date = subject_end_date;
	}

	public void setOpen_course_start_date(Date open_course_start_date) {
		this.open_course_start_date = open_course_start_date;
	}

	public void setOpen_course_end_date(Date open_course_end_date) {
		this.open_course_end_date = open_course_end_date;
	}

	public void setClass_room_name(String class_room_name) {
		this.class_room_name = class_room_name;
	}

	public void setStudent_count(int student_count) {
		this.student_count = student_count;
	}

	public void setInstructor_status(String instructor_status) {
		this.instructor_status = instructor_status;
	}
	
	// print method
}
