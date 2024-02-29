<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.manageObjects.*" %>
<span style="font-family: verdana, geneva, sans-serif;"><!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html lang="en">
<head>
  <title>Student Management System | Servlet</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
  <link rel="stylesheet" href="style2.css">
  <!-- Font Awesome Cdn Link -->
</head>
<body>

<%  response.setHeader("cache-control","no-cache, no-store, must-revalidate");
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
          <li ><a href="course_admin">
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
</div>
    <section class="main">
      <div class="main-top">
        <h1>Admin Dashboard</h1>
      </div>
      <div class="main-body">
       
<%
	ArrayList<Integer> arr = (ArrayList<Integer>) session.getAttribute("arr");
%>



      <table>
        <div class="job_details">
          <div class="img">
            <i class="fas fa-book-open"></i>
          </div>
          <div class="text">
            <h2>Courses</h2>
            <span>total number of courses :</span>
          </div>
        </div>
        <div class="number">
          <h2>
              <span><%= arr.get(0) %></span>
          </h2>
        </div>
      </div>
      
      <div class="job_card">
        <div class="job_details">
          <div class="img">
            <i class="fas fa-user-tie"></i>
          </div>
          <div class="text">
            <h2>Teachers</h2>
            <span>Total number of teachers:</span>
          </div>
        </div>
        <div class="number">
            <h2>
                <span><%= arr.get(1) %></span>
            </h2>
        </div>
      </div>

      <div class="job_card">
        <div class="job_details">
          <div class="img">
            <i class="fas fa-users"></i>
          </div>
          <div class="text">
            <h2>Classes</h2>
            <span>All avaliable classes:</span>
          </div>
        </div>
        <div class="number">
            <h2>
                <span><%= arr.get(2) %></span>
            </h2>
        </div>
      </div>

      <div class="job_card">
        <div class="job_details">
          <div class="img">
            <i class="fas fa-user"></i>
          </div>
          <div class="text">
            <h2>Students</h2>
            <span>Total number of students:</span>
          </div>
        </div>
        <div class="number">
            <h2>
                <span><%= arr.get(3) %></span>
            </h2>
        </div>
      </div>
    </div>
    </section>

      </table>
  </div>

</body>
</html>
</span>