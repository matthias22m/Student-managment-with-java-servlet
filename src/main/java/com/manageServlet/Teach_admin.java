package com.manageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.manageObjects.*;
import java.sql.*;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/teach_admin")
public class Teach_admin extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> Teachers = ManageTeacher.allTeachers();
		
		try {
			request.setAttribute("Teachers", Teachers);
			request.getRequestDispatcher("./Teach_admin.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
		
	}
}
