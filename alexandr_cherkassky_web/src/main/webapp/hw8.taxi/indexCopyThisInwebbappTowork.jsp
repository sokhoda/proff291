<%--
  Created by IntelliJ IDEA.
  User: Пк2
  Date: 26.02.2016
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
    <form  action="/client" method="POST">
        <table>
            <tbody>
            <tr>
                <td>
                    <input name="login" type="text"> Login </input>
                </td>
                <td>
                    <input name="passvord" type="text"> Passvord </input>
                </td>
                <td>
                    <input name="Button" type="submit" value="LogIn"/>
                </td>

            </tr>
            </tbody>
        </table>
    </form>

</body>
</html>
