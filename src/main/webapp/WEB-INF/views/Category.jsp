<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Category</title>
</head>
<body>
<form action="savecategory" method="post">
Title :- <select name="categoryTitle">
<option value="automobile">AUTOMOBILE</option>
  <option value="household">HOUSEHOLD</option>
</select><br><br>
User  <select name="userId">
	<option>Select User </option>
	<c:forEach items="${allUser}" var="c">

						<option value="${c.userId}">${c.firstName}</option>
				
				</c:forEach>

	</select> <br><br>
	
<input type="submit" value="Add Category">
</form>
</body>
</html>