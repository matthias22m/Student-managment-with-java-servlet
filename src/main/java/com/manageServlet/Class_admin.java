package com.manageServlet;

import java.io.IOException;
import com.manageObjects.*;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/class_admin")
public class Class_admin extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		List<Class_room> Class_rooms = ManageClass.allClasses();
		
		try {
			request.setAttribute("Class_rooms", Class_rooms);
			request.getRequestDispatcher("./Class_admin.jsp").forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}	
		
	}
}
