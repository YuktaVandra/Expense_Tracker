<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form action="authenticate" method="post">

Email <input type="text" name="email"/><br><br>
Password <input type="password" name="password"/><br><br>
<input type="submit" value="Login" name="submit"/><br><br>
</form>

<br><br>
${error}
<br> <br>
<a href="signup">SignUp</a> <br><br> 
<a href="forgetpassword">Forget Password</a>
</body>
</html>