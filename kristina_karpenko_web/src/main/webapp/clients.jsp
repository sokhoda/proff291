<%@ page import="hw8.taxi.domain.servise.ClientService" %>
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
<%
    response.getWriter().print(ClientServiceImpl.getClients());
%>
</body>
</html>
