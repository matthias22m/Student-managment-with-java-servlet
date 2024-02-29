package com.manageObjects;

public class Class_room {
	private String class_id;
	private String class_name;
	private String teacher_id;
	private String course_id;
	private String class_room;
	private int room_limit;
	private int registered_student;
	public String getClassId() {
		return class_id;
	}
	public void setClassId(String class_id) {
		this.class_id = class_id;
	}
	public String getClassName() {
		return class_name;
	}
	public void setClassName(String class_name) {
		this.class_name = class_name;
	}
	public String getTeacherId() {
		return teacher_id;
	}
	public void setTeacherId(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getCourseId() {
		return course_id;
	}
	public void setCourseId(String course_id) {
		this.course_id = course_id;
	}
	public int getRoomLimit() {
		return room_limit;
	}
	public void setRoomLimit(int room_limit) {
		this.room_limit = room_limit;
	}
	public int getRegisteredStudent() {
		return registered_student;
	}
	public void setRegisteredStudent(int registered_student) {
		this.registered_student = registered_student;
	}
	public String getClassRoom() {
		return class_room;
	}
	public void setClassRoom(String class_room) {
		this.class_room = class_room;
	}
	
}
