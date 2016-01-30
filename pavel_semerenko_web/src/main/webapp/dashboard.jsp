<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 21.01.2016
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
    <form action="/dashboard" method="post">
        <input type="submit" name="f1" value="зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)"/> <br/>
        <input type="submit" name="f2" value="вывести всех клиентов порциями по 10 человек" /> <br/>
        <input type="submit" name="f3" value="вывести всех клиентов наездивших на сумму больше указанной" /> <br/>
        <input type="submit" name="f4" value="вывести всех клиентов, делавших заказы за последний месяц" /> <br/>
    </form>
    <br/>
    ${result}
</body>
</html>
