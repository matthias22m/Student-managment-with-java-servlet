package com.manageObjects;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManageCourse {	
	public static int saveCourse(Course course) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Course (course_id, course_name, course_category, credit_hour, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getCourseCategory());
			ps.setInt(4, course.getCreditHour());
			ps.setString(5, course.getStartDate());
			ps.setString(6, course.getEndDate());
			
			status = ps.executeUpdate();
			
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int updateCourse(Course course) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("update Course set course_name = ?, course_category = ?, credit_hour = ? , start_date = ?, end_date = ? where course_id = ?");
			
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getCourseCategory());
			ps.setInt(3, course.getCreditHour());
			ps.setString(4, course.getStartDate());
			ps.setString(5, course.getEndDate());
			ps.setString(6, course.getCourseId());
			
			status = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static int deleteCourse(String course_id) {
		int status = 0;
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("delete from Course where course_id = ?");
			
			ps.setString(1, course_id);
			
			status = ps.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
		
	}
	
	public static List<Course> allCourses(){
		List<Course> courses = new ArrayList<Course>();
		
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Course");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Course course = new Course();
				
				course.setCourseId(rs.getString(1));
				course.setCourseName(rs.getString(2));
				course.setCourseCategory(rs.getInt(3));
				course.setCreditHour(rs.getInt(4));
				course.setStartDate(rs.getString(5));
				course.setEndDate(rs.getString(6));
				
				courses.add(course);
			}
			
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courses;
	}
	
	public static Course courseWithId(String course_id){
		Course course = new Course();
		Connection con = ManageStudent.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Course where course_id = ?");
			ps.setString(1,course_id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				course.setCourseId(rs.getString(1));
				course.setCourseName(rs.getString(2));
				course.setCourseCategory(rs.getInt(3));
				course.setCreditHour(rs.getInt(4));
				course.setStartDate(rs.getString(5));
				course.setEndDate(rs.getString(6));
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

}
