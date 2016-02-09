<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 19.01.2016
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi</title>
</head>

<style>
    .b1 {
        background:darkblue;
        color: white; /* Белые буквы */
        font-size: 10pt; /* Размер шрифта в пунктах */

    }
    body {
        margin: 0; /* Убираем отступы */
        height: 100%; /* Высота страницы */
        background: url("img/19.03.2015.jpg"); /* Параметры фона */
        background-size: cover; /* Фон занимает всю доступную площадь */
    }

</style>
<body>

<table>


    <tr>
        <a href="registeredClient.jsp">
            <form>
        <p><input type="button" value=" Register yourself" style="width: 300px; height: 50px " class="b1"></p>
    </form>
        </a></td>
    </tr>

    <tr>
        <a href="order.jsp">
            <form>
                <p><input type="button" value=" Make an Order " style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>
    </tr>

    <tr>
        <a href="order.jsp">
            <form>
                <p><input type="button" value=" Order Correction" style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>
    </tr>

    <tr>
        <a href="orders.jsp">
            <form>
                <p><input type="button" value=" Show list of orders" style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>
    </tr>

    <tr>
        <a href="orders.jsp">
            <form>
                <p><input type="button" value=" Show list of orders on sum" style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>
    </tr>

    <tr>
        <a href="clients.jsp">
            <form>
                <p><input type="button" value="Show all clients" style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>
    </tr>

    <tr>
        <a href="clients.jsp">
            <form>
                <p><input type="button" value=" Show all clients making the order this month" style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>
    </tr>


    <tr>
        <a href="clients.jsp">
            <form>
                <p><input type="button" value=" Show list of orders who run on sum"style="width: 300px; height: 50px " class="b1"></p>
            </form>
        </a></td>


    </tr>


</table>
</body>
</html>
