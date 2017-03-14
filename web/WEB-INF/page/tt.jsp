
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>AdminLTE  Navigation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/AdminTLE/bootstrap/css/bootstrap.min.css">


    <!--BoostrapValidator -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/BootstrapValidator/css/bootstrapValidator.min.css">
    <script href="${pageContext.request.contextPath}/static/BootstrapValidator/js/bootstrap.min.js"></script>
    <script href="${pageContext.request.contextPath}/static/BootstrapValidator/js/bootstrapValidator.min.js"></script>
</head>
<body class="skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <a class="logo" href="#">
        <span class="logo-mini">
          <b>A</b>LT
        </span>
      <span class="logo-lg">
        <span>Admin</span>
        LTE
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
                        <li class="active">
                            <a href="teacherManagement.jsp">
                                <i class="fa fa-circle-o"></i>
                                老师管理
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-circle-o"></i>
                                Dashboard v2
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>
    <div class="content-wrapper" style="min-height: 350px;">

        <section class="content">
            <div class="row">
                <div class="col-md-10">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">老师个人资料编辑</h3>
                            <form id="defaultForm" class="form-horizontal" method="post" action="" role="form">
                                <div class="col-md-6">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">用户名</label>
                                            <input id="login_name" name="login_name" class="form-control" placeholder="你的用户名" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label>姓名</label>
                                            <input id="teacher_name" class="form-control" placeholder="xxx" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label>教师学号</label>
                                            <input id="teacher_number" class="form-control" placeholder="xxx" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label>学院</label>
                                            <select class="form-control">
                                                <option>计算机软件学院</option>
                                                <option>传播学院      </option>
                                                <option>材料学院</option>
                                                <option>艺术设计学院</option>
                                                <option>管理学院</option>
                                                <option>经济学院</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>学校(机构或事业单位)</label>
                                            <select class="form-control">
                                                <option>深圳大学</option>
                                                <option>北大医院      </option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>性别</label>
                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label>
                                                            <input name="optionsRadios" id="optionsRadios1" value="option1" checked="" type="radio">
                                                            男
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label>
                                                            <input name="optionsRadios" id="optionsRadios2" value="option2" checked="" type="radio">
                                                            女
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>登录名</label>
                                            <input id="teacher_login_name" class="form-control" type="text" placeholder="20121100" disabled="">
                                        </div>
                                        <div class="form-group">
                                            <label>邮箱</label>
                                            <input id="email" class="form-control" type="email" placeholder="33258441@qq.com">
                                        </div>
                                        <div class="form-group">
                                            <label>手机号</label>
                                            <input id="phone_number" class="form-control" type="text" placeholder="15244474112">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                                        <div class="form-group">
                                            <img id="preIMG" alt="老师个人头像" longdesc="ssss" width="150px" height="200px" src="${pageContext.request.contextPath}/static/photo/8E2E014308B5DFFAF2E82A1551274730_0x0.jpg">
                                        </div>
                                        <div class="form-group">
                                            <label>选择头像文件</label>
                                            <input type="file" accept="image/*" id="imgOne" onchange="preImg(this.id,'preIMG')" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-10">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>个人介绍</label>
                                            <textarea id="introduction" style="resize: vertical" class="form-control" placeholder="xxx" type="text"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>咨询特长</label>
                                            <textarea id="motto" style="resize: vertical" class="form-control" placeholder="xxx" type="text"></textarea>
                                        </div>
                                        <div class="box-footer">
                                            <button type="button" class="btn btn-primary" onclick="upload_personal_data()">保存修改</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <footer class="main-footer">
        <strong>Copyright © 2016 <a href="#">计算机学院</a>.</strong>All rights reserved.
    </footer>
</div>

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/jQuery/jquery-2.2.3.min.js"></script>

<!-- Page script -->
<script type="text/javascript">

    var id="<%=request.getParameter("id")%>";

    $(document).ready(function(){
        $('#defaultForm').bootstrapValidator({
            message:"this value is not valid",
            feedbackIcons:{
                valid:'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields:{
                login_name:{
                    message:'The login_name is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '用户名不能为空'
                        },
                        stringLength: {/*长度提示*/
                            min: 6,
                            max: 30,
                            message: '用户名长度必须在6到30之间'
                        }/*最后一个没有逗号*/
                    }
                }
            }
        });
    });


    /**
     * 将本地图片 显示到浏览器上
     */
    function preImg(sourceId, targetId) {
        var url = getFileUrl(sourceId);
        var imgPre = document.getElementById(targetId);
        imgPre.src = url;
    }
    /**
     * 从 file 域获取 本地图片 url
     */
    function getFileUrl(sourceId) {
        var url;
        if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
            url = document.getElementById(sourceId).value;
        } else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        } else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        }
        return url;
    }

    function upload_personal_data() {
        var name=document.getElementById("teacher_name").value;alert(name);
        var formData=new FormData();

        formData.append("jsonExpert","{'motto':'hello'}");
        formData.append("file",document.getElementById('imgOne').files[0]);
        $.ajax({
            url:"${pageContext.request.contextPath}/upload/uploadExpertinfo",
            data:formData,
            contentType:false,
            processData:false,
            type:"POST",
            dataType:"text",
            success:function (data) {
                alert("yes")
                alert(data);
            },
            error:function () {
                alert("no")
            }
        })
    }


</script>

</body>
</html>
