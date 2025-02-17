<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of City</title>
</head>
<body>
<h2>List of City</h2>
<table border="1">
<tr>
<th>cityId</th>
<th>cityName</th>
</tr>
<c:forEach items="${cityList}" var="m">
<tr>
<td>${m.cityId}</td>
<td>${m.cityName}</td>
</tr>
</c:forEach>
</table>
</body>
</html>