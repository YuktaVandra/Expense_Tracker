<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login | BudgetBuddy</title>

  <!-- Google Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <!-- AdminLTE -->
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
  <!-- Bootstrap 5 CDN (optional for smoother styles) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    a {
      text-decoration: none !important;
    }
  </style>
</head>

<body class="hold-transition login-page" style="background-color: #f4f6f9;">
<div class="login-box">
  <div class="card card-outline card-primary shadow-lg rounded-3">
    <div class="card-header text-center bg-light">
      <a href="#" class="h1"><b>Budget</b>Buddy</a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Welcome back! Sign in now</p>
      
      <!-- Show success or error messages -->
      <c:if test="${not empty msg}">
        <div class="alert alert-success text-center">${msg}</div>
      </c:if>
      <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
      </c:if>

      <form action="authenticate" method="post">
        <div class="input-group mb-3">
          <input type="email" name="email" class="form-control" placeholder="Email" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
          <input type="password" name="password" class="form-control" placeholder="Password" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>

        <div class="row mb-3">
          <div class="col-8"></div>
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Sign In</button>
          </div>
        </div>
      </form>

      <p class="mb-1">
        <a href="forgetpassword">I forgot my password</a>
      </p>
      <p class="mb-0">
        <a href="signup" class="text-center">Create a new account</a>
      </p>
    </div>
  </div>
</div>

<!-- Scripts -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../dist/js/adminlte.min.js"></script>
<script src="https://kit.fontawesome.com/9d21862bba.js" crossorigin="anonymous"></script>
</body>
</html>
