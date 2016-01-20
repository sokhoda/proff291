<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 17.01.2016
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h3>Registration</h3>
<div style="float: left">

<form action="/regForm" method="post">
  <table border="0" cellpadding="6" style="background-color: #d4ecff">
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" size="25" maxlength="25"/></td>
    </tr>
    <tr>
      <td>Surname:</td>
      <td><input type="text" name="surname" size="25" maxlength="25"/></td>
    </tr>
    <tr>
      <td>Login:</td>
      <td><input type="text" name="login" size="15" maxlength="15"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password" size="15" maxlength="15"/></td>
    </tr>
    <tr>
      <td>Confirm password:</td>
      <td><input type="password" name="confirmPassword" size="15" maxlength="15"/></td>
    </tr>
    <tr><td colspan="2"><hr/></td></tr>
    <tr>
      <td align="center"><input type="submit" value="Submit" style="width: 100px"/></td>
      <td align="center"><a href="/login_form.jsp">Login page</a></td>
    </tr>
  </table>
</form>

</div>
<div style="clear: both"></div>

<p style="color: red">
    ${empty_field_err_msg}
    ${confirm_password_err_msg}
    ${already_registered_msg}
</p>

</body>

</html>

