<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 05.03.2016
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>numbers</title>
</head>
<body>
    <form action="/calc" method="get">
        <input id="numbers" type="text"/><br />
        <input id="send" type="submit" value="send" /><br />
    </form>
    Sum: ${sum} <br />
    Reverse: ${reverse} <br />
    Random: ${random} <br />
</body>
</html>
