<%--
  Created by IntelliJ IDEA.
  User: sony
  Date: 2016-10-18
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新用户个人信息</title>
</head>
<body>
<h1>用户个人资料更新接口测试(除了头像)</h1>

<form action="upload/UPDATE/updatePersonalInfo" method="post">
    updateJson字符串:<input type="text" name="updateJson"><br>
    <input type="submit" value="提交">
</form>
<h1>用户头像更新接口测试</h1>
<form action="upload/UPDATE/userProfile" method="post" enctype="multipart/form-data">
    updateJson字符串:<input type="text" name="updateJson"><br>
    头像文件  ：     <input type="file" name="file"><br>
    <input type="submit" value="提交">
</form>
<h1>取消咨询预约订单接口测试</h1>
<form action="upload/DELETE/BookOrder" method="post">
    deleteJson字符串:<input type="text" name="deleteJson"><br>
    <input type="submit" value="提交">
</form>

<h1>上传用户的咨询评价数据</h1>
<form action="upload/POST/userComment" method="post">
    用户咨询评价Json字符串:<input type="text" name="userCommentJson"><br>
    <input type="submit" value="提交">
</form>

<h1>聊天记录查询接口测试</h1>
<form action="ChatLogs/POST/getUserChatLogs" method="post">
    聊天记录查询json字符串:<input type="text" name="chatlogsJson"><br>
    <input type="submit" value="提交">
</form>


<h1>聊天结束后更新咨询订单状态为待评价接口测试</h1>
<form action="upload/UPDATE/BookorderStatus" method="post">
    >聊天结束后更新咨询订单状态json字符串:<input type="text" name="bookJson"><br>
    <input type="submit" value="提交">
</form>


</body>
</html>
