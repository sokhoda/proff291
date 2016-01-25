<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>

<html>
    <head>
        <title>Welcome to JS</title>
        <script>
            console.log('Hello JS1');
        </script>
    </head>
    <body>
    <script src="JS/test.js" type="text/javascript">    </script>
    <%
        request.getRequestDispatcher("index_TAXI.jsp").forward(request, response);
    %>

    <%--<p id="outText1" onclick=" global =2; functionFun()" >text1</p>--%>
    <%--<p id="outText2"></p>--%>

    <%--<script>--%>
        <%--var vector = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);--%>
        <%--document.getElementById("outText1").innerHTML = vector.toString();--%>

        <%--document.getElementById("outText2").innerHTML = mirrorArray(vector, 4).toString();--%>
    <%--</script>--%>

    </body>

</html>