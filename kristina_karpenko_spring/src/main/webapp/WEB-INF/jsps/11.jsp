<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Hello AngularJS</title>
    <script src="../../js/angular.js"></script>
    <script src="../../js/register.js"></script>
    <%--<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>--%>
</head>
<body>
<div ng-controller="reg">
    Login: <input ng-model="login" ng-blur="logBlur()" ng-focus="logFocus()">
    <%--<button ng-click="update()">update</button>--%>
    <br/>{{errorLog}}
    <p>Model state: {{login}}</p>
${invalid}
    Id number: <input ng-model="idNumber" ng-blur="idBlur()" ng-focus="idFocus()">


    <br/>{{errorId}}


    Password:<input ng-model="pas" ng-blur="pasBlur()" ng-focus="pasFocus()">
    <br/>{{errorPas}}
    <br/>
    Password:<input ng-model="pasConf" ng-blur="pasConfirmBlur()" ng-focus="pasConfirmFocus()">
    <br/>{{isConfirm}}
    <button ng-click="register()">register</button>

    <p>{{greeting}}</p>


</div>
</body>
</html>
