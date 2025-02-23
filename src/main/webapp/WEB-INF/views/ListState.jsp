<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of State </title>
</head>
<body>
<h2>List of State</h2>
<table border="1">
<tr>
<th>StateName</th>
<th>Action</th>
</tr>
<c:forEach items="${stateList}" var="m">
<tr>
<td>${m.stateName}</td>
<td><a href="viewstate?stateId=${m.stateId }">View</a>| <a href="deletestate?stateId=${m.stateId }">Delete</a> | Edit</td>
</tr>
</c:forEach>
</table>
</body>
</html>