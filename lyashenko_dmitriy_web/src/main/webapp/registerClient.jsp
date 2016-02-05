<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.01.2016
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegistrationClients</title>
</head>
<body>
<form action="/ClientServlet" method="post">
    <input type="text" name="name"/>
    <input type="submit" value="Registrate"/>
    <br/>
    <input type="text" name="surname"/>
    <br/>
    <input type="text" name="numberOfPhone"/>
    <br/>
    <input type="text" name="address"/>

    <% if(request.getAttribute("result") != null){
        String tmp = request.getAttribute("result").toString();
        out.println(tmp);

    }%>
</form>
</body>
</html>
