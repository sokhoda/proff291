<%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 25.01.16
  Time: 22:40
  To change this template use File | Settings | File Templates.

создать страницу, на к-рой будет кнопка 'create table'
Нажимаешь:
создает таблицу на соновании массива объектов

К примеру, объект телефон (номер и баланс два поля)
На основании каждого объекта в этом массиве заполняется таблица
-------------
При построении таблицы напротив каждой строки должны появляться пара кнопок: Delete, Edit
Изменение таблицы должно быть мгновенным

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Table</title>
    <script src="js/CreateTableFunctions.js" type="text/javascript"></script>
</head>
<body>
<input type="button" id="CreateTableButton" value="Click to Create Table" onClick="createTable(getTableContent())"/>
</body>
</html>
