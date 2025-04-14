<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Report 2 (Total Balance Across All Accounts)</title>

  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="../../plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <link rel="stylesheet" href="../../plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
  <style>
  #accountPieChart {
    width: 250px !important;
    height: 250px !important;
  }
</style>
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <jsp:include page="UserHeader.jsp" />

  <!-- Sidebar code (same as your existing code)... -->
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
            <a href="home" class="nav-link">
              <i class="fa-solid fa-house"></i>
              <p>
                Home 
                
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
                <a href="listaccount" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List of Account</p>
                </a>
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
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="fas fa-file-alt"></i>
              <p>
                Reports
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="report1" class="nav-link ">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Report 1</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="report2" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Report 2</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="report3" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Report 3</p>
                </a>
              </li>
              </ul>
          </li>
          
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper -->
  <div class="content-wrapper">
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Total Balance Across All Accounts</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home">Home</a></li>
              <li class="breadcrumb-item active">Total Balance</li>
            </ol>
          </div>
        </div>
      </div>
    </section>

    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                    <tr><th>Total Balance Across All Accounts</th>
                    <th>Pie Chart</th></tr>
                  </thead>
                  <tbody>
                    <tr><td>${totalAccountAmount} &#x20B9;</td>
                      <td>
                        <canvas id="accountPieChart" style="width:250px !important; height:250px !important;"></canvas>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>

  <jsp:include page="Admin/AdminFooter.jsp" />

  <aside class="control-sidebar control-sidebar-dark"></aside>
</div>



<script src="https://kit.fontawesome.com/9d21862bba.js" crossorigin="anonymous"></script>
<script src="../../plugins/jquery/jquery.min.js"></script>
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="../../plugins/jszip/jszip.min.js"></script>
<script src="../../plugins/pdfmake/pdfmake.min.js"></script>
<script src="../../plugins/pdfmake/vfs_fonts.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="../../plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<script src="../../dist/js/adminlte.min.js"></script>
<script src="../../dist/js/demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
  $(function () {
    const table = $("#example1").DataTable({
      responsive: true,
      lengthChange: false,
      autoWidth: false,
      buttons: [
        "copy",
        "csv",
        "excel",
        {
          extend: "pdfHtml5",
          text: "PDF",
          customize: function (doc) {
            // Get chart as image
            const chart = document.getElementById('accountPieChart'); // Make sure your chart's ID is correct
            if (chart) {
              const chartImage = chart.toDataURL("image/png");
              // Add image to the PDF before the table
              doc.content.splice(0, 0, {
                image: chartImage,
                width: 200, // adjust width
                alignment: 'center',
                margin: [0, 0, 0, 12]
              });
            }
          }
        },
        "print",
        "colvis"
      ]
    });

    table.buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');

    $('#example2').DataTable({
      paging: true,
      lengthChange: false,
      searching: false,
      ordering: true,
      info: true,
      autoWidth: false,
      responsive: true
    });
  });
</script>


<!-- Chart.js Script -->
<script>
  const ctx = document.getElementById('accountPieChart').getContext('2d');

  const accountTitles = [<c:forEach var="label" items="${labels}" varStatus="loop">${loop.index > 0 ? ',' : ''}'${label}'</c:forEach>];
  const accountBalances = [<c:forEach var="val" items="${values}" varStatus="loop">${loop.index > 0 ? ',' : ''}${val}</c:forEach>];

  new Chart(ctx, {
    type: 'pie',
    data: {
      labels: accountTitles,
      datasets: [{
        label: 'Account Balances',
        data: accountBalances,
        backgroundColor: [
          '#007bff', '#28a745', '#ffc107', '#dc3545', '#6610f2', '#6f42c1',
          '#17a2b8', '#e83e8c', '#20c997', '#fd7e14'
        ],
        borderColor: '#fff',
        borderWidth: 1
      }]
    },
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'bottom'
        },
        title: {
          display: true,
          text: 'Account Balance Distribution'
        }
      }
    }
  });
</script>

</body>
</html>
