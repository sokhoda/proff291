<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.domain.Client" %><%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 20.01.2016
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requested List of Clients</title>
    <style>
        <%@include file='/css/clients.css' %>
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
               <th colspan="100%"><h1>Список всех клиентов блоками по </h1></th>
            </tr>
            <tr>
                <th><h3>Ord.No</h3></th>
                <th><h3>Name</h3></th>
                <th><h3>Surname</h3></th>
                <th><h3>Phone</h3></th>
                <th><h3>Address</h3></th>
                <th><h3>Total Order Sum, hrn</h3></th>
                <th><h3>Last Order Date</h3></th>
            </tr>
            <%--<tr>--%>
                <%--<th>Список всех клиентов, наездивших на сумму больше </th>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th>Список всех клиентов, делавших заказы за последний месяц</th>--%>
            <%--</tr>--%>
        </thead>
        <tbody>
            <%
                List<Client> list = (List)request.getAttribute("clientList");
                for (int i = 0; i < list.size(); i++) {
            %>
                <tr>
                    <td><%= Integer.toString(i + 1) + "." %></td>
                    <td align="left"><%= list.get(i).getName()%></td>
                    <td align="left"><%= list.get(i).getSurname()%></td>
                    <td><%= list.get(i).getPhone()%></td>
                    <td align="left"><%= list.get(i).getAddress()%></td>
                    <td><%=
                    list.get(i).getTotalOrderAmount()%></td>
                    <td a><%= list.get(i).getLastOrderDate()%></td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>
