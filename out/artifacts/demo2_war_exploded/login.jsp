<%--
  Created by IntelliJ IDEA.
  User: 12241
  Date: 2020/10/14
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
        var form=document.getElementsByName("form1");
        form.action="ResgisterServlet";
        form.sumbit();
    </script>
</head>
<body>

<center>
    <h3>登录</h3>
    <form action="LoginServlet" mothod="post" name="form1">
        用户:<input type="text" name="loginname"></br>
        密码:<input type="password" name="pw"></br>
        <input type="checkbox" name="id" value="0">保留7天
        <br><br>
        <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <a href="register.jsp">注册</a>
        <!--<input type="button" value="注册" onclick="register();"> -->

    </form>
</center>
</body>
</html>
