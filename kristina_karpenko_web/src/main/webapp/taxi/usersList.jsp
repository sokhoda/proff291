<%@ page import="hw5.users.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Date" %><%--
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
        <%@include file='/css/userList.css' %>
    </style>
</head>

<body>
<%!
    List<User> ulist;
    String message = "";

    private String checkDate(java.sql.Date gc) {
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
    <a href="/hw5.users/UserAddRender.jsp">
        <button name="back" class="but">&longleftarrow;</button>
    </a>
    <label class="regMessage"><%=message%></label>
</div>

<%
    ulist = (List<User>) request.getAttribute("ulist");
    if (ulist.size() == 0 ) {
        message = "User list is empty.";
    }
    else {
%>
<table>
    <thead>
    <tr>
        <th colspan="100%"><h1>User list</h1></th>
    </tr>
    <tr>
        <th class="shrink"><h3>ID</h3></th>
        <th><h3>Login</h3></th>
        <th><h3>Pass</h3></th>
        <th><h3>Date of Registration</h3></th>
    </tr>
    </thead>
    <tbody>

    <%
        for (int i = 0; i < ulist.size(); i++) {
    %>
    <tr>
        <td class="shrink"><%= ulist.get(i).getId()%></td>
        <td align="left"><%= ulist.get(i).getUserName()%></td>
        <td align="left"><input style="margin: 0 5px 0 5px"
                                type="password"
                                value="<%=ulist.get(i).getPassword()%>" readonly>
        </td>
        <td><%=checkDate( ulist.get(i).getDateRegistration())%></td>
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