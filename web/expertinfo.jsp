<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2016-09-08
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师信息</title>
</head>
<body>
<h1>老师信息上传</h1>
<form action="upload/uploadPersoninfo/" method="post">
    qualifications <input type="text" name="qualifications"><br>
    strongPoint <input type="text" name="strongPoint"><br>
    motto <input type="text" name="motto"><br>
    background <input type="text" name="background"><br>
    others <input type="text" name="others"><br>
    page_picture <input type="text" name="page_picture"><br>
    consult_number <input type="text" name="consult_number"><br>
    <input type="submit" value="提交"><br>
</form>
<h1>老师头像和json数据上传</h1>
<form action="upload/uploadPersoninfo/"method="post" enctype="multipart/form-data">
    选择头像: <input type="file" name="file"><br>
    其他json数据<input type="text" name="jsonExpert"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
