<%--
  Created by IntelliJ IDEA.
  User: Rrr
  Date: 05.02.2016
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add new order</title>
</head>
<body>

<form action="/InsertOrder" method="post">

<table border="0" cellspacing="5" cellpadding="5">
<caption>New order form</caption>
<tr>
    <td align="right"valign="top">ID</td>
    <td><input type="text" name="ID" size="10"></td>
    </tr>

    <tr>
        <td align="right"valign="top">client name</td>
        <td><input type="text" name="Client" size="10"></td>
    </tr>

    <tr>
        <td align="right"valign="top">amount</td>
        <td><input type="text" name="Amount" size="10"></td>
    </tr>

    <tr>
        <td align="right"valign="top">Adress from</td>
        <td><input type="text" name="AdressFrom" size="10"></td>
    </tr>

    <tr>
        <td align="right"valign="top">Adress to</td>
        <td><input type="text" name="AdressTo" size="10"></td>
    </tr>
</table>

    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="save" value="Сохранить">
            </small>
            <th><small>
                <input type="reset" name="cancel" value="сбросить">
            </small>
    </table>
</form>
</body>
</html>
