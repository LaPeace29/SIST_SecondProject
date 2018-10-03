package com.scoremanagement.persistance;

import java.util.ArrayList;
import java.util.List;

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
	public List<OpenCourse> print5() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
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
