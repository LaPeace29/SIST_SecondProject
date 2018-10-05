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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "INSERT INTO open_subject (open_subject_id, subjectbook_id, subject_id\r\n" + 
					"    , instructor_id, open_course_id, subject_start_date, subject_end_date)\r\n" + 
					"    VALUES ((SELECT CONCAT('OS',\r\n" + 
					"		 LPAD(NVL(SUBSTR(MAX(open_subject_id),3), 0) + 1, 4, 0)) AS newId FROM open_subject)\r\n" + 
					"         , ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, os.getSubjectbook_id());
			pstmt.setString(2, os.getSubject_id());
			pstmt.setString(3, os.getInstructor_id());
			pstmt.setString(4, os.getOpen_course_id());
			pstmt.setDate(5, os.getSubject_start_date());
			pstmt.setDate(6, os.getSubject_end_date());

			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	// 개설 과목 출력 메소드(1)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenSubject> print1(String key, String value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("all")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, subjectbook_name\r\n" + 
						"    , instructor_name,  course_name , open_course_start_date,  open_course_end_date, class_room_name\r\n" + 
						"    FROM open_subject_all_view2\r\n" + 
						"    ORDER BY open_subject_id";
				
				pstmt = conn.prepareStatement(sql);
			}
			
			else if(key.equals("open_course_id")){
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date,\r\n" + 
						"            subjectbook_name, instructor_name, course_name, open_course_start_date\r\n" + 
						"            , open_course_end_date, class_room_name\r\n" + 
						"                FROM open_course_info_join_view\r\n" + 
						"                WHERE UPPER(open_subject_id)=UPPER(?)\r\n" + 
						"                ORDER BY open_subject_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			else if(key.equals("subject_name")){
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date,\r\n" + 
						"            subjectbook_name, instructor_name, course_name, open_course_start_date\r\n" + 
						"            , open_course_end_date, class_room_name\r\n" + 
						"                FROM open_course_info_join_view\r\n" + 
						"                WHERE INSTR(subject_name, ?) > 0\r\n" + 
						"                ORDER BY open_subject_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_subject_id = rs.getString("open_subject_id");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String subjectbook_name = rs.getString("subjectbook_name");
				String instructor_name = rs.getString("instructor_name");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				
				OpenSubject os = new OpenSubject(open_subject_id, subject_name, subjectbook_name, instructor_name, course_name,
						subject_start_date, subject_end_date, open_course_start_date, open_course_end_date, class_room_name);
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
	
	// 개설 과목 출력 메소드(2)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 과정명 / 개설 과정 기간 / 강의실명 / 삭제 가능 여부
	public List<OpenSubject> print2() {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date,\r\n" + 
					"            subjectbook_name, instructor_name, course_name, open_course_start_date\r\n" + 
					"            , open_course_end_date, class_room_name\r\n" + 
					"            , count_\r\n" + 
					"                FROM open_subject_all_view3\r\n" + 
					"                ORDER BY open_subject_id";
			
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String open_subject_id = rs.getString("open_subject_id");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String subjectbook_name = rs.getString("subjectbook_name");
				String instructor_name = rs.getString("instructor_name");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				int count_ = rs.getInt("count_");

				OpenSubject os = new OpenSubject(open_subject_id, subject_name, subjectbook_name, instructor_name,
						course_name, subject_start_date, subject_end_date, open_course_start_date, open_course_end_date,
						class_room_name, count_);

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
	
	// 개설 과목 출력 메소드(3)
	// 과목명 / 개설 과목 기간
	public List<OpenSubject> print3(String student_id, String open_course_id) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT subject_name, subject_start_date, subject_end_date\r\n" + 
					"    FROM subject_ss1\r\n" + 
					"    WHERE student_id = UPPER(?)\r\n" + 
					"    AND open_subject_id = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, open_course_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
			
				OpenSubject os = new OpenSubject(null, subject_name, subject_start_date, subject_end_date, null);
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
	
	public List<OpenSubject> print3(String open_subject_id) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT s.subject_name, os.subject_start_date, os.subject_end_date\r\n" + 
					"	    FROM open_subject os, subject s\r\n" + 
					"	    WHERE os.subject_id = s.subject_id\r\n" + 
					"	    AND os.open_subject_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, open_subject_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				
				OpenSubject os = new OpenSubject("", subject_name, subject_start_date, subject_end_date,"");
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
	
	// 개설 과목 출력 메소드(4)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명
	public List<OpenSubject> print4(String key, String value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_course_id")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date\r\n" + 
						"       , subjectbook_name, instructor_name\r\n" + 
						"    FROM os_search2\r\n" + 
						"    WHERE UPPER(open_course_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			else if(key.equals("open_subject_id")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM os_search_view2 \r\n" +
						"	 WHERE UPPER(open_subject_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			else if(key.equals("subject_id")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM os_search_view2 \r\n" +
						"	 WHERE UPPER(open_subject_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			else if(key.equals("subject_name")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM os_search_view2 \r\n" +
						"    WHERE INSTR(subject_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_subject_id = rs.getString("open_subject_id");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String subjectbook_name = rs.getString("subjectbook_name");
				String instructor_name = rs.getString("instructor_name");
				
				OpenSubject os = new OpenSubject(open_subject_id, subject_name, subjectbook_name, instructor_name,
						null, subject_start_date, subject_end_date, null, null, null);
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
	public List<OpenSubject> print8(String student_id, String open_course_id) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date\r\n" + 
					"		    FROM s_open_subject_view\r\n" + 
					"		    WHERE student_id = UPPER(?) \r\n" + 
					"		    AND open_course_id = UPPER(?)\r\n" + 
					"		    ORDER BY subject_start_date";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, open_course_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_subject_id = rs.getString("open_subject_id");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
								
				OpenSubject os = new OpenSubject(open_subject_id, subject_name,
						subject_start_date, subject_end_date, null);
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
	
	// 개설 과목 출력 메소드(9)
	// 과목명 / 개설 과목 기간 / 과정명 / 개설 과정 기간 / 강의실 / 강의 진행 여부
	public List<OpenSubject> print9(String key, String value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			
			if(key.equals("instructor_id")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, course_name\r\n" + 
						"     , open_course_start_date, open_course_end_date, class_room_name \r\n" + 
						"     , completion\r\n" + 
						"     FROM instructor_search_view1\r\n" + 
						"     WHERE UPPER(instructor_id) = UPPER(?)\r\n" + 
						"     ORDER BY subject_end_date";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);	
			}
						
			else if(key.equals("instructor_name")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, course_name\r\n" + 
						"     , open_course_start_date, open_course_end_date, class_room_name \r\n" + 
						"     , completion\r\n" + 
						"     FROM instructor_search_view1\r\n" + 
						"     WHERE INSTR(instructor_name, ?) > 0\r\n" + 
						"     ORDER BY subject_end_date";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);	
			}
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				String completion = rs.getString("completion");
				OpenSubject os = new OpenSubject(subject_name, course_name, subject_start_date, subject_end_date,
						open_course_start_date, open_course_end_date, class_room_name, completion);
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

	// 개설 과목 검색 메소드
	// 1. 개설 과목 번호  2. 과목명
	public List<OpenSubject> search(String key, String value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_subject_id")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM os_search_view2 \r\n" + 
						"    WHERE UPPER(open_subject_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}

			else if(key.equals("subject_name")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM os_search_view2 \r\n" + 
						"    WHERE INSTR(subject_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String instructor_name = rs.getString("instructor_name");
				String subjectbook_name = rs.getString("subjectbook_name");

				OpenSubject os = new OpenSubject(null, subject_name, subjectbook_name, instructor_name,
						null, subject_start_date, subject_end_date, null, null, null);
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
	
	// 개설 과목 삭제 메소드
	public int remove(OpenSubject os) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM open_subject WHERE UPPER(open_subject_id) = UPPER(?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, os.getOpen_subject_id());

			result = pstmt.executeUpdate();
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
		
		return result;
	}
}
