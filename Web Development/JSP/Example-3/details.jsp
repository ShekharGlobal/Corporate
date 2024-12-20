<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String password = request.getParameter("password");
    String username = request.getParameter("username");
    String gender = request.getParameter("gender");
    String[] hobbies = request.getParameterValues("hobbies");
    String country = request.getParameter("country");

    boolean hasError = false;
    StringBuilder errorUrl = new StringBuilder("registration.jsp?");

    if (firstName == null || firstName.isEmpty()) {
        hasError = true;
        errorUrl.append("firstNameError=First Name is required&");
    }
    if (lastName == null || lastName.isEmpty()) {
        hasError = true;
        errorUrl.append("lastNameError=Last Name is required&");
    }
    if (password == null || password.isEmpty()) {
        hasError = true;
        errorUrl.append("passwordError=Password is required&");
    }
    if (username == null || username.isEmpty()) {
        hasError = true;
        errorUrl.append("usernameError=Username is required&");
    }
    if (gender == null || gender.isEmpty()) {
        hasError = true;
        errorUrl.append("genderError=Gender is required&");
    }
    if (country == null || country.isEmpty()) {
        hasError = true;
        errorUrl.append("countryError=Country is required&");
    }

    if (hasError) {
        response.sendRedirect(errorUrl.toString());
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Details</title>
</head>
<body>
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
        <td>Username</td>
        <td><%= username %></td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><%= gender %></td>
    </tr>
    <tr>
        <td>Hobbies</td>
        <td>
            <% if (hobbies != null) {
                for (String hobby : hobbies) {
                    out.print(hobby + " ");
                }
            } else {
                out.print("None");
            } %>
        </td>
    </tr>
    <tr>
        <td>Country</td>
        <td><%= country %></td>
    </tr>
</table>
</body>
</html>
