<%@ page import="java.util.List" %>
<%@ page import="hw8.taxi.domain.Client" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    <table border="2">
        <thead>
            <tr>
               <th colspan="100%"><h1>Список всех клиентов блоками по </h1></th>
            </tr>
            <tr>
                <th><h3>Пор.№</h3></th>
                <th><h3>Имя</h3></th>
                <th><h3>Фамилия</h3></th>
                <th><h3>Телефон</h3></th>
                <th><h3>Адрес</h3></th>
                <th><h3>Общая сумма заказов, грн.</h3></th>
                <th><h3>Дата последнего заказа</h3></th>
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
                SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
                List<Client> list = (List)request.getAttribute("clientList");
                for (int i = 0; i < list.size(); i++) {
            %>
                <tr>
                    <td class="shrink"><%= Integer.toString(i + 1) + "."%></td>
                    <td align="left"><%= list.get(i).getName()%></td>
                    <td align="left"><%= list.get(i).getSurname()%></td>
                    <td><%= list.get(i).getPhone()%></td>
                    <td align="left"><%= list.get(i).getAddress()%></td>
                    <td><%=list.get(i).getTotalOrderAmount()%></td>
                    <td><%=format1.format(list.get(i).getLastOrderDate().getTime())%></td>
                </tr>
            <%
                }
            %>
        </tbody>
        <tfoot>
        <td colspan="100%" align="center">&copy; All rights reserved, Kyiv
            2016</td>
        </tfoot>
    </table>

</body>
</html>
