<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Registration</title>
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
        <h1>Teacher Registration Form</h1>
        <form action="saveObject" method="Post">
            <div class="row">
                <div class="column">
                    <label for="teach_id">Teacher ID</label>
                    <input type="text" id="teach_id"  name="teach_id" placeholder="Teacher ID here">
                </div>
                
                <div class="column">
                    <label for="name">Full Name</label>
                    <input type="text" id="name" name="full_name" placeholder="Teacher Full name here">
                </div>

                <div class="column">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="Teacher email here">
                </div>
                <div class="column">
                    <label for="contact">Contact Number</label>
                    <input type="tel" id="contact" name="phone" placeholder="Teacher phone number here">
                </div>
                <div class="column">
                    <label for="contact">Address</label>
                    <input type="tel" id="address" name="address" placeholder="Teacher Address here">
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
                        <input type="radio" name="gender" id="male" value="Male">
                        <label for="female">Female</label>
                        <input type="radio" name="gender" id="female" value="Female">
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
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
</body>
</html>