<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html lang="en">
	<head>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <title>Manage Vendor</title>

	  <!-- Google Font: Source Sans Pro -->
	  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
	  <!-- Font Awesome -->
	  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
	  <!-- daterange picker -->
	  <link rel="stylesheet" href="../../plugins/daterangepicker/daterangepicker.css">
	  <!-- iCheck for checkboxes and radio inputs -->
	  <link rel="stylesheet" href="../../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
	  <!-- Bootstrap Color Picker -->
	  <link rel="stylesheet" href="../../plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
	  <!-- Tempusdominus Bootstrap 4 -->
	  <link rel="stylesheet" href="../../plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
	  <!-- Select2 -->
	  <link rel="stylesheet" href="../../plugins/select2/css/select2.min.css">
	  <link rel="stylesheet" href="../../plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
	  <!-- Bootstrap4 Duallistbox -->
	  <link rel="stylesheet" href="../../plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
	  <!-- BS Stepper -->
	  <link rel="stylesheet" href="../../plugins/bs-stepper/css/bs-stepper.min.css">
	  <!-- dropzonejs -->
	  <link rel="stylesheet" href="../../plugins/dropzone/min/dropzone.min.css">
	  <!-- Theme style -->
	  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
	</head>
	
	<body class="hold-transition sidebar-mini">
<div class="wrapper">
  
  <jsp:include page="AdminHeader.jsp"></jsp:include>
  
  
  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">BudgetBuddy</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${user.firstName}</a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="admindashboard" class="nav-link">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Dashboard
                
              </p>
            </a>
            
          </li>
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-user"></i>
              <p>
                Users
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="listuser" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Users</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item ">
            <a href="#" class="nav-link ">
              <i class="fa-solid fa-users"></i>
              <p>
                Account
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="manageaccount" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Account</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listaccount" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Account</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item ">
            <a href="#" class="nav-link ">
              <i class="fa-solid fa-layer-group"></i>
              <p>
                Category
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="managecategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Category</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Category</p>
                </a>
              </li>
              <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-rectangle-list"></i>
              <p>
                Sub-Category
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="managesubcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Sub-Category</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listsubcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Sub-Category</p>
                </a>
              </li>
              </ul>
          </li>
              </ul>
              
          </li>
          
          
           <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-wallet"></i>
              <p>
                Expense
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="manageexpense" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Expenses</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listexpense" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Expenses</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-sack-dollar"></i>
              <p>
                Income
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="manageincome" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Income</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listincome" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Income</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-city"></i>
              <p>
                City
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="newcity" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add City</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listcity" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of City</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-map-location-dot"></i>
              <p>
                State
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="newstate" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add State</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="liststate" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of State</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="fa-solid fa-user-tie"></i>
              <p>
                Vendor
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="vendor" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Vendor</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listvendor" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Vendor</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item">
            <a href="signup" class="nav-link">
              <i class="fa-solid fa-user-plus"></i>
              <p>
                Sign-Up
              </p>
            </a>
            </li>
            <li class="nav-item">
            <a href="login" class="nav-link">
              <i class="fa-solid fa-circle-user"></i>
              <p>
                Sign-In
                 </p>
            </a>
            </li>
       
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  
  <div class="content-wrapper" style="min-height: 1345.52px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Add Vendor</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
              <li class="breadcrumb-item active">Add Vendor</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content" >
      <div class="container-fluid">
        
        <div class="card card-default">
          
          <div class="card-body">
          <form action="savevendor" method="post" class="mb-4">
          
          <div class="row">
    <!-- Left Side: Title and Amount -->
    <div class="col-md-6">
        <div class="mb-3">
                <label class="form-label">Title:</label>
                <input type="text" name="vendorTitle" class="form-control" >
            </div>
        <div class="form-group mb-3">
            <label>User:</label>
            <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" name="userId">
                <option selected="selected">Select User</option>
                <c:forEach items="${allUser}" var="c">
                    <option value="${c.userId}">${c.firstName}</option>
                </c:forEach>
            </select>
        </div>
        
        <div class="form-group mb-3">
            <label>Email:</label>
            <select class="form-control select2 select2-hidden-accessible" style="width: 100%;" name="userId">
                <option selected="selected">Select Email</option>
                <c:forEach items="${allUser}" var="c">
                    <option value="${c.userId}">${c.email}</option>
                </c:forEach>
            </select>
        </div>
    </div>
</div>

<button type="submit" class="btn btn-primary">Add Vendor</button>
</form>
          
            
</div>           
</div>
</div>
</section>
</div>
</div>        

