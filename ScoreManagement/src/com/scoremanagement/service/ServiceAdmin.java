package com.scoremanagement.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.scoremanagement.domain.Admin;
import com.scoremanagement.domain.ClassRoom;
import com.scoremanagement.domain.Course;
import com.scoremanagement.domain.Exam;
import com.scoremanagement.domain.Instructor;
import com.scoremanagement.domain.InstructorPossible;
import com.scoremanagement.domain.OpenCourse;
import com.scoremanagement.domain.OpenSubject;
import com.scoremanagement.domain.Student;
import com.scoremanagement.domain.StudentHistory;
import com.scoremanagement.domain.Subject;
import com.scoremanagement.domain.Subjectbook;
import com.scoremanagement.persistance.AdminDAO;
import com.scoremanagement.persistance.ClassRoomDAO;
import com.scoremanagement.persistance.CourseDAO;
import com.scoremanagement.persistance.ExamDAO;
import com.scoremanagement.persistance.InstructorDAO;
import com.scoremanagement.persistance.InstructorPossibleDAO;
import com.scoremanagement.persistance.OpenCourseDAO;
import com.scoremanagement.persistance.OpenSubjectDAO;
import com.scoremanagement.persistance.StudentDAO;
import com.scoremanagement.persistance.SubjectDAO;
import com.scoremanagement.persistance.SubjectbookDAO;

public class ServiceAdmin {

	private AdminDAO aDAO = new AdminDAO();
	private CourseDAO cDAO = new CourseDAO();
	private ClassRoomDAO crDAO = new ClassRoomDAO();
	private OpenCourseDAO ocDAO = new OpenCourseDAO();
	private OpenSubjectDAO osDAO = new OpenSubjectDAO();
	private StudentDAO stDAO = new StudentDAO();
	private SubjectDAO sDAO = new SubjectDAO();
	private SubjectbookDAO sbDAO = new SubjectbookDAO();
	private InstructorDAO iDAO = new InstructorDAO();
	private InstructorPossibleDAO ipDAO = new InstructorPossibleDAO();
	private ExamDAO eDAO = new ExamDAO();

	String admin_id = null;
	
	// ���� ó�� �ý��� v6.0 > 3. ������ �α���
	public void login(Scanner sc) {
		// �α��� ���� �������Ƿ� �ּ� ó��
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("���� ó�� �ý��� v6.0 > 3. ������ �α���");
		System.out.print("���̵� > ");
		admin_id = sc.nextLine();
		
		System.out.print("��й�ȣ > ");
		String admin_pw = sc.nextLine();
		
		Admin a = new Admin(admin_id, admin_pw);
		admin_id = this.aDAO.login(a);
		
		if(admin_id != null) {
			System.out.printf("������ '%s'���� �α��εǾ����ϴ�.\n", this.admin_id);
			this.main(sc);
		} else {
			 System.out.println("���̵� �Ǵ� �н����尡 Ʋ�Ƚ��ϴ�.");
		}
		
		//this.main(sc);
	}

