
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

    <script href="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script href="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <!--BoostrapValidator -->
    <link rel="stylesheet" src="${pageContext.request.contextPath}/static/BootstrapValidator/css/bootstrap.min.css">
    <link rel="stylesheet" src="${pageContext.request.contextPath}/static/BootstrapValidator/css/bootstrapValidator.min.css">
    <script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/BootstrapValidator/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/BootstrapValidator/js/bootstrapValidator.min.js"></script>
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

        <section class="content">
            <div class="row">
                <div class="col-md-10">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">老师个人资料编辑</h3>
                            <form id="defaultForm" class="form-horizontal" method="post" role="form">
                                <div class="col-md-6">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label class="control-label">用户名</label>
                                            <input id="login_name" name="login_name" class="form-control" placeholder="你的用户名" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">密码</label>
                                            <input id="password" type="password" class="form-control" name="password" />
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">确认密码</label>
                                            <input id="confirmPassword" type="password" class="form-control" name="confirmPassword" />
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">姓名(昵称)</label>
                                            <input id="username" class="form-control" name="username" placeholder="你在应用中的名字或昵称" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label>学院</label>
                                            <select id="college" class="form-control">
                                                <option>计算机软件学院</option>
                                                <option>传播学院</option>
                                                <option>材料学院</option>
                                                <option>艺术设计学院</option>
                                                <option>管理学院</option>
                                                <option>经济学院</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>学校(机构或事业单位)</label>
                                            <select id="school_name" class="form-control">
                                                <option>深圳大学</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>老师类型</label>
                                            <select id="user_type" class="form-control">
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">性别</label>
                                            <div class="col-md-12">
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label>
                                                            <input name="gender" value="男" id="optionsRadios1" type="radio">
                                                            男
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="radio">
                                                        <label>
                                                            <input name="gender" value="女" id="optionsRadios2" type="radio">
                                                            女
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">邮箱</label>
                                            <input id="email" name="email" class="form-control" type="email" placeholder="你的邮箱">
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">手机号</label>
                                            <input id="phone" name="phone" class="form-control" type="text" placeholder="你的手机号">
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label">微信</label>
                                            <input id="wechat" name="wechat" class="form-control" type="text" placeholder="你的微信号">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                                        <div class="form-group">
                                            <img id="preIMG" alt="请选择老师个人头像" width="150px" height="200px" src="">
                                        </div>
                                        <div class="form-group">
                                            <label>选择头像文件</label>
                                            <input type="file" accept="image/*" id="imgOne" onchange="preImg(this.id,'preIMG')" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                                        <div class="form-group">
                                            <img id="preIMG_1" alt="请选择老师主页封面" width="150px" height="200px" src="">
                                        </div>
                                        <div class="form-group">
                                            <label>选择头像文件</label>
                                            <input type="file" accept="image/*" id="imgOne_1" onchange="preImg(this.id,'preIMG_1')" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-10">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label>咨询特长</label>
                                            <textarea id="introduction" style="resize: vertical" class="form-control" placeholder="xxx" type="text"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>一句话座右铭</label>
                                            <input id="motto" name="motto" class="form-control" placeholder="不超过20个字" type="text">
                                        </div>
                                        <div class="box-footer">
                                            <button type="submit" class="btn btn-primary">注册新老师</button>
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
        <strong>Copyright © 2017 <a href="#">计算机学院</a>.</strong>All rights reserved.
    </footer>
</div>

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/dist/js/app.min.js"></script>

<!-- DataTables -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/chartjs/Chart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/baiduTemplate/baiduTemplate.js"></script>

<script src="${pageContext.request.contextPath}/static/AdminTLE/dist/js/demo.js"></script>

<!-- Page script -->
<script type="text/javascript">

    $(document).ready(function(){

        $.ajax({
            url:"${pageContext.request.contextPath}/upload/GET/UserTypeList/2",
            type:"GET",
            dataType:"json",
            success:function (data) {
                var select=document.getElementById('user_type');
                var jsondata=data.jsondata;
                for(var i in jsondata){
                    var op=document.createElement('option');
                    op.setAttribute('id',jsondata[i].id);
                    op.appendChild(document.createTextNode(jsondata[i].type_name));
                    select.appendChild(op);
                }
            },
            error:function () {
                alert("no");
            }
        });

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
                        },/*最后一个没有逗号*/
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: '用户名只能由字母、数字、下划线组成'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required and cannot be empty'
                        },
                        identical: {
                            field: 'confirmPassword',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: 'The confirm password is required and cannot be empty'
                        },
                        identical: {
                            field: 'password',
                            message: 'The password and its confirm are not the same'
                        }
                    }
                },
                gender: {
                    validators: {
                        notEmpty: {
                            message: 'The gender is required'
                        }
                    }
                },
                username: {
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The username is required and cannot be empty'
                        },
                        stringLength: {
                            min: 1,
                            max: 15,
                            message: 'The username must be more than 1 and less than 15 characters long'
                        }
                    }
                },
                email: {
                    validators: {
                        emailAddress: {
                            message: 'The input is not a valid email address'
                        }
                    }
                },
                phone: {
                    message: 'The phone is not valid',
                    validators: {
                        stringLength: {
                            min: 11,
                            max: 11,
                            message: '请输入11位手机号码'
                        },
                        regexp: {
                            regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                            message: '请输入正确的手机号码'
                        }
                    }
                },
                wechat:{
                    message:'wechat is not valid',
                    validators:{
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: 'The wechat can only consist of alphabetical, number, dot and underscore'
                        }
                    }
                },
                motto:{
                    message:'motto is not valid',
                    validators:{
                        stringLength: {
                            max: 20,
                            message: '不能超过20个字..'
                        }
                    }
                }
            }

        })
                .on('success.form.bv',function (e) {
                    e.preventDefault();
                    var name=document.getElementById("login_name").value;
                    var password=document.getElementById("password").value;
                    var username=document.getElementById("username").value;
                    var college_obj=document.getElementById("college");
                    var college=college_obj.options[college_obj.selectedIndex].value;
                    var school_obj=document.getElementById("school_name");
                    var school_name=school_obj.options[school_obj.selectedIndex].value;
                    var user_obj=document.getElementById("user_type");
                    var user_type=user_obj.options[user_obj.selectedIndex].id;
                    var gender_arr=document.getElementsByName('gender');
                    for (var i=0;i<gender_arr.length;i++){
                        if (gender_arr[i].checked){
                            var gender=gender_arr[i].value;
                        }
                    }
                    var email=document.getElementById("email").value;
                    var phone=document.getElementById("phone").value;
                    var wechat=document.getElementById("wechat").value;
                    var introduction=document.getElementById("introduction").value;
                    var motto=document.getElementById("motto").value;


                    var u1={};
                    var js1={};
                    u1.login_name=name;
                    u1.password=password;
                    u1.username=username;
                    u1.profile="";
                    u1.gender=gender;
                    u1.phone_number=phone;
                    u1.introduction=introduction;
                    u1.school_name=school_name;
                    u1.college=college;
                    u1.email=email;
                    u1.authority=0;
                    u1.grade="大三";
                    u1.wechat=wechat;
                    var ut={};
                    ut.id=user_type;
                    u1.userType=ut;
                    js1.user=u1;
                    js1.motto=motto;
                    js1.page_picture="";
                    js1.consult_number=0;

                    var formData=new FormData();
                    formData.append("jsonExpert",JSON.stringify(js1));
                    formData.append("file",document.getElementById('imgOne').files[0]);
                    formData.append("file_1",document.getElementById('imgOne_1').files[0]);
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

                })
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


</script>

</body>
</html>
