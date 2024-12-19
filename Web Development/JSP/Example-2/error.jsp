<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>

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

    <div id="content" style="background-color: gray; height: 70%; text-align: center;">
        <br/>
        <span style="color: red; font-size: 60px;">
            Error has occurred... <%= exception.getMessage() %>
        </span>
    </div>

    <div style="height: 10%; bottom: 0; position: relative;">
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
