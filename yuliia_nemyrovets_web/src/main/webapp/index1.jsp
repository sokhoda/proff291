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
    <title>Notebooks Shop</title>
</head>
<style>
    .b1 {
        background: black;
        color: white; /* Белые буквы */
        font-size: 10pt; /* Размер шрифта в пунктах */
        text-align: center;
        width: 150px;
        height: 50px;
        align: center;
    }

    body {
        margin: 0; /* Убираем отступы */
        height: 100%; /* Высота страницы */
        background: url("img/utro-stol-noutbuk-cveta.jpg"); /* Параметры фона */
        background-size: cover; /* Фон занимает всю доступную площадь */
    }
</style>
<body>


<div align="center">

    <h1> Notebook Shop Greeting You! </h1>
    <h3><a href="Menu.jsp">
        <form>
            <p><input type="button" value="Menu" style=" width: 150px; height: 50px " class="b1">
        </p>

        </form>
    </a></h3>
    <h3><a href="Notebook.jsp">
        <form>
            <p><input type="button" value="Notebook" style=" width: 150px; height: 50px " class="b1">
            </p>

        </form>
    </a></h3>
</div>


</body>
</html>