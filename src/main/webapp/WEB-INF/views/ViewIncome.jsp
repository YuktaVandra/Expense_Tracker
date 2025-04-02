<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>View Income</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="../../plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="../../plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  
  <jsp:include page="Admin/AdminHeader.jsp"></jsp:include>
  
  
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
          <img src="${user.profilePicPath }" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="edituser?userId=${user.userId }" class="d-block">${user.firstName}</a>
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
                Home Page
                
              </p>
            </a>
            
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
          
          
           <li class="nav-item ">
            <a href="#" class="nav-link ">
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
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
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
                <a href="listincome" class="nav-link active">
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
              <i class="fa-solid fa-user-tie"></i>
              <p>
                Vendor
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="vendor" class="nav-link">
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
       <a href="logout"><button  style="background-color: red;color: white;border-radius: 10px; width: 100%">Logout</button></a>
       </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1> View Income </h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home">Home</a></li>
              <li class="breadcrumb-item active">View Income </li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example2" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                  <th>Income Id</th>
                    <th>Title</th>
<th>Amount</th>
<th>Description</th>
<th>User Id</th>
<th>User First Name</th>
<th>User Last Name</th>
<th>User Email </th>
<th>AccountId</th>
<th>Account</th>
<th>Status</th>
<th>Transaction Date</th>                    
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${income}" var="m">
                  <tr>
                  <td>${m[0] }</td>
                  <td>${m[3]}</td>
                  <td>${m[4]}</td>
                  <td>${m[5]}</td>
                  <td>${m[2] }</td>
				  <td>${m[8]}</td>
				  <td>${m[9]}</td>
				  <td>${m[10]}</td>
				  <td>${m[1] }</td>
				  <td>${m[11]}</td>
                  <td>${m[6] }</td>
                  <td>${m[7] }</td>
                  
                   </tr> 
                  </c:forEach>  
                  </tbody>
                  
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->

          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
 <jsp:include page="Admin/AdminFooter.jsp"></jsp:include>

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
<!-- DataTables  & Plugins -->
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="../../plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="../../plugins/jszip/jszip.min.js"></script>
<script src="../../plugins/pdfmake/pdfmake.min.js"></script>
<script src="../../plugins/pdfmake/vfs_fonts.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
<script src="https://kit.fontawesome.com/9d21862bba.js" crossorigin="anonymous"></script>

</body>
</html> 
