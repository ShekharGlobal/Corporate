<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Developer's Home Page</title>
    <style type="text/css">
        body {
            background-color: olive;
            color: blue;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <div>
        <h1>Developer's Home Page</h1>
        <h2>Welcome <%= request.getParameter("name") %></h2>
    </div>
</body>
</html>
