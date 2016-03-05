<%@ page import="hw8.taxi.domain.servise.ClientService" %>
<%@ page import="hw8.taxi.domain.servise.ClientServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 17.01.2016
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! ClientServiceImpl service = new ClientServiceImpl(); %>
<form action="/ClientServlet" method="GET">
    Зарегестрировать нового клиента:<br/><br/>
    <input type="submit" name="registration" value="Registration!"/><br/><br/>
    Показать первых 10 клиентов:<br/><br/>
    <input type="text" name="portionSize"/>
    <input type="submit" name="portion" value="Show!"/>

    <br/><br/>
    Показать клиентов, наездивших на сумму больше:<br/><br/>
    <input type="text" name="ClientsGtSum"/>
    <input type="submit" name="ClientsSum" value="Show!"/>

    <br/><br/>
    Показать клиентов за последний месяц:<br/><br/>
    <input type="submit" name="ClientsLastMonth" value="Show!"/>
</form><!--/*- оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
- отредактировать заказ (поменять свойства заказа)
- вывести список заказов на сумму в указанном диапазоне
- вывести список всех заказов порциями по 5 штук*/-->
<br/><br/>
<form action="/OrderServlet" method="GET">
    Оформить заказ:<br/><br/>
    <input type="submit" name="order" value="Order Registration!"/><br/><br/>
    Редактировать заказ:<br/><br/>
    <font color="#ff4500"> Дата заказа: </font> <input type="text" name="date"/><br/><br/>
    <font color="#ff4500"> Фамилия клиента: </font> <input type="text" name="name"/><br/><br/>
    <font color="#ff4500"> Имя клиента: </font> <input type="text" name="surName"/><br/><br/>
    <font color="#ff4500"> Сумма заказа: </font> <input type="text" name="amount"/><br/><br/>
    <font color="#ff4500"> Адрес подачи: </font> <input type="text" name="addressFrom"/><br/><br/>
    <font color="#ff4500"> Адрес назначения: </font> <input type="text" name="addressTo"/><br/><br/>
    <input type="submit" name="edit" value="Edit order!"/>

    <br/><br/>
    Показать заказы на сумму в диапазоне<br/><br/>
    <input type="text" name="orderSumFrom"/>
    <input type="text" name="orderSumTo"/>
    <input type="submit" name="OrderSum" value="Show!"/>

    <br/><br/>
    Вывести список всех заказов порциями по 5 штук:<br/><br/>
    <input type="submit" name="allOrder" value="Show!"/>
</form>
</body>
</html>
