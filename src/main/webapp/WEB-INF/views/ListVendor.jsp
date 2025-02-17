<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Vendor</title>
</head>
<body>
<h2>List of Vendor</h2>
<table border="1">
<tr>
<th>vendorId</th>
<th>userId</th>
<th>title</th>
</tr>
<c:forEach items="${vendorList}" var="m">
<tr>
<td>${m.vendorId}</td>
<td>${m.userId}</td>
<td>${m.title}</td>
</tr>
</c:forEach>
</table>
</body>
</html>