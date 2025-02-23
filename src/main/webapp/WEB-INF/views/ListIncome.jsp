<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Income</title>
</head>
<body>
<h2>List of Income</h2>
<table border="1">
<tr>

<th>Title</th>
<th>Amount</th>
<th>Description</th>
<th>Action</th>

</tr>
<c:forEach items="${incomeList}" var="m">
<tr>

<td>${m.title}</td>
<td>${m.amount}</td>
<td>${m.description}</td>
<td><a href="viewincome?incomeId=${m.incomeId }">View</a>| <a href="deleteincome?incomeId=${m.incomeId }">Delete</a> | Edit</td>
</tr>
</c:forEach>
</table>
</body>
</html>