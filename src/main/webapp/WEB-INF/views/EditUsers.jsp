<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html style="height: auto; min-height: 100%;">
 <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>User Profile </title>
 
   <!-- Google Font: Source Sans Pro -->
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
   <!-- Font Awesome -->
   <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
   <!-- Ionicons -->
   <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
   <!-- Tempusdominus Bootstrap 4 -->
   <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
   <!-- iCheck -->
   <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
   <!-- JQVMap -->
   <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
   <!-- Theme style -->
   <link rel="stylesheet" href="dist/css/adminlte.min.css">
   <!-- overlayScrollbars -->
   <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
   <!-- Daterange picker -->
   <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
   <!-- summernote -->
   <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
 </head>
 
 <body class="hold-transition sidebar-mini layout-fixed">
 <div class="wrapper">
 
   <!-- Preloader -->
   <div class="preloader flex-column justify-content-center align-items-center">
     <img class="animation__shake" src="dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
   </div>
 
 
 
 <jsp:include page="Admin/AdminHeader.jsp"></jsp:include>
 
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
           <a href="edituser?userId=${user.userId } " class="d-block">${user.firstName} ${user.lastName }</a>
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
        
       </nav>
       <!-- /.sidebar-menu -->
     </div>
     <!-- /.sidebar -->
   </aside>
   
 
 <div class="content-wrapper" style="min-height: 1604.71px;">
     <!-- Content Header (Page header) -->
     <section class="content-header">
       <div class="container-fluid">
         <div class="row mb-2">
           <div class="col-sm-6">
             <h1>Profile</h1>
           </div>
           <div class="col-sm-6">
             <ol class="breadcrumb float-sm-right">
               <li class="breadcrumb-item"><a href="home">Home</a></li>
               <li class="breadcrumb-item active">User Profile</li>
             </ol>
           </div>
         </div>
       </div><!-- /.container-fluid -->
     </section>
 
     <!-- Main content -->
     <section class="content">
       <div class="container-fluid">
         <div class="row">
           <div class="col-md-3">
 
             <!-- Profile Image -->
             <div class="card card-primary card-outline">
               <div class="card-body box-profile">
                 <div class="text-center">
                   <img class="profile-user-img img-fluid img-circle" id="dynamicImage"  src="${user.profilePicPath }"  alt="User profile picture">
                 </div>
 
                 <h3 class="profile-username text-center" >${user.firstName } ${user.lastName }</h3>
 
                 <p class="text-muted text-center">${user.role }</p>
 
                 
 
                 <a href="logout" class="btn btn-primary btn-block"><b>Logout</b></a>
               </div>
               <!-- /.card-body -->
             </div>
             <!-- /.card -->
 
             </div>
           <div class="col-md-9">
             <div class="card">
               <div class="card-header p-2">
                 <ul class="nav nav-pills">
                   <li class="nav-item" style="font-size: 25px;">Update Profile</li>
                 </ul>
               </div><!-- /.card-header -->
               <div class="card-body">
                   <div class="tab-pane active" id="settings">
                     <form class="form-horizontal" action="updateuser" method="post">
                       <div class="form-group row">
                         <label for="inputName"  class="col-sm-2 col-form-label">First Name</label>
                         <div class="col-sm-10">
                           <input name="firstName" type="text" value="${user.firstName }" class="form-control" id="inputName" >
                         </div>
                       </div>
                       <div class="form-group row">
                         <label for="inputName"  class="col-sm-2 col-form-label">Last Name</label>
                         <div class="col-sm-10">
                           <input name="lastName" type="text" value="${user.lastName }" class="form-control" id="inputName" >
                         </div>
                       </div>
                       <div class="form-group row">
                         <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                         <div class="col-sm-10">
                           <input type="email" name="email" value="${user.email }" class="form-control" id="inputEmail" >
                         </div>
                       </div>
                       <div class="form-group row">
                         <label for="inputName2" class="col-sm-2 col-form-label">Contact No.</label>
                         <div class="col-sm-10">
                           <input type="text" name="contactNo" value="${user.contactNo }" class="form-control" id="inputName2" >
                         </div>
                       </div>
                       <div class="form-group row">
                         <label for="inputName2" class="col-sm-2 col-form-label">Profile Picture</label>
                         <div class="col-sm-10">
                           <input type="file" name="profilePicPath" value="${user.profilePicPath }" class="form-control" id="inputName2">
                         </div>
                       </div>
                       <div class="form-group row">
                         <div class="offset-sm-2 col-sm-10">
                           <button type="submit" class="btn btn-danger">Submit</button>
                         </div>
                       </div>
                       <input type="hidden" name="userId" value="${user.userId }"/>
                     </form>
                   </div>
                   <!-- /.tab-pane -->
                 </div>
                 <!-- /.tab-content -->
               </div><!-- /.card-body -->
             </div>
             <!-- /.card -->
           </div>
           <!-- /.col -->
         </div>
         <!-- /.row -->
         </section>
       </div>
     
   </div>
 
     <jsp:include page="Admin/AdminFooter.jsp"></jsp:include>
     
     <aside class="control-sidebar control-sidebar-dark" style="display: none;">
     <!-- Control sidebar content goes here -->
   <div class="p-3 control-sidebar-content" style=""><h5>Customize AdminLTE</h5><hr class="mb-2"><div class="mb-4"><input type="checkbox" value="1" class="mr-1"><span>Dark Mode</span></div><h6>Header Options</h6><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Fixed</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Dropdown Legacy Offset</span></div><div class="mb-4"><input type="checkbox" value="1" class="mr-1"><span>No border</span></div><h6>Sidebar Options</h6><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Collapsed</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Fixed</span></div><div class="mb-1"><input type="checkbox" value="1" checked="checked" class="mr-1"><span>Sidebar Mini</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Sidebar Mini MD</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Sidebar Mini XS</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Nav Flat Style</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Nav Legacy Style</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Nav Compact</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Nav Child Indent</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Nav Child Hide on Collapse</span></div><div class="mb-4"><input type="checkbox" value="1" class="mr-1"><span>Disable Hover/Focus Auto-Expand</span></div><h6>Footer Options</h6><div class="mb-4"><input type="checkbox" value="1" class="mr-1"><span>Fixed</span></div><h6>Small Text Options</h6><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Body</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Navbar</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Brand</span></div><div class="mb-1"><input type="checkbox" value="1" class="mr-1"><span>Sidebar Nav</span></div><div class="mb-4"><input type="checkbox" value="1" class="mr-1"><span>Footer</span></div><h6>Navbar Variants</h6><div class="d-flex"><select class="custom-select mb-3 text-light border-0 bg-white"><option class="bg-primary">Primary</option><option class="bg-secondary">Secondary</option><option class="bg-info">Info</option><option class="bg-success">Success</option><option class="bg-danger">Danger</option><option class="bg-indigo">Indigo</option><option class="bg-purple">Purple</option><option class="bg-pink">Pink</option><option class="bg-navy">Navy</option><option class="bg-lightblue">Lightblue</option><option class="bg-teal">Teal</option><option class="bg-cyan">Cyan</option><option class="bg-dark">Dark</option><option class="bg-gray-dark">Gray dark</option><option class="bg-gray">Gray</option><option class="bg-light">Light</option><option class="bg-warning">Warning</option><option class="bg-white">White</option><option class="bg-orange">Orange</option></select></div><h6>Accent Color Variants</h6><div class="d-flex"></div><select class="custom-select mb-3 border-0"><option>None Selected</option><option class="bg-primary">Primary</option><option class="bg-warning">Warning</option><option class="bg-info">Info</option><option class="bg-danger">Danger</option><option class="bg-success">Success</option><option class="bg-indigo">Indigo</option><option class="bg-lightblue">Lightblue</option><option class="bg-navy">Navy</option><option class="bg-purple">Purple</option><option class="bg-fuchsia">Fuchsia</option><option class="bg-pink">Pink</option><option class="bg-maroon">Maroon</option><option class="bg-orange">Orange</option><option class="bg-lime">Lime</option><option class="bg-teal">Teal</option><option class="bg-olive">Olive</option></select><h6>Dark Sidebar Variants</h6><div class="d-flex"></div><select class="custom-select mb-3 text-light border-0 bg-primary"><option>None Selected</option><option class="bg-primary">Primary</option><option class="bg-warning">Warning</option><option class="bg-info">Info</option><option class="bg-danger">Danger</option><option class="bg-success">Success</option><option class="bg-indigo">Indigo</option><option class="bg-lightblue">Lightblue</option><option class="bg-navy">Navy</option><option class="bg-purple">Purple</option><option class="bg-fuchsia">Fuchsia</option><option class="bg-pink">Pink</option><option class="bg-maroon">Maroon</option><option class="bg-orange">Orange</option><option class="bg-lime">Lime</option><option class="bg-teal">Teal</option><option class="bg-olive">Olive</option></select><h6>Light Sidebar Variants</h6><div class="d-flex"></div><select class="custom-select mb-3 border-0"><option>None Selected</option><option class="bg-primary">Primary</option><option class="bg-warning">Warning</option><option class="bg-info">Info</option><option class="bg-danger">Danger</option><option class="bg-success">Success</option><option class="bg-indigo">Indigo</option><option class="bg-lightblue">Lightblue</option><option class="bg-navy">Navy</option><option class="bg-purple">Purple</option><option class="bg-fuchsia">Fuchsia</option><option class="bg-pink">Pink</option><option class="bg-maroon">Maroon</option><option class="bg-orange">Orange</option><option class="bg-lime">Lime</option><option class="bg-teal">Teal</option><option class="bg-olive">Olive</option></select><h6>Brand Logo Variants</h6><div class="d-flex"></div><select class="custom-select mb-3 border-0"><option>None Selected</option><option class="bg-primary">Primary</option><option class="bg-secondary">Secondary</option><option class="bg-info">Info</option><option class="bg-success">Success</option><option class="bg-danger">Danger</option><option class="bg-indigo">Indigo</option><option class="bg-purple">Purple</option><option class="bg-pink">Pink</option><option class="bg-navy">Navy</option><option class="bg-lightblue">Lightblue</option><option class="bg-teal">Teal</option><option class="bg-cyan">Cyan</option><option class="bg-dark">Dark</option><option class="bg-gray-dark">Gray dark</option><option class="bg-gray">Gray</option><option class="bg-light">Light</option><option class="bg-warning">Warning</option><option class="bg-white">White</option><option class="bg-orange">Orange</option><a href="#">clear</a></select></div></aside>
 
    <script src="../../plugins/jquery/jquery.min.js"></script>
    
    <script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    <script src="../../dist/js/adminlte.min.js"></script>
    
    <script src="../../dist/js/demo.js"></script>
    
 
    <script>
         function changeImage() {
             let imgElement = document.getElementById("dynamicImage");
             imgElement.src = "${user.profilePicPath}";  // Change the image source
         }
     </script>
    
    
    <script src="https://kit.fontawesome.com/9d21862bba.js" crossorigin="anonymous"></script>
    </body>
    </html>