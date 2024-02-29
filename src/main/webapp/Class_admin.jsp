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
  <link rel="stylesheet" href="style2.css" />
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
        <h1>Avaliable Classes</h1>
        <a href="createClass">Create new Class</a>
      </div>

      <div class="main-body">

        
        <table>
            <thead>
                <tr>
                    <th>Class Id</th>
                    <th>Class name</th>
                    <th>Course</th>
                    <th>Teacher</th>
                    <th>Class room</th>
                    <th>no of students</th>
                    <!-- <th></th> -->
                </tr>
            </thead>
            <tbody>
             <%
               ArrayList<Class_room> class_rooms = (ArrayList<Class_room>) request.getAttribute("Class_rooms");
               Course course;
               Teacher teacher;
  
             %>
               
             <%
               	for(Class_room class_room: class_rooms){
               		course = ManageCourse.courseWithId(class_room.getCourseId());
               		teacher = ManageTeacher.teacherWithId(class_room.getTeacherId());
             %>
             <tr>
                     <td><%= class_room.getClassId() %></td>
                     <td><%= class_room.getClassName() %></td>
                     <td><%= course.getCourseName() %></td>
                     <td><%= teacher.getFullName() %></td>
                     <td><%= class_room.getClassRoom() %></td>
                     <td><%= class_room.getRegisteredStudent() %></td>
                     <td class="edit-update"><a href="editObject?class_id= <%= class_room.getClassId() %>">Update</a> <a href="deleteObject?class_id= <%= class_room.getClassId() %>">Delete</a></td>
             </tr>
                     
              <%} %>
            </tbody>
        </table>
      </div>
    </section>
  </div>

</body>
</html></span>