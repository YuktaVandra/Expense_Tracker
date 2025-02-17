<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <input type="text" name="title" class="form-control" required>
            </div><br><br>
            <div class="mb-3">
                <label class="form-label">Amount:</label>
                <input type="number" min="1" step="0.01"  name="amount" class="form-control" required>
            </div><br><br>
            <div class="mb-3">
                <label class="form-label">Description:</label>
                <textarea name="description" class="form-control" required></textarea>
            </div><br><br>
            <button type="submit" class="btn btn-primary">Add Account</button>
        </form>
</body>
</html>