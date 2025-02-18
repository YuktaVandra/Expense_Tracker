<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up Page</title>
</head>
<body>
<form action="saveuser" method="post">
First Name <input type="text" name="firstName"/><br><br>
Last Name <input type="text" name="lastName"/><br><br>
Email <input type="text" name="email"/><br><br>
Password <input type="password" name="password"/><br><br>
Confirm Password <input type="password" name="confirmpassword"/><br><br>
Contact No.<input type="tel" name="contactNo"/><br><br>
<input type="submit" value="Sign Up" name="submit"/><br><br>
</form>
<a href="login">Login</a> <br><br>  
 
</body>
</html>
