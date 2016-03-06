<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 06.03.2016
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="location_app">
<head>
    <title>Locations</title>
</head>
<body>
    Locations <br />
    <div ng-controller="LocationCtrl">
        <li ng-repeat="el in vectorLocs">{{el}}</li>
        <button ng-click="prev()"><<</button><button ng-click="next()">>></button>
    </div>
</body>
</html>
