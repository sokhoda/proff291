<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 28.02.16
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myapp">
<head>
    <title>Hello AngularJS</title>
    <script src="js/angular.js"></script>
    <script src="js/ajaxa.js"></script>
    <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>--%>
</head>
<body>
<div ng-controller="HelloCtrl">
    Your name: <input ng-model="name">
    <button ng-click="update()">update</button>
    <p>Model state: {{name}}</p>
    {{greeting}}
    <ul>
    <li ng-repeat="el in vector"> {{greeting}} </li>
    </ul>
  <%--<p>{{note}}</p>--%>
    <%--<div ng-init="person={name; vector=[]">--%>
        <%--<ul>--%>
            <%--<li ng-repeat="name in vector"> {{name}} </li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--<ul>--%>
        <%--<ul>--%>
            <%--<li ng-repeat="el in vector"> {{el.vector[]}} </li>--%>
        <%--</ul>--%>
    <%--</ul>--%>
    <%--<ul>--%>
        <%--<ul>--%>
            <%--<li ng-repeat="el in number"> {{greeting}} </li>--%>
        <%--</ul>--%>
    <%--</ul>--%>
</div>
</body>
</html>
