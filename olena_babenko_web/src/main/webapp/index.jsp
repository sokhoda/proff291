<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>olena_babenko</title>
</head>
<body>
<h3>Login Form</h3>
<form action="/form" method="post">
    <input type="text" name="Login" placeholder="username" autofocus required/>
    <input type="text" name="Password" placeholder="password" required/>
    <input type="submit" value="Login"/>
    <input type="reset" value="Reset"/>
    <p><a href="">Forgot password?</a></p>
    <p><a href="regform.jsp">Registration</a></p>
</form>
</body>
</html>