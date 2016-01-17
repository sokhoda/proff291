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

<h3>&nbsp;&nbsp;Registration form</h3>

<form action="/registrationForm" method="post">
  <table border="1" cellpadding="5" align="left">
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" size="20" maxlength="20"/></td>
    </tr>
    <tr>
      <td>Surname:</td>
      <td><input type="text" name="surname" size="20" maxlength="20"/></td>
    </tr>
    <tr>
      <td>Login:</td>
      <td><input type="text" name="login" size="10" maxlength="10"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password" size="10" maxlength="10"/></td>
    </tr>
    <tr>
      <td>Confirm password:</td>
      <td><input type="password" name="confirmPassword" size="10" maxlength="10"/></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" value="Submit"/></td>
    </tr>
  </table>

  <!--
  <p>Name: <input type="text" name="name" size="25" maxlength="25"/></p>
  <p>Surname: <input type="text" name="surname" size="25" maxlength="25"/></p>
  <p>Login: <input type="text" name="login" size="10" maxlength="10"/></p>
  <p>Password: <input type="text" name="password" size="10" maxlength="10"/></p>
  <p>Confirm password: <input type="text" name="confirmPassword" size="10" maxlength="10"/></p>
  <input type="submit" value="POST"/>
  -->
</form>


</body>
</html>

