package com.scoremanagement.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.scoremanagement.domain.Exam;
import com.scoremanagement.domain.Instructor;
import com.scoremanagement.domain.OpenSubject;
import com.scoremanagement.domain.Student;
import com.scoremanagement.persistance.ExamDAO;
import com.scoremanagement.persistance.InstructorDAO;
import com.scoremanagement.persistance.OpenSubjectDAO;
import com.scoremanagement.persistance.StudentDAO;

public class ServiceInstructor {

	private InstructorDAO iDAO = new InstructorDAO();
	private OpenSubjectDAO osDAO = new OpenSubjectDAO();
	private StudentDAO stDAO = new StudentDAO();
	private ExamDAO eDAO = new ExamDAO();
	
	private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
	private String instructor_id = null;
	private String instructor_name = null;
	
	// 성적 처리 시스템 v6.0 > 2. 강사 로그인
	public void login(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("성적 처리 시스템 v6.0 > 2. 강사 로그인");
		System.out.print("이름 > ");
		instructor_name = sc.nextLine();
		
		System.out.print("비밀번호 > ");
		String instructor_pw = sc.nextLine();
		
		Instructor i = new Instructor(instructor_name, instructor_pw);
		instructor_id = this.iDAO.login(i);
		
		if(instructor_id != null) {
			System.out.printf("강사 '%s'님이 로그인되었습니다.\n", instructor_name);
			this.main(sc);
		} else {
			 System.out.println("아이디 또는 패스워드가 틀렸습니다.");
		}
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) 
	private void main(Scanner sc) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("성적 처리 시스템 v6.0 (강사 : %s)\n", instructor_name);
			System.out.println("1. 강의 스케줄 조회  2. 배점 관리  3. 성적 관리  4. 개인 정보");
			System.out.print("선택 > ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			
			switch(selectNum) {
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

			case 0:
				run = false;
				break;
				
			default:
				System.out.println("없는 번호입니다.");
				break;
			}
		}
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 1. 강의 스케줄 조회
	private void m1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("성적 처리 시스템 v6.0 (강사 : %s) > 1. 강의 스케줄 조회\n", instructor_name);
		System.out.println("** 강의 과목 **");
		System.out.println("오늘 날짜 : " + LocalDate.now().format(formatter));
	
