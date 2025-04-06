<<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="plugins/moment/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>

<!-- ✅ Place the corrected bar chart script here -->
<script>
$(document).ready(function () {
    var barChartCanvas = document.getElementById('barChart');

    if (!barChartCanvas) {
        console.error("Error: barChart canvas not found.");
        return;
    }

    var totalJanExpense = ${totalJanExpense};
    var totalFebExpense = ${totalFebExpense};
    var totalMarchExpense = ${totalMarchExpense};
    var thisMonthExpense = ${thisMonthExpense};

    var barChartData = {
        labels: ['January', 'February', 'March', 'April'],
        datasets: [
            {
                label: 'Expenses',
                backgroundColor: ['#3498DB', '#3498DB', '#3498DB', '#3498DB'],
                borderColor: '#FFFFFF',
                borderWidth: 1,
                data: [totalJanExpense, totalFebExpense, totalMarchExpense, thisMonthExpense]
            }
        ]
    };

    var barChartOptions = {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
            y: {
                beginAtZero: true
            }
        },
        plugins: {
            legend: {
                labels: {
                    usePointStyle: true,
                    boxWidth: 0
                }
            }
        }
    };

    new Chart(barChartCanvas.getContext('2d'), {
        type: 'bar',
        data: barChartData,
        options: barChartOptions
    });
});
</script>
