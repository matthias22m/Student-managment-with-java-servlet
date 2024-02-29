<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="registration.css">
</head>
<body>

<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
	}
%>
    <div class="container">
        <h1>Student Registration Form</h1>
        <form action="saveObject" method="POST">
            <div class="row">
                <div class="column">
                    <label for="stud_id">Student ID</label>
                    <input type="text" required="true" name="stud_id" id="name" placeholder="Student ID here">
                </div>
                
                <div class="column">
                    <label for="name">Full Name</label>
                    <input type="text" required="true" name="full_name" id="name" placeholder="Student Full name here">
                </div>

                <div class="column">
                    <label for="email">Email</label>
                    <input type="email" required="true" name="email" id="email" placeholder="Student email here">
                </div>
                <div class="column">
                    <label for="contact">Contact Number</label>
                    <input type="tel" required="true" name="phone" id="contact" placeholder="Student phone number here">
                </div>
                <div class="column">
                    <label for="address">Address</label>
                    <input type="text" required="true" name="address" id="address" placeholder="Student Address here">
                </div>
                <div class="column">
                    <label  for="password">Password</label>
                    <input type="password" required="true"  name="password" id="password" placeholder="Enter Password here">
                </div>
            </div>
            <div class="row">
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
            <button type="submit" value="save student">Register</button>
        </form>
    </div>
</body>
</html>