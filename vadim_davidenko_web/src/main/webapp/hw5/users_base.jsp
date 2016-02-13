<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 20.01.2016
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2>List of registered hw5.users</h2>
<h4 style="color: green">${server_msg}</h4>

<p><a href="/hw5/login_form.jsp">Login</a></p>
<p><a href="/hw5/reg_form.jsp">Registration</a></p>

<table border="0" cellpadding="6"  style="background-color: #d4ecff">
    <%
    Map<String, String[]> hw5.users = (Map<String, String[]>)request.getAttribute("hw5.users");
    if(hw5.users != null && !hw5.users.isEmpty())
    {%>
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Reg. date</th>
    </tr>
    <tr>
         <td colspan="5"><hr/></td>
    </tr>
    <%
        for (Map.Entry<String, String[]> user : hw5.users.entrySet()){
    %>
    <tr>
        <td><%=user.getKey()%></td>
        <td><%=user.getValue()[0]%></td>
        <td><%=user.getValue()[1]%></td>
        <td><%=user.getValue()[2]%></td>
        <td><%=user.getValue()[3]%></td>
    </tr>
    <%
            }
         }
    %>
</table>

</body>

</html>
