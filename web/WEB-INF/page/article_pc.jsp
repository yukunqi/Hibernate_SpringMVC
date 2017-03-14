<%--
用于PC端web的文章展示页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>AdminLTE  Navigation</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/article/article.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/article/orginal_web_article.css">
    <script src="${pageContext.request.contextPath}/static/js/uaredirect.js"></script>
    <script type="text/javascript">uaredirect("${pageContext.request.contextPath}/page/article_phone.jsp?article_id="+"${param.article_id}")</script>
</head>
<body>
<div class="note">
    <div class="post">
    <div class="article">
        <h4 id="article_title" class="title"></h4>
        <div class="author">
        <div class="info">
            <span id="author" class="name"></span>
            <div class="meta">
                <span id="build_date" class="publish_time"></span>
                <span id="watched_num" class="views-count"></span>
                <span id="comment_num" class="comments-count"></span>
                <span id="good_num" class="likes-count"></span>
            </div>
        </div>
        </div>
        <div id="article_content" class="show-content">

        </div>
    </div>
    </div>
</div>


<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/static/AdminTLE/plugins/jQuery/jquery-2.2.3.min.js"></script>


<!-- Page script-->
<script type="text/javascript">
    var article_id="${param.article_id}";
    var data={'article_id':article_id};
    $.ajax({
        url:"${pageContext.request.contextPath}/upload/GET/ArticleDetail",
        type:"POST",
        data:JSON.stringify(data),
        contentType:"application/json",
        dataType:"text",
        success:function (data) {
            var obj=JSON.parse(data);
            var artinfo=obj.jsondata;
            document.getElementById('article_title').innerHTML=artinfo.article_title;
            document.getElementById('author').innerHTML=artinfo.author;
            document.getElementById('build_date').innerHTML=artinfo.article_build_date;
            document.getElementById('watched_num').innerHTML="阅读 "+artinfo.watched_num;
            document.getElementById('comment_num').innerHTML="评论 "+artinfo.comment_num;
            document.getElementById('good_num').innerHTML="喜欢 "+artinfo.good_num;
            document.getElementById('article_content').innerHTML=artinfo.article_content;
        },
        error:function () {
            alert("no");
        }
    })
</script>
</body>
</html>
