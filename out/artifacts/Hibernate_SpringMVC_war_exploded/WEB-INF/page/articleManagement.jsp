
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/AdminTLE/plugins/datatables/dataTables.bootstrap.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script href="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script href="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="skin-blue sidebar-mini">

<div id="modal_1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="fa fa-warning" aria-hidden="true"></span>
                    警告
                </h4>
            </div>
            <div class="modal-body">
                <p>删除后的文章将无法恢复，你确定删除文章吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="submit_delete_article" type="button" class="btn btn-primary">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


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
                            <i class="fa fa-gears"></i>        退出c
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
                <li class="treeview active">
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
                        <li class="active">
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
            <h3>文章管理</h3>
            <div class="breadcrumb">
                <a class="btn btn-danger btn-sm" href="articleEditor">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </a>
            </div>
        </section>
        <section class="content">
            <div id="row1" class="row">

            </div>
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
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/chartjs/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/baiduTemplate/baiduTemplate.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<%--  <script src="static/dist/js/pages/dashboard2.js"></script>--%>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/dist/js/demo.js"></script>

<!-- Template script-->
<script id="tp2" type="text/template">
[%
    for(var i in jsondata){
     var item=jsondata[i];
%]
<div class="col-md-6">
    <div class="box box-widget">
        <div class="box-header with-border">
            <div class="user-block">
                                <span class="username">
                                   [%= item.author %]
                                </span>
                                <span class="description">
                                   [%= item.article_build_date %]
                                </span>
            </div>
            <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            </div>
        </div>
        <div class="box-body">
            <div class="attachment-block clearfix" style="height: 100px">
                <img class="attachment-img" src="[%= item.article_picture %]">
                <div class="attachment-pushed">
                    <h4 class="attachment-heading">
                        [%= item.article_title %]
                    </h4>
                </div>
            </div>
            <span class="pull-right text-muted">[%= item.watched_num %] 阅读数 - [%= item.comment_num %] 评论数 - [%= item.good_num %] 点赞数</span>
        </div>
        <div class="box-footer">
            <button id="delete_[%= item.article_id %]" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal_1" onclick="delete_article(this.id)">删除</button>
            <button id="[%= item.article_id %]" class="btn btn-primary btn-sm" onclick="load_article(this.id)">查看</button>
            <button id="edit_[%= item.article_id %]" class="btn btn-primary btn-sm" onclick="edit_article(this.id)">编辑</button>
        </div>
    </div>
</div>
[%
    }
%]
</script>

<!-- Page script-->
<script type="text/javascript">
    $.getJSON("${pageContext.request.contextPath}/upload/GET/PC/AllArticleList",function (jsondata) {
        document.getElementById('row1').innerHTML=baidu.template('tp2',jsondata);
    });
    function load_article(id) {
        window.open("${pageContext.request.contextPath}/index/article_pc?article_id="+id);
    }
    function edit_article(id) {
        var article_id=id.split('_')[1];
        window.open("${pageContext.request.contextPath}/index/articleEditor?article_id="+article_id);
    }
    function delete_article(id) {
        var article_id=id.split('_')[1];
        $('#submit_delete_article').click(function () {
            $('#modal_1').modal('hide');
            var article={'article_id':article_id};
            $.ajax({
                url:"${pageContext.request.contextPath}/upload/delete/Article",
                type:"POST",
                data:JSON.stringify(article),
                contentType:"application/json",
                dataType:"json",
                success:function (data) {
                    alert(data.StatusCode);
                    window.location.reload();
                },
                error:function () {
                    alert("no");
                }
            })
        })
    }
</script>
</body>
</html>
