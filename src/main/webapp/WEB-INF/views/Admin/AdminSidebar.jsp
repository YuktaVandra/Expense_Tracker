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
          <li class="nav-item menu-open">
            <a href="admindashboard" class="nav-link active">
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
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fa-solid fa-users"></i>
              <p>
                Account
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
            <%--  <li class="nav-item">
                <a href="manageaccount" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Account</p>
                </a>
              </li>--%>
              <li class="nav-item">
                <a href="adminlistaccount" class="nav-link">
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
              <%-- <li class="nav-item">
                <a href="manageexpense" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Expenses</p>
                </a>
              </li>--%>
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
              <%-- <li class="nav-item">
                <a href="manageincome" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Income</p>
                </a>
              </li>--%>
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
                <a href="adminnewcity" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add City</p>
                </a>
              </li>
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
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="fas fa-file-alt"></i>
              <p>
                Reports
                <i class="fas fa-angle-left right"></i>
                
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="adminreport1" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Report 1</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="adminreport2" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Report 2</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="adminreport3" class="nav-link">
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



