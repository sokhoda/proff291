<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 17.02.2016
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sales" method="get">
    <label>Id склада: </label>
    <input type="text" name="id"><br><br>
    <label>Количество: </label>
    <input type="number" name="amount" value="0"><br>
    <input type="submit" name="sale" value="Продать">
</form>
</body>
</html>
