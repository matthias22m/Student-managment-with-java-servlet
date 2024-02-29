package com.manageServlet;

import java.io.IOException;
import java.util.HashMap;

import com.manageObjects.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/editObject")
public class Edit_object extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getParameterNames().nextElement().equals("stud_id")){
		
			Student stud = ManageStudent.studentWithId((String)request.getParameter("stud_id"));
				
			request.setAttribute("student", stud);
			request.getRequestDispatcher("./stud_update.jsp").forward(request, response);
		
		}else if(request.getParameterNames().nextElement().equals("teacher_id")){
			Teacher teach = ManageTeacher.teacherWithId((String)request.getParameter("teacher_id"));
			request.setAttribute("teacher", teach);
			request.getRequestDispatcher("./teach_update.jsp").forward(request, response);
		
		}else if(request.getParameterNames().nextElement().equals("course_id")){
			Course course = ManageCourse.courseWithId((String)request.getParameter("course_id"));
			HashMap<Integer, String> Category = Course_admin.getCategories();
			request.setAttribute("course", course);
			request.setAttribute("Category", Category);
			request.getRequestDispatcher("./course_update.jsp").forward(request, response);
		
		}else if(request.getParameterNames().nextElement().equals("class_id")){
			Class_room class_room = ManageClass.classRoomWithId((String)request.getParameter("class_id"));
			request.setAttribute("class_room", class_room);
			request.getRequestDispatcher("./class_update.jsp").forward(request, response);
		
		}
			
	}

}