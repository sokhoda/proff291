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

<h3>Login</h3>

<div style="float: left">

<form name="loginForm" action="/loginForm" method="post">
    <table border="0" cellpadding="6" align="left" style="background-color: #d4ecff">
        <tr>
            <td>Login:</td>
            <td><input id="login" type="text" name="login" size="15" maxlength="15"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input id="password" type="password" name="password" size="15" maxlength="15"/></td>
        </tr>
        <tr><td colspan="2"><hr/></td></tr>
        <tr>
            <td align="center"><input type="button" value="Login" onclick="submitLoginData(document.loginForm)" style="width: 100px"/></td>
            <td align="center"><a href="/hw4/reg_form.jsp">Registration</a></td>
        </tr>
     </table>
</form>

</div>
<div style="clear: both"></div>

<p style="color: red"><b>${server_msg}</b></p>

<script>
    function submitLoginData(form) {
        if(!checkEmptyFields(form)) {
            alert("Please, fill in all fields!");
        } else {
            form.submit();
        }
    }

    function checkEmptyFields(form) {
        return (form.login.value.trim() &&  form.password.value.trim());
    }

</script>

</body>

</html>
