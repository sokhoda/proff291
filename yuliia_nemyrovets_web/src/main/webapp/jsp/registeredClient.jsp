<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 19.01.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/Registration" method="post">
    <table>
        <tr>

            <td>Enter your name:</td>
            <td><input type="text" name="name"/></td>

        </tr>
        <tr>
            <td> Enter your surname:</td>
            <td><input type="text" name="surname"/></td>
        </tr>
        <tr>
            <td> Enter your address :</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td> Enter your phone number :</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td> Login :</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td> Password :</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td> Repeat Password :</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="POST"/>
            </td>
        </tr>


    </table>
</form>
<p style="color: red">
    <b>${message}</b>
</p>
</body>
</html>
