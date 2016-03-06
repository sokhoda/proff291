<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 17.01.2016
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><!--// оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)-->
<form action="/OderServlet" method="post">

    <font color="#ff4500"> Дата заказа: </font> <input type="text" name="date"/><br/><br/>
    <font color="#ff4500"> Фамилия клиента: </font> <input type="text" name="name"/><br/><br/>
    <font color="#ff4500"> Имя клиента: </font> <input type="text" name="surName"/><br/><br/>
    <font color="#ff4500"> Сумма заказа: </font> <input type="text" name="amount"/><br/><br/>
    <font color="#ff4500"> Адрес подачи: </font> <input type="text" name="addressFrom"/><br/><br/>
    <font color="#ff4500"> Адрес назначения: </font> <input type="text" name="addressTo"/><br/><br/>
    <input type="submit" name="Сheckout" value="Сheckout"/><br/><br/>
    <input type="submit" name="Edit" value="Edit"/><br/><br/>
</form>
</body>
</html>
