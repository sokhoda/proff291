<%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 28.02.2016
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myTest">
<head>
  <title>Hello AngularJS</title>
  <script src="js/angular.js"></script>
  <script src="js/test.js"></script>
  <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>--%>
</head>
<body>
<div ng-controller="TestCtrl">
  Your name: <input ng-model="name">
  <button ng-click="update()">update</button>
  <%--<p>Name: {{name}}</p>--%>
  <p>{{greeting}}</p>
  

</div>
</body>
</html>