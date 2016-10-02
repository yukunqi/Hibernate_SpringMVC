<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2016-09-30
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>9月30号接口测试</title>
</head>
<body>
<h1>获取老师个人页面json数据测试</h1>
<form action="upload/login/GET/ExpertsChatRoomInfo/"method="get">
    用户id<input type="text" name="expert_id">
    <input type="submit" value="提交">
</form>
<br>
<h1>上传咨询预约订单数据</h1>
<form action="upload/POST/BookOrder" method="POST">
    jsondata:<input type="text" name="bookOrder_json">
    <input type="submit" value="提交">
</form>
</body>
</html>
