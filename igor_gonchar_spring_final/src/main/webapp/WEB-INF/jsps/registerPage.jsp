<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Taxi Registration Page</title>
    <link rel="shortcut icon" href="http://webtun.com/uploads/posts/2011-11/1320833133_logo.png"/>
</head>
<body>
<script src="js/userController.js" type="text/javascript"></script>

<div id="registerPage" align="center">
    <table border="1">
        <tbody>
        <tr>
            <td colspan="2" align="center"><b>Register Form:</b></td>
            <td rowspan="9"><img src="http://blog.englishexamswithnikki.org/wp-content/uploads/2013/01/I-can-do.jpg"
                                 width="350"/></td>
        </tr>
        <form id="registerForm" action="/passwordDataConfirm" method="post">
            <tr>
                <td> Enter Login</td>
                <td><input id="loginField" type="text" name="login"/></td>
            </tr>
            <tr>
            <tr>
                <td> Enter Identifier Number</td>
                <td><input id="idNumberField" type="text" name="idNumber"/></td>
            </tr>
            <td>Enter Password</td>
            <td><input id="passwordField" type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Re-enter Password</td>
                <td><input id="rePasswordField" type="password" name="rePassword"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" onclick="registerFormValidation()" style="width:100%" value="Register"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="reset" value="Clear" style="width:100%"/></td>
            </tr>
        </form>
        <tr>
            <td colspan="2"><a href="/indexPage">
                <button style="width:100%">Back Home</button>
            </a></td>
        </tr>
        </form>
        </tbody>
    </table>

    <p>
        ${reg_result}
    </p>
    <b>Login requirements:</b>
    <br/> Not less than 4 symbols;
    <br/> No spaces;

    <br/>
    <br/>
    <b>Identifier number requirements:</b>
    <br/> 10 symbol;
    <br/> Only numbers;

    <br/>
    <br/>
    <b>Password requirements:</b>
    <br/> Not less than 8 symbols;
    <br/> Has to contain upper and case characters;
    <br/> Has to contain numbers.
</div>
</body>
</html>