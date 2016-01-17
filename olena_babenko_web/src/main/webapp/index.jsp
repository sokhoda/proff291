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
        <h3>Hello, Lena =)</h3>
        <br/>
        <table border="1">
            <thead>
            <tr>
                <th>First</th>
                <th colspan="2">Second</th>
                <%--<th>Third</th>--%>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>el1</td>
                <td>el2</td>
                <td>el3</td>
            </tr>
            </tbody>
            <tfoot>
            </tfoot>
        </table>

        <form action="/form" method="post">
            <input type="text" name="Login" value="Sveta"/>
            <input type="text" name="Password" value="Pass"/>
            <input type="submit" value="POST"/>
        </form>

    <%!
        public int count;

        public  int increaseCount(){
            count++;
            return count;
        }
    %>
        <%=increaseCount()%>

    </body>
</html>