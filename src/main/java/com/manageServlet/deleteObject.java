package com.manageServlet;

import java.io.IOException;

import com.manageObjects.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deleteObject")
public class deleteObject extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print((request.getParameterNames().nextElement().equals("class_id")));
		if(request.getParameterNames().nextElement().equals("stud_id")){
			int stat = ManageStudent.deleteStudent((String)request.getParameter("stud_id"));
			response.setHeader("cache-control","no-cache,no-store,must-revalidate");
			if(stat > 0) request.getRequestDispatcher("./stud_admin").forward(request, response);
			
		}else if(request.getParameterNames().nextElement().equals("teacher_id")){
			int stat = ManageTeacher.deleteTeacher((String)request.getParameter("teacher_id"));
			
			if(stat > 0) request.getRequestDispatcher("./teach_admin").forward(request, response);
			
		}else if(request.getParameterNames().nextElement().equals("course_id")){
			int stat = ManageCourse.deleteCourse((String)request.getParameter("course_id"));
			
			if(stat > 0) request.getRequestDispatcher("./course_admin").forward(request, response);
			
		}else if(request.getParameterNames().nextElement().equals("class_id")){
			String class_id = (String)request.getParameter("class_id");
			Class_room c_room = ManageClass.classRoomWithId(class_id); 
			
			int stat = ManageClass.deleteClass(c_room);
			System.out.print(stat);
			
			if(stat > 0) request.getRequestDispatcher("./class_admin").forward(request, response);
			
		}

	}

}