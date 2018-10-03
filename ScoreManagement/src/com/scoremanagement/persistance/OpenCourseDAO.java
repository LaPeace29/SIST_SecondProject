package com.scoremanagement.persistance;

import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.domain.OpenCourse;

public class OpenCourseDAO {

	// 개설 과정 추가 메소드
	public int insert(OpenCourse oc) {
		int result = 0;
		
		return result;
	}
	
	// 개설 과정 출력 메소드(1)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명
	public List<OpenCourse> print1() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// 개설 과정 출력 메소드(2)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 개설 과목 등록 갯수 / 수강생 등록 인원
	public List<OpenCourse> print2() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// 개설 과정 출력 메소드(3)
	// 개설 과정 번호 / 과정명 / 개설 과정 기간 / 강의실명 / 삭제 가능 여부
	public List<OpenCourse> print3() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
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
	public List<OpenCourse> print6() {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// 개설 과정 출력 메소드(7)
	// 개설 과정 번호 / 과정명 / 개설과정기간
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
	
	// 개설 과정 검색 메소드
	// 1. 개설 과정 번호 2. 과정명
	public List<OpenCourse> search(String key, String value) {
		List<OpenCourse> list = new ArrayList<OpenCourse>();
		
		return list;
	}
	
	// 개설 과정 삭제 메소드
	public int remove(OpenCourse oc) {
		int result = 0;
		
		return result;
	}
}
