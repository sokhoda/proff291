<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 17.02.2016
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addCPUServlet" method="post">

    <label>Имя производителя: </label>
    <input type="text" name="vendor"><br><br>
    <label>Модель: </label>
    <input type="text" name="model"><br><br>
    <label>Частота: </label>
    <input type="text" name="frequency"><br><br>

    <input type="submit" name="create">
    <input type="submit" name="update"> <label>Id: </label>    <input type="text" name="id"><br>

</form>
</body>
</html>
