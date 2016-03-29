<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 11.03.2016
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Регистрация клиента
${ClientMessage}
<form action="/registerClient" method="post">
    Имя: <input  name="name"><br/>
    Фамилия: <input name="surName"><br/>
    Телефон:<input name="phone"><br/>
    Адрес:<input  name="address"><br/>
    <button>Register</button>

</form>
</body>
</html>
