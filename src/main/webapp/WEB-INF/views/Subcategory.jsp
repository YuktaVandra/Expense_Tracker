<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage SubCategory</title>
</head>
<body>
<form action="savesubcategory" method="post">
Title :- <select name="subcategoryTitle">
<option value="fuel">Fuel</option>
  <option value="service">Service</option>
  <option value="grocery">Grocery</option>
</select><br><br>

User: <select name="userId">
		<option>Select User</option>
						
		<c:forEach items="${allUser}" var="u">

		<option value="${u.userId}">${u.firstName }</option>
						
		</c:forEach>

		</select> <br> <br>
		
		
				
				User: <select name="userId">
						<option>Select DateTime</option>
										
						<c:forEach items="${allUser}" var="u">

						<option value="${u.userId}">${u.createdAt }</option>
										
						</c:forEach>

						</select> <br> <br>
						
						
						Category: <select name="categoryId">
								<option>Select Category</option>
																	
								<c:forEach items="${allCategory}" var="c">

							        <option value="${c.categoryId}">${c.categoryTitle }</option>
																	
								</c:forEach>

							       </select> <br><br>
		
		
<input type="submit" value="Add Sub-Category">
</form>
</body>
</html>