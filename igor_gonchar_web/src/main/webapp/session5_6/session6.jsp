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
    <title>Proff29</title>
</head>
<body>
<h3>Hello proff29!!! I am Igor!!!</h3>

<form action="/form" method="post">
    <input type="text" name="login" value="Igor"/>
    <input type="password" name="password" size="15" maxlength="25">
    <input type="submit" value="POST"/>

    <%!

        public void methodAny() {

        }
    %>
    <%
        Date date = new Date();
        // out.ptintln(date);
    %>
    <br/>
    <%=  counter++  %>
    <br/>
    <%= date %>
    <%--<img src="http://lh5.ggpht.com/-7t070ItdC1c/Ul9wokAr3WI/AAAAAAAANEs/fNwLjJtpsnk/s160-c/pic-17.jpg"/>--%>

</form>

<a href="../registerPage.jsp">
<button> Login Re-direct</button></a>

</body>
</html>