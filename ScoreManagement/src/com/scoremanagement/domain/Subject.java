package com.scoremanagement.domain;

public class Subject {
	// Field
	private String subject_id;
	private String subject_name;
	private int count_;
	
	// Constructor
	public Subject() {
	
	}

	public Subject(String subject_id, String subject_name) {
		this.subject_id = subject_id;
		this.subject_name = subject_name;
	}
	
	public Subject(String subject_id, String subject_name, int count_) {
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.count_ = count_;
	}

	// Getter
	public String getSubject_id() {
		return subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public int getCount_() {
		return count_;
	}

	// Setter
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	// print method
	// Return �����ȣ / �����̸�
	public String print1() {
		String result = "";
		result = String.format("%s / %s", 
				this.getSubject_id(), this.getSubject_name());
		return result;
	}

	// Return �����ȣ / �����̸� / �������ɿ���
	public String print2() {
		String result = "";
		result = String.format("%s / %s / %s", 
				this.getSubject_id(), this.getSubject_name(), (getCount_() > 0 ? 'X' : 'O'));
		return result;
	}
}
