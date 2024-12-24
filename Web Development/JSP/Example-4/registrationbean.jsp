<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <jsp:useBean id="userBean" class="com.mphasis.bean.Employee" scope="request" />
    <jsp:setProperty name="userBean" property="*" />

    <%
    if (request.getParameter("register") != null) {
    %>
        <jsp:forward page="successbean.jsp">
            <jsp:param name="message" value="Registration Successful" />
        </jsp:forward>
    <%
    }
    %>

    <h2 style="font-size: 25px;">Enter Details</h2>
    <form method="post">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="fName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="uName" /></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <input type="radio" name="gender" value="Male" /> Male <br />
                    <input type="radio" name="gender" value="female" /> Female
                </td>
            </tr>
            <tr>
                <td>Hobbies</td>
                <td>
                    <input type="checkbox" name="hobbies" value="dance" /> Dance
                    <input type="checkbox" name="hobbies" value="music" /> Music
                    <br />
                    <input type="checkbox" name="hobbies" value="sports" /> Sports
                    <input type="checkbox" name="hobbies" value="painting" /> Painting
                </td>
            </tr>
            <tr>
                <td>Designation</td>
                <td>
                    <select name="designation">
                        <option value="" selected="selected">--select--</option>
                        <option value="1">Manager</option>
                        <option value="2">Trainee</option>
                        <option value="3">Developer</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register" name="register" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
