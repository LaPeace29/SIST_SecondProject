package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.Course;

public class CourseDAO {
	
	// ���� �Է� �޼ҵ�
	public int insert(Course c) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "INSERT INTO course (course_id, course_name) \r\n" + 
					"    VALUES ((SELECT CONCAT('CS',\r\n" + 
					"		 LPAD(NVL(SUBSTR(MAX(course_id), 3), 0) + 1, 4, 0)) AS newId FROM course)\r\n" + 
					"         , ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCourse_name());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	// ���� ��� �޼ҵ�
	// ������ȣ / �����̸�
	public List<Course> print1() {
		List<Course> list = new ArrayList<Course>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT course_id, course_name\r\n" + 
					"    FROM course\r\n" + 
					"ORDER BY course_id";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");
				
				Course c = new Course(course_id, course_name);
				list.add(c);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	// ���� ��� �޼ҵ�
	// ������ȣ / �����̸� / �������ɿ���
	public List<Course> print2() {
		List<Course> list = new ArrayList<Course>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT course_id, course_name\r\n" + 
					"        ,(SELECT COUNT(*) FROM open_course\r\n" + 
					"            WHERE course_id=c.course_id) count_\r\n" + 
					"            FROM course c\r\n" + 
					"            ORDER BY course_id";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");
				int count_ = rs.getInt("count_");
				
				Course c = new Course(course_id, course_name, count_);
				list.add(c);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	// ���� �˻� �޼ҵ�
	public List<Course> search(String key, String value) {
		List<Course> list = new ArrayList<Course>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();

			if(key.equals("course_id")) {
				String sql = "SELECT course_id, course_name \r\n" + 
						"	FROM course\r\n" + 
						"    WHERE course_id = UPPER(?)\r\n" + 
						"	ORDER BY course_id";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, value);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String course_id = rs.getString("course_id");
					String course_name = rs.getString("course_name");
					
					Course c = new Course(course_id, course_name);
					list.add(c);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// ���� ���� �޼ҵ�
	public int remove(Course c) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM course WHERE UPPER(course_id)=UPPER(?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getCourse_id());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
