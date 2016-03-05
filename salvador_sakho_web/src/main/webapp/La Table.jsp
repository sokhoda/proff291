<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.01.2016
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Table</title>
    <meta charset="UTF-8">

    <style>
        .main {
            width: 800px;
            min-height: 300px;
        }

        .col-50 {
            width: 50%;
            float: left;
        }

    </style>

</head>
<body>

<div class="main">
    <div id="tablediv" class="col-50"></div>
    <form action="controller.html">
        <input type="text">
        <input type="submit" value="send">
    </form>

</div>
</body>
</html>

