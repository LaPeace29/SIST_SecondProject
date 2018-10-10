package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.Student;
import com.scoremanagement.domain.StudentHistory;

public class StudentDAO {
	
	// ������ �α��� �޼ҵ�
	public String login(Student s) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String student_id = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT student_id\r\n" + 
							"    FROM student\r\n" + 
							"    WHERE student_name = ? AND student_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_name());
			pstmt.setString(2, s.getStudent_pw());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				student_id = rs.getString("student_id");
			}
			
			rs.close();
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
		return student_id;
	}
	
	// ������ �߰� �޼ҵ�
	public int insert(Student s) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();

			String sql = "INSERT INTO student (student_id, student_name, student_phone, student_regdate, student_pw)   \r\n"
					+ "    VALUES ((SELECT CONCAT('ST',\r\n"
					+ "         LPAD(NVL(SUBSTR(MAX(student_id),3), 0) + 1, 5, 0)) AS newId FROM student)\r\n"
					+ "         , ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_name());
			pstmt.setString(2, s.getStudent_phone());
			pstmt.setDate(3, s.getStudent_regDate());
			pstmt.setString(4, s.getStudent_pw());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
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
	
	// ������ ��� ����Ʈ �޼ҵ�(1)
	// ������ ��ȣ / ������ �̸� / ������ �޴�����ȣ / ������ ����� / ���� Ƚ��
	public List<Student> list1(String key, String value) {
		// student_list1_VW
		/*
		CREATE OR REPLACE VIEW student_list1_VW
		AS
		SELECT student_id, student_name, student_phone, student_regdate,
		        (SELECT COUNT(*) 
		            FROM student_history
		            WHERE student_id = s.student_id) count_
		    FROM student s;
		*/
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("all")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, count_\r\n" + 
						"    FROM student_list1_VW\r\n" + 
						"        ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
			}
			
			else if(key.equals("student_id")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, count_\r\n" + 
						"    FROM student_list1_VW\r\n" + 
						"    WHERE UPPER(student_id) = UPPER(?)\r\n" + 
						"        ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				int count_ = rs.getInt("count_");
				
				Student s = new Student(student_id, student_name, student_phone, student_regDate, count_);
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

	// ������ ��� ����Ʈ �޼ҵ�(2)
	// ������ ��ȣ / ������ �̸� / ������ �޴�����ȣ / ������ ����� / ���Ῡ�� / ��¥
	public List<Student> list2(String key, String value1, String value2) {
		// student_list2_VW1
		/*
		CREATE OR REPLACE VIEW student_list2_VW1
		AS
		SELECT oc.class_room_id, oc.open_course_id, oc.course_id, oc.open_course_start_date,
			   oc.open_course_end_date, s.student_id, s.student_name, s.student_phone, s.student_regdate,
		       c.course_name, os.instructor_id, os.open_subject_id
		    FROM open_course oc, student_history sh, student s, course c, open_subject os
		    WHERE oc.open_course_id = sh.open_course_id
		        AND s.student_id = sh.student_id
		        AND c.course_id = oc.course_id
		        AND oc.open_course_id = os.open_course_id;
		*/
		
		// student_list2_VW2
		/*
		CREATE OR REPLACE VIEW student_list2_VW2
		AS
		SELECT v1.class_room_id, v1.course_id, v1.open_course_end_date, v1.open_course_id,
		        v1.open_course_start_date, v1.student_id, v1.student_name, v1.student_phone, 
		        v1.student_regdate, v1.instructor_id, v1.open_subject_id, pc.dropout_date, course_name
		    FROM student_list2_VW1 v1, process_complete pc
		    WHERE v1.open_course_id = pc.open_course_id(+)
		        AND v1.student_id = pc.student_id(+);
		*/
		
		// student_list2_VW3
		/*
		CREATE OR REPLACE VIEW student_list2_VW3
		AS
		SELECT student_id, student_name, student_phone, student_regdate, 
		        CASE WHEN SYSDATE < open_course_start_date AND dropout_date is null THEN '���Ό��'
		            WHEN SYSDATE > open_course_end_date AND dropout_date is null THEN '����Ϸ�'
		            WHEN dropout_date IS NOT NULL THEN '�ߵ�Ż��'
		        else '������' END completion, 
		        NVL2(dropout_date, dropout_date,open_course_end_date) completion_date, open_course_id, 
		        course_name, instructor_id, open_subject_id
		    FROM student_list2_VW2;
		*/
		List<Student> list = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_course_id")) {
				
				String sql = "SELECT student_id, student_name, student_phone, student_regdate, completion, completion_date\r\n" + 
						"    FROM student_list2_VW3\r\n" + 
						"    WHERE UPPER(open_course_id) = UPPER(?)\r\n" + 
						"    AND UPPER(open_subject_id) = UPPER(?)\r\n" + 
						"    ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
				pstmt.setString(2, value2);
			}
			
			else if(key.equals("course_name")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regdate, completion, completion_date\r\n" + 
						"    FROM student_list2_VW3\r\n" + 
						"    WHERE INSTR(course_name, ?) > 0\r\n" + 
						"    AND UPPER(open_subject_id) = UPPER(?)\r\n" + 
						"    ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
				pstmt.setString(2, value2);
			}
			
			else if(key.equals("open_subject_id")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, completion, completion_date\r\n" + 
						"    FROM student_list2_VW3\r\n" + 
						"    WHERE UPPER(open_subject_id) = UPPER(?)\r\n" + 
						"    AND UPPER(instructor_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
				pstmt.setString(2, value2);
			}
			
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
	// 1. ������ ��ȣ  2. ������ �̸�  3. ������ �̸� & �޴��� ��ȣ(���� ��� ���� Ȯ�ο�)
	public List<Student> search(String key, Student value) {
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("student_id")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate\r\n" + 
						"    FROM student\r\n" + 
						"    WHERE UPPER(student_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_id());
			}
			
			else if(key.equals("student_name")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate\r\n" + 
						"    FROM student\r\n" + 
						"    WHERE INSTR(student_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_name());
			}
			
			else if(key.equals("student_idANDstudent_phone")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate\r\n" + 
						"    FROM student\r\n" + 
						"    WHERE student_name = ?\r\n" + 
						"    AND student_phone = ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value.getStudent_name());
				pstmt.setString(2, value.getStudent_phone());
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				
				Student s = new Student(student_id, student_name, student_phone, student_regDate, null);
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
	
	// ������ ���� �޼ҵ�
	public int remove(Student s) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM student WHERE UPPER(student_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_id());
			
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
	
	// ������ ��й�ȣ ���� �޼ҵ�
	public int modify(Student s) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "UPDATE student\r\n" + 
					"    SET student_pw = ?\r\n" + 
					"    WHERE student_name = ? AND student_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_new_pw());
			pstmt.setString(2, s.getStudent_name());
			pstmt.setString(3, s.getStudent_pw());
			
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
	
	// ������ ��й�ȣ �ʱ�ȭ �޼ҵ�
	public int reset(Student s) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "UPDATE student\r\n" + 
					"    SET student_pw = ?\r\n" + 
					"    WHERE UPPER(student_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getStudent_pw());
			pstmt.setString(2, s.getStudent_id());
			
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
	
	// ������ �����丮 �߰� �޼ҵ�
	public int studentHistoryAdd(StudentHistory sh) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = OracleConnection.connect();

			String sql = "INSERT INTO student_history (open_course_id, student_id)\r\n"
					+ "    VALUES (UPPER(?), UPPER(?))";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sh.getOpen_course_id());
			pstmt.setString(2, sh.getStudent_id());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
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
		
	// ������ �����丮 ���� �޼ҵ�
	public int studentHistoryRemove(StudentHistory sh) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = OracleConnection.connect();

			String sql = "DELETE FROM student_history \r\n"
					+ "    WHERE UPPER(student_id)=UPPER(?) AND UPPER(open_course_id)=UPPER(?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sh.getStudent_id());
			pstmt.setString(2, sh.getOpen_course_id());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
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
	
	// ������ �ߵ� Ż�� �߰� �޼ҵ�
	public int processCompleteAdd(StudentHistory sh) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = OracleConnection.connect();

			String sql = "INSERT INTO Process_complete (open_course_id, student_id, dropout_date)\r\n"
					+ "    VALUES (UPPER(?), UPPER(?), ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sh.getOpen_course_id());
			pstmt.setString(2, sh.getStudent_id());
			pstmt.setDate(3, sh.getDropout_date());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
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
