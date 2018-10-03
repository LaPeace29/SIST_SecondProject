package com.scoremanagement.service;

import java.util.List;
import java.util.Scanner;

import com.scoremanagement.domain.OpenCourse;
import com.scoremanagement.domain.Student;
import com.scoremanagement.persistance.ExamDAO;
import com.scoremanagement.persistance.OpenCourseDAO;
import com.scoremanagement.persistance.OpenSubjectDAO;
import com.scoremanagement.persistance.StudentDAO;

public class ServiceStudent {

	private OpenCourseDAO ocDAO = new OpenCourseDAO();
	private OpenSubjectDAO osDAO = new OpenSubjectDAO();
	private ExamDAO eDAO = new ExamDAO(); 
	private StudentDAO stDAO = new StudentDAO();
	
	private String student_name = null;
	private String student_id = null;
	
	// 성적 처리 시스템 v6.0 > 1. 수강생 로그인
	public void login(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 > 1. 수강생 로그인");
		System.out.print("이름 > ");
		student_name = sc.nextLine();
		
		System.out.print("비밀번호 > ");
		String student_pw = sc.nextLine();
		
		Student s = new Student(student_name, student_pw);
		student_id = this.stDAO.login(s);
		
		if(student_id != null) {
			System.out.printf("수강생 '%s'님이 로그인되었습니다.\n", student_name);
			this.main(sc);
		} else {
			 System.out.println("아이디 또는 패스워드가 틀렸습니다.");
		}
	}
	
