<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="com.manageObjects.*" %>

<span style="font-family: verdana, geneva, sans-serif;">
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Student Management System | Servlet</title>
  <link rel="stylesheet" href="style3.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
	}
%>
  <div class="container">
    <nav>
      <div class="navbar">
        <div class="logo">
        <i class="fas fa-school"></i>
          <h1>Student Management</h1>
        </div>
        <ul>
          <li><a href="teach_admin">
            <i class="fas fa-user-tie"></i>
            <span class="nav-item">Teacher</span>
          </a>
          </li>
          <li><a href="stud_admin">
            <i class="fas fa-user"></i>
            <span class="nav-item">Student</span>
          </a>
          </li>
          <li><a href="course_admin">
            <i class="fas fa-tasks"></i>
            <span class="nav-item">Course</span>
          </a>
          </li>
          <li class="active"><a href="class_admin">
            <i class="fas fa-users"></i>
            <span class="nav-item">Class</span>
          </a>
          
          <li><a href="logout" class="logout">
            <i class="fas fa-sign-out-alt"></i>
            <span class="nav-item">Logout</span>
          </a>
          </li>
        </ul>
      </div>
    </nav>

    <section class="main">
      <div class="main-top">
        <h1>Add Class</h1>
      </div>

      <div class="main-body">
      
      		<%
               
            	ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getAttribute("teachers");
      			ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
               
            %>

        
        <table>
            <form action="saveObject" method="Post">
            <tr>
              <td>
                <label for="class_id">Class Id: </label>
                <input type="text" name="class_id" id="class_id" required="true" placeholder="Class Id here">
              </td>
              <td>
                <label for="className">Class Name: </label>
                <input type="text" id="className" name="class_name" required="true" placeholder="Class name here">
              </td>
            </tr>
            <tr>
              <td>
                <label for="classRoom">Class Room: </label>
                <input type="text" id="classRoom" name="class_room" required="true" placeholder="Class room here">
              </td>
              <td>
                <label for="roomLimit">Room Limit: </label>
                <input type="number" id="roomLimit" name="room_limit" required="true" placeholder="Class room limit here">
              </td>
            </tr>
            <tr>
              <td>
                <label for="teacher">Teacher:</label>
                <select name="teach_id" id="teacher">
                	<% for(Teacher teach: teachers){ %>
                	
                    	<option value="<%= teach.getTeachId() %>"><%= teach.getFullName() %></option>
                    
                    <%} %>
                </select>
              </td>
              <td>
                <label for="course">Course:</label>
                <select name="course_id" id="course">
                    <% for(Course course: courses){ %>
                	
                    	<option value="<%= course.getCourseId() %>"><%= course.getCourseName() %></option>
                    
                    <%} %>
                </select>
              </td>
            </tr>
            <tr>
            <td>
              <input class="btn" type="submit" value="Submit">

            </td>
          </tr>
          </form>
          </table>

      </div>
    </section>
  </div>

</body>
</html></span>