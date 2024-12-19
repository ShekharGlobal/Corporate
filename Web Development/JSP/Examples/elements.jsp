<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample</title>
</head>
<body>
	<%!int count = 0;
	
	void incrementCount() {
		count++;
	}%>

	<h1 style="margin-left: 25px;">JSP Elements:-</h1>
	<h2>
		<%
		int localVariable = 5;
		out.print("This page is viewed " + count + " times");
		incrementCount();
		%>
	</h2>

	The value of the local variable is
	<%=localVariable%>
	<%localVariable++;%>
</body>
</html>
