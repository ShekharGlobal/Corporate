<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <style>
        .error { color: red; font-size: small; }
    </style>
</head>
<body>

<h3>Registration Form</h3>

<% 
    String firstNameError = request.getParameter("firstNameError");
    String lastNameError = request.getParameter("lastNameError");
    String passwordError = request.getParameter("passwordError");
    String usernameError = request.getParameter("usernameError");
    String genderError = request.getParameter("genderError");
    String countryError = request.getParameter("countryError");
%>

<form action="details.jsp" method="post">
    <table>
        <tr>
            <td>First Name*:</td>
            <td>
                <input type="text" name="firstName">
                <span class="error"><%= (firstNameError != null) ? firstNameError : "" %></span>
            </td>
        </tr>
        <tr>
            <td>Last Name*:</td>
            <td>
                <input type="text" name="lastName">
                <span class="error"><%= (lastNameError != null) ? lastNameError : "" %></span>
            </td>
        </tr>
        <tr>
            <td>Password*:</td>
            <td>
                <input type="password" name="password">
                <span class="error"><%= (passwordError != null) ? passwordError : "" %></span>
            </td>
        </tr>
        <tr>
            <td>Username*:</td>
            <td>
                <input type="text" name="username">
                <span class="error"><%= (usernameError != null) ? usernameError : "" %></span>
            </td>
        </tr>
        <tr>
            <td>Gender*:</td>
            <td>
                <input type="radio" name="gender" value="Male"> Male
                <input type="radio" name="gender" value="Female"> Female
                <span class="error"><%= (genderError != null) ? genderError : "" %></span>
            </td>
        </tr>
        <tr>
            <td>Hobbies:</td>
            <td>
                <input type="checkbox" name="hobbies" value="Music"> Music
                <input type="checkbox" name="hobbies" value="Dance"> Dance
                <input type="checkbox" name="hobbies" value="Sports"> Sports
                <input type="checkbox" name="hobbies" value="Painting"> Painting
            </td>
        </tr>
        <tr>
            <td>Country*:</td>
            <td>
                <select name="country">
                    <option value="">Select Country</option>
                    <option value="USA">USA</option>
                    <option value="India">India</option>
                    <option value="Canada">Canada</option>
                    <option value="UK">UK</option>
                </select>
                <span class="error"><%= (countryError != null) ? countryError : "" %></span>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</form>

</body>
</html>
