package com.scoremanagement.domain;

import java.sql.Date;

public class Exam {
	
	// Field
	private String exam_id;				// ���� ���̵�
	private String subject_project_id;	// ���� ���� ���� ���̵�
	private String student_score_id;	// ������ ���� ���� ���̵�
	private String open_subject_id;		// ���� ���� ���̵�
	private String subject_name;		// ���� �̸�
	private String subjectbook_name;	// ���� �̸�
	private Date subject_start_date;	// ���� ������
	private Date subject_end_Date;		// ���� ������
	private String instructor_id;		// ���� ���̵�
	private String instructor_name;		// ���� �̸�
	private int attendance_point;		// ��� ����
	private int write_point;			// �ʱ� ����
	private int skill_point;			// �Ǳ� ����
	private Date exam_date;				// ���� ��¥
	private String exam_file;			// ���� ���� ����
	private String student_id;			// ������ ���̵�
	private String student_name;		// ������ �̸�
	private String student_phone;		// ������ �޴�����ȣ
	private Date student_regDate;		// ������ �����
	private int attendance_score;		// ��� ����
	private int write_score;			// �ʱ� ����
	private int skill_score;			// �Ǳ� ����
	private int total_score;			// ����
	private int class_count;			// ���� Ƚ��
	private String completion_status;	// ���� ����
	private Date completion_date;		// ��¥(���� or �ߵ�Ż��)
	private String score_status;		// ���� �Է� ����(������ 20�� ����)


	// Constructor
	public Exam() {
		
	}

	// ���� ����, ���� ������ ���
	public Exam(String exam_id, String student_id, String instructor_id) {
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.instructor_id = instructor_id;
	}
	
	// ���� ��Ͻ� ���
	// �����ȣ / ������ / �ʱ���� / �Ǳ���� / ���賯¥ / ���蹮������
	public Exam(String exam_id, String open_subject_id, int attendance_point, int write_point, int skill_point,
			Date exam_date, String exam_file) {
		this.exam_id = exam_id;
		this.open_subject_id = open_subject_id;
		this.attendance_point = attendance_point;
		this.write_point = write_point;
		this.skill_point = skill_point;
		this.exam_date = exam_date;
		this.exam_file = exam_file;
	}

	// ���� ��Ͻ� ���
	public Exam(String exam_id, String student_id, int attendance_score, int write_score, int skill_score) {
		this.exam_id = exam_id;
		this.student_id = student_id;
		this.attendance_score = attendance_score;
		this.write_score = write_score;
		this.skill_score = skill_score;
	}

