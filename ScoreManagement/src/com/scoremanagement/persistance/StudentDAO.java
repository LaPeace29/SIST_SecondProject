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

	String student_id = null;
	
	// 수강생 로그인 메소드
	public String login(Student s) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
	
	// 수강생 추가 메소드
	public int insert(Student s) {
		int result = 0;
		
		return result;
	}
	
	// 수강생 출력 메소드(1)
	// 수강생 이름 / 수강생 휴대폰번호
	public List<Student> print1(String student_id) {
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT student_name, student_phone\r\n" + 
					"    FROM student\r\n" + 
					"    WHERE UPPER(student_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				
				Student s = new Student(null, student_name, student_phone, null);
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
	
	// 수강생 출력 메소드(2)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 수강생 등록일
	public List<Student> print2(String key, String value) {
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("student_id")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate\r\n" + 
						"    FROM student\r\n" + 
						"    WHERE student_id = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, student_id);
			}
			
			else if(key.equals("student_name")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate\r\n" + 
						"    FROM student\r\n" + 
						"    WHERE INSTR(student_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id1 = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				Student s = new Student(student_id1, student_name, student_phone, student_regDate);
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
	
	// 수강생 출력 메소드(3)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 수강생 등록일 / 수강 횟수
	public List<Student> print3(String key, String value) {
		List<Student> list = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("all")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, count_\r\n" + 
						"    FROM student_info_view1\r\n" + 
						"        ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
			}
			
			else if(key.equals("student_id")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, count_\r\n" + 
						"    FROM student_info_view1\r\n" + 
						"    WHERE UPPER(student_id) = UPPER(?)\r\n" + 
						"        ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id1 = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				int count_ = rs.getInt("count_");
				
				Student s = new Student(student_id1, student_name, student_phone, student_regDate, count_);
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
	
	// 수강생 출력 메소드(4)
	// 수강생 번호 / 수강생 이름 / 수강생 휴대폰번호 / 수강생 등록일 / 수료여부 / 날짜
	public List<Student> print4(String key, String value1, String value2) {
		List<Student> list = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("open_course_id")) {
				
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, completion, completion_date\r\n" + 
						"    FROM student_infoo3\r\n" + 
						"    WHERE UPPER(open_course_id) = UPPER(?)\r\n" + 
						"    ORDER BY student_id";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
			}
			
			else if(key.equals("course_name")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regdate, completion, completion_date\r\n" + 
						"    FROM student_infoo3\r\n" + 
						"    WHERE INSTR(course_name, ?) > 0\r\n" + 
						"    ORDER BY student_id;";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value1);
			}
			
			else if(key.equals("open_subject_id")) {
				String sql = "SELECT student_id, student_name, student_phone, student_regDate, completion, completion_date\r\n" + 
						"    FROM student_info_view3\r\n" + 
						"    WHERE open_subject_id = ?\r\n" + 
						"    AND instructor_id = ?";
				
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
	// 수강생 검색 메소드
	// 1. 수강생 번호  2. 수강생 이름
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
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");
				
				Student s = new Student(student_id, student_name, student_phone, student_regDate);
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
	
	// 수강생 검색 메소드2
	public List<Student> search2(String key, String value1, String value2) {
		List<Student> list = new ArrayList<Student>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = OracleConnection.connect();

			String sql = "SELECT student_id, student_name, student_phone, student_regDate\r\n" + "    FROM student\r\n"
					+ "    WHERE UPPER(student_name) = UPPER(?)\r\n" + "AND student_phone = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value1);
			pstmt.setString(2, value2);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_phone = rs.getString("student_phone");
				Date student_regDate = rs.getDate("student_regDate");

				Student s = new Student(student_id, student_name, student_phone, student_regDate);
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
	
	// 수강생 삭제 메소드
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
	
	// 수강생 비밀번호 수정 메소드
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
	
	// 수강생 비밀번호 초기화 메소드
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
	
	// 수강생 히스토리 추가 메소드
	public int studentHistoryAdd(StudentHistory sh) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = OracleConnection.connect();

			String sql = "INSERT INTO student_history (open_course_id, student_id)\r\n"
					+ "    VALUES (upper(?), upper(?))";

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
		
	// 수강생 히스토리 삭제 메소드
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
	
	// 수강생 중도 탈락 추가 메소드
	public int processCompleteAdd(StudentHistory sh) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = OracleConnection.connect();

			String sql = "INSERT INTO Student_History (open_course_id, student_id, dropout_date)\r\n"
					+ "    VALUES (?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sh.getStudent_id());
			pstmt.setString(2, sh.getOpen_course_id());
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
