package com.scoremanagement.domain;

import java.sql.Date;

public class Instructor {
	
	private String instructor_id;		// 강사 아이디
	private String instructor_name;		// 강사 이름
	private String instructor_phone;	// 강사 휴대폰 번호
	private Date instructor_regDate;	// 강사 등록일
	private String instructor_pw;		// 강사 비밀번호
	private String instructor_possible;	// 강의 가능 과목 나열
	private int count_;					// 삭제 가능 여부
}
