<%--
  Created by IntelliJ IDEA.
  User: 12241
  Date: 2020/10/12
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.student.pojo.Student" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>学生管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%
        List<Student> list=(List<Student>)request.getAttribute("stus");
        String avge=request.getAttribute("avge").toString();
        String jgl=request.getAttribute("jgl").toString();
    %>
    <style type="text/css">
        td{
            text-align: center;
            height: 37px;
        }
    </style>

</head>
<body>
<center>
    <h3>学生管理</h3>
    <table width="80%" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>年令</td>
            <td>班级</td>
            <td>成绩</td>
            <td><a href="add.jsp">增加</a> </td>
        </tr>
        <%int ii=0;
            for(Student stu:list){
                ii++;
        %>
        <tr>
            <td><%=ii%></td>
            <td><%=stu.getName() %></td>
            <td><%=stu.getAge() %></td>
            <td><%=stu.getClazz() %></td>
            <td><%=stu.getScore() %></td>
            <td><a href="FindStudentServlet?id=<%=stu.getId()%>">修改</a>
                <a href="DelStudentServlet?id=<%=stu.getId()%>" onclick="return confirm('你确认要删除吗？')" >删除</a>
            </td>
        </tr>
        <%}%>
        <tr>
            <td colspan="6">
                平均成绩：<%=avge%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                及格率：<%=jgl %>%
            </td>
        </tr>
    </table>
</center>

</body>
</html>
