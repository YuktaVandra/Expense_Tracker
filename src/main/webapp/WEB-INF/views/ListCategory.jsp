<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Category</title>
</head>
<body>
<h2>List of Category</h2>
<table border="1">
<tr>

<th>Title</th>
<th>Action</th>
</tr>
<c:forEach items="${categoryList}" var="m">
<tr>
<td>${m.title}</td>
<td><a href="viewcategory?categoryId=${m.categoryId }">View</a>| <a href="deletecategory?categoryId=${m.categoryId }">Delete</a> | Edit</td>
</tr>
</c:forEach>
</table>
</body>
</html>