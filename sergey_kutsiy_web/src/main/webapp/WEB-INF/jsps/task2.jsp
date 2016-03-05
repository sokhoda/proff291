<%--
  Created by IntelliJ IDEA.
  User: skuciy
  Date: 20.01.2016
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login_upd</title>
</head>
<body>

<form action="/logon" method="post">
    <table border="0" align="center" rules="none" width="300">
        <tr>
            <td align="right">
                User name:
            </td>
            <td width="150">
                <input type="text" name="login"/>
            </td>
        </tr>

        <tr>
            <td align="right">
                Password:
            </td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>

        <tr>
            <td align="right">

            </td>
            <td align="right">
                <input type="submit" value="Sign in"/>
            </td>
        </tr>
    </table>
</form>
<%--<img src="images/key.jpg" align="center">--%>



<script src="../../js/task2.js" type="text/javascript"></script>
</body>
</html>
