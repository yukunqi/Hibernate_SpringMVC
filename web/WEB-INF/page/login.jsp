<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2017-03-05
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>Login in | 心理咨询平台</title>
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
</head>
<body>
<nav class="navbar navbar-header">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <p>心理咨询平台</p>
            </a>
        </div>
        <div class="collapse navbar-collapse">
            <div class="navbar-right">
                <div class="navbar-text">
                    <p>
                        Have an account?
                        <strong><a href="#">Sign in</a></strong>
                    </p>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-12 text-center">
            <h1>开始,一段心灵旅程</h1>
            <p>Get started by filling in your info below.</p>
        </div>
    </div>
    <div class="row vertical">
        <div class="col-sm-5 col-sm-offset-1" style="margin-top: 50px">
            <form class="signup-form" role="form" id="new_user" action="${pageContext.request.contextPath}/index/login.do" accept-charset="UTF-8" method="post"><input name="utf8" value="✓" type="hidden">
                <div class="form-group"><label class="control-label">登录名</label><input placeholder="例如: 12054XX" class="form-control"  type="text" name="login_name"></div>
                <div class="form-group"><label class="control-label">密码</label><input placeholder="mmmdonuts123" class="form-control"  type="password" name="password"></div>
                <div class="row v-center">
                    <div class="col-sm-5"><input name="commit" value="Next" class="btn btn-primary btn-block" type="submit"></div>
                </div>
            </form>
        </div>
        <div class="col-sm-5 hidden-xs">
            <img src="${pageContext.request.contextPath}/static/photo/profit-bf09cda258f678a95b4598cacd833d662a80a3ffda4bef8529fc4fa15d9dc970.svg">
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
</body>
</html>
