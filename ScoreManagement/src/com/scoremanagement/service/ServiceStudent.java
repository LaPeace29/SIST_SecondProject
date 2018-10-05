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
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s)%n ", this.student_name);
			System.out.println("1. ���� ��ȸ  2. ���� ����");
			System.out.print("���� > ");
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
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : OOO) > 1. ���� ��ȸ
	private void m1(Scanner sc) {
		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ��ȸ %n", this.student_name);
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ������ / ���� ���� �Ⱓ");

			List<OpenCourse> list = this.ocDAO.print7(this.student_id);
			for (OpenCourse s : list) {
				System.out.println(s.print7());
			}
			/* OpenCourseDAO print7() */

			/*
			 * OC0001 / ����� ������ �м� ���� SW ������ / 2018-01-02 ~ 2018-05-06 OC0015 / Java &
			 * Python ��� ���� SW ������ �缺 ���� / 2018-06-25 ~ 2019-01-17
			 */
			System.out.println("-------------------------------");
			System.out.printf("�� %d �� %n", list.size());
			this.m1_s1(sc);

		}
	}

	// ���� ó�� �ý��� v6.0 (������ : OOO) > 1. ���� ��ȸ > ���� ������
	private void m1_s1(Scanner sc) {

		System.out.print("���� ���� ��ȣ > ");
		String open_course_id = sc.nextLine();

		List<OpenCourse> list1 = this.ocDAO.print5("open_course_id", this.student_id, open_course_id);

		if (list1.size() > 0) {

			for (OpenCourse oc : list1) {
				System.out.println("---------------------------------------------------------------");
				System.out.printf("���� ó�� �ý��� v6.0 (������ : ���μ�) > 1. ���� ��ȸ > %s", oc.getCourse_name());
				System.out.printf("���� ���� ��ȣ : %s%n", oc.getOpen_course_id());
				System.out.printf("���� ������ : %s%n", oc.getCourse_name());
				System.out.printf("���� ���� �Ⱓ : %s ~ %s %n", oc.getOpen_course_start_date(),
						oc.getOpen_course_end_date());
				System.out.printf("���ǽ� : %s%n", oc.getClass_room_name());
				System.out.printf("���� ���� : %s%n", oc.getCompletion_status());
				System.out.printf("�ߵ�Ż�� ��¥ : %s%n%n", oc.getDropout_date());
			}

			/* OpenCourse print5() */

		}
		List<OpenSubject> list2 = this.osDAO.print8(this.student_id, open_course_id);

		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ");

		for (OpenSubject os : list2) {
			System.out.println(os.print8());
		}
		/* OpenSubjectDAO print8() */

		System.out.println("-------------------------------");
		System.out.printf("�� %d ��%n", list2.size());

		System.out.print("���� ���� ��ȣ > ");
		String open_subject_id = sc.nextLine();

		System.out.println("---------------------------------------------------------------");
		List<OpenSubject> list3 = this.osDAO.print3(this.student_id, open_subject_id);
		for (OpenSubject os : list3) {
			System.out.printf("���� ����� : %s%n", os.getSubject_name());
			System.out.printf("���� ���� �Ⱓ : %s~%s%n", os.getSubject_start_date(), os.getSubject_end_date());

		}

		/* OpenSubjectDAO print3() */

		List<Exam> list4 = this.eDAO.print6(open_subject_id, this.student_id);

		if (list4.size() > 0) {

			for (Exam e : list4) {

				System.out.println("-------------------------------");
				System.out.printf("����� : %s%n", e.getSubjectbook_name());
				System.out.printf("����� : %s%n", e.getInstructor_name());
				System.out.printf("������ : %s%n", e.getAttendance_point());
				System.out.printf("�ʱ���� : %s%n", e.getWrite_point());
				System.out.printf("�Ǳ���� : %s%n", e.getSkill_point());
				System.out.printf("������� : %s%n", e.getAttendance_score());
				System.out.printf("�ʱ����� : %s%n", e.getWrite_score());
				System.out.printf("�Ǳ����� : %s%n", e.getSkill_score());
				System.out.printf("���賯¥ : %s%n", e.getExam_date());
				System.out.printf("���蹮�� : %s%n", e.getExam_file());

			}
		}

		System.out.println("-------------------------------");
		System.out.printf("�� %d��%n", list4.size());
		this.main(sc);

		/* ExamDAO print6() */

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
		List<Student> list = this.stDAO.print2("student_id", this.student_id);
		for(Student s : list) {
			System.out.printf("������ ��ȣ : %s\n", s.getStudent_id());
			System.out.printf("�̸� : %s\n", s.getStudent_name());
			System.out.printf("�޴��� ��ȣ : %s\n", s.getStudent_phone());
			System.out.printf("����� : %s\n", s.getStudent_regDate());
			System.out.println();
		}
		
		List<OpenCourse> list2 = this.ocDAO.print5("student_id", this.student_id, null);
		
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

		System.out.println("��й�ȣ�� �����Ͻðڽ��ϱ�? (0/1) > ");
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

		/*
		 * // Field private String student_id; // ������ ���̵� private String student_name;
		 * // ������ �̸� private String student_phone; // ������ �޴�����ȣ private Date
		 * student_regDate; // ������ ����� private String student_pw; // ������ ��й�ȣ private
		 * String completion_status; // ���� ����(���� ����, ���� �Ϸ�, �ߵ� Ż��) private Date
		 * completeion_date; // ��¥(�ߵ�Ż��, ����) private int count_; // ���� ���� ����
		 */
	}
}
