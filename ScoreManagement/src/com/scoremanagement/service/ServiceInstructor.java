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
	
	// ���� ó�� �ý��� v6.0 > 2. ���� �α���
	public void login(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 > 2. ���� �α���");
		System.out.print("�̸� > ");
		instructor_name = sc.nextLine();
		
		System.out.print("��й�ȣ > ");
		String instructor_pw = sc.nextLine();
		
		Instructor i = new Instructor(instructor_name, instructor_pw);
		instructor_id = this.iDAO.login(i);
		
		if(instructor_id != null) {
			System.out.printf("���� '%s'���� �α��εǾ����ϴ�.\n", instructor_name);
			this.main(sc);
		} else {
			 System.out.println("���̵� �Ǵ� �н����尡 Ʋ�Ƚ��ϴ�.");
		}
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) 
	private void main(Scanner sc) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (���� : %s)\n", instructor_name);
			System.out.println("1. ���� ������ ��ȸ  2. ���� ����  3. ���� ����  4. ���� ����");
			System.out.print("���� > ");
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
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 1. ���� ������ ��ȸ
	private void m1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (���� : %s) > 1. ���� ������ ��ȸ\n", instructor_name);
		System.out.println("** ���� ���� **");
		System.out.println("���� ��¥ : " + LocalDate.now().format(formatter));
	
		List<OpenSubject> list = osDAO.print6(instructor_id);
		if(list.size() > 0) {
			System.out.println("���������ȣ / ����� / ���� �Ⱓ / ���");
			for(OpenSubject os : list) {
				System.out.printf("%s / %s / %s ~ %s / %s\n", 
						os.getOpen_subject_id(), os.getSubject_name(), 
						os.getSubject_start_date(), os.getSubject_end_date(), os.getInstructor_status());
			}
			
			System.out.print("���� ���� ��ȣ > ");
			String open_subject_id = sc.nextLine();
			
			List<OpenSubject> list2 = osDAO.print7(open_subject_id, instructor_id);
			if(list2.size() > 0) {
				for(OpenSubject os : list2) {
					System.out.printf("���� ���� ��ȣ : %s\n", open_subject_id);
					System.out.printf("���� ������ : %s\n", os.getCourse_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", os.getOpen_course_start_date(), os.getOpen_course_end_date());
					System.out.printf("���ǽ� : %s\n", os.getClass_room_name());
					System.out.printf("���� ����� : %s\n", os.getSubject_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", os.getSubject_start_date(), os.getSubject_end_date());
					System.out.printf("����� : %s\n", os.getSubjectbook_name());					
					System.out.printf("������ ��� �ο� : %d��\n", os.getStudent_count());
					
					List<Student> list3 = stDAO.print4(open_subject_id, instructor_id);
					if(list3.size() > 0) {
						System.out.println("** ������ ���� **");
						System.out.println("��������ȣ / �̸� / ��ȭ��ȣ / ����� / ���Ῡ�� / ��¥");
						for(Student s : list3) {
							System.out.printf("%s / %s / %s / %s / %s / %s\n", 
									s.getStudent_id(), s.getStudent_name(), s.getStudent_phone(), s.getStudent_regDate(),
									s.getCompletion_status(), s.getCompleteion_date());
						}
						
					} else {
						System.out.println("�˻� ����� �����ϴ�.");
					}
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 2. ���� ����
	private void m2(Scanner sc) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (���� : %s) > 2. ���� ����\n", instructor_name);
			System.out.println("1. ���� �Է�  2. ���� ���  3. ���� ����");
			System.out.print("���� > ");
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
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 2. ���� ���� > 1. ���� �Է�
	private void m2_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (���� : %s) > 2. ���� ���� > 1. ���� �Է�\n", instructor_name);
		System.out.println("** ���� ���� **");
		System.out.println("���� ��¥ : " + LocalDate.now().format(formatter));
	
		List<OpenSubject> list = osDAO.print6(instructor_id);
		if(list.size() > 0) {
			System.out.println("���������ȣ / ����� / ���� �Ⱓ / ���");
			for(OpenSubject os : list) {
				System.out.printf("%s / %s / %s ~ %s / %s\n", 
						os.getOpen_subject_id(), os.getSubject_name(), 
						os.getSubject_start_date(), os.getSubject_end_date(), os.getInstructor_status());
			}
			
			System.out.print("���� ���� ��ȣ > ");
			String open_subject_id = sc.nextLine();
			
			List<OpenSubject> list2 = osDAO.print7(open_subject_id, instructor_id);
			if(list2.size() > 0) {
				for(OpenSubject os : list2) {
					System.out.printf("���� ���� ��ȣ : %s\n", open_subject_id);
					System.out.printf("���� ������ : %s\n", os.getCourse_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", os.getOpen_course_start_date(), os.getOpen_course_end_date());
					System.out.printf("���ǽ� : %s\n", os.getClass_room_name());
					System.out.printf("���� ����� : %s\n", os.getSubject_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", os.getSubject_start_date(), os.getSubject_end_date());
					System.out.printf("����� : %s\n", os.getSubjectbook_name());					
					
					List<Exam> list3 = eDAO.print1(open_subject_id, instructor_id); 
					if(list3.size() > 0) {
						System.out.println("** ���� ���� **");
						for(Exam e : list3) {
							System.out.printf("���� ��ȣ : %s\n", e.getExam_id());
							System.out.printf("��� ���� : %d\n", e.getAttendance_point());
							System.out.printf("�ʱ� ���� : %d\n", e.getWrite_point());
							System.out.printf("�Ǳ� ���� : %d\n", e.getSkill_point());
							System.out.printf("���� ��¥ : %s\n", e.getExam_date());
							System.out.printf("���� ���� : %s\n", e.getExam_file());
						}
					} else {
						System.out.println("�˻� ����� �����ϴ�.");
					}
					
					if(list3.size() > 0) {
						System.out.println("�̹� ���� ������ ��ϵǾ� �ֽ��ϴ�.");
						System.out.print("�߰��� �����Ͻðڽ��ϱ�? (0/1) > ");
						int selectNum = sc.nextInt();
						sc.nextLine();
						if(selectNum == 1) {
							System.out.print("��� ���� > ");
							int attendance_point = sc.nextInt();
							sc.nextLine();
							System.out.print("�ʱ� ���� > ");
							int write_point = sc.nextInt();
							sc.nextLine();
							System.out.print("�Ǳ� ���� > ");
							int skill_point = sc.nextInt();
							sc.nextLine();
							System.out.print("���� ��¥ > ");
							//Date exam_date = sc.nextLine();
							System.out.print("���� ���� > ");
							String exam_file = sc.nextLine();
							//Exam e = new Exam("", "", attendance_point, write_point, skill_point,
							//		exam_date, exam_file);
						} else {
							break;
						}
					}
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 2. ���� ���� > 2. ���� ���
	private void m2_s2(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 2. ���� ���� > 3. ���� ����
	private void m2_s3(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 3. ���� ����
	private void m3(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 3. ���� ���� > 1. ���� �Է�
	private void m3_s1(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 3. ���� ���� > 2. ���� ���
	private void m3_s2(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 3. ���� ���� > 3. ���� ����
	private void m3_s3(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 4. ���� ����
	private void m4(Scanner sc) {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 4. ���� ���� > 1. ���� ���� ��ȸ
	private void m4_s1() {
		
	}
	
	// ���� ó�� �ý��� v6.0 (���� : OOO) > 4. ���� ���� > 2. ��� ��ȣ ����
	private void m4_s2(Scanner sc) {
		
	}
}
