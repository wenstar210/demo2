<%@ page import="com.student.pojo.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 12241
  Date: 2020/10/20
  Time: 13:23
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
    <title>图书管理</title>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="Description" content="This is my page">

    <%
        List<Book> bookList=(List<Book>)request.getAttribute("books");
    %>
</head>
<body>
<center>
    <h3>图书管理</h3>
    <table border="1" width="90%" cellpadding="0" cellspacing="0">
        <tr>
            <td>序号</td>
            <td>图书名称</td>
            <td>类型</td>
            <td>出版社</td>
            <td>作者</td>
            <td>单价</td>
            <td>增加</td>
        </tr>
        <%int ii=0;
        for(Book bk:bookList){
            ii=ii+1;
            %>
        <tr>
            <td><%=ii%></td>
            <td><%=bk.getName()%></td>
            <td><%=bk.getStype()%></td>
            <td><%=bk.getPublisher()%></td>
            <td><%=bk.getAuthor()%></td>
            <td><%=bk.getPrice()%></td>
            <td>修改 删除</td>
        </tr>
        <%}%>
    </table>
</center>

</body>
</html>
