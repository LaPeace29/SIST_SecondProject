package com.scoremanagement.persistance;

import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.domain.Subjectbook;

public class SubjectbookDAO {
	
	// 교재 입력 메소드
	public int insert(Subjectbook sb) {
		int result = 0;
		
		return result;
	}
	
	// 교재 출력 메소드
	// 교재번호 / 교재명 / 교재출판사
	public List<Subjectbook> print1() {
		List<Subjectbook> list = new ArrayList<Subjectbook>();
		
		return list;				
	}
	
	// 교재 출력 메소드
	// 교재번호 / 교재명 / 교재출판사 / 삭제가능여부
	public List<Subjectbook> print2() {
		List<Subjectbook> list = new ArrayList<Subjectbook>();
		
		return list;				
	}
	
	// 교제 삭제 메소드
	public int remove(Subjectbook sb) {
		int result = 0;
		
		return result;
	}
}
