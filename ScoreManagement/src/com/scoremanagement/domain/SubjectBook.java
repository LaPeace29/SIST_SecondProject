package com.scoremanagement.domain;

public class SubjectBook {
	// Field
	private String subjectbook_id;
	private String subjectbook_name;
	private String subjectbook_publisher;
	private int count_;
	
	// Constructor
	public SubjectBook() {
	
	}

	public SubjectBook(String subjectbook_id, String subjectbook_name, String subjectbook_publisher) {
		this.subjectbook_id = subjectbook_id;
		this.subjectbook_name = subjectbook_name;
		this.subjectbook_publisher = subjectbook_publisher;
	}
	
	public SubjectBook(String subjectbook_id, String subjectbook_name, String subjectbook_publisher, int count_) {
		this.subjectbook_id = subjectbook_id;
		this.subjectbook_name = subjectbook_name;
		this.subjectbook_publisher = subjectbook_publisher;
		this.count_ = count_;
	}

	// Getter
	public String getSubjectbook_id() {
		return subjectbook_id;
	}

	public String getSubjectbook_name() {
		return subjectbook_name;
	}

	public String getSubjectbook_publisher() {
		return subjectbook_publisher;
	}

	public int getCount_() {
		return count_;
	}

	// Setter
	public void setSubjectbook_name(String subjectbook_name) {
		this.subjectbook_name = subjectbook_name;
	}

	public void setSubjectbook_publisher(String subjectbook_publisher) {
		this.subjectbook_publisher = subjectbook_publisher;
	}

	// print method
	// Return 교재번호 / 교재이름 / 교재출판사
	public String print1() {
		String result = "";
		result = String.format("%s / %s / %s", 
				this.getSubjectbook_id(), this.getSubjectbook_name(), this.getSubjectbook_publisher());
		return result;
	}

	// Return 교재번호 / 교재이름 / 교재출판사 / 삭제가능여부
	public String print2() {
		String result = "";
		result = String.format("%s / %s / %s / %s", 
				this.getSubjectbook_id(), this.getSubjectbook_name(), this.getSubjectbook_publisher(), 
				(getCount_() > 0 ? 'X' : 'O'));
		return result;
	}
}
