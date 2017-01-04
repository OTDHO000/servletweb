<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.figo.study.model.User"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>study</title>
</head>
<body>
	<!--top start-->
	<div class="top">servletWeb</div>
	<!--top end-->
	<!--main start-->
	<div class="main">

		<%
			User user = (User) session.getAttribute("user");
		%>
		username:<%=user.getUserName()%>
		<br> password:<%=user.getUserPwd()%>
	</div>
</body>
</html>
