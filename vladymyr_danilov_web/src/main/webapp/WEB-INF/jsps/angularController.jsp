<%--
  Created by IntelliJ IDEA.
  User: danilov
  Date: 2/28/16
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">
<head>
    <title>HelloAngular</title>
    <script src="js/angular.js"></script>
    <script src="js/ajaxa.js"></script>
</head>
<body>
    <div ng-controller="HelloCtrl" ng-init="arrays=[1,2,3]">
        Your name: <input ng-model="name">
        <button ng-click="update()">update</button>
        <p>{{name}}</p>
        <p>{{array}}</p>

        <ul>
            <li ng-repeat="el in array">{{name}}</li>
        </ul>
    </div>

</body>
</html>
