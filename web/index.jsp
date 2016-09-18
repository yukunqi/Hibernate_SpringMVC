<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2016-08-24
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册用户</title>
  </head>
  <body>
  <h1>注册测试</h1>
<form action="login/userRegister/POST" method="POST">
  name:<input type="text" name="name">
  <br>
  passord:<input type="password" name="password">
  <br>
  <input type="submit" value="提交">
  <br>
</form>
<h1>登录测试</h1>
<form action="login/userLogin/POST" method="POST">
  name:<input type="text" name="name">
  <br>
  passord:<input type="password" name="password">
  <br>
  <input type="submit" value="提交">
  <br>
</form>
  <h1>上传文件2 upload2</h1>
  <form action="upload/uploadImage" method="post" enctype="multipart/form-data">
    选择文件上传1:<input type="file" name="file1">
    <br>
    选择文件上传2:<input type="file" name="file2">
    <br>
    <input type="submit" value="提交">
  </form>
  <br>
  <h1>文字和图片上传</h1>
  <form action="upload/uploadPersoninfo" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file"><br>
    name: <input type="text" name="name"><br>
    descriptions：<input type="text" name="desc"><br>
    <input type="submit" value="提交">
  </form>
<h1>对象传递</h1>
  <form action="upload/uploadPersoninfo" method="post">
    username: <input type="text" name="username"><br>
    introduction：<input type="text" name="introduction"><br>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
