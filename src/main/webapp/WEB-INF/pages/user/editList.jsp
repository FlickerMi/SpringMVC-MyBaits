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
        function editUserList(){
            //批量修改用户
            document.UserForm.action="${pageContext.request.contextPath }/user/updateUserList";
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
<h1>用户列表 - 批量修改</h1>
<a href="add">增加用户</a>
<form action="search" method="post" name="UserForm">
<p>用户名：<input type="text" name="userCustom.username"><input type="button" value="搜索" onclick="searchUser()"></p>
<p><input type="button" value="批量修改" onclick="editUserList()"></p>
<table width="100%" border=1>
<tr>
    <td>用户id</td>
    <td>用户名</td>
    <td>密码</td>
    <td>邮箱</td>
    <td>创建时间</td>
</tr>
<c:forEach items="${userList}" var="userList" varStatus="status">
<tr>
    <td>${userList.id}</td>
    <td><input type="text" name="userCustomList[${status.index}].username" value="${userList.username}"></td>
    <td><input type="text" name="userCustomList[${status.index}].password" value="${userList.password}"></td>
    <td><input type="text" name="userCustomList[${status.index}].email" value="${userList.email}"></td>
    <td><input type="text" name="userCustomList[${status.index}].creattime" value="<fmt:formatDate value="${userList.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>
