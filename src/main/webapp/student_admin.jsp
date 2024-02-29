<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.manageObjects.Student" %>

<span style="font-family: verdana, geneva, sans-serif;">
<!DOCTYPE html>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Student Management System | Servlet</title>
	<link rel="stylesheet" href="./style2.css" />
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
           <li class="active"><a href="stud_admin">
             <i class="fas fa-user"></i>
             <span class="nav-item">Student</span>
           </a>
           </li>
           <li><a href="course_admin">
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
         <h1>Students</h1>
         <a href="stud_registration.jsp">Add student</a>
       </div>

       <div class="main-body">         
           <table>
               <thead>
                   <tr>
                       <th>Id</th>
                       <th>Student name</th>
                       <th>Gender</th>
                       <th>Email</th>
                       <th>Phone</th>
   
                   </tr>
               </thead>
               <tbody>
               
               <%
               
               ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
               
               %>
               
               <%
               	for(Student stud: students){
               %>
               <tr>
                     <td><%= stud.getStudId() %></td>
                     <td><%= stud.getFullName() %></td>
                     <td><%= stud.getGender() %></td>
                     <td><%= stud.getEmail() %></td>
                     <td><%= stud.getPhone() %></td>
                     <td class="edit-update"><a href="editObject?stud_id= <%= stud.getStudId() %>">Update</a> <a href="deleteObject?stud_id=<%= stud.getStudId() %>">Delete</a></td>
                </tr>
                     
                 <%} %>
                 
                 
               </tbody>
           </table>
       </div>
     </section>
   </div>
</body>
</html>