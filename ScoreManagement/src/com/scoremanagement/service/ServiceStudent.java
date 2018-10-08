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

	private StudentDAO stDAO = new StudentDAO();
	private ExamDAO eDAO = new ExamDAO(); 
	private OpenCourseDAO ocDAO = new OpenCourseDAO();
	private OpenSubjectDAO osDAO = new OpenSubjectDAO();
	
	private String student_id = null;
	private String student_name = null;
	
	// ���� ó�� �ý��� v6.0 > 1. ������ �α���
	public void login(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 > 1. ������ �α���");
		System.out.print("�̸� > ");
		this.student_name = sc.nextLine();

		System.out.print("��й�ȣ > ");
		String student_pw = sc.nextLine();

		Student s = new Student(this.student_name, student_pw, "");
		this.student_id = this.stDAO.login(s);

		if (student_id != null) {
			System.out.printf("������ '%s'���� �α��εǾ����ϴ�.\n", this.student_name);
			this.main(sc);
		} else {
			System.out.println("���̵� �Ǵ� �н����尡 Ʋ�Ƚ��ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : OOO)
	private void main(Scanner sc) {
		while (true) {

			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s)\n ", this.student_name);
			System.out.println("1. ���� ��ȸ  2. ���� ����");
			System.out.print("���� > ");
			int num = sc.nextInt();
			sc.nextLine();

			if (num == 0) {
				System.out.printf("������ '%s'���� �α׾ƿ� �Ǿ����ϴ�.\n", this.student_name);
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
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : OOO) > 1. ���� ��ȸ
	private void m1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ��ȸ\n", this.student_name);

		List<OpenCourse> list1 = this.ocDAO.list1(this.student_id);
		
		if(list1.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ������ / ���� ���� �Ⱓ / ���ǽǸ�");
			for (OpenCourse oc : list1) {
				System.out.println(oc.print1());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list1.size());
		
			System.out.print("���� ���� ��ȣ > ");
			String open_course_id = sc.nextLine();

			List<OpenCourse> list2 = this.ocDAO.list5("open_course_idANDstudent_id", 
					new OpenCourse(open_course_id, null, this.student_id,null));
			
			if(list2.size() > 0) {
				for(OpenCourse oc : list2) {
					this.m1_s1(sc, oc);
				}
			}
			
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : OOO) > 1. ���� ��ȸ > ���� ������
	private void m1_s1(Scanner sc, OpenCourse oc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ��ȸ > %s\n", this.student_name, oc.getCourse_name());
		
		System.out.printf("���� ���� ��ȣ : %s%n", oc.getOpen_course_id());
		System.out.printf("���� ������ : %s%n", oc.getCourse_name());
		System.out.printf("���� ���� �Ⱓ : %s ~ %s %n", oc.getOpen_course_start_date(),
				oc.getOpen_course_end_date());
		System.out.printf("���ǽ� : %s%n", oc.getClass_room_name());
		System.out.printf("���� ���� : %s%n", oc.getCompletion_status());
		System.out.printf("%s ��¥ : %s%n", oc.getCompletion_status(), oc.getDropout_date());
				
		List<OpenSubject> list1 = this.osDAO.list1("open_course_idANDstudent_id", 
				new OpenSubject(null, null,  oc.getOpen_course_id(), null, this.student_id, null));

		if(list1.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / �����");

			for (OpenSubject os : list1) {
				System.out.println(os.print1());
			}

			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list1.size());

			System.out.print("���� ���� ��ȣ > ");
			String open_subject_id = sc.nextLine();

			System.out.println("---------------------------------------------------------------");
			List<OpenSubject> list2 = this.osDAO.list1("open_subject_idANDstudent_id", 
					new OpenSubject(open_subject_id, null, null, null, this.student_id, null));
			
			for (OpenSubject os : list2) {				
				System.out.printf("���� ���� ��ȣ : %s\n", os.getOpen_subject_id());
				System.out.printf("���� ����� : %s\n", os.getSubject_name());
				System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", os.getSubject_start_date(), os.getSubject_end_date());
				System.out.printf("����� : %s\n", os.getSubjectbook_name());
				System.out.printf("����� : %s\n", os.getInstructor_name());
			}

			List<Exam> list3 = this.eDAO.list2("open_subject_idANDstudent_id", 
					new Exam(null, open_subject_id, this.student_id, null));

			if (list3.size() > 0) {

				for (Exam e : list3) {
					System.out.println("-------------------------------");					
					System.out.printf("���� ��ȣ : %s%n", e.getExam_id());
					System.out.printf("��� ���� : %s%n", e.getAttendance_point());
					System.out.printf("�ʱ� ���� : %s%n", e.getWrite_point());
					System.out.printf("�Ǳ� ���� : %s%n", e.getSkill_point());
					System.out.printf("��� ���� : %s%n", e.getAttendance_score());
					System.out.printf("�ʱ� ���� : %s%n", e.getWrite_score());
					System.out.printf("�Ǳ� ���� : %s%n", e.getSkill_score());
					System.out.printf("���� ��¥ : %s%n", e.getExam_date());
					System.out.printf("���� ���� : %s%n", e.getExam_file());
					System.out.println("-------------------------------");
				}
				System.out.printf("�� %d��\n", list3.size());
			}
		}
	}

	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 2. ���� ����
	private void m2(Scanner sc) {
		boolean run = true;
		while(run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ����\n", this.student_name);
			System.out.println("1. ���� ���� ��ȸ  2. ��� ��ȣ ����");
			System.out.print("���� > ");
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
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 2. ���� ���� > 1. ���� ���� ��ȸ
	private void m2_s1() {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� > 1. ���� ���� ��ȸ\n", this.student_name);
		
		List<Student> list = this.stDAO.search("student_id", new Student(student_id, null, null, null, null));
		
		for(Student s : list) {
			System.out.printf("������ ��ȣ : %s\n", s.getStudent_id());
			System.out.printf("�̸� : %s\n", s.getStudent_name());
			System.out.printf("�޴��� ��ȣ : %s\n", s.getStudent_phone());
			System.out.printf("����� : %s\n", s.getStudent_regDate());
		}
		
		List<OpenCourse> list2 = this.ocDAO.list5("student_id", new OpenCourse(null, null, this.student_id, null));
		
		if(list2.size() > 0) {
			System.out.println("-------------------------------");
			
			for(OpenCourse oc : list2) {
				System.out.printf("���� ������ : %s\n", oc.getCourse_name());
				System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
				System.out.printf("���ǽ� : %s\n", oc.getClass_room_name());
				System.out.printf("���� ���� : %s\n", oc.getCompletion_status());
				System.out.printf("%s ��¥ : %s\n", oc.getCompletion_status(), oc.getDropout_date());
				System.out.println();
			}
			System.out.println("-------------------------------");
			System.out.printf("���� ���� Ƚ�� : %d��\n", list2.size());
		}
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 2. ���� ���� > 2. ��� ��ȣ ����
	private void m2_s2(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� > 2. ��� ��ȣ ����\n", this.student_name);
		System.out.print("���� ��й�ȣ > ");
		String student_pw = sc.nextLine();
		System.out.print("�ű� ��й�ȣ > ");
		String student_new_pw = sc.nextLine();
		System.out.print("��й�ȣ Ȯ�� > ");
		String student_new_pw2 = sc.nextLine();

		System.out.print("��й�ȣ�� �����Ͻðڽ��ϱ�? (0/1) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();

		if (student_new_pw.equals(student_new_pw2)) {
			if (selectNum == 1) {
				int result = this.stDAO.modify(new Student(this.student_name, student_pw, student_new_pw));

				if (result > 0) {
					System.out.printf("������ '%s'�� ��й�ȣ�� ����Ǿ����ϴ�.\n", this.student_name);
				} else {
					System.out.println("�����߽��ϴ�.");
				}
			}
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
}
