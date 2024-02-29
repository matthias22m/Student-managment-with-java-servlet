<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.manageObjects.Course" %>

<span style="font-family: verdana, geneva, sans-serif;">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Student Management System | Servlet</title>
  <link rel="stylesheet" href="style2.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
  <div class="container">
    <nav>
      <div class="navbar">
        <div class="logo">
        <i class="fas fa-school"></i>
          <h1>Student Management</h1>
        </div>
        <ul>
          <li><a href="/Student_management/teach_admin">
            <i class="fas fa-user-tie"></i>
            <span class="nav-item">Teacher</span>
          </a>
          </li>
          <li><a href="/Student_management/stud_admin">
            <i class="fas fa-user"></i>
            <span class="nav-item">Student</span>
          </a>
          </li>
          <li class="active"><a href="#">
            <i class="fas fa-tasks"></i>
            <span class="nav-item">Course</span>
          </a>
          </li>
          <li><a href="class_admin">
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
        <h1>Courses</h1>
        <a href="registerCourse">Add course</a>
      </div>

      <div class="main-body">

        
          <table>
              <thead>
                  <tr>
                    <th>#</th>
                    <th>Course name</th>
                    <th>Category</th>
                    <th>Credit hour</th>
                  </tr>
              </thead> 
              <tbody>
                
             <%
               HashMap<Integer, String> Category = (HashMap<Integer,String>) request.getAttribute("Category");
               ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("Courses");
  
               %>
               
               <%
               	for(Course course: courses){
               %>
               <tr>
                     <td><%= course.getCourseId() %></td>
                     <td><%= course.getCourseName() %></td>
                     <td><%= Category.get(course.getCourseCategory()) %></td>
                     <td><%= course.getCreditHour() %></td>
                     <td class="edit-update"><a href="editObject?course_id=<%= course.getCourseId() %>">Update</a> <a href="deleteObject?course_id=<%= course.getCourseId() %>">Delete</a></td>
                </tr>
                     
                 <%} %>
              </tbody>
          </table>
      </div>
    </section>
  </div>

</body>
</html></span>