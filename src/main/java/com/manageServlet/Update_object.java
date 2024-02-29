package com.manageServlet;

import java.io.IOException;

import com.manageObjects.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateObject")
public class Update_object extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameterNames().nextElement().equals("stud_id")){
			Student stud = new Student();
			
			stud.setStudId((String)request.getParameter("stud_id"));
			stud.setFullName((String)request.getParameter("full_name"));
			stud.setEmail((String)request.getParameter("email"));
			stud.setPhone((String)request.getParameter("phone"));
			stud.setAddress((String)request.getParameter("address"));
			stud.setPassword((String)request.getParameter("password"));
			stud.setGender((String)request.getParameter("gender"));
			stud.setYear(Integer.parseInt((String)request.getParameter("year")));
			
			int stat = ManageStudent.updateStudent(stud);
			if(stat > 0) request.getRequestDispatcher("./stud_admin").forward(request, response);
			
		}else if(request.getParameterNames().nextElement().equals("teach_id")){
			Teacher teach = new Teacher();
		    
		    teach.setTeachId((String)request.getParameter("teach_id"));
		    teach.setFullName((String)request.getParameter("full_name"));
		    teach.setEmail((String)request.getParameter("email"));
		    teach.setPhone((String)request.getParameter("phone"));
		    teach.setAddress((String)request.getParameter("address"));
		    teach.setPassword((String)request.getParameter("password"));
		    teach.setGender((String)request.getParameter("gender"));
			teach.setHourLimit(Integer.parseInt((String)request.getParameter("credit")));
			
			
			int stat = ManageTeacher.updateTeacher(teach);
			if(stat > 0) request.getRequestDispatcher("./teach_admin").forward(request, response);
		
		}else if(request.getParameterNames().nextElement().equals("course_id")){
			Course course = new Course();
		    
		    course.setCourseId((String)request.getParameter("course_id"));
		    course.setCourseName((String)request.getParameter("course_name"));
		    course.setCreditHour(Integer.parseInt((String)request.getParameter("credit_hour")));
		    course.setCourseCategory(Integer.parseInt((String)request.getParameter("category")));
		    course.setStartDate((String)request.getParameter("start_date"));
		    course.setEndDate((String)request.getParameter("end_date"));
		    
			
			int stat = ManageCourse.updateCourse(course);
			if(stat > 0) request.getRequestDispatcher("./course_admin").forward(request, response);
		
		}
	}

}