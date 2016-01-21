<%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 22.01.16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h3>Registration form</h3>
<form action="/registration" method="post">
    <input type="text" name="UserLogin" placeholder="username" required autofocus />
    <input type="text"  name="UserPass" placeholder="password" required />
    <input type="submit" name="Register" value="Finish"/>
</form>


</body>
</html>
