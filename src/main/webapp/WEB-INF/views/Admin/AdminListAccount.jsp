<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>List Of Account</title>

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
          <img src="${user.profilePicPath}" class="img-circle elevation-2" alt="User Image">
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
                <a href="adminlistuser" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Users</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="fa-solid fa-users"></i>
              <p>
                Account
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              
              <li class="nav-item">
                <a href="adminlistaccount" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Account</p>
                </a>
              </li>
              </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-layer-group"></i>
              <p>
                Category
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="adminmanagecategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Category</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="adminlistcategory" class="nav-link">
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
                <a href="adminmanagesubcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Sub-Category</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="adminlistsubcategory" class="nav-link">
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
                <a href="adminlistexpense" class="nav-link">
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
                <a href="adminlistincome" class="nav-link">
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
                <a href="adminlistcity" class="nav-link">
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
                <a href="adminnewstate" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add State</p>
                </a>
              </li>
              
              <li class="nav-item">
                <a href="adminliststate" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of State</p>
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
                <a href="adminvendor" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Vendor</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="adminlistvendor" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Vendor</p>
                </a>
              </li>
              </ul>
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
            <h1>Account DataTable</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="admindashboard">Home</a></li>
              <li class="breadcrumb-item active">Account DataTable</li>
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
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>Title</th>
                    <th>Amount</th>
                    <th>Description</th>
					<th>User</th>
					<!--<th>Last Name </th>-->
                    <th>Action</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${accountList}" var="m">
                  <tr>
                  <td>${m.accountTitle}</td>
                  <td>${m.accountAmount}</td>
                  <td>${m.description}</td>
                  <td>${m.firstName }</td>
				  
                  <td><a href="adminviewaccount?accountId=${m.accountId }"><i class="fas fa-eye"></i> </a> | <a href="admindeleteaccount?accountId=${m.accountId }"><i class="fa-solid fa-trash"></i></a> </td>
                  </tr> 
                  </c:forEach>  
                  </tbody>
                  <tfoot>
                  <tr>
                    <th>Title</th>
                    <th>Amount</th>
                    <th>Description</th>
					<th>User</th>
                    <th>Action</th>
                  </tr>
                  </tfoot>
                  
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
