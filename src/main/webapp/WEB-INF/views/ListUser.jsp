<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
</head>
<body>
<h2>List of Users</h2>
<table border="1">
<tr>
<th>userId</th>
<th>firstName</th>
<th>lastName</th>
<th>email</th>
<th>password</th>
<th>contactNo</th>
<th>status</th>
<th>role</th>
<th>createdAt</th>
</tr>
<c:forEach items="${userList}" var="m">
<tr>
<td>${m.userId}</td>
<td>${m.firstName}</td>
<td>${m.lastName}</td>
<td>${m.email}</td>
<td>${m.password}</td>
<td>${m.contactNo}</td>
<td>${m.status}</td>
<td>${m.role}</td>
<td>${m.createdAt}</td>
</tr>
</c:forEach>
</table>
</body>
</html>