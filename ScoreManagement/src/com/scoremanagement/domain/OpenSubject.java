package com.scoremanagement.domain;

import java.sql.Date;

public class OpenSubject {
	
	// Field
	private String open_subject_id;			// 개설 과목 아이디
	private String subject_id;				// 과목 아이디
	private String subject_name;			// 과목 이름
	private String subjectbook_id;			// 교재 아이디
	private String subjectbook_name;		// 교재 이름
	private String instructor_id;			// 강사 아이디
	private String instructor_name;			// 강사 이름
	private String open_course_id;			// 개설 과정 아이디
	private String course_name;				// 과정 이름
	private Date subject_start_date;		// 과목 시작일
	private Date subject_end_date;			// 과목 종료일
	private Date open_course_start_date;	// 개설 과정 시작일
	private Date open_course_end_date;		// 개설 과정 종료일
	private String class_room_name;			// 강의실 이름
	private int student_count;				// 수강생 등록 인원
	private String instructor_status;		// 강사 진행 여부(강의진행전, 강의진행중, 강의종료)
	private int count_;						// 삭제 가능 여부
}
