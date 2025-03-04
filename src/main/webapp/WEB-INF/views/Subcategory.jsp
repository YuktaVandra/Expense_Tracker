<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<input type="submit" value="Add Sub-Category">
</form>
</body>
</html>