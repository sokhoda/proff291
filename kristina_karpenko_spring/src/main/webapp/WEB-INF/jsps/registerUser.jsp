<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Title</title>
    <script src="../../js/angular.js"></script>
    <script src="../../js/reg.js"></script>
</head>
<body  ng-controller="reg">
<form action="/register" method="post">
    Login: <input ng-model="login" ng-blur="logBlur()" name="login"> {{errorLog}}<br/>
    <p>{{greeting}}</p><br/>
    Id number: <input name="idNumber"><br/>
    Password:<input name="pas"><br/>
    <button>register</button>
</form>


${message}
</body>
</html>
