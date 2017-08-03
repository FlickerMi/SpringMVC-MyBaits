<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/17 0017
  Time: 下午 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <script>
        function deleteUser(){
            //提交form
            document.UserForm.action="${pageContext.request.contextPath }/user/deletes";
            document.UserForm.submit();
        }
        function searchUser(){
            //提交form
            document.UserForm.action="${pageContext.request.contextPath }/user/search";
            document.UserForm.submit();
        }
    </script>
</head>
<body>
<h1>用户列表 - <c:if test="${user.id!=null}">${user.username} - <a href="logout">退出</a></c:if> </h1>
<a href="/user/add">增加用户</a> | <<a href="/jsonTest.jsp">json测试</a>
<form action="/user/search" method="post" name="UserForm">
<p>用户名：<input type="text" name="userCustom.username"><input type="button" value="搜索" onclick="searchUser()"></p>
<p><input type="button" value="批量删除" onclick="deleteUser()"></p>
<table width="100%" border=1>
<tr>
    <td>选择</td>
    <td>用户id</td>
    <td>用户名</td>
    <td>密码</td>
    <td>邮箱</td>
    <td>创建时间</td>
    <td>操作</td>
</tr>
<c:forEach items="${userList}" var="userList">
<tr>
    <td><input type="checkbox" value="${userList.id}" name="user_id"></td>
    <td>${userList.id}</td>
    <td>${userList.username}</td>
    <td>${userList.password}</td>
    <td>${userList.email}</td>
    <td><fmt:formatDate value="${userList.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    <td><a href="/user/edit?id=${userList.id}">编辑</a>|<a href="/user/delete?id=${userList.id}">删除</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
