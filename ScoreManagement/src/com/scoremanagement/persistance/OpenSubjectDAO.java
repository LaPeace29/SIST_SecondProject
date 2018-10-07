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
	
	/*
	CREATE OR REPLACE VIEW open_subject_print1_view1
	AS
	SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, subjectbook_id,
             instructor_name, course_name, open_course_start_date, open_course_end_date, 
             class_room_name, oc.open_course_id, st.student_id         
            FROM open_subject os, subject s, instructor i, 
            open_course oc, class_room cr, course c, student_history sh, student st
            WHERE os.subject_id = s.subject_id
            AND os.instructor_id = i.instructor_id
            AND os.open_course_id = oc.open_course_id
            AND oc.course_id = c.course_id
            AND oc.class_room_id = cr.class_room_id
            AND oc.open_course_id = sh.open_course_id
            AND sh.student_id = st.student_id;
            
	CREATE OR REPLACE VIEW open_subject_print1_view2
	AS
	SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, subjectbook_name,
             instructor_name, course_name, open_course_start_date, open_course_end_date, 
             class_room_name, open_course_id, student_id
            FROM open_subject_print1_view1 v1, subjectbook sb
            WHERE v1.subjectbook_id = sb.subjectbook_id(+);
	 */
	// 개설 과목 출력 메소드(1)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명 / 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenSubject> print1(String key, OpenSubject value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("all")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, subjectbook_name\r\n" + 
						"    , instructor_name,  course_name , open_course_start_date, open_course_end_date, class_room_name\r\n" + 
						"    FROM open_subject_print1_view2\r\n" + 
						"    ORDER BY open_subject_id";
				
				pstmt = conn.prepareStatement(sql);
			}
			
			else if(key.equals("open_subject_id")){
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date,\r\n" + 
						"            subjectbook_name, instructor_name, course_name, open_course_start_date\r\n" + 
						"            , open_course_end_date, class_room_name\r\n" + 
						"                FROM open_subject_print1_view2\r\n" + 
						"                WHERE UPPER(open_subject_id)=UPPER(?)\r\n" + 
						"                ORDER BY open_subject_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getOpen_subject_id());
			}
			
			else if(key.equals("subject_name")){
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date,\r\n" + 
						"            subjectbook_name, instructor_name, course_name, open_course_start_date\r\n" + 
						"            , open_course_end_date, class_room_name\r\n" + 
						"                FROM open_subject_print1_view2\r\n" + 
						"                WHERE INSTR(subject_name, ?) > 0\r\n" + 
						"                ORDER BY open_subject_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getSubject_name());
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
	
	/*
	CREATE OR REPLACE VIEW open_subject_print2_view
	AS
	SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, subjectbook_name
    , instructor_name,  course_name , open_course_start_date,  open_course_end_date, class_room_name
    ,(SELECT COUNT(*) FROM exam
                WHERE open_subject_id = v.open_subject_id) count_
    FROM open_subject_print1_view2 v;
	 */
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
					"                FROM open_subject_print2_view\r\n" + 
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
	public List<OpenSubject> print3(String student_id, String open_subject_id) {
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
			pstmt.setString(2, open_subject_id);
			
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
	
	/*
	CREATE OR REPLACE VIEW open_subject_print4_view1
    AS
    SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_id, oc.open_course_id
    FROM subject s, open_subject os, instructor i, open_course oc
    WHERE s.subject_id = os.subject_id
    AND i.instructor_id = os.instructor_id
    AND os.open_course_id = oc.open_course_id;
  
	CREATE OR REPLACE VIEW open_subject_print4_view2
	AS
	SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name, open_course_id
    FROM open_subject_print4_view1 v1, subjectbook sb
    WHERE sb.subjectbook_id(+) = v1.subjectbook_id; 
	 */
	// 개설 과목 출력 메소드(4)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 교재명 / 강사명
	public List<OpenSubject> print4(String key, OpenSubject value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_course_id")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date\r\n" + 
						"       , subjectbook_name, instructor_name\r\n" + 
						"    FROM open_subject_print4_view2\r\n" + 
						"    WHERE UPPER(open_course_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getOpen_course_id());
			}
			
			else if(key.equals("open_subject_id")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM open_subject_print4_view2\r\n" +
						"	 WHERE UPPER(open_subject_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getOpen_subject_id());
			}
			
			else if(key.equals("subject_name")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM open_subject_print4_view2\r\n" +
						"    WHERE INSTR(subject_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getSubject_name());
			}
			
			else if(key.equals("open_course_idANDstudent_id")) {
				String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, subjectbook_name\r\n" + 
						"    , instructor_name,  course_name , open_course_start_date, open_course_end_date, class_room_name\r\n" + 
						"    FROM open_subject_print1_view2\r\n" + 
						"		    WHERE UPPER(student_id) = UPPER(?)\r\n" + 
						"		    AND UPPER(open_course_id) = UPPER(?)\r\n" + 
						"		    ORDER BY subject_start_date";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_id());
				pstmt.setString(2, value.getOpen_course_id());
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
	
	/*
	 CREATE OR REPLACE VIEW open_subject_print6_view
	AS
	SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_id,
    CASE
  WHEN SYSDATE <subject_start_date THEN '강의 예정'
  WHEN SYSDATE >subject_end_date THEN '강의 종료'
  else '강의 중'
  END completion
    FROM open_subject os, subject s
    WHERE os.subject_id = s.subject_id;
	 */
	// 개설 과목 출력 메소드(6)
	// 개설 과목 번호 / 과목명 / 개설 과목 기간 / 비고
	public List<OpenSubject> print6(String instructor_id) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, completion\r\n" + 
					"     FROM open_subject_print6_view\r\n" + 
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
	
	/*
	CREATE OR REPLACE VIEW open_subject_print7_view1
	AS
	SELECT os.instructor_id ,course_name, open_course_start_date, open_subject_id
	, open_course_end_date, class_room_name, subject_name
	, subject_start_date, subject_end_date, subjectbook_id, oc.open_course_id
    FROM course c, open_course oc, class_room cr
        , open_subject os, subject s
    WHERE c.course_id = oc.course_id
    AND cr.class_room_id = oc.class_room_id
    AND oc.open_course_id = os.open_course_id
    AND s.subject_id = os.subject_id;

	CREATE OR REPLACE VIEW open_subject_print7_view2
	AS
	SELECT v1.instructor_id, course_name, open_course_start_date, open_subject_id
	, open_course_end_date, class_room_name, open_course_id
	, subject_name, subject_start_date, subject_end_date, subjectbook_name
    FROM open_subject_print7_view1 v1, subjectbook sb
    WHERE v1.subjectbook_id = sb.subjectbook_id(+);
	 */
	// 개설 과목 출력 메소드(7)
	// 개설 과목 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 과목명 / 개설 과목 기간 / 교재명 / 수강생 등록 인원
	public List<OpenSubject> print7(String key, OpenSubject value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_subject_id, course_name, open_course_start_date\r\n" + 
					", open_course_end_date, class_room_name\r\n" + 
					", subject_name, subject_start_date, subject_end_date, subjectbook_name\r\n" + 
					", (SELECT COUNT(*) FROM student_history sh WHERE v2.open_course_id = sh.open_course_id) student_count\r\n" + 
					"    FROM open_subject_print7_view2 v2\r\n" + 
					"    WHERE UPPER(open_subject_id) = UPPER(?)\r\n" + 
					"    AND UPPER(v2.instructor_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value.getOpen_subject_id());
			pstmt.setString(2, value.getInstructor_id());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_subject_id = rs.getString("open_subject_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				String subject_name = rs.getString("subject_name");
				Date subject_start_date = rs.getDate("subject_start_date");
				Date subject_end_date = rs.getDate("subject_end_date");
				String subjectbook_name = rs.getString("subjectbook_name");
				int student_count = rs.getInt("student_count");
				
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
	
	/*
	CREATE OR REPLACE VIEW OpenSubject_print9_view
	AS
	SELECT subject_name, subject_start_date, subject_end_date, course_name
     , open_course_start_date, open_course_end_date, class_room_name 
     ,CASE
  WHEN SYSDATE <subject_start_date THEN '강의 예정'
  WHEN SYSDATE >subject_end_date THEN '강의 종료'
  else '강의 중'
  END completion, ip.instructor_id
    FROM subject s, open_subject os, course c, open_course oc, class_room cr
    , instructor i, instructor_possible ip
    WHERE s.subject_id = os.subject_id
    AND oc.open_course_id = os.open_course_id
    AND c.course_id = oc.course_id
    AND cr.class_room_id = oc.class_room_id
    AND i.instructor_id = os.instructor_id
    AND ip.subject_id = s.subject_id;
	 */
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
						"     FROM OpenSubject_print9_view\r\n" + 
						"     WHERE UPPER(instructor_id) = UPPER(?)\r\n" + 
						"     ORDER BY subject_end_date";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);	
			}
						
			else if(key.equals("instructor_name")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, course_name\r\n" + 
						"     , open_course_start_date, open_course_end_date, class_room_name \r\n" + 
						"     , completion\r\n" + 
						"     FROM OpenSubject_print9_view\r\n" + 
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

	/*
	CREATE OR REPLACE VIEW open_subject_search_view1
    AS
    SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_id, s.subject_id, st.student_id
    FROM subject s, open_subject os, instructor i, open_course oc, student_history sh, student st
    WHERE s.subject_id = os.subject_id
    AND i.instructor_id = os.instructor_id
    AND os.open_course_id = oc.open_course_id
    AND oc.open_course_id = sh.open_course_id
    AND sh.student_id = st.student_id;
  
	CREATE OR REPLACE VIEW open_subject_search_view2
	AS
	SELECT open_subject_id, subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name, student_id
    FROM open_subject_search_view1 osv, subjectbook sb
    WHERE sb.subjectbook_id(+) = osv.subjectbook_id; 
	 */
	// 개설 과목 검색 메소드
	// 1. 개설 과목 번호  2. 과목명
	public List<OpenSubject> search(String key, OpenSubject value) {
		List<OpenSubject> list = new ArrayList<OpenSubject>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_subject_id")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM open_subject_search_view2 \r\n" + 
						"    WHERE UPPER(open_subject_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getOpen_subject_id());
			}

			else if(key.equals("subject_name")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"    FROM open_subject_search_view2 \r\n" + 
						"    WHERE INSTR(subject_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getSubject_name());
			}

			else if(key.equals("student_idANDopen_subject_id")) {
				String sql = "SELECT subject_name, subject_start_date, subject_end_date, instructor_name, subjectbook_name\r\n" + 
						"	FROM open_subject_search_view2\r\n" + 
						"	WHERE student_id = UPPER(?)\r\n" + 
						"	AND open_subject_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_id());
				pstmt.setString(2, value.getOpen_subject_id());
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
