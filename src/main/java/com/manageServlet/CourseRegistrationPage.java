package com.manageServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.manageObjects.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/registerCourse")
public class CourseRegistrationPage extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HashMap<Integer, String> Category = Course_admin.getCategories();
		List<Course> Courses = ManageCourse.allCourses();
		
		request.setAttribute("Category", Category);
		request.getRequestDispatcher("./Register_course.jsp").forward(request, response);
	
	}

}