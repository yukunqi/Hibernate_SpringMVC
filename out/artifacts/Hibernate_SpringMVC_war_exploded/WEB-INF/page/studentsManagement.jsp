
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
                        <li class="active">
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
                学生管理
            </h1>
            <div class="breadcrumb">
                <a class="btn btn-danger btn-sm" href="addTeacher">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </a>
            </div>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">

                        </div>
                        <div class="box-body">
                            <div id="example1_wrapper" class="form-inline">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div id="example1_length" class="dataTable_length">
                                            <label>
                                                学生类型：<select id="user_type" class="form-control input-sm" name="example1_length" aria-controls="example1"></select>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div id="example1_filter" class="dataTables_filter">
                                            <label>
                                                Search: <input class="form-control input-sm" placeholder="" aria-controls="example1" type="search">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div  id="table1" class="col-sm-12">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-5">
                                    </div>
                                    <div class="col-sm-7">
                                        <div id="example1_paginate" class="dataTables_paginate paging_simple_number">
                                            <ul class="pagination" id="page_button_list">

                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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

<!-- TableData Template script-->
<script id="tp1" type="text/template">
    <table class="table table-bordered table-striped" role="grid" aria-describedby="example1_info">
        <thead>
        <tr role="row">
            <th class="sorting_asc" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="people number">序号</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="person name">用户名</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="teacher number">学生学号</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="college">学院</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="school">学校</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="gender">性别</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="teacher login_name">登录名</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="teacher email">邮箱</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="teacher phone_number">手机号</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="teacher phone_number">学生类型</th>
            <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="teacher phone_number">操作</th>

        </tr>
        </thead>
        <tbody>
        [%
        var i=0;
        var arr=[];
        for(var i in jsondata){
        var item=jsondata[i];
        %]
        <tr>
            <td>[%= i++ %]</td>
            <td>[%= item.username %]</td>
            <td>[%= item.login_name %]</td>
            <td>[%= item.college %]</td>
            <td>[%= item.school_name %]</td>
            <td>[%= item.gender %]</td>
            <td>[%= item.login_name %]</td>
            <td>[%= item.email %]</td>
            <td>[%= item.phone_number %]</td>
            <td>[%= item.userType.type_name %]</td>
            <td><button id="[%= item.id %]" type="button" onclick="open_page(this.id)" class="btn btn-block btn-info btn-sm">编辑</button></td>
        </tr>
        [%

        }

        %]
        </tbody>
        <tfoot>
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>学生学号</th>
            <th>学院</th>
            <th>学校</th>
            <th>性别</th>
            <th>登录名</th>
            <th>邮箱</th>
            <th>手机号</th>
            <th>学生类型</th>
            <th>操作</th>
        </tr>
        </tfoot>
    </table>
