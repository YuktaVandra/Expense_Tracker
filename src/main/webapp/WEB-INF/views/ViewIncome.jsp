<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Income</title>
</head>
<body>
<h2>View Income</h2>

Income Id : ${income.incomeId } <br><br>
Account Id : ${income.accountId } <br><br>
User Id : ${income.userId } <br><br>
Title : ${income.incomeTitle } <br><br>
Amount : ${income.incomeAmount } <br><br>
Description : ${income.description } <br><br>
TransactionDate : ${income.transactionDate } <br><br>
Status : ${income.status }
</body>
</html>