<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Expense</title>
</head>
<body>
<h2>View Expense</h2>
ExpenseId : ${expense.expenseId}<br><br>
AccountId : ${expense.accountId}<br><br>
CategoryId : ${expense.categoryId}<br><br>
SubCategoryId : ${expense.subcategoryId}<br><br>
UserId : ${expense.userId}<br><br>
VendorId : ${expense.vendorId}<br><br>
Title : ${expense.expenseTitle}<br><br>
Amount : ${expense.expenseAmount}<br><br>
Description : ${expense.description}<br><br>
TransactionDate : ${expense.transactionDate}<br><br>
</body>
</html>