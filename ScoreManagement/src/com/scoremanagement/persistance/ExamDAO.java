package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.Exam;

public class ExamDAO {

	// 시험 출력 메소드(1)
	// 시험번호 / 출결 배점 / 필기 배점 / 실기 배점 / 시험 날짜 / 시험문제 파일
	public List<Exam> print1(String key, String value1, String value2) {
		List<Exam> list = new ArrayList<Exam>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_subject_id")) {
				String sql = "SELECT exam_id, attendance_point, write_point, skill_point, exam_date, exam_file\r\n" + 
						"    FROM exam_info_view2\r\n" + 
						"    WHERE instructor_id = ?\r\n" + 
						"    AND open_subject_id = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value2);
				pstmt.setString(2, value1);
			}

			else if(key.equals("exam")) {
				String sql = "SELECT exam_id, attendance_point, write_point, skill_point, exam_date, exam_file\r\n" + 
						"    FROM exam_info_view2\r\n" +
						"     WHERE open_subject_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
			}
			
			else if(key.equals("exam")) {
				String sql = "SELECT exam_id, attendance_point, write_point, skill_point, exam_date, exam_file\r\n" + 
						"    FROM exam_info_view2\r\n" +
						"     WHERE open_subject_id = UPPER(?)\r\n" + 
						"     AND instructor_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
				pstmt.setString(2, value2);
			}
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
	public List<Exam> print2(String examId) {
		List<Exam> list = new ArrayList<Exam>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT student_id, student_name, student_phone, attendance_score, write_score, skill_score, total\r\n" + 
					"    FROM exam_search_view\r\n" + 
					"    WHERE UPPER(exam_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				int attendance_score = rs.getInt("attendance_score");
				int write_score = rs.getInt("write_score");
				int skill_score = rs.getInt("skill_score");
				int total = rs.getInt("total");
				
				Exam e = new Exam(student_id, student_name, student_phone, attendance_score, write_score,
						skill_score, total);
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
	
	// 시험 출력 메소드(3)
	// 과목명 / 개설 과목 기간 / 강사명 / 출결 점수 / 출결 배점 / 필기 점수 / 필기 배점 / 실기 점수 / 실기 배점 / 시험 날짜
	public List<Exam> print3(String open_subject_id, String instructor_id, String exam_id) {
		List<Exam> list = new ArrayList<Exam>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT exam_id, attendance_point, write_point, skill_point, exam_date, exam_file, count_, score_state\r\n" + 
					"    FROM all_exam_view3\r\n" + 
					"    WHERE instructor_id = ?\r\n" + 
					"    AND open_subject_id = ?";
			
			if(!Objects.isNull(exam_id)) {
				sql += "\r\n AND exam_id = ?";
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, instructor_id);
			pstmt.setString(2, open_subject_id);
			
			if(!Objects.isNull(exam_id)) {
				pstmt.setString(3, exam_id);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String exam_id1 = rs.getString("exam_id");
				int attendance_point = rs.getInt("attendance_point");
				int write_point = rs.getInt("write_point");
				int skill_point = rs.getInt("skill_point");
				Date exam_date = rs.getDate("exam_date");
				String exam_file = rs.getString("exam_file");
				int class_count = rs.getInt("count_");
				String score_status = rs.getString("score_state");
				
				Exam e = new Exam(exam_id1, attendance_point, write_point, skill_point, exam_date,
						exam_file, class_count, score_status);
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
	
	public List<Exam> print3(String student_id) {
		List<Exam> list = new ArrayList<Exam>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT subject_name, subject_start_date, subject_end_date, instructor_name, attendance_point\r\n" + 
					"    , write_point, skill_point, attendance_score, write_score, skill_score, exam_date\r\n" + 
					"    FROM score_search_view\r\n" + 
					"    WHERE UPPER(student_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String instructor_name = rs.getString("instructor_name");
				int attendance_point = rs.getInt("attendance_point");
				int write_point = rs.getInt("write_point");
				int skill_point = rs.getInt("skill_point");
				int attendance_score = rs.getInt("attendance_score");
				int write_score = rs.getInt("write_score");
				int skill_score = rs.getInt("skill_score");
				Date exam_date = rs.getDate("exam_date");
				
				Exam e = new Exam(subject_name, subject_start_date, subject_end_date,instructor_name,
						attendance_point, write_point, skill_point, exam_date, attendance_score,
						write_score, skill_score);
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
	
	// 시험 출력 메소드(4)
	// 시험번호 / 출결 배점 / 필기 배점 / 실기 배점 / 시험 날짜 / 시험문제 파일 / 성적 등록 인원수 / 성적 등록 여부
	public List<Exam> print4() {
		List<Exam> list = new ArrayList<Exam>();
		
		return list;
	}
	
	// 시험 출력 메소드(5)
	// 수강생 번호 / 수강생 이름 / 수강생 전화번호 / 수강생 등록일 / 수료여부 / 수료날짜 / 출결 점수 / 필기 점수 / 실기 점수 / 총점
	public List<Exam> print5(String open_subject_id, String instructor_id, String exam_id) {
		List<Exam> list = new ArrayList<Exam>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT student_id, student_name, student_phone, student_regDate, completion, completion_date," + 
					"    attendance_score, write_score, skill_score, total\r\n" + 
					"    FROM student_info_view3\r\n" + 
					"    WHERE open_subject_id = ?\r\n" + 
					"    AND instructor_id = ?\r\n" + 
					"    AND exam_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, open_subject_id);
			pstmt.setString(2, instructor_id);
			pstmt.setString(3, exam_id);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				int attendance_score = rs.getInt("attendance_score");
				int write_score = rs.getInt("write_score");
				int skill_score = rs.getInt("skill_score");
				int total_score = rs.getInt("total");				
				String completion_status = rs.getString("completion");
				Date completion_date = rs.getDate("completion_date");

				Exam e = new Exam(student_id, student_name, student_phone, student_regDate,
						attendance_score, write_score, skill_score, total_score, completion_status,
						completion_date);
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
	
	// 시험 출력 메소드(6)
	// 교재명 / 강사명 / 출결 배점 / 필기 배점 / 실기 배점 / 출결 점수 / 필기 점수 / 실기 점수 / 시험 날짜 / 시험문제 파일
	public List<Exam> print6() {
		List<Exam> list = new ArrayList<Exam>();
		/*SELECT course_name, subject_name, subject_start_date, subject_end_date, subjectbook_name, instructor_name, 
		attendance_point, write_point, skill_point, attendance_score, write_score, skill_score, student_id, exam_date, exam_file
	    FROM s_score_detail_view2
	    WHERE open_subject_id = 'OS0032'
	    AND student_id = 'ST00031';*/
		return list;
	}
	
	// 시험 배점 입력 메소드
	public int insertPoint(Exam e) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			String exam_id = null;
			conn = OracleConnection.connect();
			String sql1 = "SELECT (CONCAT('EXAM', LPAD(NVL(SUBSTR(MAX(exam_id), 5), 0) + 1, 4, 0)))AS newID\r\n" + 
							"FROM exam";
			
			pstmt1 = conn.prepareStatement(sql1);
			ResultSet rs = pstmt1.executeQuery();
			
			while(rs.next()) {
				exam_id = rs.getString("newID");
			}
			String sql2 = "Insert into EXAM (EXAM_ID, EXAM_DATE, EXAM_FILE, OPEN_SUBJECT_ID)\r\n" + 
					"values (?, ?, ?, ?)";
			
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt2.setString(1, exam_id);
			pstmt2.setDate(2, e.getExam_date());
			pstmt2.setString(3, e.getExam_file());
			pstmt2.setString(4, e.getOpen_subject_id());
			
			int result1 = pstmt2.executeUpdate();
			
			String sql3 = "Insert into SUBJECT_POINT \r\n" + 
					"(SUBJECT_POINT_ID,EXAM_ID,ATTENDANCE_POINT,WRITE_POINT,SKILL_POINT) \r\n" + 
					"values ((SELECT(CONCAT('SP', LPAD(NVL(SUBSTR(MAX(SUBJECT_POINT_ID), 3), 0) + 1, 2, 0)))AS newID FROM subject_point),\r\n" + 
					"?, ?, ?, ?)";			
			
			pstmt3 = conn.prepareStatement(sql3);			
			
			pstmt3.setString(1, exam_id);
			pstmt3.setInt(2, e.getAttendance_point());
			pstmt3.setInt(3, e.getWrite_point());
			pstmt3.setInt(4, e.getSkill_point());
			
			int result2 = pstmt3.executeUpdate();
			
			if((result1 != 0) && (result2 != 0)) {
				result = 1;
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
            try {
                if (pstmt1 != null)
                    pstmt1.close();
                if (pstmt2 != null)
                	pstmt2.close();
                if (pstmt3 != null)
                	pstmt3.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                OracleConnection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

		return result;
	}
	
	// 시험 배점 삭제 메소드
	public int removePoint(Exam e) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = OracleConnection.connect();
			String sql1 = "DELETE FROM subject_point\r\n" + 
					"    WHERE exam_id = (SELECT sp.exam_id\r\n" + 
					"                        FROM subject_point sp, exam e, open_subject os, instructor i \r\n" + 
					"                        WHERE sp.exam_id = e.exam_id\r\n" + 
					"                            AND e.open_subject_id = os.open_subject_id\r\n" + 
					"                            AND os.instructor_id = i.instructor_id\r\n" + 
					"                            AND i.instructor_id = ?\r\n" + 
					"                            AND e.exam_id = ?)";
			
			pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setString(1, e.getInstructor_id());
			pstmt1.setString(2, e.getExam_id());

			int result1 = pstmt1.executeUpdate();
			
			String sql2 = "DELETE FROM EXAM\r\n" + 
					"    WHERE exam_id = (SELECT exam_id\r\n" + 
					"                        FROM exam e, open_subject os, instructor i \r\n" + 
					"                        WHERE e.open_subject_id = os.open_subject_id\r\n" + 
					"                            AND os.instructor_id = i.instructor_id\r\n" + 
					"                            AND i.instructor_id = ?\r\n" + 
					"                            AND e.exam_id = ?)";
			
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt2.setString(1, e.getInstructor_id());
			pstmt2.setString(2, e.getExam_id());

			int result2 = pstmt2.executeUpdate();
			
			if((result1 != 0) && (result2 != 0)) {
				result = 1;
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
            try {
                if (pstmt1 != null)
                    pstmt1.close();
                if (pstmt2 != null)
                	pstmt2.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                OracleConnection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		return result;
	}
	
	// 시험 성적 입력 메소드
	public int insertScore(Exam e) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "INSERT INTO student_score (student_score_id, attendance_score, write_score, skill_score, exam_id, student_id)\r\n" + 
					"    VALUES((SELECT (CONCAT('SS', LPAD(NVL(SUBSTR(MAX(student_score_id), 3), 0) + 1, 5, 0)))AS newID FROM student_score)\r\n" + 
					"    , ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, e.getAttendance_score());
			pstmt.setInt(2, e.getWrite_score());
			pstmt.setInt(3, e.getSkill_score());
			pstmt.setString(3, e.getExam_id());
			pstmt.setString(4, e.getStudent_id());
			
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
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
		
		return result;
	}
	
	// 시험 성적 삭제 메소드
	public int removeScore(Exam e) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM student_score\r\n" + 
					"    WHERE student_id = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, e.getStudent_id());
			
			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
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
		
		return result;
	}
}
