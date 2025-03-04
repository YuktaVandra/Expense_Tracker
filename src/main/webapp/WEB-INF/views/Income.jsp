<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Income</title>
</head>
<body>
<form action="saveincome" method="post">
Title <input type="text" name="incomeTitle"><br><br>
<div class="mb-3">
                <label class="form-label">Amount:</label>
                <input type="number" min="1" step="0.01"  name="incomeAmount" class="form-control" required>
            </div><br><br>
            <div class="mb-3">
                <label class="form-label">Description:</label>
                <textarea name="description" class="form-control" required></textarea>
            </div><br><br>
			
			User: <select name="userId">
					<option>Select User</option>
									
					<c:forEach items="${allUser}" var="u">

					<option value="${u.userId}">${u.firstName }</option>
									
					</c:forEach>

					</select> <br> <br>
					
					Account: <select name="accountId">
					<option>Select Account</option>
							<c:forEach items="${allAccount}" var="a">
								<option value="${a.accountId}">${a.accountTitle }</option>
					</c:forEach>	
					</select><br><br>
					
					Account Amount: <select name="accountId">
					<option>Select Acount Amount</option>
							<c:forEach items="${allAccount}" var="a">
					<option value="${a.accountId}">${a.accountAmount }</option>
					</c:forEach>
					</select>
					<br><br>
            <input type="submit" Value="Add Income">

</form>
</body>
</html>