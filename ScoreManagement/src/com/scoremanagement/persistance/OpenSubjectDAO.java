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

public class OpenSubjectDAO {
	
	// 개설 과목 추가 메소드
	public int insert(OpenSubject os) {
		int result = 0;
		
		return result;
	}
	
	// 개설 과목 출력 메소드(1)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenSubject> print1() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		return list;
	}
	
	// 개설 과목 출력 메소드(2)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 과정명 / 개설 과정 기간 / 강의실명 / 삭제 가능 여부
	public List<OpenSubject> print2() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		return list;
	}
	
	// 개설 과목 출력 메소드(3)
	// 과목명 / 개설 과목 기간
	public List<OpenSubject> print3() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		/*		SELECT s.subject_name, os.subject_start_date, os.subject_end_date
	    FROM open_subject os, subject s
	    WHERE os.subject_id = s.subject_id
	    AND os.open_subject_id = 'OS0031';
*/
		return list;
	}
	
	// 개설 과목 출력 메소드(4)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명
	public List<OpenSubject> print4() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		return list;
	}
	
	// 개설 과목 출력 메소드(5)
	// 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenSubject> print5() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		return list;
	}
	
	// 개설 과목 출력 메소드(6)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 비고
	public List<OpenSubject> print6(String instructor_id) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, completion\r\n" + 
					"     FROM subject_schedule_view\r\n" + 
					"     WHERE instructor_id = ?\r\n" + 
					"     ORDER BY open_subject_id";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, instructor_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_subject_id = rs.getString("open_subject_id");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String completion = rs.getString("completion");
				
				OpenSubject os = new OpenSubject(open_subject_id, subject_name, subject_start_date, subject_end_date, completion);
				list.add(os);
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
	
	// 개설 과목 출력 메소드(7)
	// 개설 과목 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 과목명 / 개설 과목 기간 / 교재명 / 수강생 등록 인원
	public List<OpenSubject> print7(String open_subject_id, String instructor_id) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT course_name, open_course_start_date\r\n" + 
					", open_course_end_date, class_room_name\r\n" + 
					", subject_name, subject_start_date, subject_end_date, subjectbook_name\r\n" + 
					", (SELECT COUNT(*) FROM student_history sh WHERE crv.open_course_id = sh.open_course_id) count\r\n" + 
					"    FROM course_registration_view2 crv\r\n" + 
					"    WHERE open_subject_id = ?\r\n" + 
					"    AND crv.instructor_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, open_subject_id);
			pstmt.setString(2, instructor_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String subjectbook_name = rs.getString("subjectbook_name");
				int student_count = rs.getInt("count");
				
				OpenSubject os = new OpenSubject(open_subject_id, subject_name, subjectbook_name, course_name,
						subject_start_date, subject_end_date, open_course_start_date, open_course_end_date,
						class_room_name, student_count);
				list.add(os);
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
	
	// 개설 과목 출력 메소드(8)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간
	public List<OpenSubject> print8() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		/*		CREATE VIEW s_open_subject_view
		AS
		SELECT os.open_course_id, subject_name, subject_start_date, subject_end_date, sh.student_id
		    FROM student_history sh, open_course oc, open_subject os, subject sub
		    WHERE oc.open_course_id = sh.open_course_id
		    AND oc.open_course_id = os.open_course_id
		    AND sub.subject_id = os.subject_id;
		    
		SELECT open_course_id, subject_name, subject_start_date, subject_end_date
		    FROM s_open_subject_view
		    WHERE student_id = 'ST00031'
		    AND open_course_id = 'OC0001'
		    ORDER BY subject_start_date;
*/
		return list;
	}
	
	// 개설 과목 출력 메소드(9)
	// 과목명 / 개설 과목 기간 / 과정명 / 개설 과정 기간 / 강의실 / 강의 진행 여부
	public List<OpenSubject> print9() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		return list;
	}

	// 개설 과목 검색 메소드
	// 1. 개설 과목 번호  2. 과목명
	public List<OpenSubject> search(String key, String value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		return list;
	}
	
	// 개설 과목 삭제 메소드
	public int remove(OpenSubject os) {
		int result = 0;
		
		return result;
	}
}
