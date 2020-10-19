<%--
  Created by IntelliJ IDEA.
  User: 12241
  Date: 2020/10/12
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.pojo.Student" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>修改学生信息</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <%
        Student stu=(Student)request.getAttribute("stu");
    %>

</head>
<body>
<center>
    <h3>修改学生信息</h3>
    <form action="UpStudentServlet" method="post">
        <input type="hidden" name="id" value="<%=stu.getId()%>">
        姓名：<input type="text" name="name" value="<%=stu.getName() %>"></br>
        年令：<input type="text" name="age" value="<%=stu.getAge() %>"></br>
        班级：<input type="text" name="clazz" value="<%=stu.getClazz() %>"></br>
        成绩：<input type="text" name="score" value="<%=stu.getScore() %>"></br>

        <input type="submit" value="保存">&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
</center>


</body>
</html>
