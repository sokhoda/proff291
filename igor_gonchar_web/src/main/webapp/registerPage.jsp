<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%! public int counter = -1; %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<table border="1" width="320">
    <thead>
    <tr>
        <th colspan="2">
            Register Form
        </th>
    </tr>
    </thead>
    <tbody>
    <form action="/registerForm" method="post">
        <tr>
            <td width="45%"> Enter Login</td>
            <td width="55%"><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Enter Password</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td>Re-enter Password</td>
            <td><input type="text" name="rePassword"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"/></td>
            <td><input type="reset" value="Clear"/></td>
        </tr>
    </form>
    </tbody>
</table>
<p>
    ${user_list}
    ${test_m}
</p>
</body>
</html>