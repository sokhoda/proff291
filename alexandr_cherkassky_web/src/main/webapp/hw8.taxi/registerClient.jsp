<%--
  Created by IntelliJ IDEA.
  User: Пк2
  Date: 27.02.2016
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client Regitrstration</title>
</head>
<body>
<form>
    <fieldset>
        <legend> Registration form</legend>
        <table>
            <tr>
                <td>
                    <span> Client First name </span>
                </td>
                <td>
                    <input name="clName" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <span> Client Last name</span>
                </td>
                <td>
                    <input name="clSurname" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <span> Client Phone </span>
                </td>
                <td>
                    <input name="clPhone" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <span> Client Adress</span>
                </td>
                <td>
                    <input name="clAdress" type="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button name="Button" value="create Client" formaction="/client" formmethod="post"> Create </button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>


</body>
</html>
