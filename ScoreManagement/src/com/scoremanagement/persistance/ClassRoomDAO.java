package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.ClassRoom;

public class ClassRoomDAO {

	// ���ǽ� �Է� �޼ҵ�
	public int insert(ClassRoom cr) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "INSERT INTO class_room (class_room_id, class_room_name, max_number)   \r\n" + 
					"    VALUES ((SELECT CONCAT('CR',\r\n" + 
					"		 LPAD(NVL(SUBSTR(MAX(class_room_id), 3), 0) + 1, 2, 0)) AS newId FROM class_room)\r\n" + 
					"         , ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cr.getClass_room_name());
			pstmt.setInt(2, cr.getMax_number());
			
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
	
	// ���ǽ� ��� ����Ʈ �޼ҵ�(1)
	// ���ǽǹ�ȣ / ���ǽ��̸� / �ִ�����
	public List<ClassRoom> list1() {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT class_room_id, class_room_name, max_number\r\n" + 
					"    FROM class_room\r\n" + 
					"    ORDER BY class_room_id";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String class_room_id = rs.getString("class_room_id");
				String class_room_name = rs.getString("class_room_name");
				int max_number = rs.getInt("max_number");
				
				ClassRoom cr = new ClassRoom(class_room_id, class_room_name, max_number);
				list.add(cr);
			}
			
			rs.close();
			
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
	
	// ���ǽ� ��� ����Ʈ �޼ҵ�(2)
	// ���ǽǹ�ȣ / ���ǽ��̸� / �ִ����� / �������ɿ���
	public List<ClassRoom> list2() {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT class_room_id, class_room_name, max_number\r\n" + 
					"        ,(SELECT COUNT(*) FROM open_course\r\n" + 
					"            WHERE class_room_id=c.class_room_id) count_\r\n" + 
					"            FROM class_room c\r\n" + 
					"            ORDER BY class_room_id";
			
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String class_room_id = rs.getString("class_room_id");
				String class_room_name = rs.getString("class_room_name");
				int max_number = rs.getInt("max_number");
				int count_ = rs.getInt("count_");
				
				ClassRoom cr = new ClassRoom(class_room_id, class_room_name, max_number, count_);
				list.add(cr);
			}
			
			rs.close();
			
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
	
	// ���ǽ� �˻� �޼ҵ�
	// 1. ���ǽ� ��ȣ
	public List<ClassRoom> search(String key, String value) {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();

			if(key.equals("class_room_id")) {
				String sql = "SELECT class_room_id, class_room_name, max_number\r\n" + 
						"	FROM class_room\r\n" + 
						"    WHERE class_room_id = UPPER(?)\r\n" + 
						"	ORDER BY class_room_id";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, value);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String class_room_id = rs.getString("class_room_id");
					String class_room_name = rs.getString("class_room_name");
					int max_number = rs.getInt("max_number");
					
					ClassRoom cr = new ClassRoom(class_room_id, class_room_name, max_number);
					list.add(cr);
				}
				
				rs.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
		
	// ���ǽ� ���� �޼ҵ�
	public int remove(ClassRoom cr) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM class_room WHERE UPPER(class_room_id)=UPPER(?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cr.getClass_room_id());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
