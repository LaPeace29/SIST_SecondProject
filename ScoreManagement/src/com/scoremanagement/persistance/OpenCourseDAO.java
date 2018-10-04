package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.OpenCourse;

public class OpenCourseDAO {

	// 개설 과정 추가 메소드
	public int insert(OpenCourse oc) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "INSERT INTO open_course (open_course_id, class_room_id, course_id\r\n" + 
					"    , open_course_start_date, open_course_end_date)\r\n" + 
					"     VALUES ((SELECT CONCAT('OC',\r\n" + 
					"		 LPAD(NVL(SUBSTR(MAX(open_course_id),3), 0) + 1, 4, 0)) AS newId FROM open_course)\r\n" + 
					"         , ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, oc.getClass_room_id());
			pstmt.setString(2, oc.getCourse_id());
			pstmt.setDate(3, oc.getOpen_course_start_date());
			pstmt.setDate(4, oc.getOpen_course_end_date());
			
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
	
	// 개설 과정 출력 메소드(1)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenCourse> print1(String open_course_id) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_course_id, course_name, open_course_start_date\r\n"
					+ "    , open_course_end_date, class_room_name\r\n" + "    FROM open_course_search_view1\r\n"
					+ "    WHERE UPPER(open_course_id) = UPPER(?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, open_course_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String open_course_id1 = rs.getString("open_course_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				OpenCourse oc = new OpenCourse(open_course_id1, class_room_name, course_name, open_course_start_date,
						open_course_end_date, null, null);
				list.add(oc);
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
	
	// 개설 과정 출력 메소드(2)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 개설 과목 등록 갯수 / 수강생 등록 인원
	public List<OpenCourse> print2() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_course_id, course_name, open_course_start_date\r\n" + 
					"                ,open_course_end_date, class_room_name\r\n" + 
					"                ,os_count, s_count\r\n" + 
					"                FROM open_course_infoo1\r\n" + 
					"            ORDER BY open_course_id";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_course_id = rs.getString("open_course_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				int os_count = rs.getInt("os_count");
				int s_count = rs.getInt("s_count");			
				OpenCourse oc = new OpenCourse(open_course_id, class_room_name, course_name, open_course_start_date,
						open_course_end_date, os_count, s_count);
				list.add(oc);
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
	
	// 개설 과정 출력 메소드(3)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 삭제 가능 여부
	public List<OpenCourse> print3() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT oci.open_course_id, course_name, open_course_start_date\r\n" + 
					"                ,open_course_end_date, class_room_name\r\n" + 
					"                ,os_count, s_count,(SELECT COUNT(*) FROM student_history sh\r\n" + 
					"                    WHERE sh.open_course_id=oci.open_course_id) count_\r\n" + 
					"                FROM open_course_infoo1 oci\r\n" + 
					"    ORDER BY open_course_id";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_course_id = rs.getString("open_course_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				int count_ = rs.getInt("count_");
				OpenCourse oc = new OpenCourse(open_course_id, class_room_name, course_name, open_course_start_date,
						open_course_end_date, count_);
				list.add(oc);
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
	
	// 개설 과정 출력 메소드(4)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 개설 과목명
	public List<OpenCourse> print4() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// 개설 과정 출력 메소드(5)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 수료여부 / 날짜
	public List<OpenCourse> print5(String key, String value1, String value2) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("student_id")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
						"    FROM s_course_search_detail_view2\r\n" + 
						"    WHERE student_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
			}
			
			else if (key.equals("student_name")){
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
						"    FROM s_course_search_detail_view2\r\n" + 
						"    WHERE student_id = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
			}
			
			else if (key.equals("two")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
						"    FROM s_course_search_detail_view2\r\n" + 
						"    WHERE student_id = ?\r\n" +
						"    AND open_course_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
				pstmt.setString(2, value2);
			}
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_course_id = rs.getString("open_course_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				String completion_status = rs.getString("completion");
				Date dropout_date = rs.getDate("drop_date");
				OpenCourse oc = new OpenCourse(open_course_id, class_room_name, course_name, open_course_start_date,
						open_course_end_date, completion_status, dropout_date);
				list.add(oc);
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
		/*CREATE OR REPLACE VIEW s_course_search_detail_view
		AS
		SELECT oc.open_course_id, course_name, open_course_start_date, open_course_end_date, 
			class_room_name, sh.student_id, (SELECT dropout_date 
		                                        FROM process_complete pc 
		                                        WHERE pc.open_course_id = oc.open_course_id 
		                                        AND pc.student_id = sh.student_id) drop_date
		    FROM open_course oc, course c ,class_room cr, student_history sh
		    WHERE c.course_id = oc.course_id
		    AND cr.class_room_id = oc.class_room_id
		    AND oc.open_course_id = sh.open_course_id; 
		    
		CREATE OR REPLACE VIEW s_course_search_detail_view2
		AS
		SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name,
		        CASE
		            WHEN SYSDATE < open_course_end_date AND drop_date is null THEN '수료예정'
		            WHEN drop_date IS NOT NULL THEN '중도탈락'
		            else '수료'
		        END completion, drop_date, student_id
		    FROM s_course_search_detail_view;
		    
		SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date
		    FROM s_course_search_detail_view2
		 WHERE student_id = 'ST00031'
		    AND open_course_id = 'OC0001';
*/
		return list;
	}
	
	// 개설 과정 출력 메소드(6)
	// 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenCourse> print6(String student_id) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			String sql = "SELECT course_name, open_course_start_date, open_course_end_date, class_room_name\r\n" + 
					"    FROM student_search_view1\r\n" + 
					"    WHERE UPPER(student_id) = UPPER(?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, student_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				OpenCourse oc = new OpenCourse(null, class_room_name, course_name, open_course_start_date,
						open_course_end_date, null, null);
				list.add(oc);
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
	
