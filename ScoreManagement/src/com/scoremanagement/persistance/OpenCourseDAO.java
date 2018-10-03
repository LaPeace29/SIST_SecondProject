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
		
		return result;
	}
	
	// ���� ���� ��� �޼ҵ�(1)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ�
	public List<OpenCourse> print1() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(2)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ��� ���� / ������ ��� �ο�
	public List<OpenCourse> print2() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(3)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� ���� ����
	public List<OpenCourse> print3() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(4)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���� �����
	public List<OpenCourse> print4() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(5)
	// ���� ���� ��ȣ / ������ / ���� ���� �Ⱓ / ���ǽǸ� / ���Ῡ�� / ��¥
	public List<OpenCourse> print5(String student_id) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date\r\n" + 
					"    FROM s_course_search_detail_view2\r\n" + 
					"    WHERE student_id = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student_id);
			
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
		            WHEN SYSDATE < open_course_end_date AND drop_date is null THEN '���Ό��'
		            WHEN drop_date IS NOT NULL THEN '�ߵ�Ż��'
		            else '����'
		        END completion, drop_date, student_id
		    FROM s_course_search_detail_view;
		    
		SELECT open_course_id, course_name, open_course_start_date, open_course_end_date, class_room_name, completion, drop_date
		    FROM s_course_search_detail_view2
		 WHERE student_id = 'ST00031'
		    AND open_course_id = 'OC0001';
*/
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(6)
	// ������ / ���� ���� �Ⱓ / ���ǽǸ�
	public List<OpenCourse> print6() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// ���� ���� ��� �޼ҵ�(7)
	// ���� ���� ��ȣ / ������ / ���������Ⱓ
	public List<OpenCourse> print7() {
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
		return list;
	}
	
	// ���� ���� �˻� �޼ҵ�
	// 1. ���� ���� ��ȣ 2. ������
	public List<OpenCourse> search(String key, String value) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// ���� ���� ���� �޼ҵ�
	public int remove(OpenCourse oc) {
		int result = 0;
		
		return result;
	}
}
