<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proff29</title>
</head>
<body>
<h3>Welcome!</h3>
Добавить в таблицу:
<button onclick="location.href='vendor.jsp'">Производитель</Button>
<button onclick="location.href='CPU.jsp'">Процессор</Button>
<button onclick="location.href='memory.jsp'">Память</Button>
<button onclick="location.href='store.jsp'">Склад</Button>
<button onclick="location.href='notebook.jsp'">Ноутбук</Button>
<button onclick="location.href='sales.jsp'">Продажа</Button><br/>
<button onclick="location.href='removeFromStore.jsp'">Списать со склада</Button>
<br/>
<br/>
<br/>

Показать:

<form action="/showNotebooksServlet" method="get">

    Все ноутбуки  <br/> <input type="submit" name="all" value="Show"  > <br/><br>

    Ноутбуки, количество которых больше:   <input type="text" name="amount">
    <input type="submit" name="byAmount" value="Show"  > <br/><br>

    Ноутбуки по производителю процессора: <input type="text" name="cpuVendor">
    <input type="submit" name="byCpuVendor" value="Show"  > <br/><br>

    Ноутбуки со склада по процессору: <input type="submit" name="byOrderVendor" value="Show"  > <br/><br>

    Продажи за день: <input type="submit" name="sales" value="Show"  > <br/>

</form>
</body>
</html>