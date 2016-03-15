<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 11.03.2016
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/loginUser" method="post">
    Login: <input  name="login"><br/>
    Password:<input name="pas"><br/>
    <button>Вход</button>
</form>
${error}${message}
<a href="register"><button>Регистрация</button></a>
</body>
</html>
