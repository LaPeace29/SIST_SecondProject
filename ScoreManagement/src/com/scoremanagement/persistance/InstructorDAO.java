package com.scoremanagement.persistance;

import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.domain.Instructor;

public class InstructorDAO {

	// 강사 로그인 메소드
	public int login(Instructor i) {
		int result = 0;
		
		return result;
	}
	
	// 강사 추가 메소드
	public int insert(Instructor i) {
		int result = 0;
		
		return result;
	}
	
	// 강사 출력 메소드(1)
	// 강사이름 / 강사휴대폰번호
	public List<Instructor> print1() {
		List<Instructor> list = new ArrayList<Instructor>();
		
		return list;
	}
	
	// 강사 출력 메소드(2)
	// 강사번호 / 강사이름 / 강사휴대폰번호 / 등록일
	public List<Instructor> print2() {
		List<Instructor> list = new ArrayList<Instructor>();
		
		return list;
	}
	
	// 강사 출력 메소드(3)
	// 강사번호 / 강사이름 / 강사휴대폰번호 / 등록일 / 강의가능과목
	public List<Instructor> print3() {
		List<Instructor> list = new ArrayList<Instructor>();
		
		return list;
	}
	
	// 강사 출력 메소드(4)
	// 강사번호 / 강사이름 / 강사휴대폰번호 / 등록일 / 삭제가능여부
	public List<Instructor> print4() {
		List<Instructor> list = new ArrayList<Instructor>();
		
		return list;
	}
	
	// 강사 검색 메소드
	// 강사번호 or 강사이름
	public List<Instructor> search(String key, String value) {
		List<Instructor> list = new ArrayList<Instructor>();
		
		return list;
	}
	
	// 강사 삭제 메소드
	public int remove(Instructor i) {
		int result = 0;
		
		return result;
	}
	
	// 강사 비밀번호 변경 메소드
	public int modify(Instructor i) {
		int result = 0;
		
		return result;
	}
	
	// 강사 비밀번호 초기화 메소드
	public int reset(Instructor i) {
		int result = 0;
		
		return result;
	}
}
