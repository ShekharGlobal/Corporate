<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
</head>
<body>

<% 
String errorMessage = request.getParameter("errorMessage");
%>

<h3>Registration Form</h3>

<% if (errorMessage != null) { %>
<p style="color: red;"><b>Error:</b> <%= errorMessage %></p>
<% } %>

<form action="details.jsp" method="post">
  <table>
    <tr>
      <td>First Name*:</td>
      <td><input type="text" name="firstName" ></td>
    </tr>
    <tr>
      <td>Last Name*:</td>
      <td><input type="text" name="lastName"></td>
    </tr>
    <tr>   
      <td>Password*:</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td>Gender*:</td>
      <td>
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Female"> Female
      </td>
    </tr>
    <tr>
      <td>Hobbies:</td>   
      <td>
        <input type="checkbox" name="hobbies" value="Music">   Music
        <input type="checkbox" name="hobbies" value="Dance"> Dance
        <input type="checkbox" name="hobbies" value="Sports"> Sports
        <input type="checkbox" name="hobbies" value="Painting"> Painting
      </td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>
        <select name="country">
          <option value="">Select Country</option>
          <option value="USA">USA</option>
          <option value="India">India</option>
          <option value="Canada">Canada</option>
          <option value="UK">UK</option>   
        </select>
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

