package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.Exam;
import com.scoremanagement.domain.OpenSubject;

public class ExamDAO {

	// ���� ��� �޼ҵ�(1)
	// �����ȣ / ��� ���� / �ʱ� ���� / �Ǳ� ���� / ���� ��¥ / ���蹮�� ����
	public List<Exam> print1(String open_subject_id, String instructor_id) {
		List<Exam> list = new ArrayList<Exam>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT exam_id, attendance_point, write_point, skill_point, exam_date, exam_file\r\n" + 
					"    FROM exam_info_view2\r\n" + 
					"    WHERE instructor_id = ?\r\n" + 
					"    AND open_subject_id = ?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, instructor_id);
			pstmt.setString(2, open_subject_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String exam_id = rs.getString("exam_id");
				int attendance_point = rs.getInt("attendance_point");
				int write_point = rs.getInt("write_point");
				int skill_point = rs.getInt("skill_point");
				Date exam_date = rs.getDate("exam_date");
				String exam_file = rs.getString("exam_file");
				
				Exam e = new Exam(exam_id, "", attendance_point, write_point, skill_point,
						exam_date, exam_file);
				list.add(e);
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
	
	// ���� ��� �޼ҵ�(2)
	// ������ ��ȣ / ������ �̸� / ������ �޴�����ȣ / ��� ���� / �ʱ� ���� / �Ǳ� ���� / ����
	public List<Exam> print2() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// ���� ��� �޼ҵ�(3)
	// ����� / ���� ���� �Ⱓ / ����� / ��� ���� / ��� ���� / �ʱ� ���� / �ʱ� ���� / �Ǳ� ���� / �Ǳ� ���� / ���� ��¥
	public List<Exam> print3() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// ���� ��� �޼ҵ�(4)
	// �����ȣ / ��� ���� / �ʱ� ���� / �Ǳ� ���� / ���� ��¥ / ���蹮�� ���� / ���� ��� �ο��� / ���� ��� ����
	public List<Exam> print4() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// ���� ��� �޼ҵ�(5)
	// ������ ��ȣ / ������ �̸� / ������ ��ȭ��ȣ / ������ ����� / ���Ῡ�� / ���ᳯ¥ / ��� ���� / �ʱ� ���� / �Ǳ� ���� / ����
	public List<Exam> print5() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// ���� ��� �޼ҵ�(6)
	// ����� / ����� / ��� ���� / �ʱ� ���� / �Ǳ� ���� / ��� ���� / �ʱ� ���� / �Ǳ� ���� / ���� ��¥ / ���蹮�� ����
	public List<Exam> print6() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// ���� ���� �Է� �޼ҵ�
	public int insertPoint(Exam e) {
		int result = 0;
		
		return result;
	}
	
	// ���� ���� ���� �޼ҵ�
	public int removePoint(Exam e) {
		int result = 0;
		
		return result;
	}
	
	// ���� ���� �Է� �޼ҵ�
	public int insertScore(Exam e) {
		int result = 0;
		
		return result;
	}
	
	// ���� ���� ���� �޼ҵ�
	public int removeScore(Exam e) {
		int result = 0;
		
		return result;
	}
}