	// 성적 처리 시스템 v6.0 (수강생 : OOO) 
	private void main(Scanner sc) {
		while(true) {
			
			System.out.println("---------------------------------------------------------------");
			System.out.println("성적 처리 시스템 v6.0 (수강생 : %s) ");
			System.out.println("1. 성적 조회  2. 개인 정보");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			sc.nextLine();
			
			if(num == 0) {
				break;
			}
			
			switch(num) {
			case 1: this.m1(sc);
				break;
				
			case 2: this.m2(sc);
				break;
				
			default :
				System.out.println("없는 번호입니다.");
				break;
			}
		}
	}
	
	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 1. 성적 조회
	private void m1(Scanner sc) {
		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("성적 처리 시스템 v6.0 (수강생 : %s) > 1. 성적 조회");
			System.out.println("-------------------------------");
			System.out.println("개설 과정 번호 / 개설 과정명 / 개설 과정 기간");
			this.ocDAO.print7();
			/* OpenCourseDAO print7() */

			/*
			 * OC0001 / 웹기반 빅데이터 분석 응용 SW 개발자 / 2018-01-02 ~ 2018-05-06 OC0015 / Java &
			 * Python 기반 응용 SW 개발자 양성 과정 / 2018-06-25 ~ 2019-01-17
			 */
			System.out.println("-------------------------------");
			System.out.println("총 %d 건");

			System.out.print("개설 과정 번호 > ");
			String open_course_id = sc.nextLine();
		}
	}
	
	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 1. 성적 조회 > 개설 과정명
	private void m1_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (수강생 : 조인성) > 1. 성적 조회 > 웹기반 빅데이터 분석 응용 SW 개발자");

		System.out.print("개설 과정 번호 : ");
		System.out.print("개설 과정명 : ");
		System.out.print("개설 과정 기간 : ");
		System.out.print("강의실 : ");
		System.out.print("수료 여부 : ");
		System.out.print("중도탈락 날짜 : ");
		/* OpenCourse print5() */
		this.ocDAO.print5(this.student_id);

		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간");
		/* OpenSubjectDAO print8() */
		this.osDAO.print8();
		System.out.println("-------------------------------");
		System.out.println("총 %d 건");

		System.out.print("개설 과목 번호 > ");
		String open_subject_id = sc.nextLine();
		System.out.print("양성 과정 > ");
		String open_course_id = sc.nextLine();

		System.out.println("---------------------------------------------------------------");
		System.out.print("개설 과목명 : ");
		System.out.print("개설 과목 기간 :");
		/* OpenSubjectDAO print3() */
		this.ocDAO.print3();

		System.out.println("-------------------------------");
		System.out.print("교재명 : ");
		System.out.print("강사명 : ");
		System.out.print("출결배점 : ");
		System.out.print("필기배점 : ");
		System.out.print("실기배점 : ");
		System.out.print("출결점수 : ");
		System.out.print("필기점수 : ");
		System.out.print("실기점수 : ");
		System.out.print("시험날짜 : ");
		System.out.print("시험문제 : ");
		/* ExamDAO print6() */
		this.eDAO.print6();
		System.out.println("-------------------------------");
		System.out.println("총 %d건");
	}
	
	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 2. 개인 정보
	private void m2(Scanner sc) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("성적 처리 시스템 v6.0 (수강생 : %s) > 2. 개인 정보\n", this.student_name);
			System.out.println("1. 개인 정보 조회  2. 비밀 번호 변경");
			System.out.print("선택 > ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			
			switch(selectNum) {
			case 1:
				this.m2_s1();
				break;
				
			case 2:
				this.m2_s2(sc);
				break;
	
			case 0:
				run = false;
				break;
				
			default:
				System.out.println("없는 번호입니다.");
				break;
			}
		}
	}
	
	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 2. 개인 정보 > 1. 개인 정보 조회
	private void m2_s1() {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("성적 처리 시스템 v6.0 (수강생 : %s) > 2. 개인 정보 > 1. 개인 정보 조회\n", this.student_name);
		List<Student> list = this.stDAO.print2(this.student_id);
		for(Student s : list) {
			System.out.printf("수강생 번호 : %s\n", s.getStudent_id());
			System.out.printf("이름 : %s\n", s.getStudent_name());
			System.out.printf("휴대폰 번호 : %s\n", s.getStudent_phone());
			System.out.printf("등록일 : %s\n", s.getStudent_regDate());
			System.out.println();
		}
		
		List<OpenCourse> list2 = this.ocDAO.print5(this.student_id);
		
		if(list2.size() > 0) {
			System.out.println("-------------------------------");
			
			for(OpenCourse oc : list2) {
				System.out.printf("개설 과정명 : %s\n", oc.getCourse_name());
				System.out.printf("개설 과정 기간 : %s ~ %s\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
				System.out.printf("강의실 : %s\n", oc.getClass_room_name());
				System.out.printf("수료 여부 : %s\n", oc.getCompletion_status());
				System.out.printf("%s 날짜 : %s\n", oc.getCompletion_status(), oc.getDropout_date());
				System.out.println();
			}
			System.out.println("-------------------------------");
			System.out.printf("과정 수강 횟수 : %d번\n", list2.size());
		}
	}
	
	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 2. 개인 정보 > 2. 비밀 번호 변경
	private void m2_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("성적 처리 시스템 v6.0 (수강생 : %s) > 2. 개인 정보 > 2. 비밀 번호 변경\n", this.student_name);
		System.out.print("현재 비밀번호 > ");
		String student_pw = sc.nextLine();
		System.out.print("신규 비밀번호 > ");
		String student_new_pw = sc.nextLine();
		System.out.print("비밀번호 확인 > ");
		String student_new_pw2 = sc.nextLine();

		System.out.println("비밀번호를 변경하시겠습니까? (0/1) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();

		if (student_new_pw.equals(student_new_pw2)) {
			if (selectNum == 1) {
				int result = this.stDAO.modify(new Student(this.student_name, student_pw, student_new_pw));

				if (result > 0) {
					System.out.printf("수강생 '%s'의 비밀번호가 변경되었습니다.\n", this.student_name);
				} else {
					System.out.println("실패했습니다.");
				}
			}
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}

		/*
		 * // Field private String student_id; // 수강생 아이디 private String student_name;
		 * // 수강생 이름 private String student_phone; // 수강생 휴대폰번호 private Date
		 * student_regDate; // 수강생 등록일 private String student_pw; // 수강생 비밀번호 private
		 * String completion_status; // 수료 여부(수료 예정, 수료 완료, 중도 탈락) private Date
		 * completeion_date; // 날짜(중도탈락, 수료) private int count_; // 삭제 가능 여부
		 */
	}
}
