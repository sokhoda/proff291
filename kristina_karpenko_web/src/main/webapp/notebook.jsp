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
<form action="/addNotebookServlet" method="post">

    <label>Производитель ноутбука: </label>
    <input type="text" name="vendorName"><br><br>

    <label>Модель ноутбука: </label>
    <input type="text" name="modelName"><br><br>

    <label>Модель процессора ноутбука: </label>
    <input type="text" name="cpuName"><br><br>

    <label>Производитель памяти: </label>
    <input type="text" name="memoryVendor"><br><br>

    <label>Размер памяти ноутбука: </label>
    <input type="text" name="memorySize"><br><br>

    <input type="submit" name="create" value="Создать">
    <input type="submit" name="update" value="Обновить"> <label>Id: </label>    <input type="text" name="id"><br>
</form>
</body>
</html>
