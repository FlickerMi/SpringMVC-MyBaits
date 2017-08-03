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
    <title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>
<c:if test="${error!=null}">
<c:forEach var="error" items="${error}">
<p>${error.defaultMessage}<br /></p>
</c:forEach>
</c:if>
<form action="added" method="post" enctype="multipart/form-data">
<p>用户名：<input type="text" name="username" value="${user.username}"></p>
<p>密码：<input type="text" name="password" value="${user.password}"></p>
<p>邮箱：<input type="text" name="email" value="${user.email}"></p>
<p>创建时间：<input type="text" name="creattime" value="${user.creattime}"></p>
<p>头像：</p>
<p><input type="file" name="photo_file"></p>
<p><input type="submit" value="提交"></p>
</form>
</body>
</html>
