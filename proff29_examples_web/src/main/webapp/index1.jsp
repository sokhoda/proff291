<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
    <head>
        <title>Proff29</title>
    </head>
    <body>
    <script src="js/alexEx.js" type="text/javascript"></script>
    <button onclick="createTree(document.documentElement,'')">Create Tree</button>
    <button onclick="functionFun()">Test</button>
    <form id="table" action="/form" method="post">
            <input type="text" name="login" value="Sveta"/>
            <input type="submit" value="POST"/>
        </form>

        <br/>

        <h1>Hello proff29!!!</h1>
        <p>Para</p>
        <a href="http://www.google.com.ua">Link</a>
        <br/>
        <img src="img/murano.jpg"/>
        <br/>

        <q name="" id="" class="" onclick="val = 5;functionFun()">qoatation</q>

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