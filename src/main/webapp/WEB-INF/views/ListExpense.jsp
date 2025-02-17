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
<th>expenseId</th>
<th>accountId</th>
<th>categoryId</th>
<th>subcategoryId</th>
<th>userId</th>
<th>vendorId</th>
<th>title</th>
<th>amount</th>
<th>description</th>
<th>transactionDate</th>
</tr>
<c:forEach items="${expenseList}" var="m">
<tr>
<td>${m.expenseId}</td>
<td>${m.accountId}</td>
<td>${m.categoryId}</td>
<td>${m.subcategoryId}</td>
<td>${m.userId}</td>
<td>${m.vendorId}</td>
<td>${m.title}</td>
<td>${m.amount}</td>
<td>${m.description}</td>
<td>${m.transactionDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>