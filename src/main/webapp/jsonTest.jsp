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
<title>json测试</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    //请求json，输出是json
    function requestJson(){
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/requestJson',
            contentType:'application/json;charset=utf-8',
            //数据格式是json串，用户信息
            data:'{"username":"用户名1","password":9999}',
            success:function(data){//返回json结果\
                console.log(data);
                alert(data.username);
            }
        });
    }
    //请求key/value，输出是json
    function responseJson(){
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/responseJson',
            //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
            //contentType:'application/json;charset=utf-8',
            //数据格式是json串，用户信息
            data:'username=用户名&password=999',
            success:function(data){//返回json结果
                console.log(data);
                alert(data.username);
            }
        });
    }
</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出是json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
</body>
</html>
