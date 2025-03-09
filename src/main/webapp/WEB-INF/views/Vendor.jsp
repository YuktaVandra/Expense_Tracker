<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendor</title>
</head>
<body>
<form action="savevendor" method="post" class="mb-4">
<div class="mb-3">
                <label class="form-label">Title:</label>
                <input type="text" name="vendorTitle" class="form-control" >
            </div><br>
			
			User: <select name="userId">
								<option>Select User</option>
												
								<c:forEach items="${allUser}" var="u">

								<option value="${u.userId}">${u.firstName }</option>
												
								</c:forEach>

								</select> <br> <br>
								
								User: <select name="userId">
													<option>Select User Email</option>
																	
													<c:forEach items="${allUser}" var="u">

													<option value="${u.userId}">${u.email }</option>
																	
													</c:forEach>

													</select> <br> <br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
</body>
</html>