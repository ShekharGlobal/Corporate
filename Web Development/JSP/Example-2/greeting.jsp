<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ page buffer="8kb" %>
<%@ page errorPage="error.jsp" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <style type="text/css">
        body, html {
            height: 100%;
        }
    </style>
</head>
<body>
    <div id="header" style="background-color: blue; height: 20%;">
        <%@ include file="header.jsp" %>
    </div>
Current Date: <%= new Date() %>
    <%
        String name = request.getParameter("name");
        if (name == null || "".equals(name.trim())) {
            throw new Exception("Name is Empty");
        }
        Date date = new Date();
    %>

    <div id="content" style="background-color: gray; height: 70%; text-align: center;">
        <br/>
        <span style="color: green; font-size: 100px;">Welcome <%= name %></span>
    </div>

    <div style="height: 8%; bottom: 0; position: relative;">
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
