<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 28.02.2016
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="newapp">
<head>
    <title>Task1</title>
    <script src="js/angular.js"></script>
    <script src="js/controller.js"></script>
</head>
<body ng-controller="MyCtrl">

    <input type="text" ng-model="login"/>
    <button ng-click="update()">Send</button>

    <p>{{count}}</p>

    <ul ng-init="vector=[1,2,3,4,'потому что 5']">
        <li ng-repeat="el in vector"> {{el}} </li>
    </ul>

</body>
</html>