	// ��������ȣ / �������̸� / ��ȭ��ȣ / ������� / �ʱ����� / �Ǳ����� / ����
	public Exam(String student_id, String student_name, String student_phone, int attendance_score, int write_score,
			int skill_score, int total_score) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone = student_phone;
		this.attendance_score = attendance_score;
		this.write_score = write_score;
		this.skill_score = skill_score;
		this.total_score = total_score;
	}

	// ��������� / ��������Ⱓ / ����� / ������� / ������ / �ʱ����� / �ʱ���� / �Ǳ����� / �Ǳ���� / ���賯¥
	public Exam(String subject_name, Date subject_start_date, Date subject_end_Date, String instructor_name,
			int attendance_point, int write_point, int skill_point, Date exam_date, int attendance_score,
			int write_score, int skill_score) {
		this.subject_name = subject_name;
		this.subject_start_date = subject_start_date;
		this.subject_end_Date = subject_end_Date;
		this.instructor_name = instructor_name;
		this.attendance_point = attendance_point;
		this.write_point = write_point;
		this.skill_point = skill_point;
		this.exam_date = exam_date;
		this.attendance_score = attendance_score;
		this.write_score = write_score;
		this.skill_score = skill_score;
	}

	// �����ȣ / ������ / �ʱ���� / �Ǳ���� / ���賯¥ / ���蹮�� / ��������ο��� / ������Ͽ���
	public Exam(String exam_id, int attendance_point, int write_point, int skill_point, Date exam_date,
			String exam_file, int class_count, String score_status) {
		super();
		this.exam_id = exam_id;
		this.attendance_point = attendance_point;
		this.write_point = write_point;
		this.skill_point = skill_point;
		this.exam_date = exam_date;
		this.exam_file = exam_file;
		this.class_count = class_count;
		this.score_status = score_status;
	}

	// ��������ȣ / �������̸� / ��ȭ��ȣ / ����� / ���Ῡ�� / ��¥ / ��� / �ʱ� / �Ǳ� / ����
	public Exam(String student_id, String student_name, String student_phone, Date student_regDate,
			int attendance_score, int write_score, int skill_score, int total_score, String completion_status,
			Date completion_date) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_phone = student_phone;
		this.student_regDate = student_regDate;
		this.attendance_score = attendance_score;
		this.write_score = write_score;
		this.skill_score = skill_score;
		this.total_score = total_score;
		this.completion_status = completion_status;
		this.completion_date = completion_date;
	}

	// ����� / ����� / ������ / �ʱ���� / �Ǳ���� / ������� / �ʱ����� / �Ǳ����� / ���賯¥ / ���蹮��
	public Exam(String subjectbook_name, String instructor_name, int attendance_point, int write_point, int skill_point,
			Date exam_date, String exam_file, int write_score, int skill_score, int total_score) {
		super();
		this.subjectbook_name = subjectbook_name;
		this.instructor_name = instructor_name;
		this.attendance_point = attendance_point;
		this.write_point = write_point;
		this.skill_point = skill_point;
		this.exam_date = exam_date;
		this.exam_file = exam_file;
		this.write_score = write_score;
		this.skill_score = skill_score;
		this.total_score = total_score;
	}

	// Getter
	public String getExam_id() {
		return exam_id;
	}

	public String getSubject_project_id() {
		return subject_project_id;
	}

	public String getStudent_score_id() {
		return student_score_id;
	}

	public String getOpen_subject_id() {
		return open_subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public String getSubjectbook_name() {
		return subjectbook_name;
	}

	public Date getSubject_start_date() {
		return subject_start_date;
	}

	public Date getSubject_end_Date() {
		return subject_end_Date;
	}

	public String getInstructor_id() {
		return instructor_id;
	}
	
	public String getInstructor_name() {
		return instructor_name;
	}

	public int getAttendance_point() {
		return attendance_point;
	}

	public int getWrite_point() {
		return write_point;
	}

	public int getSkill_point() {
		return skill_point;
	}

	public Date getExam_date() {
		return exam_date;
	}

	public String getExam_file() {
		return exam_file;
	}

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

	public int getAttendance_score() {
		return attendance_score;
	}

	public int getWrite_score() {
		return write_score;
	}

	public int getSkill_score() {
		return skill_score;
	}

	public int getTotal_score() {
		return total_score;
	}

	public int getClass_count() {
		return class_count;
	}

	public String getCompletion_status() {
		return completion_status;
	}

	public Date getCompletion_date() {
		return completion_date;
	}

	public String getScore_status() {
		return score_status;
	}

	// Setter
	public void setOpen_subject_id(String open_subject_id) {
		this.open_subject_id = open_subject_id;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public void setSubjectbook_name(String subjectbook_name) {
		this.subjectbook_name = subjectbook_name;
	}

	public void setSubject_start_date(Date subject_start_date) {
		this.subject_start_date = subject_start_date;
	}

	public void setSubject_end_Date(Date subject_end_Date) {
		this.subject_end_Date = subject_end_Date;
	}

	public void getInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}
	
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public void setAttendance_point(int attendance_point) {
		this.attendance_point = attendance_point;
	}

	public void setWrite_point(int write_point) {
		this.write_point = write_point;
	}

	public void setSkill_point(int skill_point) {
		this.skill_point = skill_point;
	}

	public void setExam_date(Date exam_date) {
		this.exam_date = exam_date;
	}

	public void setExam_file(String exam_file) {
		this.exam_file = exam_file;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}

	public void setStudent_regDate(Date student_regDate) {
		this.student_regDate = student_regDate;
	}

	public void setAttendance_score(int attendance_score) {
		this.attendance_score = attendance_score;
	}

	public void setWrite_score(int write_score) {
		this.write_score = write_score;
	}

	public void setSkill_score(int skill_score) {
		this.skill_score = skill_score;
	}

	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}

	public void setClass_count(int class_count) {
		this.class_count = class_count;
	}

	public void setCompletion_status(String completion_status) {
		this.completion_status = completion_status;
	}

	public void setCompletion_date(Date completion_date) {
		this.completion_date = completion_date;
	}

	public void setScore_status(String score_status) {
		this.score_status = score_status;
	}
	
	// print method
	// 2018-10-04 ���� ����
	public String print1() {
	      String result = "";
	      result = String.format("%s / %s / %s / %d / %d / %d / %d%n", 
	            this.getStudent_id(), this.getStudent_name(), this.getStudent_phone()
	            , this.getAttendance_score(), this.getWrite_score(),this.getSkill_score()
	            , this.getTotal_score());
	      return result;
	  }
	
	// 2018-10-04 ���� ����
	public String print2() {
		String result = "";
		result = String.format("%s / %tF ~ %tF / %s / %d(%d) / %d(%d) / %d(%d) / %s", 
				this.getSubject_name(), this.getSubject_start_date(), this.getSubject_end_Date()
				, this.getInstructor_name(), this.getAttendance_score(), this.getAttendance_point()
				, this.getWrite_score(), this.getWrite_point(), this.getSkill_score()
				, this.getSkill_point(), this.getExam_date());
		return result;
	}
}
