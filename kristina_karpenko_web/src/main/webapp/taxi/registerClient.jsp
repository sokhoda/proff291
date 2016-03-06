<%@ page import="hw8.taxi.domain.servise.ClientServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 17.01.2016
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! ClientServiceImpl clientService = new ClientServiceImpl();%>
<form action="/ClientServlet" method="post">

    <font color="#ff4500"> Имя клиента: </font> <input type="text" name="name"/><br/><br/>
    <font color="#ff4500"> Фамилия клиента: </font> <input type="text" name="surName"/><br/><br/>
    <font color="#ff4500"> Номер телефона: </font> <input type="text" name="phone"/><br/><br/>
    <font color="#ff4500"> Адрес: </font> <input type="text" name="address"/><br/><br/>
    <input type="submit" value="Регестрировать"/><br/><br/>

</form>
</body>
</html>
