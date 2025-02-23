<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Expense</title>
</head>
<body>
<h2>List of Expense</h2>
<table border="1">
<tr>
<th>Title</th>
<th>Amount</th>
<th>Description</th>
<th>Action</th>
</tr>
<c:forEach items="${expenseList}" var="m">
<tr>
<td>${m.title}</td>
<td>${m.amount}</td>
<td>${m.description}</td>
<td><a href="viewexpense?expenseId=${m.expenseId }">View</a>| <a href="deleteexpense?expenseId=${m.expenseId }">Delete</a> | Edit</td>
</tr>
</c:forEach>
</table>
</body>
</html>