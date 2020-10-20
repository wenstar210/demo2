<%--
  Created by IntelliJ IDEA.
  User: 12241
  Date: 2020/10/20
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>增加图书</title>

    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="Description" content="This is my page">
</head>
<body>
    <center>
        <h3>增加图书</h3>
        <form> action="AddBookServlet"method="post">
            名称：<input type="text" name="name">
            类型：<input type="text" name="stype">
            出版社：<input type="text" name="publisher">
            作者：<input type="text" name="author">
            价格：<input type="text" name="price">
            <input type="submit" value="保存">
        </form>
    </center>
</body>
</html>
