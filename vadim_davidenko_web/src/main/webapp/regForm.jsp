<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 17.01.2016
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h3>&nbsp;&nbsp;Registration form</h3>

<div style="float: left">

<form action="/regForm" method="post">
  <table border="1" cellpadding="5">
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" size="20" maxlength="20"/></td>
    </tr>
    <tr>
      <td>Surname:</td>
      <td><input type="text" name="surname" size="20" maxlength="20"/></td>
    </tr>
    <tr>
      <td>Login:</td>
      <td><input type="text" name="login" size="10" maxlength="10"/></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password" size="10" maxlength="10"/></td>
    </tr>
    <tr>
      <td>Confirm password:</td>
      <td><input type="password" name="confirmPassword" size="10" maxlength="10"/></td>
    </tr>
    <tr>
      <td align="center"><input type="submit" value="Submit"/></td>
      <td align="center"><a href="/loginform.jsp">Login</a></td>
    </tr>
  </table>
</form>

</div>
<div style="clear: both"></div>

<p>
    ${empty_field_err_msg}
    ${confirm_password_err_msg}
    ${congratulations_msg}
    ${already_registered_msg}
</p>

<table border="1" cellpadding="5">
    <%
    Map<String, String[]> users = (Map<String, String[]>)request.getAttribute("users");
    if(users != null && !users.isEmpty()) {%>
        <tr>
            <th>Login</th>
            <th>Password</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Reg. date</th>
        </tr>
        <%
        for (Map.Entry<String, String[]> user : users.entrySet()){%>
        <tr>
            <td><%=user.getKey()%></td>
            <td><%=user.getValue()[0]%></td>
            <td><%=user.getValue()[1]%></td>
            <td><%=user.getValue()[2]%></td>
            <td><%=user.getValue()[3]%></td>
        </tr>
        <%}
    }%>
</table>

</body>
</html>

