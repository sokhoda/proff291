<%@ page import="hw5.users.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="hw6.notes.domain.Notebook" %><%--
  Created by IntelliJ IDEA.
  User: s_okhoda
  Date: 04.02.2016
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>UserList</title>
    <style>
        <%@include file='../css/noteList.css' %>
    </style>
</head>

<body>
<%!
    List<Notebook> nlist;
    String message = "";

    private String checkDate(GregorianCalendar gc) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        if (gc == null) {
            return "null";
        }
        else {
            return format1.format(gc.getTime());
        }
    }
%>
<%--onclick="window.location.href='/hw5.users/UserAddRender.jsp'"--%>
<div>
    <a href="/hw6.notes/pages/menu.jsp">
        <button name="back" class="but">&longleftarrow;</button>
    </a>
    <label class="regMessage"><%=message%></label>
</div>

<%
    nlist = (List<Notebook>) request.getAttribute("nlist");
    if (nlist.size() == 0 ) {
        message = "Notebook list is empty.";
    }
    else {
%>
<table>
    <thead>
    <tr>
        <th colspan="100%"><h1>Notebook list</h1></th>
    </tr>
    <tr>
        <%--<th class="shrink"><h3>ID</h3></th>--%>
        <th><h3>ID</h3></th>
        <th><h3>Serial</h3></th>
        <th><h3>Vendor</h3></th>
        <th><h3>Model</h3></th>
        <th><h3>Date of Manufacture</h3></th>
        <th><h3>Price</h3></th>
    </tr>
    </thead>
    <tbody>

    <%
        for (int i = 0; i < nlist.size(); i++) {
    %>
    <tr>
        <td class="shrink"><%= nlist.get(i).getId()%></td>
        <td align="left"><%= nlist.get(i).getSerial()%></td>
        <td align="left"><%= nlist.get(i).getVendor()%></td>
        <td align="left"><%= nlist.get(i).getModel()%></td>
        <td><%=checkDate(nlist.get(i).getManDate())%></td>
        <td align="left"><%= nlist.get(i).getPrice()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
