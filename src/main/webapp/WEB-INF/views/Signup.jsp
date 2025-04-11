<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>SignUp Page</title>

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="../../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
  <!-- Bootstrap Select -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/css/bootstrap-select.min.css">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <style>
    body {
      background-color: #f4f6f9;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      font-family: 'Source Sans Pro', sans-serif;
    }

    .register-box {
      width: 420px;
      background-color: #fff;
      padding: 30px;
      border-radius: 15px;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    }

    .card-header a {
      font-size: 32px;
      font-weight: 800;
      text-decoration: none;
    }

    .login-box-msg {
      font-size: 18px;
      font-weight: 500;
      margin-bottom: 20px;
      text-align: center;
    }

    .input-group-text {
      background-color: #e9ecef;
      border: none;
      border-left: 1px solid #ccc;
      border-radius: 0 5px 5px 0;
    }

    .form-control {
      border-right: none;
    }

    .btn-primary {
      width: 100%;
      border-radius: 6px;
      font-weight: bold;
    }

    .input-group {
      border-radius: 6px;
      overflow: hidden;
      margin-bottom: 15px;
    }

    .text-center a {
      display: block;
      margin-top: 15px;
    }
  </style>
</head>
<body>
<div class="register-box">
  <div class="card-header text-center">
    <a href="#" class="h1"><b>Budget</b>Buddy</a>
  </div>
  <p class="login-box-msg">Create New Account</p>

  <form action="saveuser" method="post" enctype="multipart/form-data">
    <p style="color: red;">${error}</p>

    <div class="input-group">
      <input type="file" name="profilePic" class="form-control">
      <span class="input-group-text"><i class="fas fa-upload"></i></span>
    </div>

    <div class="input-group">
      <input type="text" name="firstName" class="form-control" placeholder="First Name">
      <span class="input-group-text"><i class="fas fa-user"></i></span>
    </div>

    <div class="input-group">
      <input type="text" name="lastName" class="form-control" placeholder="Last Name">
      <span class="input-group-text"><i class="fas fa-user"></i></span>
    </div>

    <div class="input-group">
      <input type="email" name="email" class="form-control" placeholder="Email">
      <span class="input-group-text"><i class="fas fa-envelope"></i></span>
    </div>

    <div class="input-group">
      <input type="password" name="password" class="form-control" placeholder="Password">
      <span class="input-group-text"><i class="fas fa-lock"></i></span>
    </div>

    <div class="input-group">
      <input type="password" name="confirmPassword" class="form-control" placeholder="Confirm Password">
      <span class="input-group-text"><i class="fas fa-lock"></i></span>
    </div>


    <div class="input-group">
      <select id="state" name="stateId" class="form-control" required onchange="getCity()">
        <option value="-1">Select State</option>
        <c:forEach items="${stateList}" var="s">
          <option value="${s.stateId}">${s.stateName}</option>
        </c:forEach>
      </select>
      <span class="input-group-text"><i class="fa-solid fa-map-location-dot"></i></span>
    </div>
    
    <div class="input-group">
      <select id="city" name="cityId" class="form-control" required >
        <option value="-1">Select City</option>
        
      </select>
      <span class="input-group-text"><i class="fa-solid fa-city"></i></span>
    </div>
<div class="input-group mb-3">
  <select name="role" class="form-control" required>
    <option value="">Select Role</option>
    <option value="USER">User</option>
    <option value="ADMIN">Admin</option>
  </select>
  <div class="input-group-append">
    <div class="input-group-text">
      <span class="fas fa-user-tag"></span>
    </div>
  </div>
</div>

    <div class="input-group">
      <input type="tel" name="contactNo" class="form-control" placeholder="Contact No.">
      <span class="input-group-text"><i class="fas fa-phone"></i></span>
    </div>

    <button type="submit" class="btn btn-primary">Sign Up</button>
  </form>

  <div class="text-center">
    <a href="login">Already have an account? Sign In</a>
  </div>
</div>

<!-- Scripts -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://kit.fontawesome.com/9d21862bba.js" crossorigin="anonymous"></script>

<script type="text/javascript">
function getCity(){
	 console.log("state change");
    let stateId = document.getElementById("state").value;
    console.log(stateId);
    
    $.get( "getcity/"+stateId, function() {
     	  //alert( "success" );
     	})
     	  .done(function(data) {
     	    console.log(data);
     	    $('#city').empty().append('<option selected="selected" value="-1">Select City</option>')
     	;
     	    for (var i = 0; i < data.length; i++) {
     	        $('#city').append('<option value="' + data[i].cityId + '">' + data[i].cityName + '</option>');
     	    } 
     	  })
     	  .fail(function() {
     	    alert( "error" );
     	  })
    
}
</script>
</body>
</html>
