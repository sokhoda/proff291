<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 18.01.2016
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>

<h3>&nbsp;&nbsp;Login form</h3>

<div style="float: left">

<form action="/loginForm" method="post">
    <table border="0" cellpadding="6" align="left" style="background-color: #d4ecff">
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login" size="15" maxlength="15"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" size="15" maxlength="15"/></td>
        </tr>
        <tr><td colspan="2"><hr/></td></tr>
        <tr>
            <td align="center"><input type="submit" value="Login"/></td>
            <td align="center"><a href="/regform.jsp">Registration</a></td>
        </tr>
    </table>

</form>

</div>
<div style="clear: both"></div>

<p style="color: red">
    ${empty_field_err_msg}
    ${wrong_password_err_msg}
    ${not_registered_err_msg}
</p>

</body>

</html>
