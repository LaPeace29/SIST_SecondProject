package com.scoremanagement.service;

import java.util.List;
import java.util.Scanner;

import com.scoremanagement.domain.ClassRoom;
import com.scoremanagement.domain.Course;
import com.scoremanagement.domain.Instructor;
import com.scoremanagement.domain.OpenCourse;
import com.scoremanagement.domain.OpenSubject;
import com.scoremanagement.domain.Student;
import com.scoremanagement.domain.StudentHistory;
import com.scoremanagement.domain.Subject;
import com.scoremanagement.domain.Subjectbook;
import com.scoremanagement.persistance.ClassRoomDAO;
import com.scoremanagement.persistance.CourseDAO;
import com.scoremanagement.persistance.InstructorDAO;
import com.scoremanagement.persistance.OpenCourseDAO;
import com.scoremanagement.persistance.OpenSubjectDAO;
import com.scoremanagement.persistance.StudentDAO;
import com.scoremanagement.persistance.SubjectDAO;
import com.scoremanagement.persistance.SubjectbookDAO;

public class ServiceAdmin {

	private CourseDAO cDAO = new CourseDAO();
	private ClassRoomDAO crDAO = new ClassRoomDAO();
	private OpenCourseDAO ocDAO = new OpenCourseDAO();
	private OpenSubjectDAO osDAO = new OpenSubjectDAO();
	private StudentDAO stDAO = new StudentDAO();
	private SubjectDAO sDAO = new SubjectDAO();
	private SubjectbookDAO sbDAO = new SubjectbookDAO();
	private InstructorDAO iDAO = new InstructorDAO();

	// 성적 처리 시스템 v6.0 > 3. 관리자 로그인
	public void login(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin)
	private void main(Scanner sc) {

		while (true) {
			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) ");
			System.out.println("1. 기초 정보 관리  2. 강사 계정 관리  3. 개설 과정 관리  4. 개설 과목 관리  5. 수강생 관리  6. 성적 조회  7. 비밀번호 변경");
			System.out.print("선택 > ");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;
			}

