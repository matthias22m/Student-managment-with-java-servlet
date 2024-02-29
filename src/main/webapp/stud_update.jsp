<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.manageObjects.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    <!--Google Font-->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet">
    <!--Stylesheet-->
    <link rel="stylesheet" href="registration.css">
</head>
<body>

<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
	}
%>
    <div class="container">
        <h1>Student Update Form</h1>
        <form action="updateObject" method="POST">
        	<% Student stud = (Student) request.getAttribute("student"); %>
            <div class="row">
                <div class="column">
                    <label for="stud_id">Student ID</label>
                    <input type="text" required="true" name="stud_id" value = <%= stud.getStudId() %> id="name"  readonly>
                </div>
                
                <div class="column">
                    <label for="name">Full Name</label>
                    <input type="text" required="true" name="full_name" value = <%= stud.getFullName() %> id="name" placeholder="Student Full name here">
                </div>

                <div class="column">
                    <label for="email">Email</label>
                    <input type="email" required="true" name="email" value = <%= stud.getEmail() %> id="email" placeholder="Student email here">
                </div>
                <div class="column">
                    <label for="contact">Contact Number</label>
                    <input type="tel" required="true" name="phone" value = <%= stud.getPhone() %> id="contact" placeholder="Student phone number here">
                </div>
                <div class="column">
                    <label for="address">Address</label>
                    <input type="text" required="true" name="address" value = <%= stud.getAddress() %> id="address" placeholder="Student Address here">
                </div>
                <div class="column">
                    <label  for="password">Password</label>
                    <input type="password" required="true" value = <%= stud.getPassword() %> name="password" id="password" placeholder="Enter Password here">
                </div>
            </div>
            <div class="row">
                <!-- <div class="column">
                    <label for="conf_password">Confirm Password</label>
                    <input type="password" id="Conf_password" placeholder="Confirm password here">
                </div> -->
                <div class="column">
                    <label for="">Gender</label>
                    <div class="radio">
                        <label for="male">Male</label>
                        <input type="radio" name="gender" required="true" id="male" value="Male">
                        <label for="female">Female</label>
                        <input type="radio" name="gender" required="true" id="female" value="Female">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column">
                    <label for="year">Year:</label>
                    <select name="year" id="year">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
            </div>
            <button type="submit" value="save student">Update</button>
        </form>
    </div>
</body>
</html>