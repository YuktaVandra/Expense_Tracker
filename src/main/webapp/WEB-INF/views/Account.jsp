<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Account</title>
</head>
<body>

        <!-- Form to Add Account -->
        <form action="saveaccount" method="post" class="mb-4">
            <div class="mb-3">
                <label class="form-label">Title:</label>
                <input type="text" name="accountTitle" class="form-control" required>
            </div><br><br>
            <div class="mb-3">
                <label class="form-label">Amount:</label>
                <input type="number" min="1" step="0.01"  name="accountAmount" class="form-control" required>
            </div><br><br>
            <div class="mb-3">
                <label class="form-label">Description:</label>
                <textarea name="description" class="form-control" required></textarea>
            </div><br><br>
			
			First Name : <select name="firstName">
						<option>Select FirstName</option>
						
						<c:forEach items="${allUser}" var="a">

								<option value="${a.userId}">${a.firstName }</option>
						
						</c:forEach>

					</select> <br><br>
					
					<!--Last Name : <select name="firstName">
											<option>Select LastName</option>
											
											<c:forEach items="${allUser}" var="a">

													<option value="${a.userId}">${a.lastName }</option>
											
											</c:forEach>

										</select> <br><br>-->
					
			
            <button type="submit" class="btn btn-primary">Add Account</button>
        </form>
</body>
</html>