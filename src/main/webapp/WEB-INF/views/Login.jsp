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
First name <input type="text" name="frist name"/><br><br>
Last name <input type="text" name="last name"/><br><br>
Email <input type="text" name="text"/><br><br>
Password <input type="password" name="password"/><br><br>
<input type="submit" value="Login" name="submit"/><br><br>
</form>

<a href="signup">SignUp</a> <br><br> 
<a href="forgetpassword">Forget Password</a>
</body>
</html>