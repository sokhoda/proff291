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
    <title>Igor Web Application</title>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td colspan="2" align="center"><h2>Choose an action to perform</h2></td>
    </tr>
    <tr align="center">
        <td><a href="registerPage.jsp">
            <button>Login Form</button>
        </a></td>
        <td><a href="authorizationPage.jsp">
            <button>Authorization Form</button>
        </a></td>
    </tr>
<tr align="center">
    <td colspan="2"><img src="http://blog.englishexamswithnikki.org/wp-content/uploads/2013/01/I-can-do.jpg" width="500"/></td>
</tr>

    </tbody>
</table>
</body>
</html>