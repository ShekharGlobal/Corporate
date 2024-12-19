<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Successful</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String message = null;
	if ("admin".equals(username) && "admin".equals(password)) {
		message = "You are successfully logged in";
	} else {
		message = "Try Again";
		response.sendRedirect("login.jsp");
	}
	%>
	<p><%= message %></p>
</body>
</html>
