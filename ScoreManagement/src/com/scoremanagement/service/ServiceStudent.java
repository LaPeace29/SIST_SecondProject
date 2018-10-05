package com.scoremanagement.service;

import java.util.List;
import java.util.Scanner;

import com.scoremanagement.domain.Exam;
import com.scoremanagement.domain.OpenCourse;
import com.scoremanagement.domain.OpenSubject;
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
		this.student_name = sc.nextLine();

		System.out.print("비밀번호 > ");
		String student_pw = sc.nextLine();

		Student s = new Student(this.student_name, student_pw, "");
		this.student_id = this.stDAO.login(s);

		if (student_id != null) {
			System.out.printf("수강생 '%s'님이 로그인되었습니다.\n", this.student_name);
			this.main(sc);
		} else {
			System.out.println("아이디 또는 패스워드가 틀렸습니다.");
		}
	}

	// 성적 처리 시스템 v6.0 (수강생 : OOO)
	private void main(Scanner sc) {
		while (true) {

			System.out.println("---------------------------------------------------------------");
			System.out.printf("성적 처리 시스템 v6.0 (수강생 : %s)%n ", this.student_name);
			System.out.println("1. 성적 조회  2. 개인 정보");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			sc.nextLine();

			if (num == 0) {
				break;
			}

			switch (num) {
			case 1:
				this.m1(sc);
				break;

			case 2:
				this.m2(sc);
				break;

			default:
				System.out.println("없는 번호입니다.");
				break;
			}
		}
	}

	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 1. 성적 조회
	private void m1(Scanner sc) {
		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("성적 처리 시스템 v6.0 (수강생 : %s) > 1. 성적 조회 %n", this.student_name);
			System.out.println("-------------------------------");
			System.out.println("개설 과정 번호 / 개설 과정명 / 개설 과정 기간");

			List<OpenCourse> list = this.ocDAO.print7(this.student_id);
			for (OpenCourse s : list) {
				System.out.println(s.print7());
			}
			/* OpenCourseDAO print7() */

			/*
			 * OC0001 / 웹기반 빅데이터 분석 응용 SW 개발자 / 2018-01-02 ~ 2018-05-06 OC0015 / Java &
			 * Python 기반 응용 SW 개발자 양성 과정 / 2018-06-25 ~ 2019-01-17
			 */
			System.out.println("-------------------------------");
			System.out.printf("총 %d 건 %n", list.size());
			this.m1_s1(sc);

		}
	}

	// 성적 처리 시스템 v6.0 (수강생 : OOO) > 1. 성적 조회 > 개설 과정명
	private void m1_s1(Scanner sc) {

		System.out.print("개설 과정 번호 > ");
		String open_course_id = sc.nextLine();

		List<OpenCourse> list1 = this.ocDAO.print5("open_course_id", this.student_id, open_course_id);

		if (list1.size() > 0) {

			for (OpenCourse oc : list1) {
				System.out.println("---------------------------------------------------------------");
				System.out.printf("성적 처리 시스템 v6.0 (수강생 : 조인성) > 1. 성적 조회 > %s", oc.getCourse_name());
				System.out.printf("개설 과정 번호 : %s%n", oc.getOpen_course_id());
				System.out.printf("개설 과정명 : %s%n", oc.getCourse_name());
				System.out.printf("개설 과정 기간 : %s ~ %s %n", oc.getOpen_course_start_date(),
						oc.getOpen_course_end_date());
				System.out.printf("강의실 : %s%n", oc.getClass_room_name());
				System.out.printf("수료 여부 : %s%n", oc.getCompletion_status());
				System.out.printf("중도탈락 날짜 : %s%n%n", oc.getDropout_date());
			}

			/* OpenCourse print5() */

		}
		List<OpenSubject> list2 = this.osDAO.print8(this.student_id, open_course_id);

		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간");

		for (OpenSubject os : list2) {
			System.out.println(os.print8());
		}
		/* OpenSubjectDAO print8() */

		System.out.println("-------------------------------");
		System.out.printf("총 %d 건%n", list2.size());

		System.out.print("개설 과목 번호 > ");
		String open_subject_id = sc.nextLine();

		System.out.println("---------------------------------------------------------------");
		List<OpenSubject> list3 = this.osDAO.print3(this.student_id, open_subject_id);
		for (OpenSubject os : list3) {
			System.out.printf("개설 과목명 : %s%n", os.getSubject_name());
			System.out.printf("개설 과목 기간 : %s~%s%n", os.getSubject_start_date(), os.getSubject_end_date());

		}

		/* OpenSubjectDAO print3() */

		List<Exam> list4 = this.eDAO.print6(open_subject_id, this.student_id);

		if (list4.size() > 0) {

			for (Exam e : list4) {

				System.out.println("-------------------------------");
				System.out.printf("교재명 : %s%n", e.getSubjectbook_name());
				System.out.printf("강사명 : %s%n", e.getInstructor_name());
				System.out.printf("출결배점 : %s%n", e.getAttendance_point());
				System.out.printf("필기배점 : %s%n", e.getWrite_point());
				System.out.printf("실기배점 : %s%n", e.getSkill_point());
				System.out.printf("출결점수 : %s%n", e.getAttendance_score());
				System.out.printf("필기점수 : %s%n", e.getWrite_score());
				System.out.printf("실기점수 : %s%n", e.getSkill_score());
				System.out.printf("시험날짜 : %s%n", e.getExam_date());
				System.out.printf("시험문제 : %s%n", e.getExam_file());

			}
		}

		System.out.println("-------------------------------");
		System.out.printf("총 %d건%n", list4.size());
		this.main(sc);

		/* ExamDAO print6() */

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
		List<Student> list = this.stDAO.print2("student_id", this.student_id);
		for(Student s : list) {
			System.out.printf("수강생 번호 : %s\n", s.getStudent_id());
			System.out.printf("이름 : %s\n", s.getStudent_name());
			System.out.printf("휴대폰 번호 : %s\n", s.getStudent_phone());
			System.out.printf("등록일 : %s\n", s.getStudent_regDate());
			System.out.println();
		}
		
		List<OpenCourse> list2 = this.ocDAO.print5("student_id", this.student_id, null);
		
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
