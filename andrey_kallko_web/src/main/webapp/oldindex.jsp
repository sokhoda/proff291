<%--
  Created by IntelliJ IDEA.
  User: elenabugercuk
  Date: 21.01.16
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WellCome. Lets work!</title>
</head>
<body>

<%! int count=-2; String temp = "Input login/pass";%>
<%= temp%>
<% count++;
    if (count>0) {
        temp = new String ("Input correct Login/pass");

    }
%>


<form action="/auth" method="POST">
   Login
    <input type="text" name="name" value=""/>
    <br>
   Password
    <input type="text" name="pass"/>
    <input type="submit" value="POST"/>
    <br>

</body>
</html>
