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
<th>incomeId</th>
<th>accountId</th>
<th>userId</th>
<th>title</th>
<th>amount</th>
<th>description</th>
<th>status</th>
<th>transactionDate</th>
</tr>
<c:forEach items="${incomeList}" var="m">
<tr>
<td>${m.incomeId}</td>
<td>${m.accountId}</td>
<td>${m.userId}</td>
<td>${m.title}</td>
<td>${m.amount}</td>
<td>${m.description}</td>
<td>${m.status}</td>
<td>${m.transactionDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>