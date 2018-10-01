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
}
