<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 14.02.2016
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="/hiber" method="post">
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
</head>
<body>

</body>
</html>
