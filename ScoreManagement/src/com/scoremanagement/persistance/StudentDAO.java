package com.scoremanagement.persistance;

import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.domain.Student;
import com.scoremanagement.domain.StudentHistory;

public class StudentDAO {

	// ������ �α��� �޼ҵ�
	public int login(Student s) {
		int result = 0;
		
		return result;
	}
	
	// ������ �߰� �޼ҵ�
	public int insert(Student s) {
		int result = 0;
		
		return result;
	}
	
	// ������ �����丮 �߰� �޼ҵ�
	public int studentHistoryAdd(StudentHistory sh) {
		int result = 0;
		
		return result;
	}
	
	// ������ ��� �޼ҵ�(1)
	// ������ �̸� / ������ �޴�����ȣ
	public List<Student> print1() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// ������ ��� �޼ҵ�(2)
	// ������ ��ȣ / ������ �̸� / ������ �޴�����ȣ / ������ �����
	public List<Student> print2() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// ������ ��� �޼ҵ�(3)
	// ������ ��ȣ / ������ �̸� / ������ �޴�����ȣ / ������ ����� / ���� Ƚ��
	public List<Student> print3() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// ������ ��� �޼ҵ�(4)
	// ������ ��ȣ / ������ �̸� / ������ �޴�����ȣ / ������ ����� / ���Ῡ�� / ��¥
	public List<Student> print4() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// ������ �˻� �޼ҵ�
	// 1. ������ ��ȣ  2. ������ �̸�
	public List<Student> search(String key, String value) {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// ������ ���� �޼ҵ�
	public int remove(Student s) {
		int result = 0;
		
		return result;
	}
	
	// ������ ��й�ȣ ���� �޼ҵ�
	public int modify(Student s) {
		int result = 0;
		
		return result;
	}
	
	// ������ ��й�ȣ �ʱ�ȭ �޼ҵ�
	public int reset(Student s) {
		int result = 0;
		
		return result;
	}
	
	// ������ �����丮 ���� �޼ҵ�
	public int studentHistoryRemove(StudentHistory sh) {
		int result = 0;
		
		return result;
	}
	
	// ������ �ߵ� Ż�� �߰� �޼ҵ�
	public int processCompleteAdd(StudentHistory sh) {
		int result = 0;
		
		return result;
	}
}