	// 개설 과정 출력 메소드(7)
	// 개설 과정 번호 / 과정명 / 개설과정기간
	public List<OpenCourse> print7(String student_id) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		/*	
		CREATE OR REPLACE VIEW s_course_search_view
		AS
		SELECT o.open_course_id, course_name, o.open_course_start_date, o.open_course_end_date, sh.student_id
		    FROM open_course o, course c, student_history sh
		    WHERE o.COURSE_ID = c.COURSE_ID
		    AND o.open_course_id = sh.open_course_id;
		 
		 
		SELECT open_course_id, course_name, open_course_start_date, open_course_end_date
		    FROM s_course_search_view
		    WHERE student_id = 'ST00031'
		    ORDER BY open_course_id;*/
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date\r\n" + 
					"		    FROM s_course_search_view\r\n" + 
					"		    WHERE student_id = UPPER(?)\r\n" + 
					"		    ORDER BY open_course_id";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String open_course_id = rs.getString("open_course_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
	
				OpenCourse oc = new OpenCourse(open_course_id, null, course_name, open_course_start_date, open_course_end_date, null);
				list.add(oc);
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
	
	// 개설 과정 검색 메소드
	// 1. 개설 과정 번호 2. 과정명
	public List<OpenCourse> search(String key, String value) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		if(key.equals("open_course_id")) {
			try {
				conn = OracleConnection.connect();
				String sql = "SELECT open_course_id, course_name, open_course_start_date\r\n" + 
						"    , open_course_end_date, class_room_name\r\n" + 
						"    FROM open_course_search_view1\r\n" + 
						"    WHERE UPPER(open_course_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String open_course_id = rs.getString("open_course_id");
					String course_name = rs.getString("course_name");
					Date open_course_start_date = rs.getDate("open_course_start_date");
					Date open_course_end_date = rs.getDate("open_course_end_date");
					String class_room_name = rs.getString("class_room_name");
					OpenCourse oc = new OpenCourse(open_course_id, class_room_name, course_name, open_course_start_date,
							open_course_end_date, null, null);
					list.add(oc);
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
		}
		
		if(key.equals("course_name")) {
			try {
				conn = OracleConnection.connect();
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name\r\n" + 
						"    FROM c_info_view\r\n" + 
						"    WHERE INSTR(course_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String open_course_id = rs.getString("open_course_id");
					String course_name = rs.getString("course_name");
					Date open_course_start_date = rs.getDate("open_course_start_date");
					Date open_course_end_date = rs.getDate("open_course_end_date");
					String class_room_name = rs.getString("class_room_name");
					OpenCourse oc = new OpenCourse(open_course_id, class_room_name, course_name, open_course_start_date,
							open_course_end_date, null, null);
					list.add(oc);
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
		}
		
		return list;
	}
	
	// 개설 과정 삭제 메소드
	public int remove(OpenCourse oc) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM open_course WHERE UPPER(open_course_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, oc.getOpen_course_id());
			
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