<jsp:include page="AdminFooter.jsp"></jsp:include>

<!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Select2 -->
<script src="../../plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap4 Duallistbox -->
<script src="../../plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
<!-- InputMask -->
<script src="../../plugins/moment/moment.min.js"></script>
<script src="../../plugins/inputmask/jquery.inputmask.min.js"></script>
<!-- date-range-picker -->
<script src="../../plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap color picker -->
<script src="../../plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="../../plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Bootstrap Switch -->
<script src="../../plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- BS-Stepper -->
<script src="../../plugins/bs-stepper/js/bs-stepper.min.js"></script>
<!-- dropzonejs -->
<script src="../../plugins/dropzone/min/dropzone.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

    //Initialize Select2 Elements
    $('.select2bs4').select2({
      theme: 'bootstrap4'
    })

    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
    //Datemask2 mm/dd/yyyy
    $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
    //Money Euro
    $('[data-mask]').inputmask()

    //Date picker
    $('#reservationdate').datetimepicker({
        format: 'L'
    });

    //Date and time picker
    $('#reservationdatetime').datetimepicker({ icons: { time: 'far fa-clock' } });

    //Date range picker
    $('#reservation').daterangepicker()
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({
      timePicker: true,
      timePickerIncrement: 30,
      locale: {
        format: 'MM/DD/YYYY hh:mm A'
      }
    })
    //Date range as a button
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate  : moment()
      },
      function (start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
      }
    )

    //Timepicker
    $('#timepicker').datetimepicker({
      format: 'LT'
    })

    //Bootstrap Duallistbox
    $('.duallistbox').bootstrapDualListbox()

    //Colorpicker
    $('.my-colorpicker1').colorpicker()
    //color picker with addon
    $('.my-colorpicker2').colorpicker()

    $('.my-colorpicker2').on('colorpickerChange', function(event) {
      $('.my-colorpicker2 .fa-square').css('color', event.color.toString());
    })

    $("input[data-bootstrap-switch]").each(function(){
      $(this).bootstrapSwitch('state', $(this).prop('checked'));
    })

  })
  // BS-Stepper Init
  document.addEventListener('DOMContentLoaded', function () {
    window.stepper = new Stepper(document.querySelector('.bs-stepper'))
  })

  // DropzoneJS Demo Code Start
  Dropzone.autoDiscover = false

  // Get the template HTML and remove it from the doumenthe template HTML and remove it from the doument
  var previewNode = document.querySelector("#template")
  previewNode.id = ""
  var previewTemplate = previewNode.parentNode.innerHTML
  previewNode.parentNode.removeChild(previewNode)

  var myDropzone = new Dropzone(document.body, { // Make the whole body a dropzone
    url: "/target-url", // Set the url
    thumbnailWidth: 80,
    thumbnailHeight: 80,
    parallelUploads: 20,
    previewTemplate: previewTemplate,
    autoQueue: false, // Make sure the files aren't queued until manually added
    previewsContainer: "#previews", // Define the container to display the previews
    clickable: ".fileinput-button" // Define the element that should be used as click trigger to select files.
  })

  myDropzone.on("addedfile", function(file) {
    // Hookup the start button
    file.previewElement.querySelector(".start").onclick = function() { myDropzone.enqueueFile(file) }
  })

  // Update the total progress bar
  myDropzone.on("totaluploadprogress", function(progress) {
    document.querySelector("#total-progress .progress-bar").style.width = progress + "%"
  })

  myDropzone.on("sending", function(file) {
    // Show the total progress bar when upload starts
    document.querySelector("#total-progress").style.opacity = "1"
    // And disable the start button
    file.previewElement.querySelector(".start").setAttribute("disabled", "disabled")
  })

  // Hide the total progress bar when nothing's uploading anymore
  myDropzone.on("queuecomplete", function(progress) {
    document.querySelector("#total-progress").style.opacity = "0"
  })

  // Setup the buttons for all transfers
  // The "add files" button doesn't need to be setup because the config
  // `clickable` has already been specified.
  document.querySelector("#actions .start").onclick = function() {
    myDropzone.enqueueFiles(myDropzone.getFilesWithStatus(Dropzone.ADDED))
  }
  document.querySelector("#actions .cancel").onclick = function() {
    myDropzone.removeAllFiles(true)
  }
  // DropzoneJS Demo Code End
</script>

  
  
  <script src="https://kit.fontawesome.com/9d21862bba.js" crossorigin="anonymous"></script>
</body>
</html>  
		
		
    