			switch (select) {

			case 1:
				this.m1(sc);
				break;
			case 2:
				this.m2(sc);
				break;
			case 3:
				this.m3(sc);
				break;
			case 4:
				this.m4(sc);
				break;
			case 5:
				this.m5(sc);
				break;
			case 6:
				this.m6(sc);
				break;
			case 7:
				this.m7(sc);
				break;
			}

		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리
	private void m1(Scanner sc) {

		while (true) {
			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리");
			System.out.println("1. 과정 관리  2. 과목 관리  3. 강의실 관리  4. 교재 관리");
			System.out.println("선택 > ");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;
			}

			switch (select) {

			case 1:
				this.m1_s1(sc);
				break;
			case 2:
				this.m1_s2(sc);
				break;
			case 3:
				this.m1_s3(sc);
				break;
			case 4:
				this.m1_s4(sc);
				break;

			}

		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리
	private void m1_s1(Scanner sc) {

		while (true) {
			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리");
			System.out.println("1. 과정 관리  2. 과목 관리  3. 강의실 관리  4. 교재 관리");
			System.out.println("선택 > ");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;
			}

			switch (select) {

			case 1:
				this.m1_s1_s1(sc);
				break;
			case 2:
				this.m1_s1_s2();
				break;
			case 3:
				this.m1_s1_s3(sc);
				break;

			}
		}

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리 > 1. 과정 입력
	private void m1_s1_s1(Scanner sc) {

		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리 > 1. 과정 입력");

		System.out.print("과정명 > ");
		String course_name = sc.nextLine();

		System.out.print("등록하시겠습니까?(1/0) > ");

		System.out.println("과정이 추가되었습니다.");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리 > 2. 과정 출력
	private void m1_s1_s2() {

		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리 > 2. 과정 출력");
		System.out.println("--------------------");
		System.out.println("과정 번호 / 과정명");
		System.out.println("--------------------");
		System.out.printf("총 00건");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리 > 3. 과정 삭제
	private void m1_s1_s3(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 1. 과정 관리 > 3. 과정 삭제");
		System.out.println("--------------------");
		System.out.println("과정 번호 / 과정명 / 삭제 가능 여부");
		System.out.println("--------------------");
		System.out.println("총 : 11건 ");

		System.out.print("과정 번호 >");
		String course_id = sc.nextLine();

		System.out.print("과정명 : ");
		System.out.print("위의 과정을 삭제하시겠습니까?(0/1) > ");

		System.out.println("000000이 삭제되었습니다.");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 2. 과목 관리
	private void m1_s2(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 2. 과목 관리 > 1. 과목 입력
	private void m1_s2_s1(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 2. 과목 관리 > 2. 과목 출력
	private void m1_s2_s2() {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 2. 과목 관리 > 3. 과목 삭제
	private void m1_s2_s3(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 3. 강의실 관리
	private void m1_s3(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 3. 강의실 관리 > 1. 강의실 입력
	private void m1_s3_s1(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 3. 강의실 관리 > 2. 강의실 출력
	private void m1_s3_s2() {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 3. 강의실 관리 > 3. 강의실 삭제
	private void m1_s3_s3(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리
	private void m1_s4(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리 > 1. 교재 입력
	private void m1_s4_s1(Scanner sc) {

		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리 > 1. 교재 입력");
		System.out.println("-------------------------------");
		System.out.print("교재명 > ");
		String subjectbook_name = sc.nextLine();
		System.out.print("교재 출판사 > ");
		String subjectbook_publisher = sc.nextLine();
		System.out.print("등록하시겠습니까?(0/1)");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리 > 2. 교재 출력
	private void m1_s4_s2() {

		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리 > 2. 교재 출력");

		System.out.println("-------------------------------");

		System.out.println("교재 번호 / 교재명 / 교재 출판사");
		System.out.println("-------------------------------");
		System.out.println("총 : 00건");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리 > 3. 교재 삭제
	private void m1_s4_s3(Scanner sc) {

		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 1. 기초 정보 관리 > 4. 교재 관리");
		System.out.println("-------------------------------");
		System.out.println("교재 번호 / 교재명 / 교재 출판사 / 삭제 가능 여부");

		System.out.println("-------------------------------");
		System.out.println("총 00건");
		System.out.print("교재 번호 > ");
		String subjectbook_id = sc.nextLine();
		System.out.print("교재명 > ");
		String sujbectbook_name = sc.nextLine();
		System.out.print("교재 출판사 > ");
		String subjectbook_publisher = sc.nextLine();
		System.out.print("위의 교재를 삭제하시겠습니까? (0/1) ");
		int select = sc.nextInt();

		if (select == 1) {
			System.out.println("SB022이(가) 삭제되었습니다.");
		}

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리
	private void m2(Scanner sc) {

		while (true) {
			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리");
			System.out.println("1. 강사 입력 2. 강사 검색 및 출력 3. 강사 삭제 4. 비밀번호 초기화 5. 강의 가능 과목 관리");
			System.out.print("선택 > ");
			System.out.println("-------------------------------");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;
			}

			switch (select) {

			case 1:
				this.m2_s1(sc);
				break;
			case 2:
				this.m2_s2(sc);
				break;
			case 3:
				this.m2_s3(sc);
				break;
			case 4:
				this.m2_s4(sc);
				break;
			case 5:
				this.m2_s5(sc);
				break;

			}

		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 1. 강사 입력
	private void m2_s1(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 1. 강사 입력");

		System.out.print("강사 이름 > ");
		String instructor_id = sc.nextLine();
		System.out.print("강사 휴대폰번호 > ");
		String instructor_name = sc.nextLine();
		System.out.print("강사 비밀번호 > ");
		String instructor_pw = sc.nextLine();
		System.out.print("강사 등록일 > ");
		String instructor_regDate = sc.nextLine();

		System.out.print("등록하시겠습니까? (0/1) > ");
		System.out.println("강사가 추가되었습니다.");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력
	private void m2_s2(Scanner sc) {

		while (true) {
			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력");
			System.out.println("1. 강사 번호  2. 강사 이름  3. 강사 전체 출력");
			System.out.print("선택 > ");
			System.out.println("-------------------------------");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;
			}

			switch (select) {

			case 1:
				this.m2_s2_s1(sc);
				break;
			case 2:
				this.m2_s2_s2(sc);
				break;
			case 3:
				this.m2_s2_s3();
				break;

			}

		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력 > 1. 강사 번호
	private void m2_s2_s1(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력 > 1. 강사 번호");

		System.out.print("강사 번호 > ");
		String instructor_id = sc.nextLine();

		System.out.print("강사 이름 : ");
		System.out.print("강사 전화번호 : ");

		System.out.println("-------------------------------");
		System.out.println("개설 과목명 / 개설 과목 기간 / 개설 과정명 / 개설 과정 기간 / 강의실 / 강의 진행 여부");
		System.out.println("-------------------------------");
		System.out.println("총 00건");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력 > 2. 강사 이름
	private void m2_s2_s2(Scanner sc) {

		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력 > 2. 강사 이름");

		System.out.print("강사 이름 > ");
		String instructor_name = sc.nextLine();
		System.out.println("강사 번호 / 강사 이름 / 강사 휴대폰번호 / 등록일");
		System.out.println("-------------------------------");
		System.out.println("총 00건");

		System.out.println("검색 결과가 여러건입니다.");

		this.m2_s2_s1(sc);

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력 > 3. 강사 전체 출력
	private void m2_s2_s3() {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 2. 강사 검색 및 출력 > 3. 강사 전체 출력");
		System.out.println("-------------------------------");
		System.out.println("강사 번호 / 강사 이름 / 강사 휴대폰번호 / 강사 등록일 / 강의 가능 과목");
		System.out.println("-------------------------------");
		System.out.println("총 00건");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 3. 강사 삭제
	private void m2_s3(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 3. 강사 삭제");
		System.out.println("-------------------------------");
		System.out.println("강사 번호 / 강사 이름 / 강사 휴대폰 번호 / 강사 등록일 / 강의 가능 과목 / 삭제 가능 여부");
		System.out.println("-------------------------------");
		System.out.println("총 00명");

		System.out.print("강사 번호 > ");

		System.out.print("강사 이름 : ");
		System.out.print("전화번호 : ");
		System.out.print("위의 강사를 삭제하시겠습니까? (0/1) >");
		System.out.println("00이 삭제되었습니다.");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 4. 비밀번호 초기화
	private void m2_s4(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 4. 비밀번호 초기화");
		System.out.println("-------------------------------");
		System.out.println("강사 번호 / 강사 이름 / 강사 휴대폰 번호 / 강사 등록일 / 강의 가능 과목");
		System.out.println("-------------------------------");
		System.out.println("총 00명");

		System.out.print("강사 번호 > ");

		System.out.print("강사 이름 : ");
		System.out.print("전화번호 : ");

		System.out.print("강사 비밀번호 > ");
		System.out.println("진행하시겠습니까? (0/1) > ");
		System.out.println("'INS001'의 비밀번호가 초기화되었습니다.");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 5. 강의 가능 과목 관리
	private void m2_s5(Scanner sc) {

		while (true) {

			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 5. 강의 가능 과목 관리");
			System.out.println("1. 강의 가능 과목 추가  2. 강의 가능 과목 삭제");
			System.out.print("선택 > ");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 3) {
				break;
			}

			switch (select) {

			case 1:
				this.m2_s5_s1(sc);
				break;
			case 2:
				this.m2_s5_s2(sc);
				break;

			}

		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 5. 강의 가능 과목 관리 > 1. 강의 가능 과목 추가
	private void m2_s5_s1(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 5. 강의 가능 과목 관리 > 1. 강의 가능 과목 추가");

		System.out.print("강사 번호 > ");
		String instructor_id = sc.nextLine();

		while (true) {
			System.out.print("강사 이름 : ");
			System.out.print("강사 휴대폰번호 : ");
			System.out.println("-------------------------------");

			System.out.println("강의 가능 과목");
			System.out.println("총 00건");
			System.out.println("-------------------------------");

			System.out.print("과목 번호 (1/0) > ");
			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;

			}

			if (select == 1) {
				System.out.println("-------------------------------");
				System.out.println("과목 번호 / 과목명");
				System.out.println("-------------------------------");
				System.out.println("총 00건");

				System.out.print("과목 번호 > ");
				String subject_id = sc.nextLine();

				System.out.print("과목 번호 : ");
				System.out.print("과목명 : ");

				System.out.print("등록하시겠습니까? > (0/1) > ");

				if (select == 1) {
					System.out.println("강의 가능 과목이 추가되었습니다.");
				}
			}
		}

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 5. 강의 가능 과목 관리 > 2. 강의 가능 과목 삭제
	// 여기까지다
	private void m2_s5_s2(Scanner sc) {
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 2. 강사 계정 관리 > 5. 강의 가능 과목 관리 > 2. 강의 가능 과목 삭제");

		System.out.print("강사 번호 > ");
		String instructor_id = sc.nextLine();
		System.out.print("강사 이름 : ");
		System.out.print("강사 휴대폰 번호 : ");

		System.out.println("-------------------------------");
		System.out.println("강의 가능 과목");
		System.out.println("-------------------------------");
		System.out.println("총 00건");

		System.out.print("삭제할 강의 번호 > ");
		String subject_id = sc.nextLine();

		System.out.print("과목 번호 : ");
		System.out.print("과목명 : ");

		System.out.println("삭제 하시겠습니까? (0/1) > ");

		System.out.println("삭제 되었습니다.");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리
	private void m3(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("성적 처리 시스템 v6.0 (관리자:%s) > 3. 개설 과정 관리\n");
			System.out.println("--------------");
			System.out.println("1. 개설 과정 추가  2. 개설 과정 검색 및 출력  3. 개설 과정 삭제");
			System.out.print("선택 > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 1:
				this.m3_s1(sc);
				break;
			case 2:
				this.m3_s2(sc);
				break;
			case 3:
				this.m3_s3(sc);
				break;
			case 0:
				run = false;
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리 > 1. 개설 과정 추가
	private void m3_s1(Scanner sc) {
		System.out.println("-------------------------------");
		List<Course> list1 = this.cDAO.print1(); // 과정번호, 과정이름 출력
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());

		System.out.print("과정 번호 > ");
		String open_course_id = sc.nextLine();
		sc.nextInt();
		System.out.print("개설 과정 시작일 > ");
		String open_course_start_date = sc.nextLine();
		sc.nextInt();
		System.out.print("개설 과정 종료일 > ");
		String open_course_end_date = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<ClassRoom> list2 = this.crDAO.print1(); // 강의실 아이디, 강의실 이름, 최대정원 출력
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list2.size());

		System.out.print("강의실 번호 > ");
		String class_room_id = sc.nextLine();
		sc.nextInt();

		System.out.print("등록하시겠습니까? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// 개설 과정 등록
			System.out.println("개설 과정이 추가되었습니다.");
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리 > 2. 개설 과정 검색 및 출력
	private void m3_s2(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("성적 처리 시스템 v6.0 (관리자 : %s) > 3. 개설 과정 관리 > 2. 개설 과정 검색 및 출력\n");
			System.out.println("--------------");
			System.out.println("1. 개설 과정 번호  2. 개설 과정명  3. 개설 과정 전체 출력");
			System.out.print("선택 > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 1:
				this.m3_s2_s1(sc);
				break;
			case 2:
				this.m3_s2_s2(sc);
				break;
			case 3:
				this.m3_s2_s3();
				break;
			case 0:
				run = false;
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리 > 2. 개설 과정 검색 및 출력 > 1. 개설 과정 번호
	private void m3_s2_s1(Scanner sc) {
		System.out.print("개설 과정 번호 > ");
		String open_course_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<OpenCourse> list1 = this.ocDAO.print1();

		System.out.print("** 개설 과목 정보 **");
		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간 / 교재명 / 강사명");
		List<OpenSubject> list2 = this.osDAO.print4();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list2.size());

		System.out.print(" ** 수강생 정보 **");
		System.out.println("-------------------------------");
		System.out.println("수강생 번호 / 수강생 이름 / 전화번호 / 등록일 / 수료여부 / 날짜(중도탈락은 탈락일, 과정 종료일)");
		List<Student> list3 = this.stDAO.print4();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list3.size());
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리 > 2. 개설 과정 검색 및 출력 > 2. 개설 과정명
	private void m3_s2_s2(Scanner sc) {
		System.out.print("개설 과정명 > ");
		String course_name = sc.nextLine();
		sc.nextInt();
		System.out.println("-------------------------------");

		System.out.println("개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명");
		List<OpenCourse> list1 = this.ocDAO.print1();

		// 검색 결과가 여러개일 경우
		if (list1.size() > 1) {
			System.out.println("검색 결과가 여러개입니다.");
			this.m3_s2_s1(sc); // 개설 과정 번호 검색 메소드로 넘어감
			System.out.println("-------------------------------");
		}

		// 검색 결과가 하나인 경우
		else {
			System.out.print("** 개설 과목 정보 **");
			System.out.println("-------------------------------");
			System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간 / 교재명 / 강사명");
			List<OpenSubject> list2 = this.osDAO.print4();
			System.out.println("-------------------------------");

			System.out.print(" ** 수강생 정보 **");
			System.out.println("-------------------------------");
			System.out.println("수강생 번호 / 수강생 이름 / 전화번호 / 등록일 / 수료여부 / 날짜(중도탈락은 탈락일, 과정 종료일)");
			List<Student> list3 = this.stDAO.print4();
			System.out.println("-------------------------------");
			System.out.printf("총 %s건", list3.size());

		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리 > 2. 개설 과정 검색 및 출력 > 3. 개설 과정 전체
	// 출력
	private void m3_s2_s3() {
		System.out.println("-------------------------------");
		System.out.println("개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 개설 과목 등록 갯수 / 수강생 등록 인원");
		List<OpenCourse> list1 = this.ocDAO.print2();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 3. 개설 과정 관리 > 3. 개설 과정 삭제
	private void m3_s3(Scanner sc) {
		System.out.println("-------------------------------");
		System.out.println("개설 과정 번호 / 강의실명 / 과정명 / 개설 과정 기간 / 삭제 가능 여부");
		List<OpenCourse> list1 = this.ocDAO.print3();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());

		System.out.print("개설 과정 번호 > ");
		String open_course_id = sc.nextLine();
		sc.nextInt();

		// 개설 과정 번호에 따른 개설 과정명, 개설 과정 기간, 강의실명 출력
		List<OpenCourse> list2 = this.ocDAO.print1();

		System.out.print("위의 개설 과정을 삭제하시겠습니까? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// 개설 과정 삭제
			System.out.println("삭제되었습니다.");
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리
	private void m4(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("성적 처리 시스템 v6.0 (관리자 : %s) > 4. 개설 과목 관리\n");
			System.out.println("--------------");
			System.out.println("1. 개설 과목 추가  2. 개설 과목 검색 및 출력  3. 개설 과목 삭제");
			System.out.print("선택 > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 1:
				this.m4_s1(sc);
				break;
			case 2:
				this.m4_s2(sc);
				break;
			case 3:
				this.m4_s3(sc);
				break;
			case 0:
				run = false;
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리 > 1. 개설 과목 추가
	private void m4_s1(Scanner sc) {
		System.out.println("-------------------------------");
		List<OpenCourse> list1 = this.ocDAO.print4();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());

		String open_course_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<Subject> list2 = this.sDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list2.size());

		String open_course_start_date = sc.nextLine();
		sc.nextInt();
		String open_course_end_date = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<Subjectbook> list3 = this.sbDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list3.size());

		String subjectbook_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<Instructor> list4 = this.iDAO.print3();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list4.size());

		String instructor_id = sc.nextLine();
		sc.nextInt();

		System.out.print("등록하시겠습니까? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// 개설 과목 등록
			System.out.println("개설 과목이 추가되었습니다.");
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리 > 2. 개설 과목 검색 및 출력
	private void m4_s2(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("성적 처리 시스템 v6.0 (관리자 : %s) > 4. 개설 과목 관리 > 2. 개설 과목 검색 및 출력");
			System.out.println("--------------");
			System.out.println("1. 개설 과목 번호  2. 개설 과목명  3. 개설 과목 전체 출력");
			System.out.print("선택 > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 1:
				this.m4_s2_s1(sc);
				break;
			case 2:
				this.m4_s2_s2(sc);
				break;
			case 3:
				this.m4_s2_s3();
				break;
			case 0:
				run = false;
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리 > 2. 개설 과목 검색 및 출력 > 1. 개설 과목 번호
	private void m4_s2_s1(Scanner sc) {
		String open_course_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 개설 과정명 / 개설 과정 기간 / 강의실");
		List<OpenSubject> list1 = this.osDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리 > 2. 개설 과목 검색 및 출력 > 2. 개설 과목명
	private void m4_s2_s2(Scanner sc) {

		String course_name = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 개설 과정명 / 개설 과정 기간 / 강의실");
		List<OpenSubject> list1 = this.osDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리 > 2. 개설 과목 검색 및 출력 > 3. 개설 과목 전체
	// 출력
	private void m4_s2_s3() {
		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 개설 과정명 / 개설 과정 기간 / 강의실");
		List<OpenSubject> list1 = this.osDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 4. 개설 과목 관리 > 3. 개설 과목 삭제
	private void m4_s3(Scanner sc) {
		System.out.println("-------------------------------");
		System.out.println("개설 과목 번호 / 개설 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 개설 과정명 / 개설 과정 기간 / 강의실 / 삭제 가능 여부");
		List<OpenSubject> list1 = this.osDAO.print2();
		System.out.println("-------------------------------");
		System.out.printf("총 %s건", list1.size());

		String open_course_id = sc.nextLine();
		sc.nextInt();
		List<OpenSubject> list2 = this.osDAO.print3();

		System.out.print("위의 개설 과목을 삭제하시겠습니까? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// 개설 과목 삭제
			System.out.println("삭제되었습니다.");
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리
	private void m5(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 1. 수강생 입력
	private void m5_s1(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 2. 수강생 검색 및 출력
	private void m5_s2(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 2. 수강생 검색 및 출력 > 1. 수강생 번호
	private void m5_s2_s1(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 2. 수강생 검색 및 출력 > 2. 수강생 이름
	private void m5_s2_s2(Scanner sc) {

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 2. 수강생 검색 및 출력 > 3. 수강생 전체 출력
	private void m5_s2_s3() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 2. 수강생 검색 및 출력 > 3. 수강생 전체 출력");
		System.out.println("---------------------------------------------------------------");
		
		List<Student> list = this.stDAO.print3();
		if (list.size() > 0) {
			System.out.println("--------------");
			System.out.println("수강생 번호 / 수강생 이름 / 수강생 전화번호 / 수강생 등록일 / 수강 횟수");
			for (Student s : list) {
				//System.out.println(s.print3());
			}
			System.out.println("--------------");
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 3. 수강생 삭제
	private void m5_s3(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 3. 수강생 삭제");
		System.out.println("---------------------------------------------------------------");

		List<Student> list = this.stDAO.print2();
		System.out.println("--------------");
		System.out.println("수강생 번호 / 수강생 이름 / 수강생 전화번호 / 수강생 등록일 / 삭제 가능 여부");
		for (Student s : list) {
			//System.out.println(s.print2());
		}
		System.out.println("--------------");

		System.out.printf("총 %d명 \n", list.size());
		System.out.print("수강생 번호 >");
		String student_id = sc.nextLine();
		List<Student> list2 = this.stDAO.search("student_id", student_id);
		if (list2.size() > 0) {
			for (Student s : list2) {
				System.out.printf("수강생 이름 : %s\n", s.getStudent_name());
				System.out.printf("수강생 전화번호 : %s\n", s.getStudent_phone());
			}
			System.out.println();
			System.out.println("위의 수강생을 삭제하시겠습니까? (0/1) >");
			int check = sc.nextInt();
			sc.nextLine();

			if (check == 1) {
				Student s = new Student(student_id, "");

				this.stDAO.remove(s);

				System.out.printf("'%s' 이 삭제되었습니다.", student_id);
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 4. 비밀번호 초기화
	private void m5_s4(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 4. 비밀번호 초기화");
		System.out.println("---------------------------------------------------------------");
				
		List<Student> list = this.stDAO.print2();
		if (list.size() > 0) {
			System.out.println("--------------");
			System.out.println("수강생 번호 / 수강생 이름 / 수강생 전화번호 / 수강생 등록일");
			for (Student s : list) {
				//System.out.println(s.print1());
			}
			System.out.println("--------------");
			System.out.printf("총 %d명 \n", list.size());
		}

		System.out.print("수강생 번호 >");
		String student_id = sc.nextLine();
		List<Student> list2 = this.stDAO.search("student_id", student_id);
		if (list2.size() > 0) {
			for (Student s : list2) {
				System.out.printf("수강생 이름 : %s\n", s.getStudent_name());
				System.out.printf("수강생 전화번호 : %s\n", s.getStudent_phone());
			}
			System.out.println();
			System.out.println("수강생 비밀번호 >");
			String student_pw = sc.nextLine();

			System.out.println("진행하시겠습니까? (0/1) >");
			int check = sc.nextInt();
			sc.nextLine();

			if (check == 1) {
				Student s = new Student(student_id, student_pw);

				int m = this.stDAO.reset(s);

				if (m == 1) {
					System.out.printf("'%s'의 비밀번호가 초기화되었습니다.", student_id);
				}
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리
	private void m5_s5(Scanner sc) {
		while (true) {
			System.out.println();
			System.out.println("--------------");
			System.out.printf("성적 처리 시스템 v6.0 (관리자 :%s)%n > 5. 수강생 관리 > 5. 수강생 과정 관리");
			System.out.println("--------------");
			System.out.println("1. 수강생 과정 등록  2. 수강생 과정 취소  3. 수강생 중도 탈락");
			System.out.print("선택>");
			int m = sc.nextInt();
			sc.nextLine();

			if (m == 0) {
				break;
			}
			switch (m) {
			case 1:
				this.m5_s5_s1(sc);
				break;
			case 2:
				this.m5_s5_s2(sc);
				break;
			case 3:
				this.m5_s5_s3(sc);
				break;
			}
		}
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리 > 1. 수강생 과정 등록
	private void m5_s5_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리 > 1. 수강생 과정 등록");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println("수강생 번호 >");
		String student_id = sc.nextLine();
		
		List<Student> list = this.stDAO.search("student_id", student_id);
		if (list.size() > 0) {
			for (Student s : list) {
				System.out.println("-------------------------------");
				//System.out.println(s.print3());
				System.out.println("-------------------------------");
			}
			System.out.printf("총 %d명 \n", list.size());
		}
		
		List<OpenCourse> list2 = this.ocDAO.print2();
		if (list2.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 개설 과목 등록 갯수 / 수강생 등록 인원");
			for (OpenCourse oc : list2) {
				//System.out.println(oc.print2());
				System.out.println("--------------");
			}
			System.out.printf("총 %d건 \n", list.size());
		}
		
		System.out.println("개설 과정 번호 >");
		String open_course_id = sc.nextLine();
		
		List<OpenCourse> list3 = this.ocDAO.search("open_course_id", open_course_id);
		if(list3.size() > 0) {
			for(OpenCourse oc : list3) {
				System.out.printf("개설 과정 번호 : ", open_course_id);
				System.out.printf("개설 과정명 : ", oc.getCourse_name());
				System.out.printf("개설 과정 기간 : %tF ~ %tF ", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
				System.out.printf("강의실명 : ", oc.getClass_room_name());
			}
			
		}
		
		System.out.println("등록하시겠습니까? (0/1) > ");
		int check = sc.nextInt();
		sc.nextLine();
		if(check == 1) {
			StudentHistory s = new StudentHistory(student_id, open_course_id);
			stDAO.studentHistoryAdd(s);
		}
		
		
		
	/*
		
		
		총 16건
		
		개설 과정 번호 > OC0014
		 
		개설 과정 번호 : OC0014
		개설 과정명 : 웹기반 빅데이터 분석 응용SW개발자
		개설 과정 기간 :  2018-12-05 ~ 2019-07-04
		강의실명 : 7강의실
		
		등록하시겠습니까? (0/1) > 1
				
		등록되었습니다.*/
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리 > 2. 수강생 과정 취소
	private void m5_s5_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리 > 2. 수강생 과정 취소");
		System.out.println("---------------------------------------------------------------");
	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리 > 3. 수강생 중도 탈락
		private void m5_s5_s3(Scanner sc) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 5. 수강생 관리 > 5. 수강생 과정 관리 > 3. 수강생 중도 탈락");
			System.out.println("---------------------------------------------------------------");
		

		}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회
	private void m6(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회");
		System.out.println("---------------------------------------------------------------");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 1. 개설 과목 성적 조회
	private void m6_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 1. 개설 과목 성적 조회");
		System.out.println("---------------------------------------------------------------");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 2. 수강생 개인 성적 조회
	private void m6_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 2. 수강생 개인 성적 조회");
		System.out.println("---------------------------------------------------------------");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 2. 수강생 개인 성적 조회 > 1. 수강생 번호
	private void m6_s2_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 2. 수강생 개인 성적 조회 > 1. 수강생 번호");
		System.out.println("---------------------------------------------------------------");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 2. 수강생 개인 성적 조회 > 2. 수강생 이름
	private void m6_s2_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 6. 성적 조회 > 2. 수강생 개인 성적 조회 > 2. 수강생 이름");
		System.out.println("---------------------------------------------------------------");

	}

	// 성적 처리 시스템 v6.0 (관리자 : admin) > 7. 비밀번호 변경
	private void m7(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 (관리자 : admin) > 7. 비밀번호 변경");
		System.out.println("---------------------------------------------------------------");

	}
	
	private void ocPrint(List<Course> list) {
		System.out.println("-------------------------------");
			for(Course c : list) {
				System.out.println(c.toString());
			}
		System.out.println("-------------------------------");
		System.out.printf("총 %s건" , list.size());

	}
}