	// ���� ó�� �ý��� v6.0 (������ : admin)
	private void main(Scanner sc) {

		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s)\n", this.admin_id);
			System.out.println("1. ���� ���� ����  2. ���� ���� ����  3. ���� ���� ����  4. ���� ���� ����  5. ������ ����  6. ���� ��ȸ  7. ��й�ȣ ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;

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

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ����
	private void m1(Scanner sc) {

		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ����\n", this.admin_id);
			System.out.println("1. ���� ����  2. ���� ����  3. ���ǽ� ����  4. ���� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
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
				
			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ����
	private void m1_s1(Scanner sc) {

		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 1. ���� ����\n", this.admin_id);
			System.out.println("1. ���� �Է�  2. ���� ���  3. ���� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
			case 1:
				this.m1_s1_s1(sc);
				break;
				
			case 2:
				this.m1_s1_s2();
				break;
				
			case 3:
				this.m1_s1_s3(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 1. ���� �Է�
	private void m1_s1_s1(Scanner sc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 1. ���� ���� > 1. ���� �Է�\n", this.admin_id);

		System.out.print("������ > ");
		String course_name = sc.nextLine();

		System.out.print("����Ͻðڽ��ϱ�?(1/0) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(selectNum == 1) {
			Course c = new Course("", course_name);
			int result = this.cDAO.insert(c);
			
			if(result > 0) {
				System.out.println("������ �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�����Ͽ����ϴ�.");
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 2. ���� ���
	private void m1_s1_s2() {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 1. ���� ���� > 2. ���� ���\n", this.admin_id);
		List<Course> list = this.cDAO.print1();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ������");
			for(Course c : list) {
				System.out.println(c.print1());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 1. ���� ���� > 3. ���� ����
	private void m1_s1_s3(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 1. ���� ���� > 3. ���� ����\n", this.admin_id);
		List<Course> list = this.cDAO.print2();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ������ / ���� ���� ����");
			for(Course c : list) {
				System.out.println(c.print2());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
			
			System.out.print("���� ��ȣ > ");
			String course_id = sc.nextLine();

			List<Course> list2 = this.cDAO.search("course_id", course_id);
			
			if(list2.size() > 0) {
				for(Course c : list2) {
					System.out.printf("������ : %s\n", c.getCourse_name());
					
				}
				System.out.print("���� ������ �����Ͻðڽ��ϱ�?(0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if(selectNum == 1) {
					Course c = new Course(course_id, "");
					int result = this.cDAO.remove(c);
					
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ����
	private void m1_s2(Scanner sc) {

		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 2. ���� ����\n", this.admin_id);
			System.out.println("1. ���� �Է�  2. ���� ���  3. ���� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
			case 1:
				this.m1_s2_s1(sc);
				break;
				
			case 2:
				this.m1_s2_s2();
				break;
				
			case 3:
				this.m1_s2_s3(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ���� > 1. ���� �Է�
	private void m1_s2_s1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 2. ���� ���� > 1. ���� �Է�\n", this.admin_id);

		System.out.print("����� > ");
		String subject_name = sc.nextLine();

		System.out.print("����Ͻðڽ��ϱ�?(1/0) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(selectNum == 1) {
			Subject s = new Subject("", subject_name);
			int result = this.sDAO.insert(s);
			
			if(result > 0) {
				System.out.println("������ �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�����Ͽ����ϴ�.");
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ���� > 2. ���� ���
	private void m1_s2_s2() {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 2. ���� ���� > 2. ���� ���\n", this.admin_id);
		List<Subject> list = this.sDAO.print1();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / �����");
			for(Subject s : list) {
				System.out.println(s.print1());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 2. ���� ���� > 3. ���� ����
	private void m1_s2_s3(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 2. ���� ���� > 3. ���� ����\n", this.admin_id);
		List<Subject> list = this.sDAO.print2();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ����� / ���� ���� ����");
			for(Subject s : list) {
				System.out.println(s.print2());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
			
			System.out.print("���� ��ȣ > ");
			String subject_id = sc.nextLine();

			List<Subject> list2 = this.sDAO.search("subject_id", subject_id);
			
			if(list2.size() > 0) {
				for(Subject s : list2) {
					System.out.printf("����� : %s\n", s.getSubject_name());
					
				}
				System.out.print("���� ������ �����Ͻðڽ��ϱ�?(0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if(selectNum == 1) {
					Subject s = new Subject(subject_id, "");
					int result = this.sDAO.remove(s);
					
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ����
	private void m1_s3(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 1. ���ǽ� ����\n", this.admin_id);
			System.out.println("1. ���ǽ� �Է�  2. ���ǽ� ���  3. ���ǽ� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
			case 1:
				this.m1_s3_s1(sc);
				break;
				
			case 2:
				this.m1_s3_s2();
				break;
				
			case 3:
				this.m1_s3_s3(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 1. ���ǽ� �Է�
	private void m1_s3_s1(Scanner sc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 1. ���ǽ� �Է�\n", this.admin_id);

		System.out.print("���ǽǸ� > ");
		String class_room_name = sc.nextLine();

		System.out.print("�ִ� ���� > ");
		int max_number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("����Ͻðڽ��ϱ�?(1/0) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(selectNum == 1) {
			ClassRoom cr = new ClassRoom("", class_room_name, max_number);
			int result = this.crDAO.insert(cr);
			
			if(result > 0) {
				System.out.println("���ǽ��� �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�����Ͽ����ϴ�.");
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 2. ���ǽ� ���
	private void m1_s3_s2() {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 2. ���ǽ� ���\n", this.admin_id);
		List<ClassRoom> list = this.crDAO.print1();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���ǽ� ��ȣ / ���ǽǸ� / �ִ� ����");
			for(ClassRoom cr : list) {
				System.out.println(cr.print1());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 3. ���ǽ� ����
	private void m1_s3_s3(Scanner sc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 3. ���ǽ� ���� > 3. ���ǽ� ����\n", this.admin_id);
		List<ClassRoom> list = this.crDAO.print2();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���ǽ� ��ȣ / ���ǽǸ� / �ִ� ���� / ���� ���� ����");
			for(ClassRoom cr : list) {
				System.out.println(cr.print2());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
			
			System.out.print("���ǽ� ��ȣ > ");
			String class_room_id = sc.nextLine();

			List<ClassRoom> list2 = this.crDAO.search("class_room_id", class_room_id);
			
			if(list2.size() > 0) {
				for(ClassRoom cr : list2) {
					System.out.printf("���ǽǸ� : %s\n", cr.getClass_room_name());
					System.out.printf("�ִ� ���� : %d\n", cr.getMax_number());
					
				}
				System.out.print("���� ���ǽ��� �����Ͻðڽ��ϱ�?(0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if(selectNum == 1) {
					ClassRoom cr = new ClassRoom(class_room_id, "", 0);
					int result = this.crDAO.remove(cr);
					
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ����
	private void m1_s4(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 4. ���� ����\n", this.admin_id);
			System.out.println("1. ���� �Է�  2. ���� ���  3. ���� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
			case 1:
				this.m1_s4_s1(sc);
				break;
				
			case 2:
				this.m1_s4_s2();
				break;
				
			case 3:
				this.m1_s4_s3(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 1. ���� �Է�
	private void m1_s4_s1(Scanner sc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 4. ���� ���� > 1. ���� �Է�\n", this.admin_id);

		System.out.print("����� > ");
		String subjectbook_name = sc.nextLine();

		System.out.print("���� ���ǻ� > ");
		String subjectbook_publisher = sc.nextLine();
		System.out.print("����Ͻðڽ��ϱ�?(1/0) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(selectNum == 1) {
			Subjectbook sb = new Subjectbook("", subjectbook_name, subjectbook_publisher);
			int result = this.sbDAO.insert(sb);
			
			if(result > 0) {
				System.out.println("���簡 �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�����Ͽ����ϴ�.");
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 2. ���� ���
	private void m1_s4_s2() {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� >  4. ���� ���� > 2. ���� ���\n", this.admin_id);
		List<Subjectbook> list = this.sbDAO.print1();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ����� / ���� ���ǻ�");
			for(Subjectbook sb : list) {
				System.out.println(sb.print1());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 1. ���� ���� ���� > 4. ���� ���� > 3. ���� ����
	private void m1_s4_s3(Scanner sc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 1. ���� ���� ���� > 4. ���� ���� > 3. ���� ����\n", this.admin_id);
		List<Subjectbook> list = this.sbDAO.print2();
		if(list.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ����� / ���� ���ǻ� / ���� ���� ����");
			for(Subjectbook sb : list) {
				System.out.println(sb.print2());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list.size());
			
			System.out.print("���� ��ȣ > ");
			String subjectbook_id = sc.nextLine();

			List<Subjectbook> list2 = this.sbDAO.search("subjectbook_id", subjectbook_id);
			
			if(list2.size() > 0) {
				for(Subjectbook sb : list2) {
					System.out.printf("����� : %s\n", sb.getSubjectbook_name());
					System.out.printf("���� ���ǻ� : %s\n", sb.getSubjectbook_publisher());					
				}
				System.out.print("���� ���縦 �����Ͻðڽ��ϱ�?(0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if(selectNum == 1) {
					Subjectbook sb = new Subjectbook(subjectbook_id, "", "");
					int result = this.sbDAO.remove(sb);
					
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ����
	private void m2(Scanner sc) {

		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ����\n", this.admin_id);
			System.out.println("1. ���� �Է�  2. ���� �˻� �� ���  3. ���� ����  4. ��й�ȣ �ʱ�ȭ  5. ���� ���� ���� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
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

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 1. ���� �Է�
	private void m2_s1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 1. ���� �Է�\n", this.admin_id);

		System.out.print("���� �̸� > ");
		String instructor_name = sc.nextLine();
		
		System.out.print("���� �޴�����ȣ > ");
		String instructor_phone = sc.nextLine();
		
		System.out.print("���� ��й�ȣ > ");
		String instructor_pw = sc.nextLine();
		
		System.out.print("���� ����� > ");
		Date instructor_regDate = Date.valueOf(sc.nextLine());
		
		System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(selectNum == 1) {
			
			Instructor i = new Instructor(instructor_name, instructor_phone, instructor_regDate, instructor_pw);
			int result = this.iDAO.insert(i);
			
			if(result > 0) {
				System.out.println("���簡 �߰��Ǿ����ϴ�.");				
			} else {
				System.out.println("�����Ͽ����ϴ�.");
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ���
	private void m2_s2(Scanner sc) {

		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 2. ���� �˻� �� ���\n", this.admin_id);
			System.out.println("1. ���� ��ȣ  2. ���� �̸�  3. ���� ��ü ���");
			System.out.print("���� > ");

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

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 1. ���� ��ȣ
	private void m2_s2_s1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 1. ���� ��ȣ\n", this.admin_id);

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();

		List<Instructor> list1 = this.iDAO.search("instructor_id", instructor_id);

		if (list1.size() > 0) {
			
			for (Instructor i : list1) {
				System.out.printf("���� �̸� : %s\n", i.getInstructor_name());
				System.out.printf("���� ��ȭ��ȣ : %s\n", i.getInstructor_phone());
				System.out.println();
			}			
		}
		
		List<OpenSubject> list2 = this.osDAO.print9("instructor_id", instructor_id);
		
		if(list2.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("���� ����� / ���� ���� �Ⱓ / ���� ������ / ���� ���� �Ⱓ / ���ǽ� / ���� ���� ����");
			for (OpenSubject os : list2) {
				System.out.printf("%s / %s ~ %s / %s / %s / %s\n", os.getSubject_name(), os.getSubject_start_date(),
						os.getSubject_end_date(), os.getCourse_name(), os.getClass_room_name(), os.getInstructor_status());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list2.size());
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 2. ���� �̸�
	private void m2_s2_s2(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 2. ���� �̸�\n", this.admin_id);

		System.out.print("���� �̸� > ");
		String instructor_name = sc.nextLine();

		List<Instructor> list1 = this.iDAO.search("instructor_name", instructor_name);
		
		if (list1.size() == 1) {
			
			for (Instructor i : list1) {
				System.out.printf("���� �̸� : %s\n", i.getInstructor_name());
				System.out.printf("���� ��ȭ��ȣ : %s\n", i.getInstructor_phone());
				System.out.println();
			}

			List<OpenSubject> list2 = this.osDAO.print9("instructor_name", instructor_name);

			if(list2.size() > 0) {
				System.out.println("-------------------------------");
				System.out.println("���� ����� / ���� ���� �Ⱓ / ���� ������ / ���� ���� �Ⱓ / ���ǽ� / ���� ���� ����");
				for (OpenSubject os : list2) {
					System.out.printf("%s / %s ~ %s / %s / %s / %s\n", os.getSubject_name(), os.getSubject_start_date(),
							os.getSubject_end_date(), os.getCourse_name(), os.getClass_room_name(),
							os.getInstructor_status());
				}
				System.out.println("-------------------------------");
				System.out.printf("�� %d��\n", list2.size());
			}
		} else if (list1.size() > 1) {
			
			System.out.println("-------------------------------");
			System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / �����");
			for (Instructor i : list1) {
				System.out.printf("%s / %s / %s / %s\n", i.getInstructor_id(), i.getInstructor_name(),
						i.getInstructor_phone(), i.getInstructor_regDate());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list1.size());
			System.out.println("�˻� ����� ���� ���Դϴ�.");
			this.m2_s2_s1(sc);
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 3. ���� ��ü ���
	private void m2_s2_s3() {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 2. ���� �˻� �� ��� > 3. ���� ��ü ���\n", this.admin_id);

		List<Instructor> list1 = this.iDAO.print3("all", null);
		
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / ���� ����� / ���� ���� ����");
			for(Instructor i : list1) {
				System.out.printf("%s / %s / %s / %s / %s\n", i.getInstructor_id(), i.getInstructor_name(),
						i.getInstructor_phone(), i.getInstructor_regDate(), i.getInstructor_possible());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 3. ���� ����
	private void m2_s3(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 3. ���� ����\n", this.admin_id);
		
		List<Instructor> list1 = this.iDAO.print4();
		
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / ���� ����� / ���� ���� ���� / ���� ���� ����");
			for(Instructor i : list1) {
				System.out.printf("%s / %s / %s / %s / %s / %s\n", i.getInstructor_id(), i.getInstructor_name(),
						i.getInstructor_phone(), i.getInstructor_regDate(), i.getInstructor_possible(), 
						(i.getCount_() > 0 ? 'X' : 'O'));
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
			
			System.out.print("���� ��ȣ > ");
			String instructor_id = sc.nextLine();
			
			List<Instructor> list2 = this.iDAO.search("instructor_id", instructor_id);
			
			if(list2.size() > 0) {
				for(Instructor i : list2) {
					System.out.printf("���� �̸� : %s\n", i.getInstructor_name());
					System.out.printf("�޴�����ȣ : %s\n", i.getInstructor_phone());
				}
				
				System.out.print("���� ���縦 �����Ͻðڽ��ϱ�? (0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if(selectNum == 1) {
					Instructor i = new Instructor(instructor_id, null);
					int result = this.iDAO.remove(i);
					
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 4. ��й�ȣ �ʱ�ȭ
	private void m2_s4(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 4. ��й�ȣ �ʱ�ȭ\n", this.admin_id);

		List<Instructor> list1 = this.iDAO.print3("all", "");
		if (list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / ���� ����� / ���� ���� ����");
			for (Instructor i : list1) {
				System.out.printf("%s / %s / %s / %s / %s\n", i.getInstructor_id(), i.getInstructor_name(),
						i.getInstructor_phone(), i.getInstructor_regDate(), i.getInstructor_possible());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		}

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();
		List<Instructor> list2 = this.iDAO.search("instructor_id", instructor_id);
		
		if (list2.size() > 0) {
			
			for (Instructor i : list2) {
				System.out.printf("���� �̸� : %s\n", i.getInstructor_name());
				System.out.printf("���� ��ȭ��ȣ : %s\n", i.getInstructor_phone());
				System.out.println();
			}
			
			System.out.print("���� ��й�ȣ > ");
			String instructor_pw = sc.nextLine();

			System.out.print("�����Ͻðڽ��ϱ�? (0/1) > ");
			int selectNum = sc.nextInt();
			sc.nextLine();

			if (selectNum == 1) {
				Instructor i = new Instructor(instructor_id, instructor_pw);
				int result = this.iDAO.reset(i);

				if (result > 0) {
					System.out.printf("'%s'�� ��й�ȣ�� �ʱ�ȭ�Ǿ����ϴ�.\n", instructor_id);
				} else {
					System.out.println("�����Ͽ����ϴ�.");
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ����
	private void m2_s5(Scanner sc) {

		while (true) {

			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 5. ���� ���� ���� ����\n", this.admin_id);
			System.out.println("1. ���� ���� ���� �߰�  2. ���� ���� ���� ����");
			System.out.print("���� > ");

			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				break;
			}

			switch (select) {

			case 1:
				this.m2_s5_s1(sc);
				break;
				
			case 2:
				this.m2_s5_s2(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 1. ���� ���� ���� �߰�
	private void m2_s5_s1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 1. ���� ���� ���� �߰�\n", this.admin_id);

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();

		List<Instructor> list1 = this.iDAO.print1(instructor_id);
		
		if (list1.size() > 0) {
			
			for(Instructor i : list1) {
				System.out.printf("���� �̸� : %s\n", i.getInstructor_name());
				System.out.printf("���� �޴�����ȣ : %s\n", i.getInstructor_phone());
			}
			
			List<InstructorPossible> list2 = this.ipDAO.print(instructor_id);
			
			if(list2.size() > 0) {
				System.out.println("-------------------------------");
				System.out.println("���� ���� ����");
				for(InstructorPossible ip : list2) {
					System.out.printf("%s - %s\n", ip.getSubject_id(), ip.getSubject_name());
				}
				System.out.println("-------------------------------");
				System.out.printf("�� %d��\n", list2.size());
			}
			

			while(true) {
				System.out.print("���� ��ȣ > ");
				String subject_id = sc.nextLine();

				if(subject_id.equals("0")) {
					break;
				}
				
				else if (subject_id.equals("1")) {
					List<Subject> listAll = this.sDAO.print1();
					
					if(listAll.size() > 0) {
						System.out.println("-------------------------------");
						System.out.println("���� ��ȣ / �����");
						for(Subject s : listAll) {
							System.out.println(s.print1());
						}
						System.out.println("-------------------------------");
						System.out.printf("�� %d��\n", listAll.size());					
					}
				}
				
				else {
					List<Subject> list3 = this.sDAO.search("subject_id", subject_id);
					
					if(list3.size() > 0) {
						for(Subject s : list3) {
							System.out.printf("���� ��ȣ : %s\n", s.getSubject_id());
							System.out.printf("����� : %s\n", s.getSubject_name());
						}
						
						System.out.print("���� ���� ���� �߰��Ͻðڽ��ϱ�? (0/1) >");
						int selectNum = sc.nextInt();
						sc.nextLine();
						
						if(selectNum == 1) {
							InstructorPossible ip = new InstructorPossible(instructor_id, subject_id);
							int result = this.ipDAO.subjectPossibleAdd(ip);
							
							if(result > 0 ) {
								System.out.println("���� ���� ������ �߰��Ǿ����ϴ�.");
							} else {
								System.out.println("�����Ͽ����ϴ�.");
							}
						}
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 2. ���� ���� ���� ����
	// ���������
	private void m2_s5_s2(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 2. ���� ���� ���� > 5. ���� ���� ���� ���� > 2. ���� ���� ���� ����\n", this.admin_id);

		System.out.print("���� ��ȣ > ");
		String instructor_id = sc.nextLine();

		List<Instructor> list1 = this.iDAO.print1(instructor_id);
		
		if (list1.size() > 0) {
			
			for(Instructor i : list1) {
				System.out.printf("���� �̸� : %s\n", i.getInstructor_name());
				System.out.printf("���� �޴�����ȣ : %s\n", i.getInstructor_phone());
			}
			
			List<InstructorPossible> list2 = this.ipDAO.print(instructor_id);
			
			if(list2.size() > 0) {
				System.out.println("-------------------------------");
				System.out.println("���� ���� ����");
				for(InstructorPossible ip : list2) {
					System.out.printf("%s - %s\n", ip.getSubject_id(), ip.getSubject_name());
				}
				System.out.println("-------------------------------");
				System.out.printf("�� %d��\n", list2.size());
			}
			

			while(true) {
				System.out.print("������ ���� ��ȣ > ");
				String subject_id = sc.nextLine();

				if(subject_id.equals("0")) {
					break;
				}
				
				else {
					List<Subject> list3 = this.sDAO.search("subject_id", subject_id);
					
					if(list3.size() > 0) {
						for(Subject s : list3) {
							System.out.printf("���� ��ȣ : %s\n", s.getSubject_id());
							System.out.printf("����� : %s\n", s.getSubject_name());
						}
						
						System.out.print("�����Ͻðڽ��ϱ�? (0/1) >");
						int selectNum = sc.nextInt();
						sc.nextLine();
						
						if(selectNum == 1) {
							InstructorPossible ip = new InstructorPossible(instructor_id, subject_id);
							int result = this.ipDAO.subjectPossibleRemove(ip);
							
							if(result > 0 ) {
								System.out.println("���� ���� ������ �����Ǿ����ϴ�.");
							} else {
								System.out.println("�����Ͽ����ϴ�.");
							}
						}
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ����
	private void m3(Scanner sc) {
		
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ����\n", this.admin_id);
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
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 1. ���� ���� �߰�\n", this.admin_id);
		List<Course> list1 = this.cDAO.print1();		 // ������ȣ, �����̸� ���
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ��ȣ / ������");
			for(Course c : list1) {
				System.out.println(c.print1());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
			
			System.out.print("���� ��ȣ > ");
			String course_id = sc.nextLine();
			
			System.out.print("���� ���� ������ > ");
			Date open_course_start_date = Date.valueOf(sc.nextLine());
			
			System.out.print("���� ���� ������ > ");
			Date open_course_end_date = Date.valueOf(sc.nextLine());

			List<ClassRoom> list2 = this.crDAO.print1(); // ���ǽ� ���̵�, ���ǽ� �̸�, �ִ����� ���
			if(list2.size() > 0) {
				System.out.println("--------------------");
				System.out.println("���ǽ� ��ȣ / ���ǽǸ� / �ִ� ����");
				for(ClassRoom cr : list2) {
					System.out.println(cr.print1());
				}
				System.out.println("--------------------");
				System.out.printf("�� %d��\n", list2.size());
				
				System.out.print("���ǽ� ��ȣ > ");
				String class_room_id = sc.nextLine();

				System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if (selectNum == 1) {
					// ���� ���� ���
					OpenCourse oc = new OpenCourse("", class_room_id, course_id, open_course_start_date, open_course_end_date);
					int result = this.ocDAO.insert(oc);
					if(result > 0) {
						System.out.println("���� ������ �߰��Ǿ����ϴ�.");				
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}	
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ���
	private void m3_s2(Scanner sc) {
		
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ���\n", this.admin_id);
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
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 1. ���� ���� ��ȣ\n", this.admin_id);
		System.out.print("���� ���� ��ȣ > ");
		String open_course_id = sc.nextLine();

		List<OpenCourse> list1 = this.ocDAO.search("open_course_id", open_course_id);
		if(list1.size() > 0) {
			System.out.println("--------------------");
			for(OpenCourse oc : list1) {
				System.out.printf("���� ���� ��ȣ : %s\n", oc.getOpen_course_id());
				System.out.printf("���� ������ : %s\n", oc.getCourse_name());
				System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
				System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
			}
			System.out.println("--------------------");
			
			List<OpenSubject> list2 = this.osDAO.print4("open_course_id", open_course_id);
			if(list2.size() > 0) {
				System.out.println("** ���� ���� ���� **");
				System.out.println("--------------------");
				System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / �����");
				for(OpenSubject os : list2) {
					System.out.printf("%s / %s / %s ~ %s / %s / %s\n",
							os.getOpen_subject_id(), os.getSubject_name(), 
							os.getSubject_start_date(), os.getSubject_end_date(),
							os.getSubjectbook_name(), os.getInstructor_name());
				}
				System.out.println("--------------------");
				System.out.printf("�� %d��\n", list2.size());
				
				List<Student> list3 = this.stDAO.print4("open_course_id", open_course_id, null);
				if(list3.size() > 0) {
					System.out.println(" ** ������ ���� **");
					System.out.println("--------------------");
					System.out.println("������ ��ȣ / ������ �̸� / ��ȭ��ȣ / ����� / ���Ῡ�� / ��¥");
					for(Student s : list3) {
						System.out.printf("%s / %s / %s / %s / %s / %s\n", 
								s.getStudent_id(), s.getStudent_name(), s.getStudent_phone(), s.getStudent_regDate(),
								s.getCompletion_status(), s.getCompleteion_date());
					}
					System.out.println("--------------------");
					System.out.printf("�� %d��\n", list3.size());
				} else {
					System.out.println("�˻� ����� �����ϴ�.");
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 2. ���� ������
	private void m3_s2_s2(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 2. ���� ������\n", this.admin_id);
		System.out.print("���� ������ > ");
		String course_name = sc.nextLine();
		
		List<OpenCourse> list1 = this.ocDAO.search("course_name", course_name);
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ�");
			for(OpenCourse oc : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s\n", 
						oc.getOpen_course_id(), oc.getCourse_name(),
						oc.getOpen_course_start_date(), oc.getOpen_course_end_date(), oc.getClass_room_name());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
			
			// �˻� ����� �������� ���
			if(list1.size() > 1) {
				System.out.println("�˻� ����� �������Դϴ�.");
				this.m3_s2_s1(sc); // ���� ���� ��ȣ �˻� �޼ҵ�� �Ѿ
			// �˻� ����� �ϳ��� ���
			} else {
				List<OpenSubject> list2 = this.osDAO.print4("course_name", course_name);
				if(list2.size() > 0) {
					System.out.print("** ���� ���� ���� **");
					System.out.println("--------------------");
					System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / �����");
					for(OpenSubject os : list2) {
						System.out.printf("%s / %s / %s ~ %s / %s / %s\n",
								os.getOpen_subject_id(), os.getSubject_name(), 
								os.getOpen_course_start_date(), os.getOpen_course_end_date(),
								os.getSubjectbook_name(), os.getInstructor_name());
					}
					System.out.println("--------------------");
					System.out.printf("�� %d��\n", list2.size());
					
					List<Student> list3 = this.stDAO.print4("course_name", course_name, null);
					if(list3.size() > 0) {
						System.out.print(" ** ������ ���� **");
						System.out.println("--------------------");
						System.out.println("������ ��ȣ / ������ �̸� / ��ȭ��ȣ / ����� / ���Ῡ�� / ��¥");
						for(Student s : list3) {
							System.out.printf("%s / %s / %s / %s / %s / %s\n", 
									s.getStudent_id(), s.getStudent_name(), s.getStudent_phone(), s.getStudent_regDate(),
									s.getCompletion_status(), s.getCompleteion_date());
						}
						System.out.println("--------------------");
						System.out.printf("�� %d��\n", list3.size());
					} else {
						System.out.println("�˻� ����� �����ϴ�.");
					}
				} else {
					System.out.println("�˻� ����� �����ϴ�.");
				}
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 3. ���� ���� ��ü
	// ���
	private void m3_s2_s3() {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 3. ���� ���� ��ü\n", this.admin_id);
		List<OpenCourse> list1 = this.ocDAO.print2();
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�");
			for(OpenCourse oc : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s / %d�� / %d��\n", 
						oc.getOpen_course_id(), oc.getCourse_name(),
						oc.getOpen_course_start_date(), oc.getOpen_course_end_date(), oc.getClass_room_name(),
						oc.getOpen_subject_count(), oc.getStudent_count());
			}
			System.out.println("--------------------");
			System.out.printf("�� %s��\n", list1.size());
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 3. ���� ���� ���� > 3. ���� ���� ����
	private void m3_s3(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 3. ���� ���� ���� > 3. ���� ���� ���� > 3. ���� ���� ����\n", this.admin_id);
		List<OpenCourse> list1 = this.ocDAO.print3();
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ���� ��ȣ / ���ǽǸ� / ������ / ���� ���� �Ⱓ / ���� ���� ����");
			for(OpenCourse oc : list1) {
				System.out.printf("%s / %s / %s / %s ~ %s / %s\n", oc.getOpen_course_id(), oc.getClass_room_name(), 
						oc.getCourse_name(), oc.getOpen_course_start_date(), oc.getOpen_course_end_date(),
						(oc.getCount_() > 0 ? 'X' : 'O'));
			}
			System.out.println("--------------------");
			System.out.printf("�� %s��\n", list1.size());
			
			System.out.print("���� ���� ��ȣ > ");
			String open_course_id = sc.nextLine();
			
			// ���� ���� ��ȣ�� ���� ���� ������, ���� ���� �Ⱓ, ���ǽǸ� ���
			List<OpenCourse> list2 = this.ocDAO.search("open_course_id", open_course_id);
			
			if(list2.size() > 0) {
				System.out.println("--------------------");
				for(OpenCourse oc : list2) {
					System.out.printf("���� ���� ��ȣ : %s\n", oc.getOpen_course_id());
					System.out.printf("���� ������ : %s\n", oc.getCourse_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
					System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
				}
				System.out.println("--------------------");
				
				System.out.print("���� ���� ������ �����Ͻðڽ��ϱ�? (0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				if (selectNum == 1) {
					// ���� ���� ����
					OpenCourse oc = new OpenCourse(open_course_id, "");
					int result = this.ocDAO.remove(oc);
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");					
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				} 
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ����
	private void m4(Scanner sc) {
		
		boolean run = true;
		
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ����\n", this.admin_id);
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
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 1. ���� ���� �߰�\n", this.admin_id);
		
		List<OpenCourse> list1 = this.ocDAO.print4();
		
		if (list1.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� �����");
			for (OpenCourse oc : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s / %s\n",
						oc.getOpen_course_id(), oc.getCourse_name(),
						oc.getOpen_course_start_date(), oc.getOpen_course_end_date(),
						oc.getClass_room_name(), oc.getSubject_list());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %s��\n", list1.size());

			System.out.print("���� ���� ��ȣ > ");
			String open_course_id = sc.nextLine();

			List<Subject> list2 = this.sDAO.print1();
			
			if (list2.size() > 0) {
				System.out.println("-------------------------------");
				System.out.println("���� ��ȣ / �����");
				for (Subject s : list2) {
					System.out.println(s.print1());
				}
				
				System.out.println("-------------------------------");
				System.out.printf("�� %s��\n", list2.size());

				System.out.print("���� ��ȣ > ");
				String subject_id = sc.nextLine();

				System.out.print("���� ���� ������ > ");
				Date subject_start_date = Date.valueOf(sc.nextLine());
				
				System.out.print("���� ���� ������ > ");
				Date subject_end_date = Date.valueOf(sc.nextLine());

				List<Subjectbook> list3 = this.sbDAO.print1();
				if (list3.size() > 0) {
					System.out.println("-------------------------------");
					System.out.println("���� ��ȣ / ����� / ���� ���ǻ�");
					for (Subjectbook sb : list3) {
						System.out.println(sb.print1());
					}
					
					System.out.println("-------------------------------");
					System.out.printf("�� %s��\n", list3.size());

					System.out.print("���� ��ȣ > ");
					String subjectbook_id = sc.nextLine();

					List<Instructor> list4 = this.iDAO.print3("all", null);
					
					if (list4.size() > 0) {
						System.out.println("-------------------------------");
						System.out.println("���� ��ȣ / ���� �̸� / ���� �޴��� ��ȣ / ���� ����� / ���� ���� ����");
						for (Instructor i : list4) {
							System.out.printf("%s / %s / %s / %s / %s\n", i.getInstructor_id(), i.getInstructor_name(), 
									i.getInstructor_phone(), i.getInstructor_regDate(), i.getInstructor_possible());
						}
						
						System.out.println("-------------------------------");
						System.out.printf("�� %s��\n", list4.size());

						System.out.print("���� ��ȣ > ");
						String instructor_id = sc.nextLine();

						System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
						int iNum = sc.nextInt();
						sc.nextLine();

						if (iNum == 1) {
							// ���� ���� ���
							OpenSubject os = new OpenSubject("", subject_id, subjectbook_id, instructor_id, open_course_id,
									subject_start_date, subject_end_date);
							int result = this.osDAO.insert(os);
							
							if (result > 0) {
								System.out.println("���� ������ �߰��Ǿ����ϴ�.");
							} else {
								System.out.println("�����Ͽ����ϴ�.");
							}
						}
					} else {
						System.out.println("�˻� ����� �����ϴ�.");
					}
				} else {
					System.out.println("�˻� ����� �����ϴ�.");
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ���
	private void m4_s2(Scanner sc) {
		
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ���\n", this.admin_id);
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
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 1. ���� ���� ��ȣ\n", this.admin_id);
		
		System.out.print("���� ���� ��ȣ > ");
		String open_course_id = sc.nextLine();

		List<OpenSubject> list1 = this.osDAO.print1("open_course_id", open_course_id);
		
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽǸ�");
			for(OpenSubject os : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s / %s / %s / %s ~ %s / %s\n",
						os.getOpen_subject_id(), os.getSubject_name(),
						os.getSubject_start_date(), os.getSubject_end_date(),
						os.getSubjectbook_name(), os.getInstructor_name(),
						os.getCourse_name(), os.getOpen_course_start_date(), os.getOpen_course_end_date(),
						os.getClass_room_name());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 2. ���� �����
	private void m4_s2_s2(Scanner sc) {

		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 2. ���� �����\n", this.admin_id);
		
		System.out.print("���� ����� > ");
		String subject_name = sc.nextLine();

		List<OpenSubject> list1 = this.osDAO.print1("subject_name", subject_name);
		
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽǸ�");
			for(OpenSubject os : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s / %s / %s / %s ~ %s / %s\n",
						os.getOpen_subject_id(), os.getSubject_name(),
						os.getSubject_start_date(), os.getSubject_end_date(),
						os.getSubjectbook_name(), os.getInstructor_name(),
						os.getCourse_name(), os.getOpen_course_start_date(), os.getOpen_course_end_date(),
						os.getClass_room_name());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 3. ���� ���� ��ü
	// ���
	private void m4_s2_s3() {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 2. ���� ���� �˻� �� ��� > 3. ���� ���� ��ü\n", this.admin_id);
		
		List<OpenSubject> list1 = this.osDAO.print1("all", null);
		if(list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽ�");
			for(OpenSubject os : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s / %s / %s / %s ~ %s / %s\n",
						os.getOpen_subject_id(), os.getSubject_name(), os.getSubject_start_date(), os.getSubject_end_date(),
						os.getSubjectbook_name(), os.getInstructor_name(), os.getCourse_name(),
						os.getOpen_course_start_date(), os.getOpen_course_end_date(), os.getClass_room_name());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 4. ���� ���� ���� > 3. ���� ���� ����
	private void m4_s3(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 4. ���� ���� ���� > 3. ���� ���� ����\n", this.admin_id);

		List<OpenSubject> list1 = this.osDAO.print2();
		
		if (list1.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / ����� / ���� ������ / ���� ���� �Ⱓ / ���ǽ� / ���� ���� ����");

			for (OpenSubject os : list1) {
				System.out.printf("%s / %s / %s ~ %s / %s / %s / %s / %s ~ %s / %s / %s\n", os.getOpen_subject_id(),
						os.getSubject_name(), os.getSubject_start_date(), os.getSubject_end_date(),
						os.getSubjectbook_name(), os.getInstructor_name(), os.getCourse_name(),
						os.getOpen_course_start_date(), os.getOpen_course_end_date(), os.getClass_room_name(),
						(os.getCount_() > 0 ? 'X' : 'O'));
			}

			System.out.println("-------------------------------");
			System.out.printf("�� %s��\n", list1.size());

			System.out.print("���� ���� ��ȣ > ");
			String open_subject_id = sc.nextLine();

			List<OpenSubject> list2 = this.osDAO.print3(open_subject_id);
			if (list2.size() > 0) {

				for (OpenSubject os : list2) {
					System.out.printf("���� ����� : %s\n", os.getSubject_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", os.getSubject_start_date(), os.getSubject_end_date());
				}
				
				System.out.print("���� ���� ������ �����Ͻðڽ��ϱ�? (0/1) > ");
				int iNum = sc.nextInt();
				sc.nextLine();
				
				if (iNum == 1) {
					// ���� ���� ����
					OpenSubject os = new OpenSubject(open_subject_id, "", null, null, "");
					int result = this.osDAO.remove(os);
					if (result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			}	
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ����
	private void m5(Scanner sc) {
		
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ����\n", this.admin_id);
			System.out.println("1. ������ �Է�  2. ������ �˻� �� ���  3. ������ ����  4. ��й�ȣ �ʱ�ȭ  5. ������ ���� ����");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
			case 1:
				this.m5_s1(sc);
				break;
				
			case 2:
				this.m5_s2(sc);
				break;
				
			case 3:
				this.m5_s3(sc);
				break;
				
			case 4:
				this.m5_s4(sc);
				break;
				
			case 5:
				this.m5_s5(sc);
				break;
				
			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 1. ������ �Է�
	private void m5_s1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 1. ������ �Է�\n", this.admin_id);

		System.out.print("������ �̸� > ");
		String student_name = sc.nextLine();
		
		System.out.print("������ ��ȭ��ȣ > ");
		String student_phone = sc.nextLine();
		
		System.out.println("������ ����� > ");
		Date student_regdate = Date.valueOf(sc.nextLine());
		
		System.out.print("������ ��й�ȣ > ");
		String student_pw = sc.nextLine();

		Student s1 = new Student(null, student_name, student_phone, student_regdate, student_pw);

		System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
		int check = sc.nextInt();
		sc.nextLine();
		
		if (check == 1) {

			List<Student> list = this.stDAO.search2("null", student_name, student_phone);
			if (list.size() == 0) {
				this.stDAO.insert(s1);
				System.out.println("��ϵǾ����ϴ�.");
				
				System.out.println("���� ���� ������ ���� ����Ͻðڽ��ϱ�? (0/1) > ");
				int check2 = sc.nextInt();
				sc.nextLine();
				if (check2 == 1) {

					List<OpenCourse> list2 = this.ocDAO.print2();
					if (list2.size() > 0) {
						System.out.println("-------------------------------");
						System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�");
						for (OpenCourse oc : list2) {
							System.out.println(oc.getOpen_course_id() + "/" + oc.getCourse_name() + "/"
									+ oc.getOpen_course_start_date() + "~" + oc.getOpen_course_end_date() + "/"
									+ oc.getClass_room_name() + "/" + oc.getOpen_subject_count() + "��" + "/"
									+ oc.getStudent_count() + "��");

						}
						System.out.println("--------------");
						System.out.printf("�� %d�� \n", list.size());
					}

					System.out.println("���� ���� ��ȣ >");
					String open_course_id = sc.nextLine();

					List<OpenCourse> list3 = this.ocDAO.search("open_course_id", open_course_id);
					if (list3.size() > 0) {
						for (OpenCourse oc : list3) {
							System.out.printf("���� ���� ��ȣ : %s", open_course_id);
							System.out.printf("���� ������ : %s", oc.getCourse_name());
							System.out.printf("���� ���� �Ⱓ : %tF ~ %tF ", oc.getOpen_course_start_date(),
									oc.getOpen_course_end_date());
							System.out.printf("���ǽǸ� : %s", oc.getClass_room_name());
						}
					}

					System.out.println("����Ͻðڽ��ϱ�? (0/1) > ");
					int check4 = sc.nextInt();
					sc.nextLine();
					if (check4 == 1) {
						List<Student> list4 = this.stDAO.search2("null", student_name, student_phone);
						String student_id = null;
						for (Student s : list4) {
							student_id = s.getStudent_id();
						}
						StudentHistory s = new StudentHistory(student_id, open_course_id);
						stDAO.studentHistoryAdd(s);
						System.out.println("��ϵǾ����ϴ�.");
					}
				}

			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ���
	private void m5_s2(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 2. ������ �˻� �� ���\n", this.admin_id);
			System.out.println("1. ������ ��ȣ  2. ������ �̸�  3. ������ ��ü ���");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;
				
			case 1:
				this.m5_s2_s1(sc);
				break;
				
			case 2:
				this.m5_s2_s2(sc);
				break;
				
			case 3:
				this.m5_s2_s3();
				break;
				
			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 1. ������ ��ȣ
	private void m5_s2_s1(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 2. ������ �˻� �� ��� > 1. ������ ��ȣ\n", this.admin_id);
	
		System.out.print("������ ��ȣ > ");
		String student_id = sc.nextLine();
		
		List<Student> list1 = this.stDAO.search("student_id", student_id);
		
		if (list1.size() > 0) {
		
			for (Student s : list1) {
				System.out.printf("������ �̸� : %s\n", s.getStudent_name());
				System.out.printf("������ ��ȭ��ȣ : %s\n", s.getStudent_phone());
				System.out.println();
			}
			
			List<OpenCourse> list2 = this.ocDAO.print5("student_id", student_id, "");
			if(list2.size() > 0) {
				
				for(OpenCourse oc : list2) {
					System.out.println("--------------------");
					System.out.printf("���� ���� ��ȣ : %s\n", oc.getOpen_course_id());
					System.out.printf("���� ������ : %s\n", oc.getCourse_name());
					System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
					System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
					System.out.printf("���Ῡ�� : %s\n", oc.getCompletion_status());
					System.out.printf("%s ��¥ : %s\n", oc.getCompletion_status(), oc.getDropout_date());
					System.out.println("--------------------");
					System.out.println();
				}
				System.out.printf("�� %d��\n", list2.size());
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 2. ������ �̸�
	private void m5_s2_s2(Scanner sc) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 2. ������ �˻� �� ��� > 2. ������ �̸�\n", this.admin_id);
	
		System.out.print("������ �̸� > ");
		String student_name = sc.nextLine();
		
		List<Student> list1 = this.stDAO.search("student_name", student_name);
		
		if(list1.size() > 0) {
			
			System.out.println("-------------------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ �޴��� ��ȣ / ������ �����");
			for (Student s : list1) {
				System.out.printf("%s / %s / %s / %s\n", 
						s.getStudent_id(), s.getStudent_name(), s.getStudent_phone(), s.getStudent_regDate());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list1.size());
			
			if(list1.size() > 1) {
				System.out.println("�˻� ����� ������ �Դϴ�.");
				this.m5_s2_s1(sc);
				
			} else {
				
				List<OpenCourse> list2 = this.ocDAO.print5("student_name", student_name, "");
				if(list2.size() > 0) {
					
					for(OpenCourse oc : list2) {
						System.out.println("--------------------");
						System.out.printf("���� ���� ��ȣ : %s\n", oc.getOpen_course_id());
						System.out.printf("���� ������ : %s\n", oc.getCourse_name());
						System.out.printf("���� ���� �Ⱓ : %s ~ %s\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
						System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
						System.out.printf("���Ῡ�� : %s\n", oc.getCompletion_status());
						System.out.printf("%s ��¥ : %s\n", oc.getCompletion_status(), oc.getDropout_date());
						System.out.println("--------------------");
						System.out.println();
					}
					System.out.printf("�� %d��\n", list2.size());
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 2. ������ �˻� �� ��� > 3. ������ ��ü ���
	private void m5_s2_s3() {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 2. ������ �˻� �� ��� > 3. ������ ��ü ���\n", this.admin_id);
		
		List<Student> list1 = this.stDAO.print3("all", "");
		if (list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ����Ƚ��");
			for (Student s : list1) {
				System.out.printf("%s / %s / %s / %s / %dȸ\n", s.getStudent_id(), s.getStudent_name(),
						s.getStudent_phone(), s.getStudent_regDate(), s.getCount_());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 3. ������ ����
	private void m5_s3(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 3. ������ ����\n", this.admin_id);

		List<Student> list1 = this.stDAO.print3("all", null);
		
		if(list1.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���� ���� ����");
			for(Student s : list1) {
				System.out.printf("%s / %s / %s / %s / %s\n",
						s.getStudent_id(), s.getStudent_name(), s.getStudent_phone(), s.getStudent_regDate(),
						(s.getCount_() > 0 ? 'X' : 'O'));
			}
			System.out.println("-------------------------------");
			System.out.printf("%d��\n", list1.size());
			
			System.out.print("������ ��ȣ > ");
			String student_id = sc.nextLine();
			
			List<Student> list2 = this.stDAO.search("student_id", student_id);
			
			if(list2.size() > 0) {
				for(Student s : list2) {
					System.out.printf("������ �̸� : %s\n", s.getStudent_name());
					System.out.printf("������ �޴�����ȣ : %s\n", s.getStudent_phone());
				}
				
				System.out.print("���� �������� �����Ͻðڽ��ϱ�? (0/1) > ");
				int selectNum = sc.nextInt();
				sc.nextLine();
				
				if(selectNum == 1) {
					Student s = new Student(student_id, null);
					int result = this.stDAO.remove(s);
					
					if(result > 0) {
						System.out.println("�����Ǿ����ϴ�.");
					} else {
						System.out.println("�����Ͽ����ϴ�.");
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 4. ��й�ȣ �ʱ�ȭ
	private void m5_s4(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 4. ��й�ȣ �ʱ�ȭ\n", this.admin_id);
				
		List<Student> list1 = this.stDAO.print3("all", "");
		if (list1.size() > 0) {
			System.out.println("--------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ����Ƚ��");
			for (Student s : list1) {
				System.out.printf("%s / %s / %s / %s / %dȸ\n", s.getStudent_id(), s.getStudent_name(),
						s.getStudent_phone(), s.getStudent_regDate(), s.getCount_());
			}
			System.out.println("--------------------");
			System.out.printf("�� %d��\n", list1.size());
		}

		System.out.print("������ ��ȣ > ");
		String student_id = sc.nextLine();
		List<Student> list2 = this.stDAO.search("student_id", student_id);
		
		if (list2.size() > 0) {
			
			for (Student s : list2) {
				System.out.printf("������ �̸� : %s\n", s.getStudent_name());
				System.out.printf("������ ��ȭ��ȣ : %s\n", s.getStudent_phone());
				System.out.println();
			}
			
			System.out.print("������ ��й�ȣ > ");
			String student_pw = sc.nextLine();

			System.out.print("�����Ͻðڽ��ϱ�? (0/1) > ");
			int selectNum = sc.nextInt();
			sc.nextLine();

			if (selectNum == 1) {
				Student s = new Student(student_id, student_pw);
				int result = this.stDAO.reset(s);

				if (result > 0) {
					System.out.printf("'%s'�� ��й�ȣ�� �ʱ�ȭ�Ǿ����ϴ�.\n", student_id);
				} else {
					System.out.println("�����Ͽ����ϴ�.");
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ����
	private void m5_s5(Scanner sc) {
		
		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 5. ������ ���� ����\n", this.admin_id);
			System.out.println("1. ������ ���� ���  2. ������ ���� ���  3. ������ �ߵ� Ż��");
			System.out.print("���� > ");
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
				
			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 1. ������ ���� ���
	private void m5_s5_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 5. ������ ���� ���� > 1. ������ ���� ���\n", this.admin_id);

		System.out.print("������ ��ȣ > ");
		String student_id = sc.nextLine();

		List<Student> list = this.stDAO.print3("student_id", student_id);
		
		if (list.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���� Ƚ��");
			for (Student s : list) {				
				System.out.printf("%s / %s / %s / %s / %dȸ\n", s.getStudent_id(), s.getStudent_name(), 
						s.getStudent_phone(), s.getStudent_regDate(), s.getCount_());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list.size());
			
			List<OpenCourse> list2 = this.ocDAO.print2();
			if (list2.size() > 0) {
				System.out.println("-------------------------------");
				System.out.println("���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�");
				for (OpenCourse oc : list2) {
					System.out.printf("%s / %s / %s ~ %s / %s / %d�� / %d��\n", oc.getOpen_course_id(), oc.getCourse_name(),
							oc.getOpen_course_start_date(), oc.getOpen_course_end_date(), oc.getClass_room_name(),
							oc.getOpen_subject_count(), oc.getStudent_count());
				}
				System.out.println("-------------------------------");
				System.out.printf("�� %d��\n", list.size());
				
				System.out.print("���� ���� ��ȣ >");
				String open_course_id = sc.nextLine();

				List<OpenCourse> list3 = this.ocDAO.search("open_course_id", open_course_id);
				if (list3.size() > 0) {
					for (OpenCourse oc : list3) {
						System.out.printf("���� ���� ��ȣ : %s\n", open_course_id);
						System.out.printf("���� ������ : %s\n", oc.getCourse_name());
						System.out.printf("���� ���� �Ⱓ : %tF ~ %tF\n", oc.getOpen_course_start_date(),
								oc.getOpen_course_end_date());
						System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
					}
					
					System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
					int check = sc.nextInt();
					sc.nextLine();
					
					if (check == 1) {
						StudentHistory s = new StudentHistory(student_id, open_course_id);
						int result = stDAO.studentHistoryAdd(s);
						if(result > 0) {
							System.out.println("��ϵǾ����ϴ�.");							
						} else {
							System.out.println("�����Ͽ����ϴ�.");
						}
					}
				} else {
					System.out.println("�˻� ����� �����ϴ�.");
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");				
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");							
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 2. ������ ���� ���
	private void m5_s5_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 5. ������ ���� ���� > 2. ������ ���� ���\n", this.admin_id);

		System.out.print("������ ��ȣ > ");
		String student_id = sc.nextLine();

		List<Student> list = this.stDAO.search("student_id", student_id);
		
		if (list.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���� Ƚ��");
			for (Student s : list) {
				System.out.printf("%s / %s / %s / %s / %dȸ\n", s.getStudent_id(), s.getStudent_name(), 
						s.getStudent_phone(), s.getStudent_regDate(), s.getCount_());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list.size());
			
			List<OpenCourse> list2 = this.ocDAO.print5("student_id", student_id, "");
			if (list2.size() > 0) {
				
				System.out.println("-------------------------------");
				for (OpenCourse oc : list2) {
					System.out.printf("���� ���� ��ȣ : %s\n", oc.getOpen_course_id());
					System.out.printf("���� ������ : %s\n", oc.getCourse_name());
					System.out.printf("���� ���� �Ⱓ : %tF ~ %tF\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
					System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
					System.out.printf("���Ῡ�� : %s\n", oc.getCompletion_status());
					System.out.printf("��¥ : %s\n", oc.getDropout_date());
				}
				System.out.println("-------------------------------");
				System.out.printf("�� %d��\n", list2.size());
				
				System.out.print("���� ���� ��ȣ > ");
				String open_course_id = sc.nextLine();
				List<OpenCourse> list3 = this.ocDAO.search("open_course_id", open_course_id);
				if (list3.size() > 0) {
					for (OpenCourse oc : list3) {
						System.out.printf("���� ���� ��ȣ : %s\n", open_course_id);
						System.out.printf("���� ������ : %s\n", oc.getCourse_name());
						System.out.printf("���� ���� �Ⱓ : %tF ~ %tF\n", oc.getOpen_course_start_date(),
								oc.getOpen_course_end_date());
						System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
					}

					System.out.print("����Ͻðڽ��ϱ�? (0/1) > ");
					int check = sc.nextInt();
					sc.nextLine();

					if (check == 1) {
						StudentHistory s = new StudentHistory(student_id, open_course_id);
						int result = stDAO.studentHistoryRemove(s);
						if(result > 0) {
							System.out.println("��ҵǾ����ϴ�.");
						} else {
							System.out.println("�����Ͽ����ϴ�.");
						}
					}
				} else {
					System.out.println("�˻� ����� �����ϴ�.");
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 5. ������ ���� > 5. ������ ���� ���� > 3. ������ �ߵ� Ż��
	private void m5_s5_s3(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 5. ������ ���� > 5. ������ ���� ���� > 3. ������ �ߵ� Ż��\n", this.admin_id);

		System.out.print("������ ��ȣ > ");
		String student_id = sc.nextLine();

		List<Student> list = this.stDAO.search("student_id", student_id);
		if (list.size() > 0) {
			System.out.println("-------------------------------");
			System.out.println("������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���� Ƚ��");
			for (Student s : list) {	
				System.out.printf("%s / %s / %s / %s / %dȸ\n", s.getStudent_id(), s.getStudent_name(), 
						s.getStudent_phone(), s.getStudent_regDate(), s.getCount_());
			}
			System.out.println("-------------------------------");
			System.out.printf("�� %d��\n", list.size());
			
			List<OpenCourse> list2 = this.ocDAO.print5("student_id", student_id, "");
			if (list2.size() > 0) {
				System.out.println("-------------------------------");
				for (OpenCourse oc : list2) {
					System.out.printf("���� ���� ��ȣ : %s\n", oc.getOpen_course_id());
					System.out.printf("���� ������ : %s\n", oc.getCourse_name());
					System.out.printf("���� ���� �Ⱓ : %tF ~ %tF\n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
					System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
					System.out.printf("���Ῡ�� : %s\n", oc.getCompletion_status());
					System.out.printf("��¥ : %s\n", oc.getDropout_date());

				}
				System.out.println("-------------------------------");
				System.out.printf("�� %d��\n", list2.size());
				
				System.out.print("���� ���� ��ȣ > ");
				String open_course_id = sc.nextLine();
				List<OpenCourse> list3 = this.ocDAO.search("open_course_id", open_course_id);
				if (list3.size() > 0) {
					for (OpenCourse oc : list3) {
						System.out.printf("���� ���� ��ȣ : %s\n", open_course_id);
						System.out.printf("���� ������ : %s\n", oc.getCourse_name());
						System.out.printf("���� ���� �Ⱓ : %tF ~ %tF \n", oc.getOpen_course_start_date(),
								oc.getOpen_course_end_date());
						System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
					}

					System.out.print("�ߵ� Ż�� ��¥ > ");
					Date drop_date = Date.valueOf(sc.nextLine());
					
					System.out.print("�����Ͻðڽ��ϱ�? (0/1) > ");
					int check = sc.nextInt();
					sc.nextLine();

					if (check == 1) {
						StudentHistory s = new StudentHistory(student_id, open_course_id, drop_date);
						int result = this.stDAO.processCompleteAdd(s);
						if(result > 0) {
							System.out.println("�ߵ� Ż���Ǿ����ϴ�.");
						} else {
							System.out.println("�����Ͽ����ϴ�.");
						}
					}
				} else {
					System.out.println("�˻� ����� �����ϴ�.");
				}
			} else {
				System.out.println("�˻� ����� �����ϴ�.");
			}
		} else {
			System.out.println("�˻� ����� �����ϴ�.");
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ
	private void m6(Scanner sc) {

		boolean run = true;
	
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 6. ���� ��ȸ\n", this.admin_id);
			System.out.println("1. ���� ���� ���� ��ȸ  2. ������ ���� ���� ��ȸ");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;

			case 1:
				this.m6_s1(sc);
				break;

			case 2:
				this.m6_s2(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 1. ���� ���� ���� ��ȸ
	private void m6_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 6. ���� ��ȸ > 1. ���� ���� ���� ��ȸ%n", this.admin_id);

		System.out.print("���� ���� ��ȣ > ");
		String open_course_id = sc.nextLine();

		System.out.println("---------------------------");
		System.out.println("** ���� ���� ���� **");
		List<OpenCourse> list1 = this.ocDAO.print1(open_course_id);

		if (list1.size() > 0) {
			for (OpenCourse oc : list1) {
				System.out.printf("���� ���� ��ȣ : %s\n", oc.getCourse_name());
				System.out.printf("���� ������ : %s\n", oc.getCourse_name());
				System.out.printf("���� ���� �Ⱓ : %tF ~ %tF\n", oc.getOpen_course_start_date(),
						oc.getOpen_course_end_date());
				System.out.printf("���ǽǸ� : %s\n", oc.getClass_room_name());
			}
			List<OpenSubject> list2 = this.osDAO.print4("open_course_id", open_course_id);
		
			if(list2.size() > 0) {
				System.out.println("---------------------------");
				System.out.println("���� ���� ��ȣ / ���� ����� / ���� ���� �Ⱓ / ����� / �����");
				
				for (OpenSubject os : list2) {
					System.out.println(os.print1());
				}
				
				System.out.println("---------------------------");
				System.out.printf("�� %d��\n", list2.size());

				System.out.print("���� ���� ��ȣ > ");
				String open_subject_id = sc.nextLine();

				List<OpenSubject> list3 = this.osDAO.print4("open_subject_id", open_subject_id);

				if (list3.size() > 0) {
					for (OpenSubject os : list3) {
						System.out.printf("���� ���� ��ȣ : %s%n", os.getOpen_subject_id());
						System.out.printf("���� ����� : %s%n", os.getSubject_name());
						System.out.printf("���� ���� �Ⱓ : %tF ~ %tF%n", os.getSubject_start_date(), os.getSubject_end_date());
						System.out.printf("����� : %s%n", os.getInstructor_name());
						System.out.printf("����� : %s%n", os.getSubjectbook_name());
					}
					
					List<Exam> list4 = this.eDAO.print1("exam", open_subject_id, null);

					if (list4.size() > 0) {
						for (Exam e1 : list4) {
							System.out.println("-----------------------");
							System.out.printf("�����ȣ : %s%n", e1.getExam_id());
							System.out.printf("������ : %s%n", e1.getAttendance_point());
							System.out.printf("�ʱ���� : %s%n", e1.getWrite_point());
							System.out.printf("�Ǳ���� : %s%n", e1.getSkill_point());
							System.out.printf("���賯¥ : %tF%n", e1.getExam_date());
							System.out.printf("���蹮������ : %s%n", e1.getExam_file());
							System.out.println("-----------------------");

							List<Exam> list5 = this.eDAO.print2(e1.getExam_id());
							if (list5.size() > 0) {
								System.out.println("������ ��ȣ / ������ �̸� / ��ȭ��ȣ / ������� / �ʱ����� / �Ǳ����� / ����");
								for (Exam e2 : list5) {
									System.out.println(e2.print1());
								}
							}
						}
					}
				}
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ
	private void m6_s2(Scanner sc) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------------");
			System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ\n", this.admin_id);
			System.out.println("1. ������ ��ȣ  2. ������ �̸�");
			System.out.print("���� > ");

			int selectNum = sc.nextInt();
			sc.nextLine();

			switch (selectNum) {

			case 0:
				run = false;
				break;

			case 1:
				this.m6_s2_s1(sc);
				break;

			case 2:
				this.m6_s2_s2(sc);
				break;

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 1. ������ ��ȣ
	private void m6_s2_s1(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 1. ������ ��ȣ\n", this.admin_id);
		System.out.print("������ ��ȣ > ");
		String student_id = sc.nextLine();
		System.out.println();
		
		System.out.println(" ** ������ ���� **");
		List<Student> list1 = this.stDAO.print1(student_id);
		if (list1.size() > 0) {
			for (Student s : list1) {
				System.out.printf("������ �̸� : %s%n", s.getStudent_name());
				System.out.printf("������ ��ȭ��ȣ : %s%n", s.getStudent_phone());
			}
			System.out.println();
			System.out.println(" ** ���� ���� ���� **");
			
			List<OpenCourse> list2 = this.ocDAO.print6(student_id);
			if (list2.size() > 0) {
				for (OpenCourse oc : list2) {
					System.out.printf("���� ������ : %s%n", oc.getCourse_name());
					System.out.printf("���� �����Ⱓ : %tF ~ %tF %n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
					System.out.printf("���ǽǸ� : %s%n", oc.getClass_room_name());
				}
				
				System.out.println();
				System.out.println(" ** ���� ���� ���� ���� **");
				List<Exam> list3 = this.eDAO.print3(student_id);
				if (list3.size() > 0) {
					for (Exam e : list3) {
						System.out.println(e.print2());
					}
				}
				System.out.println();
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 2. ������ �̸�
	private void m6_s2_s2(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 6. ���� ��ȸ > 2. ������ ���� ���� ��ȸ > 2. ������ �̸�\n", this.admin_id);
		System.out.print("������ �̸� > ");
		String student_name = sc.nextLine();
		System.out.println();
		
		List<Student> list1 = this.stDAO.print2("student_name", student_name);
			
		if (list1.size() > 0) {

			if(list1.size() > 1) {
				System.out.println("������ ��ȣ / ������ �̸� / ������ �޴��� ��ȣ / ������ �����");
				System.out.println("----------------------");
				for (Student s : list1) {
					System.out.println(s.print1());
				}
				System.out.println("----------------------");
				System.out.printf("�� %s��%n", list1.size());
				System.out.println();
				System.out.println("�˻� ����� ������ �Դϴ�.");
				this.m6_s2_s1(sc);
			} else {
				String student_id = null;
				for (Student s : list1) {
					System.out.printf("������ �̸� : %s%n", s.getStudent_name());
					System.out.printf("������ ��ȭ��ȣ : %s%n", s.getStudent_phone());
					student_id = s.getStudent_id();
				}
				
				System.out.println();
				System.out.println(" ** ���� ���� ���� **");
				List<OpenCourse> list2 = this.ocDAO.print6(student_id);
				if (list2.size() > 0) {
					for (OpenCourse oc : list2) {
						System.out.printf("���� ������ : %s%n", oc.getCourse_name());
						System.out.printf("���� �����Ⱓ : %tF ~ %tF %n", oc.getOpen_course_start_date(), oc.getOpen_course_end_date());
						System.out.printf("���ǽǸ� : %s%n", oc.getClass_room_name());
					}
					
					System.out.println();
					System.out.println(" ** ���� ���� ���� ���� **");
					List<Exam> list3 = this.eDAO.print3(student_id);
					if (list3.size() > 0) {
						for (Exam e : list3) {
							System.out.println(e.print2());
						}
					}
					System.out.println();
				}	
			}
		}
	}

	// ���� ó�� �ý��� v6.0 (������ : admin) > 7. ��й�ȣ ����
	private void m7(Scanner sc) {
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� ó�� �ý��� v6.0 (������ : %s) > 7. ��й�ȣ ����\n", this.admin_id);
		System.out.print("���� ��й�ȣ > ");
		String admin_pw = sc.nextLine();
		System.out.print("�ű� ��й�ȣ > ");
		String admin_new_pw = sc.nextLine();
		System.out.print("��й�ȣ Ȯ�� > ");
		String admin_new_pw2 = sc.nextLine();
		
		System.out.print("��й�ȣ�� �����Ͻðڽ��ϱ�? (0/1) > ");
		int selectNum = sc.nextInt();
		sc.nextLine();
		
		if(admin_new_pw.equals(admin_new_pw2)) {
			if(selectNum == 1) {
				int result = this.aDAO.modify(new Admin(this.admin_id, admin_pw, admin_new_pw));
				
				if(result > 0) {
					System.out.printf("������ '%s'�� ��й�ȣ�� ����Ǿ����ϴ�.\n", this.admin_id);
				} else {
					System.out.println("�����߽��ϴ�.");
				}
			}
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}
}