package com.manageServlet;

import java.io.IOException;
import java.util.List;

import com.manageObjects.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/createClass")
public class ClassCreationPage extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Teacher> Teachers = ManageTeacher.allTeachers();
		List<Course> Courses = ManageCourse.allCourses();
		
		request.setAttribute("teachers", Teachers);
		request.setAttribute("courses", Courses);
		request.getRequestDispatcher("./Create_class.jsp").forward(request, response);
	
	}

}