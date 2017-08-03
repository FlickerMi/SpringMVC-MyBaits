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
<title>登录</title>
</head>
<body>
<h1>用户登录</h1>
<p>${message}</p>
<form action="/doLogin" method="post">
<p>E-mail：<input type="text" name="email" value="${user.email}"></p>
<p>密码：<input type="text" name="password" value="${user.password}"></p>
<p><input type="submit" value="提交"></p>
</form>
</body>
</html>
