<%--
  Created by IntelliJ IDEA.
  User: i.gonchar
  Date: 3/1/2016
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi Order Page</title>
    <link rel="shortcut icon" href="http://webtun.com/uploads/posts/2011-11/1320833133_logo.png"/>
</head>
<body>
<h1 align="center">${login_result}, you was authorized!</h1>
<hr width="500">

<div align="center">
    <form id="generalForm" action="/choiceSelector" method="post">
        <input type="radio" value="client" name="addOption" checked> Client <br/>
        <input type="radio" value="order" name="addOption"> Order <br/>
        <input name="addButton" type="submit" value="Add"/>
        <input name="editButton" type="submit" value="Edit"/>
        <input name="showButton" type="submit" value="Show All"/>
    </form>
</div>
<hr width="500">

${choice_res}

<div align="center">
    <a href="/indexPage">
        <button>Back Home</button>
    </a>
<%--    <br/>
    <a target="_self" href="/uploads/test.txt" download="aaa.txt">Download me</a>--%>
</div>
</body>
</html>
