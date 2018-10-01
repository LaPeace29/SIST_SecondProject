package com.scoremanagement.domain;

import java.sql.Date;

public class Student {

	// Field
	private String student_id;			// ������ ���̵�
	private String student_name;		// ������ �̸�
	private String student_phone;		// ������ �޴�����ȣ
	private Date student_regDate;		// ������ �����
	private String student_pw;			// ������ ��й�ȣ
	private String completion_status;	// ���� ����(���� ����, ���� �Ϸ�, �ߵ� Ż��)
	private Date completeion_date;		// ��¥(�ߵ�Ż��, ����)
	private int count_;					// ���� ���� ����
	
	// Constructor
	public Student() {
		
	}

	// ������ �α��ν� ���
	public Student(String student_id, String student_pw) {
		this.student_id = student_id;
		this.student_pw = student_pw;
	}

	// �������̸� / ��������ȭ��ȣ
	// ��������ȣ / �������̸� / ��������ȭ��ȣ / �����������
	public Student(String student_id, String student_name, String student_phone, Date student_regDate) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone = student_phone;
		this.student_regDate = student_regDate;
	}
	
	// ������ �߰��� ���
	public Student(String student_id, String student_name, String student_phone, Date student_regDate,
			String student_pw) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone = student_phone;
		this.student_regDate = student_regDate;
		this.student_pw = student_pw;
	}

	// ��������ȣ / �������̸� / ��������ȭ��ȣ / ����������� / ����Ƚ��
	public Student(String student_id, String student_name, String student_phone, Date student_regDate, int count_) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone = student_phone;
		this.student_regDate = student_regDate;
		this.count_ = count_;
	}

	// ��������ȣ / �������̸� / ��������ȭ��ȣ / ����������� / ���Ῡ�� / ��¥
	public Student(String student_id, String student_name, String student_phone, Date student_regDate,
			String completion_status, Date completeion_date) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone = student_phone;
		this.student_regDate = student_regDate;
		this.completion_status = completion_status;
		this.completeion_date = completeion_date;
	}

	// Getter
	public String getStudent_id() {
		return student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public String getStudent_phone() {
		return student_phone;
	}

	public Date getStudent_regDate() {
		return student_regDate;
	}

	public String getStudent_pw() {
		return student_pw;
	}

	public String getCompletion_status() {
		return completion_status;
	}

	public Date getCompleteion_date() {
		return completeion_date;
	}

	public int getCount_() {
		return count_;
	}

	// Setter
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}

	public void setStudent_regDate(Date student_regDate) {
		this.student_regDate = student_regDate;
	}

	public void setStudent_pw(String student_pw) {
		this.student_pw = student_pw;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	public void setCompleteion_date(Date completeion_date) {
		this.completeion_date = completeion_date;
	}
	
	// print method
}
