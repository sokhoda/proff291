<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.01.2016
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hw8.taxi.service.ClientService" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>ListOfClients</title>
</head>
<body>
<%!
   ClientService clientServ = new ClientService();

%>
<%
    List<Client> oop = clientServ.showClientsByPortion(5);
    for (Client cli: oop) {
   out.println(cli.toString());

   }
%>



</body>
</html>
