<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!--Google Font-->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet">
    <!--Stylesheet-->
    <link rel="stylesheet" href="registration.css">
</head>
<body>
    <div class="container">
        <h1>Admin Login</h1>
        <form action="login" method = "post">
            <div class="row">
                <div class="column">
                    <label for="name">Username</label>
                    <input type="text" id="name" name="username" placeholder="Enter User ID here">
                </div>
                
                
                
            </div>
            <div class="row">
                <div class="column">
                    <label for="name">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter password here">
                </div>
            </div>
            <div class="invisible row">
                <div class="column">
                    <label for="">User</label>
                    <div class="radio">
                        <label for="student">Student</label>
                        <input type="radio" name="gender" id="student" value="student">
                        <label for="teacher">Teacher</label>
                        <input type="radio" name="gender" id="teacher" value="teacher">
                    </div>
                </div>
            </div>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
</body>
</html>