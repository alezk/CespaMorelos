
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
  <!-- DataTables -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/datatables/dataTables.bootstrap.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/iCheck/all.css">
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
  <!-- Select2 -->
  <link rel="stylesheet" href="<%=contex%>/Css/plugins/select2/select2.min.css">
   <!-- Theme style -->
  <link rel="stylesheet" href="<%=contex%>/Css/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="<%=contex%>/Css/dist/css/skins/skin-black-light.min.css">    
      
      
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="hold-transition skin-black-light sidebar-mini">
    <div class="wrapper">

      <!-- Main Header -->
      <header class="main-header">

        <!-- Logo -->
        <a href="<%=contex%>/Jsp/JspHomeCespa.jsp" class="logo">
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
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <!-- Menu toggle button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 4 messages</li>
                  <li>
                    <!-- inner menu: contains the messages -->
                    <ul class="menu">
                      <li><!-- start message -->
                        <a href="#">
                          <div class="pull-left">
                            <!-- User Image -->
                            <img src="<%=contex%>/Css/dist/img/user160x160-angel.jpg" class="img-circle" alt="User Image">
                          </div>
                          <!-- Message title and timestamp -->
                          <h4>
                            Support Team
                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                          </h4>
                          <!-- The message -->
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li><!-- end message -->
                    </ul><!-- /.menu -->
                  </li>
                  <li class="footer"><a href="#">See All Messages</a></li>
                </ul>
              </li><!-- /.messages-menu -->

              <!-- Notifications Menu -->
              <li class="dropdown notifications-menu">
                <!-- Menu toggle button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-bell-o"></i>
                  <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 10 notifications</li>
                  <li>
                    <!-- Inner Menu: contains the notifications -->
                    <ul class="menu">
                      <li><!-- start notification -->
                        <a href="#">
                          <i class="fa fa-users text-aqua"></i> 5 new members joined today
                        </a>
                      </li><!-- end notification -->
                    </ul>
                  </li>
                  <li class="footer"><a href="#">View all</a></li>
                </ul>
              </li>
              <!-- Tasks Menu -->
              <li class="dropdown tasks-menu">
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-flag-o"></i>
                  <span class="label label-danger">9</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 9 tasks</li>
                  <li>
                    <!-- Inner menu: contains the tasks -->
                    <ul class="menu">
                      <li><!-- Task item -->
                        <a href="#">
                          <!-- Task title and progress text -->
                          <h3>
                            Design some buttons
                            <small class="pull-right">20%</small>
                          </h3>
                          <!-- The progress bar -->
                          <div class="progress xs">
                            <!-- Change the css width attribute to simulate progress -->
                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">20% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item -->
                    </ul>
                  </li>
                  <li class="footer">
                    <a href="#">View all tasks</a>
                  </li>
                </ul>
              </li>
              <!-- User Account Menu -->
              <li class="dropdown user user-menu">
                <!-- Menu Toggle Button -->
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <!-- The user image in the navbar-->
                  <img src="<%=contex%>/Css/dist/img/user160x160-angel.jpg" class="user-image" alt="User Image">
                  <!-- hidden-xs hides the username on small devices so only the image appears. -->
                  <span class="hidden-xs">Ángel Estrada</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- The user image in the menu -->
                  <li class="user-header">
                    <img src="<%=contex%>/Css/dist/img/user160x160-angel.jpg" class="img-circle" alt="User Image">
                    <p>
                      Ángel Estrada - Director
                      <small>Member since Nov. 2012</small>
                    </p>
                  </li>
                  <!-- Menu Body -->
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="#" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

          <!-- Sidebar user panel (optional) -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="<%=contex%>/Css/dist/img/user160x160-angel.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>Ángel Estrada</p>
              <!-- Status -->
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>

          <!-- search form (Optional) -->
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
            <li class="header">NAVEGACIÓN</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview active">
              <a href="#"><i class="glyphicon glyphicon-home text-red"></i> <span>Centros</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="centros.html">Ejemplo Reportes</a></li>
                <li><a href="#">Link in level 2</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="glyphicon glyphicon-list-alt text-purple"></i> <span>Reportes</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="#">Ejemplo Reportes</a></li>
                <li><a href="#">Link in level 2</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-building text-fuchsia"></i> <span>Inmuebles</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="inmuebles.html">Ejemplo Inmuebles</a></li>
                <li><a href="#">Link in level 2</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-users text-orange"></i> <span>Administrativos</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="administrativos.html">Ejemplo Administrativos</a></li>
                <li><a href="#">Link in level 2</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="glyphicon glyphicon-bullhorn text-yellow"></i> <span>Conductores</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="conductores.html">Ejemplo Conductores</a></li>
                <li><a href="#">Link in level 2</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#"><i class="fa fa-book text-green"></i> <span>Asesores</span> <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
                <li><a href="asesores.html">Ejemplo Asesores</a></li>
                <li><a href="#">Link in level 2</a></li>
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
            Centros
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
          <!-- START CUSTOM TABS -->
          <h2 class="page-header">Administración de Centros</h2>
          <div class="row">
            <div class="col-md-12">
              <!-- Custom Tabs -->
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                  <li class="active"><a href="#tab_1" data-toggle="tab">Registrar Centro</a></li>
                  <li><a href="#tab_2" data-toggle="tab">Ver Centros</a></li>
                  <li><a href="#tab_3" data-toggle="tab">Reporte de Centro</a></li>
                </ul>
                <div class="tab-content">
                  <div class="tab-pane active" id="tab_1">
                  
                      <div class="box box-fuchsia">
                        <div class="box-header with-border">
                          <h3 class="box-title">Datos del Centro</h3>
                        </div>
                        <div class="box-body">
                          <p class="text-danger">Los campos marcados con (*) son obligatorios.</p>
                          <div class="row">
                            <div class="col-md-4">
                              <input type="text" class="form-control" placeholder="Número de registro *">
                            </div>
                            <div class="col-md-4">
                              <input type="text" class="form-control" placeholder="Nombre del centro de asosoría *">
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <select class="form-control select2">
                                  <option selected="selected">Municipio *</option>
                                  <option>Cuernavaca</option>
                                  <option>Cuautla</option>
                                  <option>Temixco</option>
                                  <option>Xochitepec</option>
                                </select>
                              </div><!-- /.form-group -->
                            </div>
                          </div><!--/row-->
                            <p>Seleccione la documentación que ha sido entregada:</p>
                          <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-6">
                                      <div class="form-group">
                                        <label>
                                          <input type="checkbox" class="minimal-red">
                                            Horarios
                                        </label>
                                      </div>
                                      <div class="form-group">
                                        <label>
                                          <input type="checkbox" class="minimal-red">
                                            Publicidad
                                        </label>
                                      </div>
                                      <div class="form-group">
                                        <label>
                                          <input type="checkbox" class="minimal-red">
                                            Logo y lema
                                        </label>
                                      </div>
                                    </div>
                                    <div class="col-md-6">
                                      <div class="form-group">
                                        <label>
                                          <input type="checkbox" class="minimal-red">
                                            Inventario
                                        </label>
                                      </div>
                                      <div class="form-group">
                                        <label>
                                          <input type="checkbox" class="minimal-red">
                                            Reglamento
                                        </label>
                                      </div>
                                      <div class="form-group">
                                        <label>
                                          <input type="checkbox" class="minimal-red">
                                            Fotos
                                        </label>
                                      </div>
                                    </div>
                                </div>
                            </div>  
                            <div class="col-md-6">
                                <textarea class="form-control" placeholder="Comentarios" rows="6"></textarea>
                            </div>
                          </div><!--/row-->
                          <div class="row">
                              <div class="col-md-4">
                                <button class="btn btn-success btn-action btn-lg" type="submit">Registrar</button>
                                <button class="btn btn-orange btn-action btn-lg" type="clear">Cancelar</button>
                              </div>
                          </div><!--/row-->

                        </div><!-- /.box-body -->
                      </div><!-- /.box -->
                      
                  </div><!-- /.tab-pane -->
                  <div class="tab-pane" id="tab_2">

                      <div class="box box-fuchsia">
                        <div class="box-header">
                          <h3 class="box-title">Ver Datos</h3>
                        </div><!-- /.box-header -->
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">
                                  <table id="example2" class="table table-bordered table-striped">
                                    <thead>
                                      <tr>
                                        <th>No. Registro</th>
                                        <th>Centro de asesoría</th>
                                        <th>Conductor de plática</th>
                                        <th>Horarios</th>
                                        <th>Inventario</th>
                                        <th>Logo y lema</th>
                                        <th>Publicidad</th>
                                        <th>Reglamento</th>
                                        <th>Fotos</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Colegio Teocalli A.C (La Luna)</td>
                                        <td>Mandan a los chicos al CESPA</td>
                                        <td>Actualizar</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17047</td>
                                        <td>Preparatoria Nueva Opción S.C.</td>
                                        <td>Lic. Mariano Colector GutiÃ©rrez</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>No</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Centro Universitario Americano del Estado de Morelos</td>
                                        <td>Lic. Ricardo Alcalá Reynaud</td>
                                        <td>SI</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Colegio Teocalli A.C (La Luna)</td>
                                        <td>Mandan a los chicos al CESPA</td>
                                        <td>Actualizar</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17047</td>
                                        <td>Preparatoria Nueva Opción S.C.</td>
                                        <td>Lic. Mariano Colector GutiÃ©rrez</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>No</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Centro Universitario Americano del Estado de Morelos</td>
                                        <td>Lic. Ricardo Alcalá Reynaud</td>
                                        <td>SI</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Colegio Teocalli A.C (La Luna)</td>
                                        <td>Mandan a los chicos al CESPA</td>
                                        <td>Actualizar</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17047</td>
                                        <td>Preparatoria Nueva Opción S.C.</td>
                                        <td>Lic. Mariano Colector GutiÃ©rrez</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>No</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Centro Universitario Americano del Estado de Morelos</td>
                                        <td>Lic. Ricardo Alcalá Reynaud</td>
                                        <td>SI</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Colegio Teocalli A.C (La Luna)</td>
                                        <td>Mandan a los chicos al CESPA</td>
                                        <td>Actualizar</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17047</td>
                                        <td>Preparatoria Nueva Opción S.C.</td>
                                        <td>Lic. Mariano Colector GutiÃ©rrez</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>No</td>
                                      </tr>
                                      <tr>
                                        <td>CUE17035</td>
                                        <td>Centro Universitario Americano del Estado de Morelos</td>
                                        <td>Lic. Ricardo Alcalá Reynaud</td>
                                        <td>SI</td>
                                        <td>No</td>
                                        <td>Si</td>
                                        <td>Si</td>
                                        <td>No</td>
                                        <td>Si</td>
                                      </tr>

                                    </tbody>
                                    <tfoot>
                                      <tr>
                                        <th>No. Registro</th>
                                        <th>Centro de asesoría</th>
                                        <th>Conductor de plática</th>
                                        <th>Horarios</th>
                                        <th>Inventario</th>
                                        <th>Logo y lema</th>
                                        <th>Publicidad</th>
                                        <th>Reglamento</th>
                                        <th>Fotos</th>
                                      </tr>
                                    </tfoot>
                                  </table>
                                </div>
                            </div><!-- /row -->
                        
                          <div class="row">
                              <div class="col-md-4">
                                <button class="btn btn-success btn-action btn-lg" type="submit">Modificar</button>
                                <button class="btn btn-orange btn-action btn-lg" type="clear">Eliminar</button>
                                <button class="btn btn-primary btn-action btn-lg" type="clear">Generar Reporte</button>
                              </div>
                          </div><!--/row-->
                        </div><!-- /.box-body -->
                      </div><!-- /.box -->
                      
                  </div><!-- /.tab-pane -->
                  <div class="tab-pane" id="tab_3">

                      <div class="box box-fuchsia">
                        <div class="box-header with-border">
                          <h3 class="box-title">Datos del Centro</h3>
                        </div>
                        <div class="box-body">
                          <dl class="dl-horizontal">
                            <dt>Número de Registro:</dt>
                            <dd>CUE17316</dd>
                            <dt>Nombre:</dt>
                            <dd>Centro Universitario Americano del Estado de Morelos</dd>
                            <dt class="text-fuchsia">Datos del Inmueble</dt>
                            <dd></dd>
                            <dt>Fecha de apertura:</dt>
                            <dd>12/08/2010</dd>

                          </dl>
                        </div><!-- /.box-body -->
                      </div><!-- /.box -->
                      
                      <div class="box box-teal">
                        <div class="box-header with-border">
                          <h3 class="box-title">Documentación</h3>
                        </div>
                        <div class="box-body">
                            
                            
                          <div class="row">
                            <div class="col-md-4">
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Acta constitutiva
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Visto bueno de protección civil
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Constancia de uso de suelo
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Constancia de seguridad estructural
                                </label>
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Horario
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Inventario
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Logo y lema
                                </label>
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Publicidad
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Reglamento
                                </label>
                              </div>
                              <div class="form-group">
                                <label>
                                  <input type="checkbox" checked="" class="minimal-red">
                                    Fotos
                                </label>
                              </div>
                            </div>
                          </div>
                            
                        </div><!-- /.box-body -->
                      </div><!-- /.box -->
                      
                      <div class="box box-lime">
                        <div class="box-header with-border">
                          <h3 class="box-title">Personal</h3>
                        </div>
                        <div class="box-body">
                          <dl class="dl-horizontal">
                            <dt>Propietario:</dt>
                            <dd>Ing. Salvador Ávila Arias</dd>
                            <dt>Responsable:</dt>
                            <dd>Ing. Salvador Ávila Arias</dd>
                            <dt>Gestor:</dt>
                            <dd>Ing. Henry Ávila Ascencio</dd>
                            <dt>Suplente de gestor:</dt>
                            <dd>Lic. Bertha Anguiano</dd>
                            <dt>Conductor de Plática:</dt>
                            <dd>Lic. Ricardo Alcalá Reynaud</dd>
                            <dt>Número de Asesores:</dt>
                            <dd>12</dd>
                          </dl>
                        </div><!-- /.box-body -->
                      </div><!-- /.box -->  
                      
                  </div><!-- /.tab-pane -->
                </div><!-- /.tab-content -->
              </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->

          </div> <!-- /.row -->
          <!-- END CUSTOM TABS -->



        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
        	<img src="<%=contex%>/Css/dist/img/logo/logo-morelos-90.png" width="90" height="30" alt="Visión Morelos"> </div>
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



    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>

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
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<%=contex%>/Css/dist/js/pages/dashboard.js"></script>

    <!-- jQuery 2.1.4 -->
    <script src="<%=contex%>/Css/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="<%=contex%>/Css/bootstrap/js/bootstrap.min.js"></script>
    <!-- DataTables -->
    <script src="<%=contex%>/Css/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="<%=contex%>/Css/plugins/datatables/dataTables.bootstrap.min.js"></script>
    <!-- Select2 -->
    <script src="<%=contex%>/Css/plugins/select2/select2.full.min.js"></script>
    <!-- InputMask -->
    <script src="<%=contex%>/Css/plugins/input-mask/jquery.inputmask.js"></script>
    <script src="<%=contex%>/Css/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="<%=contex%>/Css/plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <!-- date-range-picker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="<%=contex%>/Css/plugins/daterangepicker/daterangepicker.js"></script>
    <!-- iCheck 1.0.1 -->
    <script src="<%=contex%>/Css/plugins/iCheck/icheck.min.js"></script>
    <!-- AdminLTE App -->
    <script src="<%=contex%>/Css/dist/js/app.min.js"></script>
    <!-- Page script -->
    <script>
      $(function () {
        //Initialize Select2 Elements
        $(".select2").select2();
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
          checkboxClass: 'icheckbox_minimal-blue',
          radioClass: 'iradio_minimal-blue'
        });
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
          checkboxClass: 'icheckbox_minimal-red',
          radioClass: 'iradio_minimal-red'
        });
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
          checkboxClass: 'icheckbox_flat-red',
          radioClass: 'iradio_flat-red'
        });
      });
    </script>
      
    <script>
      $(function () {
        $('#example2').DataTable({
          "paging": true,
          "lengthChange": true,
          "searching": true,
          "ordering": true,
          "info": true,
          "autoWidth": true
        });
      });
    </script>
      
</body>
</html>

