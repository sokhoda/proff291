<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.lang.String" %>
<html>
    <head>
        <title>Proff29</title>
        <script>console.log('Hello World');</script>
    </head>
    <body>
    <script></script>

    <form action="/form" method="post">
        <input type="text" name="login" value="Sveta"/>
        <input type="submit" value="POST"/>
    </form>


    <%!
        public void globalMethod() {

        }

        int field;
    %>

    ${name}

    <%
        String name = (String)request.getAttribute("name");
        Date date = new Date();
        System.out.println(name);
    %>
    <br/>
    <%= "Это датаЖ " + date %>

    <h1>Hello proff29!!!</h1>
    <p>Para</p>
    <a href="http://www.google.com.ua">Link</a>
    <br/>
   <%-- <img src="img/murano.jpg"/>--%>
    <br/>
    <q>qoatation</q>

    <ol start="5" type="A">
        <li>item</li>
        <li>item</li>
        <li>item</li>
    </ol>

    <ul>
        <li>item 1</li>
        <li>item 2</li>
        <li>item 3</li>
    </ul>

    <table border="1">
        <thead>
        <tr>
            <th>First</th>
            <th colspan="2">Last</th>
            <%--<th>Age</th>--%>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Alex</td>
            <td>Bonasevich</td>
            <td>35</td>
        </tr>

        </tbody>

        <tfoot></tfoot>
    </table>
    </body>
</html>