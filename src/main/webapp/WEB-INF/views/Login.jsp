<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="saveuser" method="post">

Email <input type="text" name="Email"/><br><br>
Password <input type="password" name="Password"/><br><br>
<input type="submit" value="Login" name="submit"/><br><br>
</form>

<a href="signup">SignUp</a> <br><br> 
<a href="forgetpassword">Forget Password</a>
</body>
</html>