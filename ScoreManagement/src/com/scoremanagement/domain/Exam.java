package com.scoremanagement.domain;

import java.sql.Date;

public class Exam {
	
	// Field
	private String exam_id;				// 시험 아이디
	private String subject_name;		// 과목 이름
	private String subjectbook_name;	// 교재 이름
	private Date subject_start_date;	// 과목 시작일
	private Date subject_end_Date;		// 과목 종료일
	private String instructor_name;		// 강사 이름
	private int attendance_point;		// 출결 배점
	private int write_point;			// 필기 배점
	private int skill_point;			// 실기 배점
	private Date exam_date;				// 시험 날짜
	private String exam_file;			// 시험 문제 파일
	private String student_id;			// 수강생 아이디
	private String student_name;		// 수강생 이름
	private String student_phone;		// 수강생 휴대폰번호
	private Date student_regDate;		// 수강생 등록일
	private int attendance_score;		// 출결 점수
	private int write_score;			// 필기 점수
	private int skill_score;			// 실기 점수
	private int total_score;			// 총점
	private int class_count;			// 수강 횟수
	private String completion_status;	// 수료 여부
	private Date completion_date;		// 날짜(수료 or 중도탈락)
	private String score_status;		// 성적 입력 여부(관리자 20번 참고)


}
