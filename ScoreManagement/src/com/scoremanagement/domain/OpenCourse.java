package com.scoremanagement.domain;

import java.sql.Date;

public class OpenCourse {
	
	private String open_course_id;			// ���� ���� ���̵�
	private String class_room_id;			// ���ǽ� ���̵�
	private String class_room_name;
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

	
}