		List<OpenSubject> list = osDAO.print6(instructor_id);
		if(list.size() > 0) {
			System.out.println("개설과목번호 / 과목명 / 과목 기간 / 비고");
			for(OpenSubject os : list) {
				System.out.printf("%s / %s / %s ~ %s / %s\n", 
						os.getOpen_subject_id(), os.getSubject_name(), 
						os.getSubject_start_date(), os.getSubject_end_date(), os.getInstructor_status());
			}
			
			System.out.print("개설 과목 번호 > ");
			String open_subject_id = sc.nextLine();
			
			List<OpenSubject> list2 = osDAO.print7(open_subject_id, instructor_id);
			if(list2.size() > 0) {
				for(OpenSubject os : list2) {
					System.out.printf("개설 과목 번호 : %s\n", open_subject_id);
					System.out.printf("개설 과정명 : %s\n", os.getCourse_name());
					System.out.printf("개설 과정 기간 : %s ~ %s\n", os.getOpen_course_start_date(), os.getOpen_course_end_date());
					System.out.printf("강의실 : %s\n", os.getClass_room_name());
					System.out.printf("개설 과목명 : %s\n", os.getSubject_name());
					System.out.printf("개설 과목 기간 : %s ~ %s\n", os.getSubject_start_date(), os.getSubject_end_date());
					System.out.printf("교재명 : %s\n", os.getSubjectbook_name());					
					System.out.printf("수강생 등록 인원 : %d명\n", os.getStudent_count());
					
					List<Student> list3 = stDAO.print4(open_subject_id, instructor_id);
					if(list3.size() > 0) {
						System.out.println("** 수강생 정보 **");
						System.out.println("수강생번호 / 이름 / 전화번호 / 등록일 / 수료여부 / 날짜");
						for(Student s : list3) {
							System.out.printf("%s / %s / %s / %s / %s / %s\n", 
									s.getStudent_id(), s.getStudent_name(), s.getStudent_phone(), s.getStudent_regDate(),
									s.getCompletion_status(), s.getCompleteion_date());
						}
						
					} else {
						System.out.println("검색 결과가 없습니다.");
					}
				}
			} else {
				System.out.println("검색 결과가 없습니다.");
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 2. 배점 관리
	private void m2(Scanner sc) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("성적 처리 시스템 v6.0 (강사 : %s) > 2. 배점 관리\n", instructor_name);
			System.out.println("1. 배점 입력  2. 배점 출력  3. 배점 삭제");
			System.out.print("선택 > ");
			int selectNum = sc.nextInt();
			sc.nextLine();
			
			switch(selectNum) {
			case 1:
				this.m2_s1(sc);
				break;
				
			case 2:
				this.m2_s2(sc);
				break;

			case 3:
				this.m2_s3(sc);
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
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 2. 배점 관리 > 1. 배점 입력
	private void m2_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("성적 처리 시스템 v6.0 (강사 : %s) > 2. 배점 관리 > 1. 배점 입력\n", instructor_name);
		System.out.println("** 강의 과목 **");
		System.out.println("오늘 날짜 : " + LocalDate.now().format(formatter));
	
		List<OpenSubject> list = osDAO.print6(instructor_id);
		if(list.size() > 0) {
			System.out.println("개설과목번호 / 과목명 / 과목 기간 / 비고");
			for(OpenSubject os : list) {
				System.out.printf("%s / %s / %s ~ %s / %s\n", 
						os.getOpen_subject_id(), os.getSubject_name(), 
						os.getSubject_start_date(), os.getSubject_end_date(), os.getInstructor_status());
			}
			
			System.out.print("개설 과목 번호 > ");
			String open_subject_id = sc.nextLine();
			
			List<OpenSubject> list2 = osDAO.print7(open_subject_id, instructor_id);
			if(list2.size() > 0) {
				for(OpenSubject os : list2) {
					System.out.printf("개설 과목 번호 : %s\n", open_subject_id);
					System.out.printf("개설 과정명 : %s\n", os.getCourse_name());
					System.out.printf("개설 과정 기간 : %s ~ %s\n", os.getOpen_course_start_date(), os.getOpen_course_end_date());
					System.out.printf("강의실 : %s\n", os.getClass_room_name());
					System.out.printf("개설 과목명 : %s\n", os.getSubject_name());
					System.out.printf("개설 과목 기간 : %s ~ %s\n", os.getSubject_start_date(), os.getSubject_end_date());
					System.out.printf("교재명 : %s\n", os.getSubjectbook_name());					
					
					List<Exam> list3 = eDAO.print1(open_subject_id, instructor_id); 
					if(list3.size() > 0) {
						System.out.println("** 시험 정보 **");
						for(Exam e : list3) {
							System.out.printf("시험 번호 : %s\n", e.getExam_id());
							System.out.printf("출결 배점 : %d\n", e.getAttendance_point());
							System.out.printf("필기 배점 : %d\n", e.getWrite_point());
							System.out.printf("실기 배점 : %d\n", e.getSkill_point());
							System.out.printf("시험 날짜 : %s\n", e.getExam_date());
							System.out.printf("시험 문제 : %s\n", e.getExam_file());
						}
					} else {
						System.out.println("검색 결과가 없습니다.");
					}
					
					if(list3.size() > 0) {
						System.out.println("이미 시험 정보가 등록되어 있습니다.");
						System.out.print("추가로 진행하시겠습니까? (0/1) > ");
						int selectNum = sc.nextInt();
						sc.nextLine();
						if(selectNum == 1) {
							System.out.print("출결 배점 > ");
							int attendance_point = sc.nextInt();
							sc.nextLine();
							System.out.print("필기 배점 > ");
							int write_point = sc.nextInt();
							sc.nextLine();
							System.out.print("실기 배점 > ");
							int skill_point = sc.nextInt();
							sc.nextLine();
							System.out.print("시험 날짜 > ");
							//Date exam_date = sc.nextLine();
							System.out.print("시험 문제 > ");
							String exam_file = sc.nextLine();
							//Exam e = new Exam("", "", attendance_point, write_point, skill_point,
							//		exam_date, exam_file);
						} else {
							break;
						}
					}
				}
			} else {
				System.out.println("검색 결과가 없습니다.");
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 2. 배점 관리 > 2. 배점 출력
	private void m2_s2(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 2. 배점 관리 > 3. 배점 삭제
	private void m2_s3(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 3. 성적 관리
	private void m3(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 3. 성적 관리 > 1. 성적 입력
	private void m3_s1(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 3. 성적 관리 > 2. 성적 출력
	private void m3_s2(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 3. 성적 관리 > 3. 성적 삭제
	private void m3_s3(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 4. 개인 정보
	private void m4(Scanner sc) {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 4. 개인 정보 > 1. 개인 정보 조회
	private void m4_s1() {
		
	}
	
	// 성적 처리 시스템 v6.0 (강사 : OOO) > 4. 개인 정보 > 2. 비밀 번호 변경
	private void m4_s2(Scanner sc) {
		
	}
}
