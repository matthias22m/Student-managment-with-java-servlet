<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.manageObjects.Teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Teacher</title>
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
        <h1>Teacher Update Form</h1>
        <form action="updateObject" method="POST">
        	<% Teacher teach = (Teacher) request.getAttribute("teacher"); %>
            <div class="row">
                <div class="column">
                    <label for="teach_id">Ieacher ID</label>
                    <input type="text" required="true" name="teach_id" value = <%= teach.getTeachId() %> id="name"  readonly>
                </div>
                
                <div class="column">
                    <label for="name">Full Name</label>
                    <input type="text" required="true" name="full_name" value = <%= teach.getFullName() %> id="name" placeholder="Student Full name here">
                </div>

                <div class="column">
                    <label for="email">Email</label>
                    <input type="email" required="true" name="email" value = <%= teach.getEmail() %> id="email" placeholder="Student email here">
                </div>
                <div class="column">
                    <label for="contact">Contact Number</label>
                    <input type="tel" required="true" name="phone" value = <%= teach.getPhone() %> id="contact" placeholder="Student phone number here">
                </div>
                <div class="column">
                    <label for="address">Address</label>
                    <input type="text" required="true" name="address" value = <%= teach.getAddress() %> id="address" placeholder="Student Address here">
                </div>
                <div class="column">
                    <label  for="password">Password</label>
                    <input type="password" required="true" value = <%= teach.getPassword() %> name="password" id="password" placeholder="Enter Password here">
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
                    <label for="credit">Credit Hour Limit:</label>
                    <select name="credit" id="credit">
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="15">14</option>
                        <option value="16">15</option>
                        <option value="17">16</option>
                    </select>
                </div>
            </div>
            <button type="submit" value="save student">Update</button>
        </form>
    </div>
</body>
</html>