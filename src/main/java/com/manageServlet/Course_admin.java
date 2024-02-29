package com.manageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.manageObjects.*;
import java.sql.*;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/course_admin")
public class Course_admin extends HttpServlet{
	
	public static HashMap<Integer, String> getCategories(){
		Connection con = ManageStudent.getConnection();
		HashMap<Integer, String> mp = new HashMap<Integer, String>();
		try {			
			PreparedStatement ps = con.prepareStatement("select * from CourseCategory");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mp.put(rs.getInt(1), rs.getString(2));
			}
			
			con.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return mp;
		
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		List<Course> Courses = ManageCourse.allCourses();
		HashMap<Integer, String> Category = getCategories();
		try {
			
			request.setAttribute("Category", Category);
			request.setAttribute("Courses", Courses);
			request.getRequestDispatcher("./course_admin.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
		
	}
}