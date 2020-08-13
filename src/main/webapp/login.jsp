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



   登录页面
<form action="${pageContext.request.contextPath}/login/login.do" method="post">
   用户名： <input type="text" name="username"><br>
    密码：<input type="password" name="pwd">
    <input type="submit">



</form>
</body>
</html>
