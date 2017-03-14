<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>校园  心理咨询平台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/AdminTLE/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/AdminTLE/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/AdminTLE/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script href="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script href="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="skin-blue sidebar-mini">
  <div class="wrapper">
    <header class="main-header">
      <a class="logo" href="#">
        <span class="logo-mini">
          <b>A</b>LT
        </span>
      <span class="logo-lg">
        <span>心理咨询</span>
        平台
      </span>
      </a>
      <nav class="navbar navbar-static-top" role="navigation">
        <a class="sidebar-toggle" href="#" data-toggle="offcanvas" role="button"></a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <li>
              <a href="#">
                <i class="fa fa-gears"></i>        退出
              </a>
              </li>
            </ul>
          </div>

      </nav>
    </header>
    <aside class="main-sidebar">
      <section class="sidebar" style="height: auto">
        <ul class="sidebar-menu">
          <li class="header">MAIN NAVNATION</li>
          <li class="treeview">
            <a href="#">
              <i class="fa fa-dashboard"></i>
              <span>DashBoard</span>
              <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
            </a>
            <ul class="treeview-menu">
              <li>
                <a href="teacherManagement">
                  <i class="fa fa-circle-o"></i>
                  老师管理
                </a>
              </li>
              <li>
                <a href="studentsManagement">
                  <i class="fa fa-circle-o"></i>
                  学生管理
                </a>
              </li>
              <li>
                <a href="articleManagement">
                  <i class="fa fa-circle-o"></i>
                  文章管理
                </a>
              </li>
              <li>
                <a href="picture_setting">
                  <i class="fa fa-circle-o"></i>
                  封面轮播图片设置
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </section>
    </aside>
    <div class="content-wrapper" style="min-height: 350px;">
      <section class="content-header">
        <h1>
          Page Header fucking
          <small>you can do anything </small>
        </h1>
      </section>
      <section class="content">

      </section>
    </div>
    <footer class="main-footer">
      <strong>Copyright © 2017 <a href="#">计算机学院</a>.</strong>All rights reserved.
    </footer>
  </div>

  <!-- jQuery 2.2.3 -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/jQuery/jquery-2.2.3.min.js"></script>
  <!-- Bootstrap 3.3.6 -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/bootstrap/js/bootstrap.min.js"></script>
  <!-- FastClick -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/fastclick/fastclick.js"></script>
  <!-- AdminLTE App -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/dist/js/app.min.js"></script>
  <!-- Sparkline -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/sparkline/jquery.sparkline.min.js"></script>
  <!-- jvectormap -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
  <!-- SlimScroll 1.3.0 -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <!-- ChartJS 1.0.1 -->
  <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/chartjs/Chart.min.js"></script>
<%--  <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
  <script src="static/AdminTLE/dist/js/pages/dashboard2.js"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="static/AdminTLE/dist/js/demo.js"></script>--%>
  </body>
</html>
