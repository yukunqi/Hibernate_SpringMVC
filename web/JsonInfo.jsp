<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2016-09-12
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json字符串上传</title>
</head>
<body>
<h1>用户注册json测试</h1>
<form action="login/userRegister/POST" method="post">
    <input type="text" name="UserRegisterJson"><br>
    <input type="submit" value="提交"><br>
</form>
<br>
<h1>用户登录json测试</h1>
<form action="login/userLogin/POST" method="post">
    <input type="text" name="UserLoginJson"><br>
    <input type="submit" value="提交"><br>
</form>
<h1>老师信息上传json测试</h1>
<form action="upload/uploadExpertinfo" method="post" enctype="multipart/form-data">
    <input type="text" name="jsonExpert"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
