<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 19.02.2016
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<style>
    table {
        width: 200px; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */

    }


    body {
        margin: 0; /* Убираем отступы */
        height: 100%; /* Высота страницы */
        background: url("img/macbook-laptop-computer.jpg"); /* Параметры фона */
        background-size: cover; /* Фон занимает всю доступную площадь */
    }
</style>
<body>
<table border="1">
    <tr>
        <form name="shop" action="" method="post">
            <p><b>Choose your preferences</b></p>
            <p><input name="dzen" type="radio" value="notebook type" style="color: #0d0a14"> Notebook type </p>
            <p><input name="dzen" type="radio" value="memory" style="color: blue"> Memory</p>
            <p><input name="dzen" type="radio" value="cpu" style="color: blue"> CPU</p>
            <p><input name="dzen" type="radio" value="vendor" style="color: blue" checked> Vendor </p>
            <p><input type="submit" value="Click"></p>
        </form>
    </tr>
</table>
</body>
</html>
