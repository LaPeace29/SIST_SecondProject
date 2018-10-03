package com.scoremanagement.service;

import java.util.Scanner;

import com.scoremanagement.domain.Student;
import com.scoremanagement.persistance.ExamDAO;
import com.scoremanagement.persistance.OpenCourseDAO;
import com.scoremanagement.persistance.OpenSubjectDAO;
import com.scoremanagement.persistance.StudentDAO;

public class ServiceStudent {

	private String student_name;
	private String student_id;
	private OpenCourseDAO ocDAO = new OpenCourseDAO();
	private OpenSubjectDAO osDAO = new OpenSubjectDAO();
	private ExamDAO eDAO = new ExamDAO(); 
	private StudentDAO stDAO = new StudentDAO();
	
	// ���� ó�� �ý��� v6.0 > 1. ������ �α���
	public void login(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 > 1. ������ �α���");
		System.out.print("�̸� > ");
		String student_name = sc.nextLine();
		System.out.print("��й�ȣ > ");
		String student_pw = sc.nextLine();
		
		int result = this.stDAO.login(new Student(student_name, student_pw));
		if (result ==0) {
			System.out.println("���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");	
		} else {
			
			System.out.printf("������ %s ���� �α��εǾ����ϴ�.%n", student_name);	
			
			this.main(sc);
		}
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) 
	private void main(Scanner sc) {
		while(true) {
			
			System.out.println("---------------------------------------------------------------");
			System.out.println("���� ó�� �ý��� v6.0 (������ : %s) ");
			System.out.println("1. ���� ��ȸ  2. ���� ����");
			System.out.print("���� > ");
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
				break;
			
			}
		}
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 1. ���� ��ȸ
	private void m1(Scanner sc) {
		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ��ȸ");
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ������ / ���� ���� �Ⱓ");
			this.ocDAO.print7();
			/* OpenCourseDAO print7() */

			/*
			 * OC0001 / ����� ������ �м� ���� SW ������ / 2018-01-02 ~ 2018-05-06 OC0015 / Java &
			 * Python ��� ���� SW ������ �缺 ���� / 2018-06-25 ~ 2019-01-17
			 */
			System.out.println("-------------------------------");
			System.out.println("�� %d ��");

			System.out.print("���� ���� ��ȣ > ");
			String open_course_id = sc.nextLine();
		}
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 1. ���� ��ȸ > ���� ������
	private void m1_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : ���μ�) > 1. ���� ��ȸ > ����� ������ �м� ���� SW ������");

		System.out.print("���� ���� ��ȣ : ");
		System.out.print("���� ������ : ");
		System.out.print("���� ���� �Ⱓ : ");
		System.out.print("���ǽ� : ");
		System.out.print("���� ���� : ");
		System.out.print("�ߵ�Ż�� ��¥ : ");
		/* OpenCourse print5() */
		this.ocDAO.print5();

		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ");
		/* OpenSubjectDAO print8() */
		this.osDAO.print8();
		System.out.println("-------------------------------");
		System.out.println("�� %d ��");

		System.out.print("���� ���� ��ȣ > ");
		String open_subject_id = sc.nextLine();
		System.out.print("�缺 ���� > ");
		String open_course_id = sc.nextLine();

		System.out.println("---------------------------------------------------------------");
		System.out.print("���� ����� : ");
		System.out.print("���� ���� �Ⱓ :");
		/* OpenSubjectDAO print3() */
		this.ocDAO.print3();

		System.out.println("-------------------------------");
		System.out.print("����� : ");
		System.out.print("����� : ");
		System.out.print("������ : ");
		System.out.print("�ʱ���� : ");
		System.out.print("�Ǳ���� : ");
		System.out.print("������� : ");
		System.out.print("�ʱ����� : ");
		System.out.print("�Ǳ����� : ");
		System.out.print("���賯¥ : ");
		System.out.print("���蹮�� : ");
		/* ExamDAO print6() */
		this.eDAO.print6();
		System.out.println("-------------------------------");
		System.out.println("�� %d��");
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 2. ���� ����
	private void m2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : ���μ�) > 2. ���� ����");
		System.out.println("1. ���� ���� ��ȸ  2. ��� ��ȣ ����");
		System.out.print("���� > ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println("---------------------------------------------------------------");
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 2. ���� ���� > 1. ���� ���� ��ȸ
	private void m2_s1() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : ���μ�) > 2. ���� ���� > 1. ���� ���� ��ȸ");
		System.out.print("�̸� : ");
		System.out.print("��ȭ��ȣ : ");
		/*StudentDAO print1()*/
		this.stDAO.print1(student_id);
		
		System.out.println("-------------------------------");
		System.out.print("���� ��û ������ : ");
		System.out.print("���� ���� �Ⱓ : ");
		System.out.print("���ǽ� : ");
		System.out.print("���� ���� : ");
		System.out.print("�ߵ�Ż�� ��¥ : ");
		/*OpenCourse print5()*/
		this.ocDAO.print5();
		System.out.println("-------------------------------");
	}
	
	// ���� ó�� �ý��� v6.0 (������ : OOO) > 2. ���� ���� > 2. ��� ��ȣ ����
	private void m2_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : ���μ�) > 2. ���� ���� > 2. ��� ��ȣ ����");
		System.out.print("���� ��й�ȣ > ");
		String student_pw = sc.nextLine();
		System.out.print("�ű� ��й�ȣ > ");
		String student_new_pw = sc.nextLine();
		System.out.print("��й�ȣ Ȯ�� > ");
		
		int result = this.stDAO.modify(new Student(this.student_name, student_new_pw ));
		
		if (result ==0) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");	
		} else {
			System.out.printf("������ %s ���� �α��εǾ����ϴ�.%n", this.student_name);	
			
		}
		
		System.out.print("��й�ȣ�� �����Ͻðڽ��ϱ�? (0/1) > ");
		
		System.out.println("������ '���μ�'�� ��й�ȣ�� ����Ǿ����ϴ�.");
		
		/*// Field
		private String student_id;			// ������ ���̵�
		private String student_name;		// ������ �̸�
		private String student_phone;		// ������ �޴�����ȣ
		private Date student_regDate;		// ������ �����
		private String student_pw;			// ������ ��й�ȣ
		private String completion_status;	// ���� ����(���� ����, ���� �Ϸ�, �ߵ� Ż��)
		private Date completeion_date;		// ��¥(�ߵ�Ż��, ����)
		private int count_;					// ���� ���� ����
*/	}
}
