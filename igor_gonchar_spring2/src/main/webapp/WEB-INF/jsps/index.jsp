<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Taxi Welcome Page</title>
    <link rel="shortcut icon" href="images/favicon.png"/>
    <link type="text/css" rel="stylesheet" href="css/index.css">
</head>
<body>
<script src="js/indexController.js" type="text/javascript"></script>

<div id="indexPage" align="center">
    <table border="1">
        <tbody>
        <form id="loginForm" action="/loginConfirm" method="post">
            <tr>
                <td rowspan="6"><img
                        src="images/taxiLogo.jpg"
                        height="200"/>
                </td>
                <td id="loginHeader" align="center"><b>Login Form:</b></td>
            </tr>
            <td><input id="indexLoginField" type="text" name="login"/></td>
            <tr>
                <td><input id="indexPasswordField" type="password" name="password"/></td>
            </tr>

            <tr>
                <td><input type="button" onclick="loginFormValidation()" style="width:100%" value="Login"/></td>

            </tr>
        </form>
        <tr>
            <td><a href="/registerPage">
                <button style="width:100%">Register Now</button>
            </a>
            </td>

        </tr>
        </tbody>
    </table>
    <div>
        <p>
            ${reg_result}
            ${login_result}
        </p>
    </div>
</div>
</body>
</html>