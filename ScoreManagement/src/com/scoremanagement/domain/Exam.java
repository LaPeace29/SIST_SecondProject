package com.scoremanagement.domain;

import java.sql.Date;

public class Exam {
	
	// Field
	private String exam_id;				// ���� ���̵�
	private String subject_name;		// ���� �̸�
	private String subjectbook_name;	// ���� �̸�
	private Date subject_start_date;	// ���� ������
	private Date subject_end_Date;		// ���� ������
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


}
