<%--
  Created by IntelliJ IDEA.
  User: danilov
  Date: 2/28/16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myApp">
<head>
    <title>Title</title>
    <script src="js/angular.js"></script>
    <script src="js/ajaxaName.js"></script>
</head>
<body>
    <div ng-controller="HelloNameCtrl">
        Type your name: <input ng-model="login"/>
        <button ng-click="update()">Update</button>
        <p>{{greeting}}</p>
    </div>

</body>
</html>
