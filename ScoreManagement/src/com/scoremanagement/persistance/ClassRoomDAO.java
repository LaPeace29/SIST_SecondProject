package com.scoremanagement.persistance;

import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.domain.ClassRoom;

public class ClassRoomDAO {

	// 강의실 입력 메소드
	public int insert(ClassRoom cr) {
		int result = 0;
		
		return result;
	}
	
	// 강의실 출력메소드
	// 강의실번호 / 강의실이름 / 최대정원
	public List<ClassRoom> print1() {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		
		return list;
	}
	
	// 강의실 출력메소드
	// 강의실번호 / 강의실이름 / 최대정원 / 삭제가능여부
	public List<ClassRoom> print2() {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		
		return list;
	}
	
	// 강의실 삭제 메소드
	public int remove(ClassRoom cr) {
		int result = 0;
		
		return result;
	}
}
