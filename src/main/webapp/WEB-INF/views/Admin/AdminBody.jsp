<section class="content">
      <div class="container-fluid">
        
        
        
        
        <div class="row">
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>${totalUsers }</h3>

                <p>Users</p>
              </div>
              <div class="icon">
                <i class="fa-solid fa-users  " style="font-size: 30px;"></i>
              </div>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                <h3>${thisMonthUsersCount }</h3>

                <p>Active Users (This Month)</p>
              </div>
              <div class="icon">
                <i class="fa-solid fa-user-check" style="font-size: 30px;"></i>
              </div>
              
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-warning">
              <div class="inner">
                <h3>${expensePercentage}%</h3>

                <p>Monthly Expense Overview</p>
              </div>
              <div class="icon">
                <i class="fa-solid fa-calendar" style="font-size: 30px;"></i>
              </div>
            </div>
          </div>
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-danger">
              <div class="inner">
                <h3>${thisMonthDuePayments}&#x20B9</h3>

                <p>Due Payments Alert </p>
              </div>
              <div class="icon">
                <i class="fa fa-bell" style="font-size: 30px;"></i>
              </div>
            </div>
          </div>
          <!-- ./col -->
        </div>
        
        <div class="card card-success">
              <div class="card-header" style="background-color: #3498DB">
                <h3 class="card-title" >Bar Chart</h3>

                
              </div>
              <div class="card-body">
                <div class="chart"><div class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand"><div class=""></div></div><div class="chartjs-size-monitor-shrink"><div class=""></div></div></div>
                  <canvas id="barChart" style="min-height: 250px; height: 250px; max-height: 250px; max-width: 100%; display: block; width: 707px;" width="1414" height="500" class="chartjs-render-monitor"></canvas>
                </div>
              </div>
              <!-- /.card-body -->
            </div>
        
            
            
      </div><!-- /.container-fluid -->
    </section>