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
<div id="modal_1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">

                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <img id="" alt="" style="display: block ;margin: 0 auto; max-width: 100%;" width="150px" height="200px" src="">
                </div>
                <div class="form-group">
                    <label></label>
                    <form id="file_form">
                    <input type="file" accept="image/*" id="imgOne_2" onchange="" >
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="upload_page_picture" class="btn btn-primary">确定</button>
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
                        <li>
                            <a href="articleManagement">
                                <i class="fa fa-circle-o"></i>
                                文章管理
                            </a>
                        </li>
                        <li class="active">
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
                封面轮播图片上传
            </h1>
        </section>
        <section class="content" id="main_content">
            <div class="row">
                <div class="col-md-6">
                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                        <div class="form-group">
                            <img id="preIMG_1" alt="封面轮播图1" width="150px" height="200px" src="">
                        </div>
                        <div class="form-group">
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal_1" data-id="preIMG_1" style="margin-left: 30px">封面轮播图1</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                        <div class="form-group">
                            <img id="preIMG_3" alt="封面轮播图2" width="150px" height="200px" src="">
                        </div>
                        <div class="form-group">
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal_1" data-id="preIMG_3" style="margin-left: 30px">封面轮播图2</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                        <div class="form-group">
                            <img id="preIMG_4" alt="封面轮播图3" width="150px" height="200px" src="">
                        </div>
                        <div class="form-group">
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal_1" data-id="preIMG_4" style="margin-left: 30px">封面轮播图3</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="box-body" style="margin-left: 100px ;margin-top: 20px;">
                        <div class="form-group">
                            <img id="preIMG_5" alt="封面轮播图4" width="150px" height="200px" src="">
                        </div>
                        <div class="form-group">
                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal_1" data-id="preIMG_5" style="margin-left: 30px">封面轮播图4</a>
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
<!-- SlimScroll 1.3.0 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/chartjs/Chart.min.js"></script>



<script type="text/javascript">

    $(document).ready(function () {

        $.ajax({
            url:"${pageContext.request.contextPath}/upload/GET/PagePictureList",
            type:"GET",
            dataType:"json",
            success:function (data) {
                var jsondata=data.jsondata;
                var content=$('#main_content');
                var arr=content.find('img');
                var arr_a=content.find('a');
                for (var i=0;i<arr.length;i++){
                    $(arr[i]).attr('src',jsondata[i].url);
                    $(arr[i]).attr('id',jsondata[i].id);
                    $(arr_a[i]).attr('data-id',jsondata[i].id);
                }
            },
            error:function () {
                alert("no");
            }
        });

        //动态加载不同的id到同一模态框中
        $('#modal_1').on('show.bs.modal',function (event) {
            var button=$(event.relatedTarget);
            var img_id=button.data('id');
            var modal=$(this);
            var img=modal.find('img');
            var input=modal.find('input');
            var h4=modal.find('h4');
            var label=modal.find('label');
            h4.text(button.text());
            label.text("请选择"+button.text()+"文件");
            img.attr('id',img_id);
            img.attr('alt',button.text());
            input.attr('onchange',"preImg(this.id,'"+img_id+"')");
        });

        //当一个模态框关闭时，清空里面的文件内容。为另外触发模态框的按钮做准备
        $('#modal_1').on('hidden.bs.modal',function () {
            var modal=$(this);
            var form=modal.find('form');
            var img=modal.find('img');
            img.attr('src','');
            form[0].reset();
        });

        $('#upload_page_picture').click(function () {
            $('#modal_1').modal('hide');
            var img_id=$('div.modal-body').find('img').attr('id');
            var img={'id':img_id,'url':''};
            var formdata=new FormData();
            formdata.append("file",document.getElementById('imgOne_2').files[0]);
            formdata.append("jsondata",JSON.stringify(img));
            $.ajax({
                url:"${pageContext.request.contextPath}/upload/POST/PagePicture",
                type:"POST",
                data:formdata,
                contentType:false,
                processData:false,
                dataType:"json",
                success:function (data) {
                    alert(data.StatusCode);
                    window.location.reload();//重新加载一次页面 刷新作用
                },
                error:function () {
                    alert("no");
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
