<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 29.01.2016
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--<link rel="stylesheet" type="text/css" href="table.css">-->
    <script src="../js/phone.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
</head>
<body>
<label>ФИО:</label>
<input type="text" id="Surname">

<label>Номер телефона:</label>
<input type="text" id="PhoneNumber">

<label>Баланс:</label>
<input type="text" id="Balance">

<label>Оператор:</label>
<input type="text" id="Operator">
<br/><br/><br/>

<button  onclick="addPhone(Surname.value, PhoneNumber.value, Balance.value, Operator.value);">
    Добавить запись в таблицу
</button>
<br/>
<table  border="1px" id="tableExample" onfocus="foo()">

     <thead >

  <th>ФИО:</th>
  <th>Номер телефона:</th>
  <th>Баланс:</th>
  <th>Оператор:</th>
    <th></th>
    <th></th>
 </thead>

     <tbody id="tableBodyExample"  ></tbody>
</table>

</body>
</html>
