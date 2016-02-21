<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 19.02.2016
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addStoreServlet" method="get">
    <label>Id склада: </label>
    <input type="text" name="id"><br><br>
    <label>Количество: </label>
    <input type="number" name="amount" value="0"><br><br>
    <input type="submit" name="remove" value="Списать">
    <input type="submit" name="sale" value="Продать">
</form>

<%--<%--%>
    <%--int numb = Integer.parseInt(request.getParameter("number"));--%>
    <%----%>
    <%--if (${number} < 0){ response.getWriter().print("Количество должно быть больше ноля.");--%>
    <%--}--%>
<%--%>--%>
</body>
</html>
