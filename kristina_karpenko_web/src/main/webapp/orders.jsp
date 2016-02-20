<%@ page import="hw8.taxi.domain.servise.OrderServiceImpl" %><%--
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
<body>
<%!OrderServiceImpl orderService = new OrderServiceImpl();%>
<%response.getWriter().print(orderService.getOrders());%>
</body>
</html>
