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
<form action="/ClientServlet" method="post">
    <img <%--height="100px" width="100px" --%>
            src="../img/newUser.jpg" align="left"
            style="margin-right: 20px">
    <label for="login1">Name: </label>
    <input  type="text" placeholder="Надія" name="login" id="login1"><br>

    <label for="surname">Surname: </label>
    <input  type="text" placeholder="Міцненька" name="surname" id="surname"><br>

    <label for="phone">Phone: </label>
    <input  type="text" placeholder="+38 097 111 22 33" name="phone" id="phone"><br>

    <label for="address">Address: </label>
    <input  type="text" placeholder="25, I. Franka Str, app. 7, 03051 Kyiv"
            name="address" id="address"><br>

    <label for="sum">Total Order Amount: </label>
    <input  type="text" value="0.0" name="sum" id="sum"><label> грн.</label> <br>

    <%! String curDate =
            new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());
    %>

    <label for="date">Last Order Date: </label>
    <input  type="text" name="LastOrderDate" id="date" value = <%= curDate %>><br>
    <br>

    <br>
    <input  type="submit" value="Register" id="reg">

</form>
</body>
</html>
