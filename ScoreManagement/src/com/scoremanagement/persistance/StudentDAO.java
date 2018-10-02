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

	// 수강생 로그인 메소드
	public int login(Student s) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 추가 메소드
	public int insert(Student s) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 히스토리 추가 메소드
	public int studentHistoryAdd(StudentHistory sh) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 출력 메소드(1)
	// 수강생 이름 / 수강생 휴대폰번호
	public List<Student> print1() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// 수강생 출력 메소드(2)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 수강생 등록일
	public List<Student> print2() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// 수강생 출력 메소드(3)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 수강생 등록일 / 수강 횟수
	public List<Student> print3() {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// 수강생 출력 메소드(4)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 수강생 등록일 / 수료여부 / 날짜
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
	
	// 수강생 검색 메소드
	// 1. 수강생 번호  2. 수강생 이름
	public List<Student> search(String key, String value) {
		List<Student> list = new ArrayList<Student>();
		
		return list;
	}
	
	// 수강생 삭제 메소드
	public int remove(Student s) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 비밀번호 수정 메소드
	public int modify(Student s) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 비밀번호 초기화 메소드
	public int reset(Student s) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 히스토리 삭제 메소드
	public int studentHistoryRemove(StudentHistory sh) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 중도 탈락 추가 메소드
	public int processCompleteAdd(StudentHistory sh) {
		int result = 0;
		
		return result;
	}
}
