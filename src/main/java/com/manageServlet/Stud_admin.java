package com.manageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.manageObjects.*;
import java.sql.*;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/stud_admin")
public class Stud_admin extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		List<Student> Students = ManageStudent.allStudents();
		
		try {
			request.setAttribute("students", Students);
			request.getRequestDispatcher("./student_admin.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
		
	}
}
