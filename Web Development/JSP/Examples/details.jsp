<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Details</title>
</head>
<body>
<%
    // Retrieve form parameters
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String password = request.getParameter("password");
    String gender = request.getParameter("gender");
    String[] hobbies = request.getParameterValues("hobbies");
    String country = request.getParameter("country");

    // Create an ArrayList for selected hobbies
    ArrayList<String> selectedHobbies = new ArrayList<String>();
    if (hobbies != null) {
        for (String hobby : hobbies) {
            selectedHobbies.add(hobby);
        }
    }

    // Check for null values in mandatory fields
    if (firstName == null || firstName.isEmpty() ||
        lastName == null || lastName.isEmpty() ||
        password == null || password.isEmpty() ||
        gender == null) {
        response.sendRedirect("registration.jsp?errorMessage=Please fill all mandatory fields.");
        return;
    }
%>

<h3>Registration Details</h3>

<table border="2">
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>First Name</td>
        <td><%= firstName %></td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td><%= lastName %></td>
    </tr>
    <tr>
        <td>Password</td>
        <td>(hidden for security)</td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><%= gender %></td>
    </tr>
    <tr>
        <td>Hobbies</td>
        <td>
            <% for (String hobby : selectedHobbies) { %>
                <%= hobby %> &nbsp;
            <% } %>
        </td>
    </tr>
    <tr>
        <td>Country</td>
        <td><%= country %></td>
    </tr>
</table>

</body>
</html>
