<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add new order</title>
</head>
<body>

<form action="/form14" method="post">

    <table border="0" cellspacing="5" cellpadding="5">
        <caption>FORM</caption>
        <tr>
            <td align="right"valign="top">Name</td>
            <td><input type="text" name="login" size="10"></td>
        </tr>

        <%--<tr>
            <td align="right"valign="top">Surname</td>
            <td><input type="text" name="Client" size="10"></td>
        </tr>--%>


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
