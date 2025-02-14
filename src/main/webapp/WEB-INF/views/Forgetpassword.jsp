<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
</head>
<body>
<form action="sendotp" method="post">
Email <input type="text" name="email"/><br><br>
<input type="submit" value="Reset password">
</form>
<a href="login">Login</a>
</body>
</html>