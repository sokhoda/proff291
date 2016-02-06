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
<script src="js/homework_table1.js" type="text/javascript"></script>

<center>
    <button onclick="tableCreate()" class="b1">Create Table</button>
</center>

</body>
</html>