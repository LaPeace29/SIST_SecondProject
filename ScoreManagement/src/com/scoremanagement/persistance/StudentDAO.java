package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.OpenSubject;
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
	public List<Student> print4(String open_subject_id, String instructor_id) {
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT student_id, student_name, student_phone, student_regDate, completion, completion_date\r\n" + 
					"    FROM student_info_view3\r\n" + 
					"    WHERE open_subject_id = ?\r\n" + 
					"    AND instructor_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, open_subject_id);
			pstmt.setString(2, instructor_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				String completion_status = rs.getString("completion");
				Date completion_date = rs.getDate("completion_date");
				
				Student s = new Student(student_id, student_name, student_phone, student_regDate,
						completion_status, completion_date);
				list.add(s);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                OracleConnection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

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
