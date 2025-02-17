<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Subcategory</title>
</head>
<body>
<h2>List of Subcategory</h2>
<table border="1">
<tr>
<th>subcategoryId</th>
<th>categoryId</th>
<th>userId</th>
<th>title</th>
</tr>
<c:forEach items="${subcategoryList}" var="m">
<tr>
<td>${m.subcategoryId}</td>
<td>${m.categoryId}</td>
<td>${m.userId}</td>
<td>${m.title}</td>
</tr>
</c:forEach>
</table>
</body>
</html>