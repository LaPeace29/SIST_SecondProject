package com.scoremanagement.domain;

import java.sql.Date;

public class Student {

	// Field
	private String student_id;			// 수강생 아이디
	private String student_name;		// 수강생 이름
	private String student_phone;		// 수강생 휴대폰번호
	private Date student_regDate;		// 수강생 등록일
	private String student_pw;			// 수강생 비밀번호
	private String completion_status;	// 수료 여부(수료 예정, 수료 완료, 중도 탈락)
	private Date completeion_date;		// 날짜(중도탈락, 수료)
	private int count_;					// 삭제 가능 여부
}
