
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
    <!-- editor.md css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/editor.md/css/editormd.css">
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
                <p>返回上一级后正在编辑的文章将被清空，你确定执行返回吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <a href="articleManagement" class="btn btn-primary">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<div id="modal_2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">
                    <span class="fa fa-info-circle" aria-hidden="true"></span>
                    提示
                </h4>
            </div>
            <div class="modal-body">
                <p>你确定发布文章吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="submit" type="button" class="btn btn-primary">确定</button>
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
                            <i class="fa fa-gears"></i>        退出
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

        <section class="content-header">
            <button class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modal_1">返回文章列表</button>
            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal_2">发布文章</button>
        </section>
        <section class="content">
            <div class="form-group">
                <input id="article_title" class="form-control"style="margin: 0 auto;width: 90%" placeholder="请输入文章标题......." type="text">
            </div>
        <div class="editormd" id="test_editormd">
            <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
            <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
            <textarea class="editormd-html-textarea" name="text"></textarea>
        </div>
        </section>

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
<!--editor.md js -->
<script src="${pageContext.request.contextPath}/static/editor.md/js/editormd.min.js"></script>
<%--<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
  <script src="static/dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/dist/js/demo.js"></script>--%>


<!-- Page script-->
<script type="text/javascript">
        var testeditor={};
        var markdown_str="";
        var article_id="<%=request.getParameter("article_id")%>";
        //如果id不为空 则进行文章的编辑 否则为新增文章
        if (article_id!="null"){
            var article={'article_id':article_id};
            $.ajax({
                url:"${pageContext.request.contextPath}/upload/GET/ArticleMarkdown",
                type:"POST",
                data:JSON.stringify(article),
                contentType:"application/json",
                dataType:"json",
                success:function (data) {
                    document.getElementById('article_title').value=data.jsondata.article_title;
                    markdown_str=data.jsondata.article_markdown;
                },
                error:function () {
                    alert("no");
                }
            });
        }

        testeditor=editormd("test_editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            path    : "${pageContext.request.contextPath}/static/editor.md/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea : true,
            imageUpload:true,
            imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
            imageUploadURL : "${pageContext.request.contextPath}/upload/uploadImage",
            placeholder:"就在这里编辑你的文章，开始markdown!...",
            onload:function () {
                if (article_id!="null"){
                    testeditor.setMarkdown(markdown_str);
                }
            }
        });

    $('#submit').click(function () {
        $('#modal_2').modal('hide');
        var mark_str=testeditor.getMarkdown();

        var html_str=testeditor.getHTML();

        var title=$('#article_title').val();


        if (isNull(title)){
            alert("请输入正常的文章标题....");
        }else{
            var article={'article_title':title,'article_content':html_str,'article_markdown':mark_str};
            $.ajax({
                url:"${pageContext.request.contextPath}/upload/POST/NewArticle",
                type:"POST",
                data:JSON.stringify(article),
                contentType:"application/json",
                dataType:"text",
                success:function (data) {
                    alert("yes");
                    alert(data);
                    parent.location.href="articleEditor"
                },
                error:function () {
                    alert("no");
                }
            })
        }
    });

        function isNull( str ){
            if ( str == "" ) return true;
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        }
</script>
</body>
</html>
