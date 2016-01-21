<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %><%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 20.01.2016
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%!
    String name;
    String surname;
    String phone;
    String address;
    double totalOrderAmount;
    GregorianCalendar lastOrderDate;
%>
<head>
    <title>Registration Form</title>
    <style>
        <%@include file='/css/registerClient.css' %>
    </style>
</head>
<body>
<form action="/taxi" method="post">
    <img <%--height="100px" width="100px" --%>
            src="../img/newUser.jpg" align="left"
            style="margin-right: 20px">
    <label for="login1">Имя: </label>
    <input  type="text" placeholder="Надія" name="login" id="login1"><br>

    <label for="surname">Фамилия: </label>
    <input  type="text" placeholder="Міцненька" name="surname" id="surname"><br>

    <label for="phone">Телефон: </label>
    <input  type="text" placeholder="+38 097 111 22 33" name="phone" id="phone"><br>

    <label for="address">Адрес: </label>
    <input  type="text" placeholder="25, I. Franka Str, app. 7, 03051 Kyiv"
            name="address" id="address"><br>

    <label for="sum">Общая сумма заказов: </label>
    <input  type="text" value="0.0" name="sum" id="sum"><label
        style="width: 35px">грн.</label>
    <br>

    <%! String curDate =
            new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
    %>

    <label for="date">Дата последнего заказа: </label>
    <input  type="text" name="LastOrderDate" id="date" value = <%= curDate %>><br>
    <br>

    <br>
    <input  type="submit" value="Зарегистрировать" id="reg">

</form>
</body>
</html>
