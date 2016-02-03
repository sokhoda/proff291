<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Solyk
  Date: 24.01.2016
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Taxi</title>
    </head>
    <body>

        <form action="/ClientServlet" method="post">
            <input type="text" name="login"/>
            <input type="submit" value="LogIn"/>
            <br/>
            <input type="password" name="password"/>

        </form>
        <% if(request.getAttribute("result") != null){
            String tmp = request.getAttribute("result").toString();
            out.println(tmp);

        }%>

    </body>
</html>
