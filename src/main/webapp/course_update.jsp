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
          <li class="active"><a href="course_admin">
            <i class="fas fa-tasks"></i>
            <span class="nav-item">Course</span>
          </a>
          </li>
          <li ><a href="class_admin">
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
        <h1>Register Course</h1>
      </div>

      <div class="main-body">
      
      		<%
      			HashMap<Integer, String> Category = (HashMap<Integer,String>) request.getAttribute("Category");
      			Course course = (Course) request.getAttribute("course");
               
            %>

        
        <table>
            <form action="updateObject" method="Post">
            <tr>
              <td>
                <label for="course_id">Course Id: </label>
                <input type="text" name="course_id" id="course_id" value="<%= course.getCourseId() %>"  required="true" placeholder="Course Id here" readonly>
              </td>
              <td>
                <label for="course_name">Course Name: </label>
                <input type="text" id="course_name" name="course_name" value="<%= course.getCourseName() %>" required="true" placeholder="Course name here">
              </td>
            </tr>
            <tr>
              <td>
                <label for="start_date">Start date: </label>
                <input type="date" id="start_date" name="start_date" value="<%= course.getStartDate() %>" required="true" >
              </td>
              <td>
                <label for="end_date">End date: </label>
                <input type="date" id="end_date" name="end_date" value="<%= course.getEndDate() %>" required="true">
              </td>
            </tr>
            <tr>
              <td>
                <label for="category">Course Category:</label>
                <select name="category" value="<%= course.getCourseCategory() %>" id="category">
                	<% for (int cat : Category.keySet()){ %>
                	
                    	<option value="<%= cat %>"><%= Category.get(cat) %></option>
                    
                    <%} %>
                </select>
              </td>
              <td>
                <label for="credit_hour">Credit Hour: </label>
                <input type="number" id="credit_hour" name="credit_hour" value="<%= course.getCreditHour() %>" required="true" placeholder="Class room limit here">
              </td>
            </tr>
            <tr>
            <td>
              <input class="btn" type="submit" value="Update">

            </td>
          </tr>
          </form>
          </table>

      </div>
    </section>
  </div>

</body>
</html></span>