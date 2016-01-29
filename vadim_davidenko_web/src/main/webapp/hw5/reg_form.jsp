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

<form name="regForm" action="/regForm" method="post">
  <table border="0" cellpadding="6" style="background-color: #d4ecff">
    <tr>
      <td>Name:</td>
      <td><input type="text" name="userName" size="25" maxlength="25"/></td>
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
      <td align="center"><input type="button" value="Submit" onclick="submitForm(document.regForm)" style="width: 100px"/></td>
      <td align="center"><a href="/hw5/login_form.jsp">Login page</a></td>
    </tr>
  </table>
</form>

</div>
<div style="clear: both"></div>
<p style="color: red"><b>${server_msg}</b></p>

<script>
    function submitForm(form) {
        if(!checkEmptyFields(form)) {
            alert("Please, fill in all fields!");
            return;
        }
        if(!checkConfirmPassword(form)) {
            alert("The password confirmation does not match!");
            return;
        }
        form.submit();
    }

    function checkEmptyFields(form) {
        return (form.userName.value.trim() &&
                form.surname.value.trim() &&
                form.login.value.trim() &&
                form.password.value.trim() &&
                form.confirmPassword.value.trim());
    }

    function checkConfirmPassword(form) {
        return (form.password.value === form.confirmPassword.value);
    }

</script>

</body>

</html>

