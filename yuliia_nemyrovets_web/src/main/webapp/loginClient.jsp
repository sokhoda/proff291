<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 20.01.2016
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<form action="/authentification" method="post">
<table>
    <tr>
        <td> Login :</td>
        <td><input type="text" name="login"/></td>
    </tr>
    <tr>
        <td> Password :</td>
        <td><input type="text" name="password"/></td>
    </tr>



    <tr>

        <td>
        <a href="registeredClient.jsp"><h3> Registration</h3></a>
    </td>
        <td>
            <a href="dashboard.jsp"><h3> Taxi</h3></a>
        </td>
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
