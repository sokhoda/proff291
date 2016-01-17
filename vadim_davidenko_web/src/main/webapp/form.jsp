<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 17.01.2016
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public static int counter = 0; %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="/form" method="post" >
  <input type="text" name="login" value="vadim"/>
  <input type="password" name="password" size="15" maxlength="25">
  <input type="submit" value="POST"/>
</form>
<%= ++counter %>

</body>
</html>
