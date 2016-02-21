<%--
    Created by IntelliJ IDEA.
    User: Юлия
    Date: 24.01.2016
    Time: 24:12
    To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<style>
    .b1 {
        background: darkblue;
        color: white; /* Белые буквы */
        font-size: 10pt; /* Размер шрифта в пунктах */
        text-align: center;
        width: 300px;
        height: 50px;
        align: center;
    }

    body {
        margin: 0; /* Убираем отступы */
        height: 100%; /* Высота страницы */
        background: lavender; /* Параметры фона */
        background-size: cover; /* Фон занимает всю доступную площадь */
    }
</style>
<body>
<form action="/list" method="post"></form>
<table border="1" width="300">
    <tr>
        <td> Login :</td>
        <td><input type="text" name="login"/></td>
    </tr>
    <tr>
        <td> Password :</td>
        <td><input type="text" name="password"/></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="POST"/>
        </td>
    </tr>


</table>
</body>
</html>