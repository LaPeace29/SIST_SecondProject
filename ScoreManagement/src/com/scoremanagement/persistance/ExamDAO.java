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

	// 시험 출력 메소드(1)
	// 시험번호 / 출결 배점 / 필기 배점 / 실기 배점 / 시험 날짜 / 시험문제 파일
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
	
	// 시험 출력 메소드(2)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 출결 점수 / 필기 점수 / 실기 점수 / 총점
	public List<Exam> print2() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// 시험 출력 메소드(3)
	// 과목명 / 개설 과목 기간 / 강사명 / 출결 점수 / 출결 배점 / 필기 점수 / 필기 배점 / 실기 점수 / 실기 배점 / 시험 날짜
	public List<Exam> print3() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// 시험 출력 메소드(4)
	// 시험번호 / 출결 배점 / 필기 배점 / 실기 배점 / 시험 날짜 / 시험문제 파일 / 성적 등록 인원수 / 성적 등록 여부
	public List<Exam> print4() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// 시험 출력 메소드(5)
	// 수강생 번호 / 수강생 이름 / 수강생 전화번호 / 수강생 등록일 / 수료여부 / 수료날짜 / 출결 점수 / 필기 점수 / 실기 점수 / 총점
	public List<Exam> print5() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// 시험 출력 메소드(6)
	// 교재명 / 강사명 / 출결 배점 / 필기 배점 / 실기 배점 / 출결 점수 / 필기 점수 / 실기 점수 / 시험 날짜 / 시험문제 파일
	public List<Exam> print6() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// 시험 배점 입력 메소드
	public int insertPoint(Exam e) {
		int result = 0;
		
		return result;
	}
	
	// 시험 배점 삭제 메소드
	public int removePoint(Exam e) {
		int result = 0;
		
		return result;
	}
	
	// 시험 성적 입력 메소드
	public int insertScore(Exam e) {
		int result = 0;
		
		return result;
	}
	
	// 시험 성적 삭제 메소드
	public int removeScore(Exam e) {
		int result = 0;
		
		return result;
	}
}
