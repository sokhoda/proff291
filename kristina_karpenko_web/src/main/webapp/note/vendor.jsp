<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 17.02.2016
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addVendorServlet" method="post">
    <label>Name: </label>
    <input type="text" name="name"><br><br>
    <input type="submit" name="create" value="Создать">
    <input type="submit" name="update" value="Обновить"><span/> <label>Id: </label>    <input type="text" name="id"><br>
    </form>
</body>
</html>
