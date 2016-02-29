<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 28.02.2016
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User registration</title>
    <script type="text/javascript" src="/js/register.js"></script>
</head>
<body>

<table align="center">
    <tr><td>
        <form name="registerForm" action="/register.html" method="get">
            <table border="0" cellpadding="5" style="background-color: #d4ecff">
                <tr><td colspan="2" align="center"><b>User registration</b></td></tr>
                <tr><td colspan="2"><hr/></td></tr>
                <tr>
                    <td align="right">ID Number:</td>
                    <td><input type="text" name="idNumber" size="15" maxlength="15"/></td>
                </tr>
                <tr>
                    <td align="right">Login name:</td>
                    <td><input type="text" name="login" size="15" maxlength="15"/></td>
                </tr>
                <tr>
                    <td align="right">Password:</td>
                    <td><input type="password" name="password" size="15" maxlength="15"/></td>
                </tr>
                <tr>
                    <td align="right">Confirm:</td>
                    <td><input type="password" name="confirmPassword" size="15" maxlength="15"/></td>
                </tr>
                <tr><td colspan="2"><hr/></td></tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" value="Submit" onclick="submitRegisterForm()" style="width: 70px"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/dashboard"><input type="button" value="Back" style="width: 70px"/></a>
                    </td>
                </tr>
            </table>
        </form>

    </td></tr>
    <tr><td colspan="2" align="center">
        <span id="msg"><i>${msg}</i></span>
    </td></tr>
</table>

<%--<script>--%>
    <%--function submitRegisterForm() {--%>
        <%--var form = document.registerForm;--%>
        <%--if(checkFields(form)) {--%>
            <%--document.getElementById("msg").innerHTML = '';--%>
            <%--form.submit();--%>
        <%--}--%>
    <%--}--%>

    <%--function checkFields(form) {--%>
        <%--if(!form.login.value.trim() || !form.idNumber.value.trim() || !form.password.value.trim()) {--%>
            <%--alert("Please, fill in all fields with valid values!");--%>
            <%--return false;--%>
        <%--}--%>
        <%--return true;--%>
    <%--}--%>
<%--</script>--%>

</body>
</html>
