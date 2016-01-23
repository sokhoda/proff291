<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Proff29</title>
    </head>
    <body>
      <form ation="/form" method = "post">
          <input type ="text"
                 name="login"
                 value="Servlet"/>
          <input type = "submit" value="POST"/>
      </form>

    <%
        String count ="Counter";
        Integer i= 0;
        i++;

            System.out.println("Counter: " +i);


    %>
    </body>
</html>