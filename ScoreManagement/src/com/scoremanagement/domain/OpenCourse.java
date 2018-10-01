package com.scoremanagement.domain;

import java.sql.Date;

public class OpenCourse {
	
	private String open_course_id;			// 개설 과정 아이디
	private String class_room_id;			// 강의실 아이디
	private String class_room_name;
	private String course_id;				// 과정 아이디
	private String course_name;				// 과정 이름
	private Date open_course_start_date;	// 개설 과정 시작일
	private Date open_course_end_date;		// 개설 과정 종료일
	private String subject_list;			// 개설 과목명(관리자 37번 참고)
	private int open_subject_count;			// 개설 과목 등록 갯수
	private int student_count;				// 수강생 등록 인원
	private int count_;						// 삭제 가능 여부
	private String completion_status;		// 수료 여부
	private Date dropout_date;				// 수료or탈락 날짜

	
}
