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
}
