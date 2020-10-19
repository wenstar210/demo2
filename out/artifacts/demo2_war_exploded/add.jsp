<%--
  Created by IntelliJ IDEA.
  User: 12241
  Date: 2020/10/12
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>增加学生</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


</head>
<body>
<center>
    <h3>增加学生</h3>
    <form action="AddStudentServlet" method="post">
        姓名：<input type="text" name="name"></br>
        年令：<input type="text" name="age"></br>
        班级：<input type="text" name="clazz"></br>
        成绩：<input type="text" name="score"></br>
        <input type="submit" value="保存">&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
    <botton onclick="javascript:history.back();" value="返回到上一个页面"></botton>
</center>

</body>
</html>
