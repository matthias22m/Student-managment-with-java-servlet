package com.manageObjects;

public class Course {
	private String course_id;
	private String course_name;
	private int course_category;
	private int credit_hour;
	private String start_date;
	private String end_date;

	public String getCourseId() {
		return course_id;
	}

	public void setCourseId(String course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return course_name;
	}

	public void setCourseName(String course_name) {
		this.course_name = course_name;
	}

	public int getCourseCategory() {
		return course_category;
	}

	public void setCourseCategory(int course_category) {
		this.course_category = course_category;
	}

	public int getCreditHour() {
		return credit_hour;
	}

	public void setCreditHour(int credit_hour) {
		this.credit_hour = credit_hour;
	}

	public String getStartDate() {
		return start_date;
	}

	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public String getEndDate() {
		return end_date;
	}

	public void setEndDate(String end_date) {
		this.end_date = end_date;
	}
}