</script>
<!-- Page script-->
<script type="text/javascript">

    var page_num='${param.get("page")}';
    if (page_num==""){//第一次从侧标题栏加载进来时
        page_num=1;
    }


    $.ajax({
        url:"${pageContext.request.contextPath}/upload/GET/ExpertList/1/"+page_num,
        type:"GET",
        dataType:"json",
        success:function (data) {
            document.getElementById("table1").innerHTML=baidu.template('tp1',data);
            if (page_num>data.pageAmount){
                page_num=data.pageAmount;
            }
            if (page_num<=0){
                page_num=1;
            }
            load_page_button_1(page_num,1,data.pageAmount);
        },
        error:function () {
            alert("no");
        }
    });

    //跳转到编辑老师个人资料页面
    function open_page(id) {
        window.location.href="editTeacher?id="+id
    }
    var li,a,text={};
    var i,next_page,pre_page=0;
    var div_id="page_button_list";//整个分页导航所在的父结构元素id
    /**
     * 生成分页导航
     * @param current_page 当前页数
     * @param first_page   首页
     * @param final_page   末尾页
     * 当当前页和首页(或者末尾页)<=4页时 不产生省略图标 其余情况产生
     * 一共4种情况对应下面4个if语句
     */
    function load_page_button_1(current_page,first_page,final_page) {

        if (current_page-first_page<=3&&final_page-current_page>=4){

            create_previous_button(current_page,first_page,pre_page);

            for(i=1;i<=(current_page-'0')+2;i++){
                li=document.createElement('li');
                if(current_page==i){
                    li.setAttribute('class','paginate_button active');
                }else{
                    li.setAttribute('class','paginate_button');
                }
                a=document.createElement('a');
                a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+i);
                a.setAttribute('aria-controls','example1');
                a.setAttribute('data-dt-idx','0');
                a.setAttribute('tabindex','0');
                text=document.createTextNode(i+"");
                a.appendChild(text);
                li.appendChild(a);
                document.getElementById('page_button_list').appendChild(li);
            }

            create_quote_button();

            create_final_button(final_page);

            create_next_button(current_page,final_page,next_page);

        }

        if (current_page-first_page<=3&&final_page-current_page<=3){
            create_previous_button(current_page,first_page,pre_page);

            for(i=1;i<=(final_page-'0');i++){
                li=document.createElement('li');
                if(current_page==i){
                    li.setAttribute('class','paginate_button active');
                }else{
                    li.setAttribute('class','paginate_button');
                }
                a=document.createElement('a');
                a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+i);
                a.setAttribute('aria-controls','example1');
                a.setAttribute('data-dt-idx','0');
                a.setAttribute('tabindex','0');
                text=document.createTextNode(i+"");
                a.appendChild(text);
                li.appendChild(a);
                document.getElementById('page_button_list').appendChild(li);
            }
            create_next_button(current_page,final_page,next_page);
        }

        if (current_page-first_page>=4&&final_page-current_page>=4){

            create_previous_button(current_page,first_page,pre_page);

            create_first_button(first_page);

            create_quote_button();

            for(i=(current_page-'0')-2;i<=(current_page-'0')+2;i++){
                li=document.createElement('li');
                if(current_page==i){
                    li.setAttribute('class','paginate_button active');
                }else{
                    li.setAttribute('class','paginate_button');
                }
                a=document.createElement('a');
                a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+i);
                a.setAttribute('aria-controls','example1');
                a.setAttribute('data-dt-idx','0');
                a.setAttribute('tabindex','0');
                text=document.createTextNode(i+"");
                a.appendChild(text);
                li.appendChild(a);
                document.getElementById('page_button_list').appendChild(li);
            }

            create_quote_button();

            create_final_button(final_page);

            create_next_button(current_page,final_page,next_page);
        }

        if (current_page-first_page>=4&&final_page-current_page<=3){
            create_previous_button(current_page,first_page,pre_page);

            create_first_button(first_page);

            create_quote_button();

            for(i=(current_page-'0')-2;i<=final_page;i++){
                li=document.createElement('li');
                if(current_page==i){
                    li.setAttribute('class','paginate_button active');
                }else{
                    li.setAttribute('class','paginate_button');
                }
                a=document.createElement('a');
                a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+i);
                a.setAttribute('aria-controls','example1');
                a.setAttribute('data-dt-idx','0');
                a.setAttribute('tabindex','0');
                text=document.createTextNode(i+"");
                a.appendChild(text);
                li.appendChild(a);
                document.getElementById('page_button_list').appendChild(li);
            }

            create_next_button(current_page,final_page,next_page);

        }
    }

    //生成上一页的按钮
    function create_previous_button(current_page,first_page,pre_page) {
        li=document.createElement('li');
        a=document.createElement('a');
        if(current_page==first_page){
            li.setAttribute('class','paginate_button previous disabled');
        }else {
            li.setAttribute('class','paginate_button previous');
            pre_page=(current_page-'0')-1;
            a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+pre_page);
        }
        a.setAttribute('aria-controls','example1');
        a.setAttribute('data-dt-idx','0');
        a.setAttribute('tabindex','0');
        text=document.createTextNode('Previous');
        a.appendChild(text);
        li.appendChild(a);
        document.getElementById(div_id).appendChild(li);
    }
    //生成下一页的按钮
    function create_next_button(current_page,final_page,next_page) {
        li=document.createElement('li');
        a=document.createElement('a');
        if (current_page==final_page){
            li.setAttribute('class','paginate_button next disabled');
        }else {
            li.setAttribute('class','paginate_button next');
            next_page=(current_page-'0')+1;
            a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+next_page);
        }
        a.setAttribute('aria-controls','example1');
        a.setAttribute('data-dt-idx','0');
        a.setAttribute('tabindex','0');
        text=document.createTextNode('Next');
        a.appendChild(text);
        li.appendChild(a);
        document.getElementById(div_id).appendChild(li);
    }
    //生成省略号按钮
    function create_quote_button() {
        li=document.createElement('li');
        li.setAttribute('class','paginate_button disabled');
        a=document.createElement('a');
        a.setAttribute('aria-controls','example1');
        a.setAttribute('data-dt-idx','0');
        a.setAttribute('tabindex','0');
        text=document.createTextNode('....');
        a.appendChild(text);
        li.appendChild(a);
        document.getElementById(div_id).appendChild(li);
    }
    //生成第一页按钮
    function create_first_button(first_page) {
        li=document.createElement('li');
        li.setAttribute('class','paginate_button');
        a=document.createElement('a');
        a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+first_page);
        a.setAttribute('aria-controls','example1');
        a.setAttribute('data-dt-idx','0');
        a.setAttribute('tabindex','0');
        text=document.createTextNode(first_page);
        a.appendChild(text);
        li.appendChild(a);
        document.getElementById(div_id).appendChild(li);
    }
    //生成最后页按钮
    function create_final_button(final_page) {
        li=document.createElement('li');
        li.setAttribute('class','paginate_button');
        a=document.createElement('a');
        a.setAttribute('href','${pageContext.request.contextPath}/index/studentsManagement?page='+final_page);
        a.setAttribute('aria-controls','example1');
        a.setAttribute('data-dt-idx','0');
        a.setAttribute('tabindex','0');
        text=document.createTextNode(final_page);
        a.appendChild(text);
        li.appendChild(a);
        document.getElementById(div_id).appendChild(li);
    }
</script>
</body>
</html>
