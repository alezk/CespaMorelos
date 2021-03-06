<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String contex = request.getContextPath();%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- Logo mini cespa, pestañas del navegador -->
  <link rel="shortcut icon" href="<%=contex%>/Css/dist/img/logo/visionmorelos.png">
  <title>Coordinación Estatal del Subsistema de Preparatoria Abierta</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="<%=contex%>/Css/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=contex%>/Css/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="<%=contex%>/Css/dist/css/skins/skin-black-light.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <link rel="stylesheet" type="text/css" href="<%=contex%>/Css/bootstrap/css/bootstrap.css" />
  <link rel="stylesheet" type="text/css" href="<%=contex%>/Css/bootstrap/css/bootstrap-responsive.css" />
  <script type="text/javascript" src="<%=contex%>/Css/bootstrap/js/jquery.js"></script>
  <script type="text/javascript" src="<%=contex%>/Css/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body class="hold-transition skin-black-light sidebar-mini">
    <div class="wrapper">

      <!-- Main Header -->
      <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><img src="<%=contex%>/Css/dist/img/logo/logo-cespa-50.png" width="50" height="50" alt="CESPA"></span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><img src="<%=contex%>/Css/dist/img/logo/logo-cespa-200.png" width="200" height="50" alt="CESPA"></span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

          <!-- Sidebar user panel (optional) 
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<%=contex%>/Css/dist/img/user160x160-angel.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>Ángel Estrada</p>
                /*Status*/ 
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          -->
          
          <!-- search form (Optional) 
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->

          <!-- Sidebar Menu -->
          <ul class="sidebar-menu">
            <!--<li class="header">NAVEGACIÓN</li>-->
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview active">
              <a href="#"><i class="glyphicon glyphicon-unchecked text-red"></i><span>Dirección</span><i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="<%=contex%>/Jsp/JspCentrosAsesoria.jsp">Semanal</a></li>
                <li><a href="<%=contex%>/Jsp/JspCentrosAsesoria.jsp">Etapas</a></li>
                
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="glyphicon glyphicon-unchecked text-purple"></i> <span>Planeación</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="#">Exámenes Ordinarios</a></li>
                <li><a href="#">Exámenes Extemporáneos</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="glyphicon glyphicon-unchecked text-fuchsia"></i> <span>Académico</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="#">Plan 22</a></li>
                <li><a href="#">Plan 33</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="glyphicon glyphicon-unchecked text-orange"></i> <span>Regulación</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="#">Centro Social</a></li>
                <li><a href="#">Centro Particular</a></li>
                <li><a href="#">Detalle Social</a></li>
                <li><a href="#">Detalle Particular</a></li>
              </ul>
            </li>
            
          </ul><!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Página de Inicio
            <small>Contenido Opcional</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Nivel</a></li>
            <li class="active">Página Actual</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">

<!-- **************************************** Your Page Content Here **************************************** -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
        	<img src="<%=contex%>/Css/dist/img/logo/logo-morelos-90.png" width="90" height="30" alt="Visión Morelos"> 
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2015 <a href="#">Secretaría de Educación Estado de Morelos</a>.</strong> Derechos Reservados.
      </footer>

      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane active" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                    <p>Will be 23 on April 24th</p>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <h4 class="control-sidebar-subheading">
                    Custom Template Design
                    <span class="label label-danger pull-right">70%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
              <h3 class="control-sidebar-heading">General Settings</h3>
              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Report panel usage
                  <input type="checkbox" class="pull-right" checked>
                </label>
                <p>
                  Some information about this general settings option
                </p>
              </div><!-- /.form-group -->
            </form>
          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->

    <!-- jQuery 2.1.4 -->
    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.5 -->
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="<%=contex%>/Css/plugins/morris/morris.min.js"></script>
    <!-- Sparkline -->
    <script src="<%=contex%>/Css/plugins/sparkline/jquery.sparkline.min.js"></script>
    <!-- jvectormap -->
    <script src="<%=contex%>/Css/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="<%=contex%>/Css/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <!-- jQuery Knob Chart -->
    <script src="<%=contex%>/Css/plugins/knob/jquery.knob.js"></script>
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="<%=contex%>/Css/plugins/daterangepicker/daterangepicker.js"></script>
    <!-- datepicker -->
    <script src="<%=contex%>/Css/plugins/datepicker/bootstrap-datepicker.js"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<%=contex%>/Css/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <!-- Slimscroll -->
    <script src="<%=contex%>/Css/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="<%=contex%>/Css/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="<%=contex%>/Css/dist/js/app.min.js"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<%=contex%>/Css/dist/js/pages/dashboard.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<%=contex%>/Css/dist/js/demo.js"></script>
  </body>
</html>
