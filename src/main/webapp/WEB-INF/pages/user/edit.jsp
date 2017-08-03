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
    <title>用户编辑</title>
</head>
<body>
<h1>修改用户信息</h1>
<p>id:${users.id}</p>
<form action="update" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${users.id }"/>
<p>用户名：<input type="text" name="username" value="${users.username}"></p>
<p>密码：<input type="text" name="password" value="${users.password}"></p>
<p>邮箱：<input type="text" name="email" value="${users.email}"></p>
<p>创建时间：<input type="text" name="creattime" value="<fmt:formatDate value="${users.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></p>
<p>头像：</p>
<c:if test="${users.photo != null}">
<p><img src="${users.photo}" width="100px" height="100px" alt=""></p>
</c:if>
<p><input type="file" name="photo_file"></p>
<p><input type="submit" value="提交"></p>
</form>
</body>
</html>
