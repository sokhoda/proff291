<%--
  Created by IntelliJ IDEA.
  User: skuciy
  Date: 21.01.2016
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <form action="/register" method="post">
        <input type="text" name="name"/> <br/>
        <input type="text" name="login"/> <br/>
        <input type="text" name="password"/> <br/>
        <input type="submit" value="Register"/>
    </form>

</body>
</html>
