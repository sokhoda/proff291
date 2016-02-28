<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 28.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JavaScript</title>
</head>

<body onload="/*fun()*/">
<h2 id="elh" onclick="ajaxic('Sestra')">Header</h2>
<form action="/hello.html" onsubmit="return check()">
    <div ng-controller="HelloCtrl"> Your name: <input ng-model="name">
    <input id="text" name="login" type="text" value="user name"/>
    <input type="submit" value="send"/>
    <button ng-click="update()">update</button>
    <p>Model state: {{name}}</p>
    <p>{{greeting}}</p>

    <ul>
        <li ng-repeat="i in emps"> {{i.firstName}} </li>
    </ul>





</div></form>
</body>



</html>

