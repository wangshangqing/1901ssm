<%@ page import="java.util.Date" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%

    String savePath=request.getServletContext().getRealPath("/");
    File file=new File(savePath);
    String path=file.getParent();

%>
<html>
<head>
    <title>Title</title>

    <script src="jquery-3.3.1.min.js"></script>
</head>
<body>




欢迎：<shiro:principal></shiro:principal>登录

<shiro:hasPermission name="delete">
    <a>删除</a>
</shiro:hasPermission>

<shiro:hasPermission name="add">
    <a>添加</a>
</shiro:hasPermission>


</body>
</html>
