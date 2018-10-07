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

	// ���� ���� �߰� �޼ҵ�
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
	
	/*
	CREATE OR REPLACE VIEW open_course_print1_view
	AS
	SELECT oc.open_course_id, c.course_name, oc.open_course_start_date, st.student_id
    , oc.open_course_end_date, cr.class_room_name
    FROM open_course oc, course c, class_room cr, student_history sh, student st
    WHERE oc.course_id = c.course_id
    AND oc.class_room_id = cr.class_room_id
    AND oc.open_course_id = sh.open_course_id
    AND sh.student_id = st.student_id;
	 */
	// ���� ���� ��� �޼ҵ�(1)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ�
	public List<OpenCourse> print1(String key, OpenCourse value) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_course_id")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date\r\n" + 
						"    , open_course_end_date, class_room_name\r\n" + 
						"    FROM open_course_print1_view\r\n"	+ 
						"    WHERE UPPER(open_course_id) = UPPER(?)";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, value.getOpen_course_id());
			}
			
			else if(key.equals("student_id")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name\r\n" + 
						"    FROM open_course_print1_view\r\n" + 
						"    WHERE UPPER(student_id) = UPPER(?)\r\n" + 
						"    ORDER BY open_course_id";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, value.getStudent_id());
			}
			
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
	/*
	CREATE OR REPLACE VIEW open_course_print2_view
	AS
    SELECT open_course_id, course_name, open_course_start_date
                ,open_course_end_date, class_room_name
                    ,(SELECT COUNT(*) FROM open_subject
            WHERE open_course_id=oc.open_course_id) os_count
            ,(SELECT COUNT(*) FROM student_history
            WHERE open_course_id=oc.open_course_id) s_count
            
            FROM open_course oc, course c, class_room cr
            WHERE oc.course_id = c.course_id
            AND oc.class_room_id=cr.class_room_id;
	 */
	// ���� ���� ��� �޼ҵ�(2)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�
	public List<OpenCourse> print2() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_course_id, course_name, open_course_start_date\r\n" + 
					"            ,open_course_end_date, class_room_name\r\n" + 
					"            ,os_count, s_count\r\n" + 
					"            FROM open_course_print2_view\r\n" + 
					"        ORDER BY open_course_id";
			
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
	
	// ���� ���� ��� �޼ҵ�(3)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ����
	public List<OpenCourse> print3() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT v1.open_course_id, course_name, open_course_start_date\r\n" + 
					"                ,open_course_end_date, class_room_name\r\n" + 
					"                ,os_count, s_count,(SELECT COUNT(*) FROM student_history sh\r\n" + 
					"                    WHERE sh.open_course_id=v1.open_course_id) count_\r\n" + 
					"                FROM open_course_print2_view v1\r\n" + 
					"    ORDER BY open_course_id;";
			
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
	
	/*
		CREATE OR REPLACE VIEW open_course_print4_view1
	AS    
	SELECT cr.class_room_id, cr.class_room_name, cr.max_number, oc.open_course_id,
	oc.open_course_start_date, oc.open_course_end_date, c.course_id, c.course_name
    FROM open_course oc, course c, class_room cr
    WHERE cr.class_room_id = oc.class_room_id
    AND c.course_id = oc.course_id
    AND sysdate < open_course_start_date;    
    
	CREATE OR REPLACE VIEW open_course_print4_view2
	AS    
	SELECT 
	v1.open_course_id, v1.class_room_name, v1.course_name, v1.open_course_start_date, v1.open_course_end_date,
	
	(SELECT (LISTAGG(s.subject_name, ', ') WITHIN GROUP(ORDER BY s.subject_id))
	    FROM open_subject t, subject s
	   WHERE s.subject_id = t.subject_id 
	   AND v1.open_course_id= t.open_course_id
	 ) subjectlist
    FROM open_course_print4_view1 v1;
	 */
	// ���� ���� ��� �޼ҵ�(4)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� �����
	public List<OpenCourse> print4() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT open_course_id, course_name,\r\n" + 
					"open_course_start_date, open_course_end_date, class_room_name,\r\n" + 
					"subjectlist\r\n" + 
					"    FROM open_course_print4_view2\r\n" + 
					"    ORDER BY open_course_id";
			
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String open_course_id = rs.getString("open_course_id");
				String course_name = rs.getString("course_name");
				Date open_course_start_date = rs.getDate("open_course_start_date");
				Date open_course_end_date = rs.getDate("open_course_end_date");
				String class_room_name = rs.getString("class_room_name");
				String subjectlist = rs.getString("subjectlist");

				OpenCourse oc = new OpenCourse(open_course_id, class_room_name, course_name, open_course_start_date,
						open_course_end_date, subjectlist);
				list.add(oc);
			}
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
		
		return list;
	}
	
	/*
	CREATE OR REPLACE VIEW open_course_print5_view
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
    
	CREATE OR REPLACE VIEW open_course_print5_view2
	AS
	SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name,
        CASE
            WHEN SYSDATE < open_course_end_date AND drop_date is null THEN '���Ό��'
            WHEN drop_date IS NOT NULL THEN '�ߵ�Ż��'
            else '����'
        END completion, drop_date, student_id
    FROM open_course_print5_view;
	 */
	// ���� ���� ��� �޼ҵ�(5)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���Ῡ�� / ��¥
	public List<OpenCourse> print5(String key, OpenCourse value) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("student_id")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
						"    FROM open_course_print5_view2\r\n" + 
						"    WHERE student_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_id());
			}
			
			else if (key.equals("student_name")){
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
						"    FROM open_course_print5_view2\r\n" + 
						"    WHERE INSTR(student_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_name());
			}
			
			else if (key.equals("open_course_idANDstudent_id")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
						"    FROM open_course_print5_view2\r\n" + 
						"    WHERE student_id = UPPER(?)\r\n" +
						"    AND open_course_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_id());
				pstmt.setString(2, value.getOpen_course_id());
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
		
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(6)
	// ������ / ���� ���� �Ⱓ / ���ǽǸ�
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
	
	// ���� ���� ��� �޼ҵ�(7)
	// ���� ���� ��ȣ / ������ / ���������Ⱓ
	public List<OpenCourse> print7(String student_id) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();

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
	
	/*
	CREATE OR REPLACE VIEW open_course_search_view1
	AS
	SELECT oc.open_course_id, c.course_name, oc.open_course_start_date
    , oc.open_course_end_date, cr.class_room_name
    FROM open_course oc, course c, class_room cr
    WHERE oc.course_id = c.course_id
    AND oc.class_room_id = cr.class_room_id;
	 */
	// ���� ���� �˻� �޼ҵ�
	// 1. ���� ���� ��ȣ 2. ������
	public List<OpenCourse> search(String key, OpenCourse value) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_course_id")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date\r\n" + 
						"    , open_course_end_date, class_room_name\r\n" + 
						"    FROM open_course_search_view1\r\n" + 
						"    WHERE UPPER(open_course_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getOpen_course_id());
			}
			
			else if(key.equals("course_name")) {
				String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name\r\n" + 
						"    FROM open_course_search_view1\r\n" + 
						"    WHERE INSTR(course_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getCourse_name());
			}
			
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

		return list;
	}
	
	// ���� ���� ���� �޼ҵ�
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
