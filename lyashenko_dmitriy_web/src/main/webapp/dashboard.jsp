<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20.01.2016
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Dashboard</title>
    </head>
    <body>
         <h1>List of function</h1>
         <form action="registerClient.jsp">
             <input type="submit" value="Registretion of Clients"/>
         </form>
         <form action="clients.jsp">
             <input type="submit" value="List of Clients"/>
         </form>
         <form action="/OrderServlet" method="post">
             <input type="submit" value="Create Order"/>
         </form>
         <form action="/OrderServlet" method="post">
             <input type="submit" value="List of Orderss"/>
         </form>
         <% if(request.getAttribute("result") != null){
             String tmp = request.getAttribute("result").toString();
             out.println(tmp);

         }%>


    </body>
</html>
