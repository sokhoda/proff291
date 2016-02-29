<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 28.02.2016
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client registration</title>
    <script type="text/javascript" src="/js/registerClient.js"></script>
</head>
<body>

<table align="center">
    <tr><td>
        <form name="registerClientForm" action="/registerClient.html" method="get">
            <table border="0" cellpadding="5" style="background-color: #d4ecff">
                <tr><td colspan="2" align="center"><b>Client registration</b></td></tr>
                <tr><td colspan="2"><hr/></td></tr>
                <tr>
                    <td align="right">First name:</td>
                    <td><input type="text" name="firstName" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                    <td align="right">Last name:</td>
                    <td><input type="text" name="lastName" size="20" maxlength="20"/></td>
                </tr>
                <tr>
                    <td align="right">Phone #:</td>
                    <td><input type="text" name="phone" size="15" maxlength="15"/></td>
                </tr>
                <tr>
                    <td align="right">Address:</td>
                    <td><input type="text" name="address" size="20" maxlength="50"/></td>
                </tr>
                <tr><td colspan="2"><hr/></td></tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="button" value="Submit" onclick="submitRegisterClientForm()" style="width: 70px"/>
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

</body>
</html>
