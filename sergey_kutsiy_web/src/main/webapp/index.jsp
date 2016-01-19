<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 17.01.2016
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My app</title>
</head>
<body>
    <form action="/form" method="POST">
        <input type="text" name="login/>
        </br>
        <input type="password" name="password"/>
        </br>
        <input type="submit" value="Send to Serv"/>
    </form>
    </br></br>
<%!
    static int count=0;
%>

    <%= count++ %>


</body>
</html>
