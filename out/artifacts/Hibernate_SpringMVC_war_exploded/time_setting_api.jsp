<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2016-10-07
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师时间预约接口测试</title>
</head>
<body>
<h1>老师时间预约接口测试</h1>
<form action="upload/POST/AppointmentSetting" method="post">
    json数据:<input type="text" name="settingJson"><br>
    <input type="submit" value="提交">
</form>
<h1>老师时间删除接口测试</h1>
<form action="upload/DELETE/AppointmentSetting" method="post">
    appointment_id:<input type="text" name="deleteJson"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
