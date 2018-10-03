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

	// ���� ó�� �ý��� v6.0 > 3. ������ �α���
	public void login(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin)
	private void main(Scanner sc) {

		while (true) {
			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) ");
			System.out.println("1. ���� ���� ����  2. ���� ���� ����  3. ���� ���� ����  4. ���� ���� ����  5. ������ ����  6. ���� ��ȸ  7. ��й�ȣ ����");
			System.out.print("���� > ");

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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ����
	private void m1(Scanner sc) {

		while (true) {
			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ����");
			System.out.println("1. ���� ����  2. ���� ����  3. ���ǽ� ����  4. ���� ����");
			System.out.println("���� > ");

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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ����
	private void m1_s1(Scanner sc) {

		while (true) {
			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ����");
			System.out.println("1. ���� ����  2. ���� ����  3. ���ǽ� ����  4. ���� ����");
			System.out.println("���� > ");

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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 1. ���� �Է�
	private void m1_s1_s1(Scanner sc) {

		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 1. ���� �Է�");

		System.out.print("������ > ");
		String course_name = sc.nextLine();

		System.out.print("����Ͻðڽ��ϱ�?(1/0) > ");

		System.out.println("������ �߰��Ǿ����ϴ�.");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 2. ���� ���
	private void m1_s1_s2() {

		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 2. ���� ���");
		System.out.println("--------------------");
		System.out.println("���� ��ȣ / ������");
		System.out.println("--------------------");
		System.out.printf("�� 00��");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 3. ���� ����
	private void m1_s1_s3(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 3. ���� ����");
		System.out.println("--------------------");
		System.out.println("���� ��ȣ / ������ / ���� ���� ����");
		System.out.println("--------------------");
		System.out.println("�� : 11�� ");

		System.out.print("���� ��ȣ >");
		String course_id = sc.nextLine();

		System.out.print("������ : ");
		System.out.print("���� ������ �����Ͻðڽ��ϱ�?(0/1) > ");

		System.out.println("000000�� �����Ǿ����ϴ�.");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ����
	private void m1_s2(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ���� > 1. ���� �Է�
	private void m1_s2_s1(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ���� > 2. ���� ���
	private void m1_s2_s2() {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ���� > 3. ���� ����
	private void m1_s2_s3(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ����
	private void m1_s3(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 1. ���ǽ� �Է�
	private void m1_s3_s1(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 2. ���ǽ� ���
	private void m1_s3_s2() {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 3. ���ǽ� ����
	private void m1_s3_s3(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ����
	private void m1_s4(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 1. ���� �Է�
	private void m1_s4_s1(Scanner sc) {

		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 1. ���� �Է�");
		System.out.println("-------------------------------");
		System.out.print("����� > ");
		String subjectbook_name = sc.nextLine();
		System.out.print("���� ���ǻ� > ");
		String subjectbook_publisher = sc.nextLine();
		System.out.print("����Ͻðڽ��ϱ�?(0/1)");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 2. ���� ���
	private void m1_s4_s2() {

		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 2. ���� ���");

		System.out.println("-------------------------------");

		System.out.println("���� ��ȣ / ����� / ���� ���ǻ�");
		System.out.println("-------------------------------");
		System.out.println("�� : 00��");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 3. ���� ����
	private void m1_s4_s3(Scanner sc) {

		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ����");
		System.out.println("-------------------------------");
		System.out.println("���� ��ȣ / ����� / ���� ���ǻ� / ���� ���� ����");

		System.out.println("-------------------------------");
		System.out.println("�� 00��");
		System.out.print("���� ��ȣ > ");
		String subjectbook_id = sc.nextLine();
		System.out.print("����� > ");
		String sujbectbook_name = sc.nextLine();
		System.out.print("���� ���ǻ� > ");
		String subjectbook_publisher = sc.nextLine();
		System.out.print("���� ���縦 �����Ͻðڽ��ϱ�? (0/1) ");
		int select = sc.nextInt();

		if (select == 1) {
			System.out.println("SB022��(��) �����Ǿ����ϴ�.");
		}

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ����
	private void m2(Scanner sc) {

		while (true) {
			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ����");
			System.out.println("1. ���� �Է� 2. ���� �˻� �� ��� 3. ���� ���� 4. ��й�ȣ �ʱ�ȭ 5. ���� ���� ���� ����");
			System.out.print("���� > ");
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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 1. ���� �Է�
	private void m2_s1(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 1. ���� �Է�");

		System.out.print("���� �̸� > ");
		String instructor_id = sc.nextLine();
		System.out.print("���� �޴�����ȣ > ");
		String instructor_name = sc.nextLine();
		System.out.print("���� ��й�ȣ > ");
		String instructor_pw = sc.nextLine();
		System.out.print("���� ����� > ");
		String instructor_regDate = sc.nextLine();

		System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
		System.out.println("���簡 �߰��Ǿ����ϴ�.");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ���
	private void m2_s2(Scanner sc) {

		while (true) {
			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ���");
			System.out.println("1. ���� ��ȣ  2. ���� �̸�  3. ���� ��ü ���");
			System.out.print("���� > ");
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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 1. ���� ��ȣ
	private void m2_s2_s1(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 1. ���� ��ȣ");

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();

		System.out.print("���� �̸� : ");
		System.out.print("���� ��ȭ��ȣ : ");

		System.out.println("-------------------------------");
		System.out.println("���� ����� / ���� ���� �Ⱓ / ���� ������ / ���� ���� �Ⱓ / ���ǽ� / ���� ���� ����");
		System.out.println("-------------------------------");
		System.out.println("�� 00��");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 2. ���� �̸�
	private void m2_s2_s2(Scanner sc) {

		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 2. ���� �̸�");

		System.out.print("���� �̸� > ");
		String instructor_name = sc.nextLine();
		System.out.println("���� ��ȣ / ���� �̸� / ���� �޴�����ȣ / �����");
		System.out.println("-------------------------------");
		System.out.println("�� 00��");

		System.out.println("�˻� ����� �������Դϴ�.");

		this.m2_s2_s1(sc);

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 3. ���� ��ü ���
	private void m2_s2_s3() {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 3. ���� ��ü ���");
		System.out.println("-------------------------------");
		System.out.println("���� ��ȣ / ���� �̸� / ���� �޴�����ȣ / ���� ����� / ���� ���� ����");
		System.out.println("-------------------------------");
		System.out.println("�� 00��");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 3. ���� ����
	private void m2_s3(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 3. ���� ����");
		System.out.println("-------------------------------");
		System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / ���� ����� / ���� ���� ���� / ���� ���� ����");
		System.out.println("-------------------------------");
		System.out.println("�� 00��");

		System.out.print("���� ��ȣ > ");

		System.out.print("���� �̸� : ");
		System.out.print("��ȭ��ȣ : ");
		System.out.print("���� ���縦 �����Ͻðڽ��ϱ�? (0/1) >");
		System.out.println("00�� �����Ǿ����ϴ�.");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 4. ��й�ȣ �ʱ�ȭ
	private void m2_s4(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 4. ��й�ȣ �ʱ�ȭ");
		System.out.println("-------------------------------");
		System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / ���� ����� / ���� ���� ����");
		System.out.println("-------------------------------");
		System.out.println("�� 00��");

		System.out.print("���� ��ȣ > ");

		System.out.print("���� �̸� : ");
		System.out.print("��ȭ��ȣ : ");

		System.out.print("���� ��й�ȣ > ");
		System.out.println("�����Ͻðڽ��ϱ�? (0/1) > ");
		System.out.println("'INS001'�� ��й�ȣ�� �ʱ�ȭ�Ǿ����ϴ�.");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ����
	private void m2_s5(Scanner sc) {

		while (true) {

			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ����");
			System.out.println("1. ���� ���� ���� �߰�  2. ���� ���� ���� ����");
			System.out.print("���� > ");

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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 1. ���� ���� ���� �߰�
	private void m2_s5_s1(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 1. ���� ���� ���� �߰�");

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();

		while (true) {
			System.out.print("���� �̸� : ");
			System.out.print("���� �޴�����ȣ : ");
			System.out.println("-------------------------------");

			System.out.println("���� ���� ����");
			System.out.println("�� 00��");
			System.out.println("-------------------------------");

			System.out.print("���� ��ȣ (1/0) > ");
			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;

			}

			if (select == 1) {
				System.out.println("-------------------------------");
				System.out.println("���� ��ȣ / �����");
				System.out.println("-------------------------------");
				System.out.println("�� 00��");

				System.out.print("���� ��ȣ > ");
				String subject_id = sc.nextLine();

				System.out.print("���� ��ȣ : ");
				System.out.print("����� : ");

				System.out.print("����Ͻðڽ��ϱ�? > (0/1) > ");

				if (select == 1) {
					System.out.println("���� ���� ������ �߰��Ǿ����ϴ�.");
				}
			}
		}

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 2. ���� ���� ���� ����
	// ���������
	private void m2_s5_s2(Scanner sc) {
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 2. ���� ���� ���� ����");

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();
		System.out.print("���� �̸� : ");
		System.out.print("���� �޴��� ��ȣ : ");

		System.out.println("-------------------------------");
		System.out.println("���� ���� ����");
		System.out.println("-------------------------------");
		System.out.println("�� 00��");

		System.out.print("������ ���� ��ȣ > ");
		String subject_id = sc.nextLine();

		System.out.print("���� ��ȣ : ");
		System.out.print("����� : ");

		System.out.println("���� �Ͻðڽ��ϱ�? (0/1) > ");

		System.out.println("���� �Ǿ����ϴ�.");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ����
	private void m3(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������:%s) > 3. ���� ���� ����\n");
			System.out.println("--------------");
			System.out.println("1. ���� ���� �߰�  2. ���� ���� �˻� �� ���  3. ���� ���� ����");
			System.out.print("���� > ");

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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 1. ���� ���� �߰�
	private void m3_s1(Scanner sc) {
		System.out.println("-------------------------------");
		List<Course> list1 = this.cDAO.print1(); // ������ȣ, �����̸� ���
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());

		System.out.print("���� ��ȣ > ");
		String open_course_id = sc.nextLine();
		sc.nextInt();
		System.out.print("���� ���� ������ > ");
		String open_course_start_date = sc.nextLine();
		sc.nextInt();
		System.out.print("���� ���� ������ > ");
		String open_course_end_date = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<ClassRoom> list2 = this.crDAO.print1(); // ���ǽ� ���̵�, ���ǽ� �̸�, �ִ����� ���
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list2.size());

		System.out.print("���ǽ� ��ȣ > ");
		String class_room_id = sc.nextLine();
		sc.nextInt();

		System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// ���� ���� ���
			System.out.println("���� ������ �߰��Ǿ����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ���
	private void m3_s2(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ���\n");
			System.out.println("--------------");
			System.out.println("1. ���� ���� ��ȣ  2. ���� ������  3. ���� ���� ��ü ���");
			System.out.print("���� > ");

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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 1. ���� ���� ��ȣ
	private void m3_s2_s1(Scanner sc) {
		System.out.print("���� ���� ��ȣ > ");
		String open_course_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<OpenCourse> list1 = this.ocDAO.print1();

		System.out.print("** ���� ���� ���� **");
		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / �����");
		List<OpenSubject> list2 = this.osDAO.print4();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list2.size());

		System.out.print(" ** ������ ���� **");
		System.out.println("-------------------------------");
		System.out.println("������ ��ȣ / ������ �̸� / ��ȭ��ȣ / ����� / ���Ῡ�� / ��¥(�ߵ�Ż���� Ż����, ���� ������)");
		List<Student> list3 = this.stDAO.print4();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list3.size());
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 2. ���� ������
	private void m3_s2_s2(Scanner sc) {
		System.out.print("���� ������ > ");
		String course_name = sc.nextLine();
		sc.nextInt();
		System.out.println("-------------------------------");

		System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ�");
		List<OpenCourse> list1 = this.ocDAO.print1();

		// �˻� ����� �������� ���
		if (list1.size() > 1) {
			System.out.println("�˻� ����� �������Դϴ�.");
			this.m3_s2_s1(sc); // ���� ���� ��ȣ �˻� �޼ҵ�� �Ѿ
			System.out.println("-------------------------------");
		}

		// �˻� ����� �ϳ��� ���
		else {
			System.out.print("** ���� ���� ���� **");
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / �����");
			List<OpenSubject> list2 = this.osDAO.print4();
			System.out.println("-------------------------------");

			System.out.print(" ** ������ ���� **");
			System.out.println("-------------------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ��ȭ��ȣ / ����� / ���Ῡ�� / ��¥(�ߵ�Ż���� Ż����, ���� ������)");
			List<Student> list3 = this.stDAO.print4();
			System.out.println("-------------------------------");
			System.out.printf("�� %s��", list3.size());

		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 3. ���� ���� ��ü
	// ���
	private void m3_s2_s3() {
		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�");
		List<OpenCourse> list1 = this.ocDAO.print2();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 3. ���� ���� ����
	private void m3_s3(Scanner sc) {
		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���ǽǸ� / ������ / ���� ���� �Ⱓ / ���� ���� ����");
		List<OpenCourse> list1 = this.ocDAO.print3();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());

		System.out.print("���� ���� ��ȣ > ");
		String open_course_id = sc.nextLine();
		sc.nextInt();

		// ���� ���� ��ȣ�� ���� ���� ������, ���� ���� �Ⱓ, ���ǽǸ� ���
		List<OpenCourse> list2 = this.ocDAO.print1();

		System.out.print("���� ���� ������ �����Ͻðڽ��ϱ�? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// ���� ���� ����
			System.out.println("�����Ǿ����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ����
	private void m4(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ����\n");
			System.out.println("--------------");
			System.out.println("1. ���� ���� �߰�  2. ���� ���� �˻� �� ���  3. ���� ���� ����");
			System.out.print("���� > ");

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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 1. ���� ���� �߰�
	private void m4_s1(Scanner sc) {
		System.out.println("-------------------------------");
		List<OpenCourse> list1 = this.ocDAO.print4();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());

		String open_course_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<Subject> list2 = this.sDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list2.size());

		String open_course_start_date = sc.nextLine();
		sc.nextInt();
		String open_course_end_date = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<Subjectbook> list3 = this.sbDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list3.size());

		String subjectbook_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		List<Instructor> list4 = this.iDAO.print3();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list4.size());

		String instructor_id = sc.nextLine();
		sc.nextInt();

		System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// ���� ���� ���
			System.out.println("���� ������ �߰��Ǿ����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ���
	private void m4_s2(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("--------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ���");
			System.out.println("--------------");
			System.out.println("1. ���� ���� ��ȣ  2. ���� �����  3. ���� ���� ��ü ���");
			System.out.print("���� > ");

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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 1. ���� ���� ��ȣ
	private void m4_s2_s1(Scanner sc) {
		String open_course_id = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽ�");
		List<OpenSubject> list1 = this.osDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 2. ���� �����
	private void m4_s2_s2(Scanner sc) {

		String course_name = sc.nextLine();
		sc.nextInt();

		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽ�");
		List<OpenSubject> list1 = this.osDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 3. ���� ���� ��ü
	// ���
	private void m4_s2_s3() {
		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽ�");
		List<OpenSubject> list1 = this.osDAO.print1();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 3. ���� ���� ����
	private void m4_s3(Scanner sc) {
		System.out.println("-------------------------------");
		System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽ� / ���� ���� ����");
		List<OpenSubject> list1 = this.osDAO.print2();
		System.out.println("-------------------------------");
		System.out.printf("�� %s��", list1.size());

		String open_course_id = sc.nextLine();
		sc.nextInt();
		List<OpenSubject> list2 = this.osDAO.print3();

		System.out.print("���� ���� ������ �����Ͻðڽ��ϱ�? (0/1) > ");
		int iNum = sc.nextInt();
		if (iNum == 1) {
			// ���� ���� ����
			System.out.println("�����Ǿ����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ����
	private void m5(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 1. ������ �Է�
	private void m5_s1(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ���
	private void m5_s2(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 1. ������ ��ȣ
	private void m5_s2_s1(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 2. ������ �̸�
	private void m5_s2_s2(Scanner sc) {

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 3. ������ ��ü ���
	private void m5_s2_s3() {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 3. ������ ��ü ���");
		System.out.println("---------------------------------------------------------------");
		
		List<Student> list = this.stDAO.print3();
		if (list.size() > 0) {
			System.out.println("--------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���� Ƚ��");
			for (Student s : list) {
				//System.out.println(s.print3());
			}
			System.out.println("--------------");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 3. ������ ����
	private void m5_s3(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 3. ������ ����");
		System.out.println("---------------------------------------------------------------");

		List<Student> list = this.stDAO.print2();
		System.out.println("--------------");
		System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���� ���� ����");
		for (Student s : list) {
			//System.out.println(s.print2());
		}
		System.out.println("--------------");

		System.out.printf("�� %d�� \n", list.size());
		System.out.print("������ ��ȣ >");
		String student_id = sc.nextLine();
		List<Student> list2 = this.stDAO.search("student_id", student_id);
		if (list2.size() > 0) {
			for (Student s : list2) {
				System.out.printf("������ �̸� : %s\n", s.getStudent_name());
				System.out.printf("������ ��ȭ��ȣ : %s\n", s.getStudent_phone());
			}
			System.out.println();
			System.out.println("���� �������� �����Ͻðڽ��ϱ�? (0/1) >");
			int check = sc.nextInt();
			sc.nextLine();

			if (check == 1) {
				Student s = new Student(student_id, "");

				this.stDAO.remove(s);

				System.out.printf("'%s' �� �����Ǿ����ϴ�.", student_id);
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 4. ��й�ȣ �ʱ�ȭ
	private void m5_s4(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 4. ��й�ȣ �ʱ�ȭ");
		System.out.println("---------------------------------------------------------------");
				
		List<Student> list = this.stDAO.print2();
		if (list.size() > 0) {
			System.out.println("--------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ �����");
			for (Student s : list) {
				//System.out.println(s.print1());
			}
			System.out.println("--------------");
			System.out.printf("�� %d�� \n", list.size());
		}

		System.out.print("������ ��ȣ >");
		String student_id = sc.nextLine();
		List<Student> list2 = this.stDAO.search("student_id", student_id);
		if (list2.size() > 0) {
			for (Student s : list2) {
				System.out.printf("������ �̸� : %s\n", s.getStudent_name());
				System.out.printf("������ ��ȭ��ȣ : %s\n", s.getStudent_phone());
			}
			System.out.println();
			System.out.println("������ ��й�ȣ >");
			String student_pw = sc.nextLine();

			System.out.println("�����Ͻðڽ��ϱ�? (0/1) >");
			int check = sc.nextInt();
			sc.nextLine();

			if (check == 1) {
				Student s = new Student(student_id, student_pw);

				int m = this.stDAO.reset(s);

				if (m == 1) {
					System.out.printf("'%s'�� ��й�ȣ�� �ʱ�ȭ�Ǿ����ϴ�.", student_id);
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ����
	private void m5_s5(Scanner sc) {
		while (true) {
			System.out.println();
			System.out.println("--------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ :%s)%n > 5. ������ ���� > 5. ������ ���� ����");
			System.out.println("--------------");
			System.out.println("1. ������ ���� ���  2. ������ ���� ���  3. ������ �ߵ� Ż��");
			System.out.print("����>");
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

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 1. ������ ���� ���
	private void m5_s5_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 1. ������ ���� ���");
		System.out.println("---------------------------------------------------------------");
		
		System.out.println("������ ��ȣ >");
		String student_id = sc.nextLine();
		
		List<Student> list = this.stDAO.search("student_id", student_id);
		if (list.size() > 0) {
			for (Student s : list) {
				System.out.println("-------------------------------");
				//System.out.println(s.print3());
				System.out.println("-------------------------------");
			}
			System.out.printf("�� %d�� \n", list.size());
		}
		
		List<OpenCourse> list2 = this.ocDAO.print2();
		if (list2.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�");
			for (OpenCourse oc : list2) {
				//System.out.println(oc.print2());
				System.out.println("--------------");
			}
			System.out.printf("�� %d�� \n", list.size());
		}
		
		System.out.println("���� ���� ��ȣ >");
		String open_course_id = sc.nextLine();
		
		List<OpenCourse> list3 = this.ocDAO.search("open_course_id", open_course_id);
		if(list3.size() > 0) {
			for(OpenCourse oc : list3) {
				System.out.printf("���� ���� ��ȣ : ", open_course_id);
				System.out.printf("���� ������ : ", oc.getCourse_name());
				System.out.printf("���� ���� �Ⱓ : %tF ~ %tF ", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
				System.out.printf("���ǽǸ� : ", oc.getClass_room_name());
			}
			
		}
		
		System.out.println("����Ͻðڽ��ϱ�? (0/1) > ");
		int check = sc.nextInt();
		sc.nextLine();
		if(check == 1) {
			StudentHistory s = new StudentHistory(student_id, open_course_id);
			stDAO.studentHistoryAdd(s);
		}
		
		
		
	/*
		
		
		�� 16��
		
		���� ���� ��ȣ > OC0014
		 
		���� ���� ��ȣ : OC0014
		���� ������ : ����� ������ �м� ����SW������
		���� ���� �Ⱓ :  2018-12-05 ~ 2019-07-04
		���ǽǸ� : 7���ǽ�
		
		����Ͻðڽ��ϱ�? (0/1) > 1
				
		��ϵǾ����ϴ�.*/
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 2. ������ ���� ���
	private void m5_s5_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 2. ������ ���� ���");
		System.out.println("---------------------------------------------------------------");
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 3. ������ �ߵ� Ż��
		private void m5_s5_s3(Scanner sc) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 3. ������ �ߵ� Ż��");
			System.out.println("---------------------------------------------------------------");
		

		}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ
	private void m6(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ");
		System.out.println("---------------------------------------------------------------");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 1. ���� ���� ���� ��ȸ
	private void m6_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 1. ���� ���� ���� ��ȸ");
		System.out.println("---------------------------------------------------------------");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ
	private void m6_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ");
		System.out.println("---------------------------------------------------------------");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 1. ������ ��ȣ
	private void m6_s2_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 1. ������ ��ȣ");
		System.out.println("---------------------------------------------------------------");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 2. ������ �̸�
	private void m6_s2_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 2. ������ �̸�");
		System.out.println("---------------------------------------------------------------");

	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 7. ��й�ȣ ����
	private void m7(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 (������ : admin) > 7. ��й�ȣ ����");
		System.out.println("---------------------------------------------------------------");

	}
	
	private void ocPrint(List<Course> list) {
		System.out.println("-------------------------------");
			for(Course c : list) {
				System.out.println(c.toString());
			}
		System.out.println("-------------------------------");
		System.out.printf("�� %s��" , list.size());

	}
}