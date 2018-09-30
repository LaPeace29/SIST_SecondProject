package com.scoremanagement.domain;

public class ClassRoom {
	// Field
	private String class_room_id;
	private String class_room_name;
	private int max_number;
	private int count_;
	
	// Constructor
	public ClassRoom() {
	
	}

	public ClassRoom(String class_room_id, String class_room_name, int max_number) {
		this.class_room_id = class_room_id;
		this.class_room_name = class_room_name;
		this.max_number = max_number;
	}

	public ClassRoom(String class_room_id, String class_room_name, int max_number, int count_) {
		this.class_room_id = class_room_id;
		this.class_room_name = class_room_name;
		this.max_number = max_number;
		this.count_ = count_;
	}

	// Getter
	public String getClass_room_id() {
		return class_room_id;
	}

	public String getClass_room_name() {
		return class_room_name;
	}

	public int getMax_number() {
		return max_number;
	}

	public int getCount_() {
		return count_;
	}

	// Setter
	public void setClass_room_name(String class_room_name) {
		this.class_room_name = class_room_name;
	}

	public void setMax_number(int max_number) {
		this.max_number = max_number;
	}
	
	// print method
	// Return 강의실번호 / 강의실이름 / 최대정원
	public String print1() {
		String result = "";
		result = String.format("%s / %s / %d", 
				this.getClass_room_id(), this.getClass_room_name(), this.getMax_number());
		return result;
	}
	
	// Return 강의실번호 / 강의실이름 / 최대정원 / 삭제 가능여부
	public String print2() {
		String result = "";
		result = String.format("%s / %s / %d / %s", 
				this.getClass_room_id(), this.getClass_room_name(), this.getMax_number(),
				(getCount_() > 0 ? 'X' : 'O'));
		return result;
	}
}
