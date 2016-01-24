<%--
  Created by IntelliJ IDEA.
  User: elenabugercuk
  Date: 21.01.16
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New product for TAXI Driver</title>
</head>
<body>

<form action="/register" method="POST">
Имя
<input type="text" name="name" value=""/>
    <br>
Фамилия
<input type="text" name="surName"/>
    <br>

Телефон
    <input type="text" name="phone"/>
    <br>
Адрес
    <input type="text" name="adress"/>
    <br>

Сумма
    <input type="text" name="price"/>
    <br>

Дата крайнего заказа
    <input type="text" name="lastCall"/>
    <br>


    <input type="submit" value="POST"/>

</form>

<%--<% request.getRequestDispatcher("register.jsp").forward(request,response);%>--%>

</body>
</html>
